package com.epam.conference.command;

import com.epam.conference.command.impl.*;

public enum CommandMap {
    SIGN_IN(new SignIn()),
    SIGN_OUT(new SignOut()),
    REGISTER(new Register()),
    GET_USERS(new GetUsers()),
    TO_LOGIN_PAGE(new ToLoginPage()),
    TO_REGISTER_PAGE(new ToRegisterPage()),
    TO_MAIN_PAGE(new ToMainPage());

    private final Command command;

    CommandMap(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
