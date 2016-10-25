# Angular starter kit : Java / Tomcat / Maven build integration

This repository contains minimal build and configuration files to support deployment of the Angular starter kit as part of a Java ecosystem.

For now Maven is the supported build manager, and Tomcat is the supported application server. Other choices include Spring / Jersey / Jackson for the server stack.

The target deployment architecture is a single WAR file containing both the HTML/JS content, and the server-side REST APIs.

## How to start

Initialize a project from the root pom.xml file. This Maven aggregator project references three modules, each in its own sub-folder :
- web : the actual angular application
- rest-api : the REST APIs that will be used by the application
- war-package : a wrapper containing both other modules, this is what we will deploy on Tomcat

Go to *web/app/* which contains a single file : *deploy-starter-kit-here*. Go ahead and follow the filename's advice. Once done, you should have files such as *gulpfile.js* and *bower.json* in *web/app/*.
Note that if you are starting a new project with the starter kit and this proposed Java integration, you should edit the *.gitignore* file which is set to ignore everything from *web/app/* except that file.

You are almost ready to go. In case you have not already done so, install maven and node (through apt-get, setup.exe, yum...).
Lastly, you must also have an executable gulp command in web/app/ (typical installation is **npm install gulp-cli -g**).

Once everything is in place, set your IDE to perform the following build steps in order :
- execute maven goal clean
- execute maven goal install
- deploy the war-package artifact in tomcat

Perform the build, open your web browser at *http://localhost:8080/* and you will land on the default starting page.

You can also go to *http://localhost:8080/rest/alive* which will return a default greeting.

Finally, *http://localhost:8080/rest/comments* supports both GET and PUT operations so you can validate the REST functionality. Use application/json type if you want to try it out.

## How to customize the solution

When starting a new project, you will want to change the default project's and packages' names. To do this, search the entire solution, all file types, for the following case-insensitive text :
- kaer-morhen
- KaerMorhen
- kaer.morhen
- Kaer Morhen
- Kaer (in folder names, matching package structure)
- Morhen (in folder names, matching package structure)

It may look like a waste if time to have all these different searches, and in particular you may at first be unsatisfied of us having used a two-word name as the default name.
This is in fact intentional : several tools in the Java stack rely on different naming conventions, and some of them are intolerant enough to break if the convention is not followed.
Rather than letting you face the unknown by yourself, performing all the renames will guide you about where to use what convention, in the case where your own project name comprises multiple words.
