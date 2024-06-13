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
    public CommentDTO submitComment(@RequestBody CommentDTO commentDTO) {
        Comment savedComment = commentService.saveComment(commentDTO);
        CommentDTO responseDTO = new CommentDTO();
        responseDTO.setMemberId(savedComment.getMember().getId());
        responseDTO.setComments(savedComment.getComments());
        responseDTO.setPassword(savedComment.getPassword());
        return responseDTO;
    }
}
