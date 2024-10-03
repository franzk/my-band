package net.franz.myband.profile.service;

import net.bytebuddy.utility.RandomString;
import net.franz.myband.profile.domain.Post;
import net.franz.myband.profile.exception.PostNotFoundException;
import net.franz.myband.profile.repository.PostRepository;
import net.franz.myband.profile.service.impl.PostServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @InjectMocks
    private PostServiceImpl serviceUnderTest;

    @Mock
    private PostRepository postRepository;

    @Test
    void createPostTest() {
        // Act
        Post post = new Post();

        // Arrange
        serviceUnderTest.createPost(post);

        // Assert
        verify(postRepository).save(post);
    }

    @Test
    void getPostByIdTest() throws PostNotFoundException {
        // Act
        String id = RandomString.make(64);
        when(postRepository.findById(id)).thenReturn(java.util.Optional.of(new Post()));

        // Arrange
        serviceUnderTest.getPostById(id);

        // Assert
        verify(postRepository).findById(id);
    }

    @Test
    void getPostByIdWithExceptionTest() {
        // Act
        String id = RandomString.make(64);

        // Arrange + Assert
        assertThrows(PostNotFoundException.class, () ->  serviceUnderTest.getPostById(id));
    }

    @Test
    void getPostsByProfileIdTest() {
        // Act
        String profileId = RandomString.make(64);

        // Arrange
        serviceUnderTest.getPostsByProfileId(profileId);

        // Assert
        verify(postRepository).findByProfileId(profileId);
    }

    @Test
    void updatePostTest() throws PostNotFoundException {
        // Act
        Post post = new Post();
        when(postRepository.existsById(post.getId())).thenReturn(true);

        // Arrange
        serviceUnderTest.updatePost(post);

        // Assert
        verify(postRepository).save(post);
    }

    @Test
    void updatePostWithExceptionTest() {
        // Act
        Post post = new Post();
        when(postRepository.existsById(post.getId())).thenReturn(false);

        // Arrange + Assert
        assertThrows(PostNotFoundException.class, () -> serviceUnderTest.updatePost(post));
    }

    @Test
    void deletePostTest() {
        // Act
        String postId = RandomString.make(64);

        // Arrange
        serviceUnderTest.deletePost(postId);

        // Assert
        verify(postRepository).deleteById(postId);
    }

}
