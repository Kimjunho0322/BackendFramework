package SchoolProject.Backend.controller;

import SchoolProject.Backend.dto.CommentDTO;
import SchoolProject.Backend.entity.Comment;
import SchoolProject.Backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public String submitComment(@RequestBody CommentDTO commentDTO) {
        commentService.saveComment(commentDTO);
        return "good";
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.findAllComments();
    }
}
