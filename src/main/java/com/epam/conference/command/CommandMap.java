package com.epam.conference.command;

import com.epam.conference.command.impl.*;

public enum CommandMap {
    TO_MAIN_PAGE(new ToMainPageCommand()),
    TO_REGISTER_PAGE(new ToRegisterPageCommand()),
    TO_LOGIN_PAGE(new ToLoginPageCommand()),
    TO_PROFILE_PAGE(new ToLoginPageCommand()),
    REGISTER(new RegisterCommand()),
    SIGN_IN(new SignInCommand()),
    SIGN_OUT(new SignOutCommand()),
    GET_USERS(new GetUsersCommand());

    private final Command command;

    CommandMap(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
