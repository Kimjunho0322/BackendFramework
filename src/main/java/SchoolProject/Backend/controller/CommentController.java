package SchoolProject.Backend.controller;

import SchoolProject.Backend.dto.CommentDTO;
import SchoolProject.Backend.entity.Comment;
import SchoolProject.Backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comments")
    public Comment submitComment(@RequestBody CommentDTO commentDTO) {
        Comment savedComment = commentService.saveComment(commentDTO);
        return savedComment;
    }
}
