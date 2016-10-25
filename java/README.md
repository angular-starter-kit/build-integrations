# Angular starter kit : Java / Tomcat / Maven build integration

This repository contains minimal build and configuration files to support deployment of the Angular starter kit as part of a Java ecosystem.
For now Maven is the supported build manager, and Tomcat is the supported application server.
Other choices include Spring / Jersey / Jackson for the server stack.
The target deployment architecture is a single WAR file containing both the HTML/JS content, and the server-side REST APIs.

## How to start

Initialize a project from the root pom.xml file. This Maven aggregator project references three modules, each in its own sub-folder :
- web : the actual angular application
- rest-api : the REST APIs that will be used by the application
- war-package : a wrapper containing both other modules, this is what we will deploy on Tomcat
