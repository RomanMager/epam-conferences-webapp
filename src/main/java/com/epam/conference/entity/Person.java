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
    private String name;
    private String surname;
    // TODO: not sure how we can supply this field using a registration form
    //  - participants definitely should not be able to register as 'admins'
    //  - or the field can be set automatically, if nothing is provided
    private RoleName role;

    public Person(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Person(int personId, String login, String email, String password) {
        this.personId = personId;
        this.login = login;
        this.email = email;
        this.password = password;
    }
}


