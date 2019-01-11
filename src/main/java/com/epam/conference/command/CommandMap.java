package com.epam.conference.command;

import com.epam.conference.command.impl.*;

public enum CommandMap {
    SIGN_IN(new SignIn()),
    SIGN_OUT(new SignOut()),
    REGISTER(new Register()), TO_MAIN_PAGE(new ToMainPage()),
    TO_REGISTER_PAGE(new ToRegisterPage()), TO_LOGIN_PAGE(new ToLoginPage()), TO_PROFILE_PAGE(new ToLoginPage()), GET_USERS(new GetUsers());

    private final Command command;

    CommandMap(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
