package net.franzka.myband.post.service;

import net.bytebuddy.utility.RandomString;
import net.franzka.myband.post.domain.Comment;
import net.franzka.myband.post.exception.CommentNotFoundException;
import net.franzka.myband.post.exception.PostNotFoundException;
import net.franzka.myband.post.repository.CommentRepository;
import net.franzka.myband.post.service.impl.CommentServiceImpl;
import net.franzka.myband.post.utils.TestComment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    @InjectMocks
    private CommentServiceImpl serviceUnderTest;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostService postService;

    @Test
    void createCommentTest() throws PostNotFoundException {
        // Arrange
        Comment comment = TestComment.create();

        // Act
         serviceUnderTest.createComment(comment);

        // Assert
        verify(commentRepository).save(comment);
        verify(postService).incrementCommentCount(any());
    }

    @Test
    void createCommentWithPostNotFoundExceptionTest() throws PostNotFoundException {
        // Arrange
        Comment comment = TestComment.create();
        when(postService.incrementCommentCount(any())).thenThrow(PostNotFoundException.class);

        // Act
        serviceUnderTest.createComment(comment);
    }

    @Test
    void getCommentsByPostIdTest() {
        // Arrange
        String postId = RandomString.make(64);
        when(commentRepository.findByPostId(postId)).thenReturn(List.of(TestComment.create()));

        // Act
        List<Comment> comments = serviceUnderTest.getCommentsByPostId(postId);

        // Assert
        assertThat(comments.size()).isEqualTo(1);
        verify(commentRepository).findByPostId(postId);
    }

    @Test
    void updateCommentTest() throws CommentNotFoundException {
        // Arrange
        Comment comment = TestComment.create();
        when(commentRepository.existsById(comment.getId())).thenReturn(true);

        // Act
        serviceUnderTest.updateComment(comment);

        // Assert
        verify(commentRepository).save(comment);
    }

    @Test
    void updateCommentWithCommentNotFoundExceptionTest() {
        // Arrange
        Comment comment = TestComment.create();
        when(commentRepository.existsById(comment.getId())).thenReturn(false);

        // Act
        assertThrows(CommentNotFoundException.class, () -> serviceUnderTest.updateComment(comment));
    }

    @Test
    void deleteCommentTest() throws CommentNotFoundException, PostNotFoundException {
        // Arrange
        Comment comment = TestComment.create();
        when(commentRepository.findById(comment.getId())).thenReturn(java.util.Optional.of(comment));

        // Act
        serviceUnderTest.deleteComment(comment.getId());

        // Assert
        verify(commentRepository).deleteById(comment.getId());
        verify(postService).decrementCommentCount(comment.getPostId());
    }

    @Test
    void deleteCommentWithCommentNotFoundExceptionTest() {
        // Arrange
        Comment comment = TestComment.create();
        when(commentRepository.findById(comment.getId())).thenReturn(java.util.Optional.empty());

        // Act
        assertThrows(CommentNotFoundException.class, () -> serviceUnderTest.deleteComment(comment.getId()));
    }

    @Test
    void deleteCommentWithPostNotFoundExceptionTest() throws PostNotFoundException, CommentNotFoundException {
        // Arrange
        Comment comment = TestComment.create();
        when(commentRepository.findById(comment.getId())).thenReturn(java.util.Optional.of(comment));
        when(postService.decrementCommentCount(comment.getPostId())).thenThrow(PostNotFoundException.class);

        // Act
        serviceUnderTest.deleteComment(comment.getId());
    }



}
