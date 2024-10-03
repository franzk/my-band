package net.franz.myband.profile.controller;

import lombok.AllArgsConstructor;
import net.franz.myband.profile.domain.Post;
import net.franz.myband.profile.exception.PostNotFoundException;
import net.franz.myband.profile.service.impl.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/v1/posts")
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPostsByProfileId(@RequestParam String profileId) {
        return ResponseEntity.ok(postService.getPostsByProfileId(profileId));
    }

    @GetMapping
    public ResponseEntity<Post> getPostById(@RequestParam String postId) throws PostNotFoundException {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post post) throws PostNotFoundException {
        return ResponseEntity.ok(postService.updatePost(post));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam String postId) throws PostNotFoundException {
        postService.deletePost(postId);
        return ResponseEntity.ok("Post deleted");
    }

}
