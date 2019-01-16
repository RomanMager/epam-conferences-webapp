package com.epam.conference.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) // TODO: Really need to call super? ('Entity' class is empty)
public class Person extends Entity {
    private int personId;
    private String login;
    private String email;
    private String password;
    private Role role;

    public Person(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Person(String login, String email, String password, Role role) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Person(int personId, String login, String email, Role role) {
        this.personId = personId;
        this.login = login;
        this.email = email;
        this.role = role;
        this.role = role;
    }
}


