package com.epam.conference.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Conference extends Entity {
    private int conferenceId;
    private String title;
    private String topic;
    private String description;

    public Conference(String title, String topic, String description) {
        this.title = title;
        this.topic = topic;
        this.description = description;
    }
}
