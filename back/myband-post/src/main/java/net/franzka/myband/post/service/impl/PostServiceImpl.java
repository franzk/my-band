package net.franzka.myband.post.service.impl;

import lombok.AllArgsConstructor;
import net.franzka.myband.post.domain.Post;
import net.franzka.myband.post.exception.PostNotFoundException;
import net.franzka.myband.post.repository.PostRepository;
import net.franzka.myband.post.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public Post createPost(Post post) {
        post.setCreated(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Post getPostById(String id) throws PostNotFoundException {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    public List<Post> getPostsByProfileId(String profileId) {
        return postRepository.findByProfileId(profileId);
    }

    public Post updatePost(Post post) throws PostNotFoundException {
        if (postRepository.existsById(post.getId())) {
            post.setUpdated(LocalDateTime.now());
            return postRepository.save(post);
        } else {
            throw new PostNotFoundException();
        }
    }

    public Post incrementCommentCount(String postId) throws PostNotFoundException {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        post.setCommentsCount(post.getCommentsCount() + 1);
        return postRepository.save(post);
    }

    public Post decrementCommentCount(String postId) throws PostNotFoundException {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        post.setCommentsCount(post.getCommentsCount() - 1);
        return postRepository.save(post);
    }

    public void deletePost(String id) {
        postRepository.deleteById(id);
    }
}