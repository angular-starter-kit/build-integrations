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
            comments.add(new Comment("alice", "luxueux comme j'aime"));
            comments.add(new Comment("bob", "tro bi1"));
            comments.add(new Comment("charles", "le beige des murs devrait être un peu plus taupe"));
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