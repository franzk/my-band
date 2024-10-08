package net.franzka.myband.post.controller;

import net.bytebuddy.utility.RandomString;
import net.franzka.myband.post.domain.Comment;
import net.franzka.myband.post.exception.CommentNotFoundException;
import net.franzka.myband.post.service.CommentService;
import net.franzka.myband.post.utils.TestComment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommentControllerTest {

    @InjectMocks
    private CommentController controllerUnderTest;

    @Mock
    private CommentService commentService;

    @Test
    void createCommentTest() {
        // Arrange
        Comment comment = TestComment.create();
        when(commentService.createComment(comment)).thenReturn(comment);
        // Act
        ResponseEntity<Comment> result = controllerUnderTest.createComment(comment);
        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(commentService).createComment(comment);
    }

    @Test
    void getCommentsByPostIdTest() {
        // Arrange
        String testPostId = RandomString.make(64);
        when(commentService.getCommentsByPostId(testPostId)).thenReturn(List.of(TestComment.create()));
        // Act
        ResponseEntity<List<Comment>> result = controllerUnderTest.getCommentsByPostId(testPostId);
        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(commentService).getCommentsByPostId(testPostId);
    }


    @Test
    void updateCommentTest() throws CommentNotFoundException {
        // Arrange
        Comment commentBefore = TestComment.create();
        Comment commentAfter = TestComment.create();
        when(commentService.updateComment(commentBefore)).thenReturn(commentAfter);
        // Act
        ResponseEntity<Comment> result = controllerUnderTest.updateComment(commentBefore);
        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(commentService).updateComment(commentBefore);
    }


    @Test
    void deleteCommentTest() throws CommentNotFoundException {
        // Arrange
        String testCommentId = RandomString.make(64);
        // Act
        ResponseEntity<String> result = controllerUnderTest.deleteComment(testCommentId);
        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(commentService).deleteComment(testCommentId);
    }

}
