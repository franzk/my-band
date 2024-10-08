package net.franzka.myband.post.service;

import net.bytebuddy.utility.RandomString;
import net.franzka.myband.post.domain.Comment;
import net.franzka.myband.post.domain.Post;
import net.franzka.myband.post.exception.PostNotFoundException;
import net.franzka.myband.post.repository.PostRepository;
import net.franzka.myband.post.service.impl.PostServiceImpl;
import net.franzka.myband.post.utils.TestPost;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @InjectMocks
    private PostServiceImpl serviceUnderTest;

    @Mock
    private PostRepository postRepository;

    @Test
    void createPostTest() {
        // Arrange
        Post post = TestPost.create();
        when(postRepository.save(any())).thenReturn(post);

        // Act
        serviceUnderTest.createPost(post);

        // Assert
        verify(postRepository, times(3)).save(post);
    }

    @Test
    void getPostByIdTest() throws PostNotFoundException {
        // Arrange
        String id = RandomString.make(64);
        when(postRepository.findById(id)).thenReturn(java.util.Optional.of(TestPost.create()));

        // Act
        serviceUnderTest.getPostById(id);

        // Assert
        verify(postRepository).findById(id);
    }

    @Test
    void getPostByIdWithExceptionTest() {
        // Arrange
        String id = RandomString.make(64);

        // Act + Assert
        assertThrows(PostNotFoundException.class, () ->  serviceUnderTest.getPostById(id));
    }

    @Test
    void getPostsByProfileIdTest() {
        // Arrange
        String profileId = RandomString.make(64);

        // Act
        serviceUnderTest.getPostsByProfileId(profileId);

        // Assert
        verify(postRepository).findByProfileId(profileId);
    }

    @Test
    void updatePostTest() throws PostNotFoundException {
        // Arrange
        Post post = TestPost.create();
        when(postRepository.existsById(post.getId())).thenReturn(true);

        // Act
        serviceUnderTest.updatePost(post);

        // Assert
        verify(postRepository).save(post);
    }

    @Test
    void updatePostWithExceptionTest() {
        // Arrange
        Post post = TestPost.create();
        when(postRepository.existsById(post.getId())).thenReturn(false);

        // Act + Assert
        assertThrows(PostNotFoundException.class, () -> serviceUnderTest.updatePost(post));
    }

    @Test
    void incrementCommentCountTest() throws PostNotFoundException {
        // Arrange
        String postId = RandomString.make(64);
        Post post = TestPost.create();
        int commentsCount = post.getCommentsCount();
        when(postRepository.findById(postId)).thenReturn(java.util.Optional.of(post));

        // Act
        serviceUnderTest.incrementCommentCount(postId);

        // Assert
        verify(postRepository).save(post);
        assertThat(post.getCommentsCount()).isEqualTo(commentsCount + 1);
    }

    @Test
    void decrementCommentCountTest() throws PostNotFoundException {
        // Arrange
        String postId = RandomString.make(64);
        Post post = TestPost.create();
        int commentsCount = post.getCommentsCount();
        when(postRepository.findById(postId)).thenReturn(java.util.Optional.of(post));

        // Act
        serviceUnderTest.decrementCommentCount(postId);

        // Assert
        verify(postRepository).save(post);
        assertThat(post.getCommentsCount()).isEqualTo(commentsCount - 1);
    }

    @Test
    void deletePostTest() {
        // Arrange
        String postId = RandomString.make(64);

        // Act
        serviceUnderTest.deletePost(postId);

        // Assert
        verify(postRepository).deleteById(postId);
    }

}
