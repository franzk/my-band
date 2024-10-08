package net.franzka.myband.post.controller;

import lombok.AllArgsConstructor;
import net.franzka.myband.post.domain.Post;
import net.franzka.myband.post.exception.PostNotFoundException;
import net.franzka.myband.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/v1/post")
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping("/profile")
    public ResponseEntity<List<Post>> getPostsByProfileId(@RequestParam String profileId) {
        return ResponseEntity.ok(postService.getPostsByProfileId(profileId));
    }

    @GetMapping
    public ResponseEntity<Post> getPostById(@RequestParam String id) throws PostNotFoundException {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post post) throws PostNotFoundException {
        return ResponseEntity.ok(postService.updatePost(post));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam String id) throws PostNotFoundException {
        postService.deletePost(id);
        return ResponseEntity.ok("Post deleted");
    }

}
