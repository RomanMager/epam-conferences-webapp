package com.epam.conference.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ParticipantData extends Entity {
    private int participantDataId;
    private int personId;
    private String name;
    private String surname;

    public ParticipantData(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
