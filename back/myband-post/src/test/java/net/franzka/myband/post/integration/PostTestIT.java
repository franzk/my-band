package net.franzka.myband.post.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.utility.RandomString;
import net.franzka.myband.post.domain.Post;
import net.franzka.myband.post.repository.PostRepository;
import net.franzka.myband.post.utils.TestPost;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class PostTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
    }

    @Test
    void createPostTestIT() throws Exception {
        // Arrange
        Post post = TestPost.create();
        LocalDateTime timeBefore = LocalDateTime.now();
        // Act
        mockMvc.perform(post("/api/v1/post")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk());
        // Assert
        Optional<Post> result = postRepository.findById(post.getId());
        if (result.isEmpty()) {
            fail("Post not found");
        } else {
            assertThat(result.get().getContent()).isEqualTo(post.getContent());
            assertThat(result.get().getImage()).isEqualTo(post.getImage());
            assertThat(result.get().getCreated()).isAfter(timeBefore);
        }
    }

    @Test
    void getPostByIdTestIT() throws Exception {
        // Arrange
        Post post = TestPost.create();
        postRepository.save(post);
        // Act
        ResultActions result = mockMvc.perform(get("/api/v1/post").param("id", post.getId()))
                .andExpect(status().isOk());
        // Assert
        Post resultPost = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(), Post.class);
        assertThat(resultPost.getContent()).isEqualTo(post.getContent());
        assertThat(resultPost.getImage()).isEqualTo(post.getImage());
    }

    @Test
    void getPostByIdWithExceptionTestIT() throws Exception {
        // Arrange
        String id = "123";
        // Act
        ResultActions result = mockMvc.perform(get("/api/v1/post").param("id", id))
                .andExpect(status().isNotFound());
        // Assert
        assertThat(result.andReturn().getResponse().getContentAsString()).isEqualTo("Post not found");
    }

    @Test
    void getPostsByProfileIdTestIT() throws Exception {
        // Arrange
        String testProfileId = RandomString.make(64);
        int nbPosts = new Random().nextInt(10) + 1;
        List<Post> testPosts = new ArrayList<>();
        for (int i = 0; i < nbPosts; i++) {
            Post post = TestPost.create();
            post.setProfileId(testProfileId);
            postRepository.save(post);
            testPosts.add(post);
        }
        // Act
        ResultActions result = mockMvc.perform(get("/api/v1/post/profile").param("profileId", testProfileId))
                .andExpect(status().isOk());
        // Assert
        Post[] resultPosts = objectMapper.readValue(result.andReturn().getResponse().getContentAsString(), Post[].class);
        assertThat(resultPosts.length).isEqualTo(nbPosts);
        assertThat(resultPosts[0].getContent()).isEqualTo(testPosts.get(0).getContent());
        assertThat(resultPosts[0].getImage()).isEqualTo(testPosts.get(0).getImage());
        int randomPostIndex = new Random().nextInt(nbPosts);
        assertThat(resultPosts[randomPostIndex].getContent()).isEqualTo(testPosts.get(randomPostIndex).getContent());
        assertThat(resultPosts[randomPostIndex].getImage()).isEqualTo(testPosts.get(randomPostIndex).getImage());
    }

    @Test
    void updatePostTestIT() throws Exception {
        // Arrange
        Post post = TestPost.create();
        postRepository.save(post);
        post.setContent("new content");
        LocalDateTime timeBefore = LocalDateTime.now();
        // Act
        mockMvc.perform(put("/api/v1/post")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk());
        // Assert
        Optional<Post> result = postRepository.findById(post.getId());
        if (result.isEmpty()) {
            fail("Post not found");
        } else {
            assertThat(result.get().getContent()).isEqualTo(post.getContent());
            assertThat(result.get().getUpdated()).isAfter(timeBefore);
        }
    }

    @Test
    void deletePostTestIT() throws Exception {
        // Arrange
        Post post = TestPost.create();
        postRepository.save(post);
        // Act
        mockMvc.perform(delete("/api/v1/post").param("id", post.getId()))
                .andExpect(status().isOk());
        // Assert
        Optional<Post> result = postRepository.findById(post.getId());
        assertThat(result.isEmpty()).isTrue();
    }


}
