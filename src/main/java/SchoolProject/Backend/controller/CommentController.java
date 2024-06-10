package SchoolProject.Backend.controller;

import SchoolProject.Backend.dto.CommentDTO;
import SchoolProject.Backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comments")
    public String submitComment(@RequestBody CommentDTO commentDTO) {
        commentService.saveComment(commentDTO);
        return "good";
    }
}
