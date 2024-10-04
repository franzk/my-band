package net.franzka.myband.profile.repository;

import net.franzka.myband.profile.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByProfileId(String profileId);
}
