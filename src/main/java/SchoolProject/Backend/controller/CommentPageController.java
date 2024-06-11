package SchoolProject.Backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentPageController {

    @GetMapping("/comment")
    public String getCommentPage() {
        return "comments"; // "comments" 파일을 반환.
    }
}
