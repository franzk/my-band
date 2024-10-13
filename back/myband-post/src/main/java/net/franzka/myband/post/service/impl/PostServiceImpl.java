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
        post.setCommentsCount(0);
        Post newPost = postRepository.save(post);

        if (newPost.getImage() != null) {
            newPost.getImage().setRelatedPostId(newPost.getId());
            newPost = postRepository.save(newPost);
        }
        if (newPost.getVideo() != null) {
            newPost.getVideo().setRelatedPostId(newPost.getId());
            newPost = postRepository.save(newPost);
        }
        return newPost;
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
            if (post.getImage() != null) {
                post.getImage().setRelatedPostId(post.getId());
            }
            if (post.getVideo() != null) {
                post.getVideo().setRelatedPostId(post.getId());
            }
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