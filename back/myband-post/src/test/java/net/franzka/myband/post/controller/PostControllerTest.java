package net.franzka.myband.post.controller;

import net.bytebuddy.utility.RandomString;
import net.franzka.myband.post.domain.Post;
import net.franzka.myband.post.exception.PostNotFoundException;
import net.franzka.myband.post.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    @InjectMocks
    private PostController controllerUnderTest;

    @Mock
    private PostService postService;

    @Test
    void createPostTest() {
        // Arrange
        Post testPost = new Post();
        when(postService.createPost(testPost)).thenReturn(testPost);

        // Act
        ResponseEntity<Post> result = controllerUnderTest.createPost(testPost);

        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(postService).createPost(testPost);
    }

    @Test
    void getPostsByProfileIdTest() {
        // Arrange
        String testProfileId = RandomString.make(64);
        when(postService.getPostsByProfileId(testProfileId)).thenReturn(List.of());

        // Act
        ResponseEntity<List<Post>> result = controllerUnderTest.getPostsByProfileId(testProfileId);

        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(postService).getPostsByProfileId(testProfileId);
    }

    @Test
    void getPostByIdTest() throws PostNotFoundException {
        // Arrange
        String testPostId = RandomString.make(64);
        when(postService.getPostById(testPostId)).thenReturn(new Post());

        // Act
        ResponseEntity<Post> result = controllerUnderTest.getPostById(testPostId);

        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(postService).getPostById(testPostId);
    }

    @Test
    void updatePostTest() throws PostNotFoundException {
        // Arrange
        Post testPost = new Post();
        when(postService.updatePost(testPost)).thenReturn(testPost);

        // Act
        ResponseEntity<Post> result = controllerUnderTest.updatePost(testPost);

        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(postService).updatePost(testPost);
    }

    @Test
    void deletePostTest() throws PostNotFoundException {
        // Arrange
        String testPostId = RandomString.make(64);

        // Act
        ResponseEntity<String> result = controllerUnderTest.deletePost(testPostId);

        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(postService).deletePost(testPostId);
    }





}
