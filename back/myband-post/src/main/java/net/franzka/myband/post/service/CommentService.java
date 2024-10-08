package net.franzka.myband.post.service;

import net.franzka.myband.post.domain.Comment;
import net.franzka.myband.post.exception.CommentNotFoundException;
import net.franzka.myband.post.exception.PostNotFoundException;

import java.util.List;

public interface CommentService {

    Comment createComment(Comment comment);

    List<Comment> getCommentsByPostId(String postId);

    Comment updateComment(Comment comment) throws CommentNotFoundException;

    void deleteComment(String id) throws CommentNotFoundException;

}
