package net.franzka.myband.profile.service.impl;

import lombok.AllArgsConstructor;
import net.franzka.myband.profile.domain.Post;
import net.franzka.myband.profile.exception.PostNotFoundException;
import net.franzka.myband.profile.repository.PostRepository;
import net.franzka.myband.profile.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public Post createPost(Post post) {
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
            return postRepository.save(post);
        } else {
            throw new PostNotFoundException();
        }
    }

    public void deletePost(String id) {
        postRepository.deleteById(id);
    }
}