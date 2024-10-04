package net.franzka.myband.profile.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {

    private String username;
    private String content;
    private LocalDateTime date;

}
