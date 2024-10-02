package net.franz.myband.profile.domain;

import lombok.Data;
import net.franz.myband.profile.domain.media.Video;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "profiles")
public class Profile extends CollectionItem {

    @Id
    private String id;
    private String username;

    private String title;
    private String slogan;
    private String bio;

    private String avatarUrl;
    private String coverImageUrl;

    private Video video;

    private List<String> tags;

}
