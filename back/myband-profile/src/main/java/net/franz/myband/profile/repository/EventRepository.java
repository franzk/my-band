package net.franz.myband.profile.repository;

import net.franz.myband.profile.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByProfileId(String profileId);
}
