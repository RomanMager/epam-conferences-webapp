package com.epam.conference.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Person extends Entity {
    private int personId;
    private String login;
    private String email;
    private String password;
    private String name;
    private String surname;
    private RoleName roleName;
}
