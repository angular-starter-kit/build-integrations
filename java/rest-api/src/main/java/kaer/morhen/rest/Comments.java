package kaer.morhen.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class Comments {

    private static List<Comment> comments;

    public Comments() {
        if (comments == null) {
            comments = new ArrayList<>();
            comments.add(new Comment("Alice", "Alice in Wonderland"));
            comments.add(new Comment("Bob", "BOB LIKES CAPS LOCK"));
            comments.add(new Comment("Charles", "The King of Hearts"));
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> get() throws IOException {
        return comments;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public void put(@RequestBody Comment comment) throws IOException {
        comments.add(comment);
    }
}