package net.franzka.myband.post.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.franzka.myband.post.domain.Comment;
import net.franzka.myband.post.domain.Post;
import net.franzka.myband.post.exception.CommentNotFoundException;
import net.franzka.myband.post.repository.CommentRepository;
import net.franzka.myband.post.service.CommentService;
import net.franzka.myband.post.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final PostService postService;

    public Comment createComment(Comment comment) {
        comment.setCreated(LocalDateTime.now());
        Comment result = commentRepository.save(comment);
        // increment comment count in post
        try {
            Post post = postService.incrementCommentCount(comment.getPostId());
        } catch (Exception e) {
            log.error("Error incrementing comment count for post: {} : {}", comment.getPostId(), e.getMessage());
        }
        return result;
    }

    public List<Comment> getCommentsByPostId(String postId) {
        return commentRepository.findByPostId(postId);
    }

    public Comment updateComment(Comment comment) throws CommentNotFoundException {
        if (commentRepository.existsById(comment.getId())) {
            comment.setUpdated(LocalDateTime.now());
            return commentRepository.save(comment);
        } else {
            throw new CommentNotFoundException();
        }
    }

    @Override
    public void deleteComment(String id) throws CommentNotFoundException {
        Comment commentToDelete = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        String postId = commentToDelete.getPostId();
        commentRepository.deleteById(id);
        // decrement comment count in post
        try {
            Post post = postService.decrementCommentCount(postId);
        } catch (Exception e) {
            log.error("Error decrementing comment count for post: {} : {}", postId, e.getMessage());
        }
    }
}
