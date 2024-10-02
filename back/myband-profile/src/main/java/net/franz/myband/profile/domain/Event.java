package net.franz.myband.profile.domain;

import lombok.Data;
import net.franz.myband.profile.domain.media.Image;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "events")
public class Event extends CollectionItem {

    @Id
    private String id;
    private String profileId;

    private LocalDateTime date;
    private Image image;

    private String title;
    private String description;
    private String location;

    private List<Comment> comments;

}
