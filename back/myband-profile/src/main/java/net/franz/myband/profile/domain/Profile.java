package net.franz.myband.profile.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.franz.myband.profile.domain.media.Video;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Document(collection = "profiles")
public class Profile extends CollectionItem {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String title;
    private String slogan;
    private String bio;

    private String avatarUrl;
    private String coverImageUrl;

    private Video video;

    private List<String> tags;

}
