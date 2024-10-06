package net.franzka.myband.post.controller;

import lombok.AllArgsConstructor;
import net.franzka.myband.post.domain.Comment;
import net.franzka.myband.post.exception.CommentNotFoundException;
import net.franzka.myband.post.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/v1/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.createComment(comment));
    }

    @GetMapping
    ResponseEntity<List<Comment>> getCommentsByPostId(@RequestParam String postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }

    @PutMapping
    ResponseEntity<Comment> updateComment(@RequestBody Comment comment) throws CommentNotFoundException {
        return ResponseEntity.ok(commentService.updateComment(comment));
    }

    @DeleteMapping
    ResponseEntity<String> deleteComment(@RequestParam String id) throws CommentNotFoundException {
        commentService.deleteComment(id);
        return ResponseEntity.ok("Comment deleted");
    }

}
