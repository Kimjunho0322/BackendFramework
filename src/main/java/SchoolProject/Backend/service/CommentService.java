package SchoolProject.Backend.service;

import SchoolProject.Backend.dto.CommentDTO;
import SchoolProject.Backend.entity.Comment;
import SchoolProject.Backend.entity.MemberEntity;
import SchoolProject.Backend.repository.CommentRepository;
import SchoolProject.Backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, MemberRepository memberRepository) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
    }

    public Comment saveComment(CommentDTO commentDTO) {
        MemberEntity member = memberRepository.findById(commentDTO.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));
        Comment comment = new Comment();
        comment.setMember(member);
        comment.setContent(commentDTO.getContent());
        return commentRepository.save(comment);
    }

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }
}
