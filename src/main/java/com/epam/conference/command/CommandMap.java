package com.epam.conference.command;

import com.epam.conference.command.impl.GetUsersCommand;
import com.epam.conference.command.impl.RegisterCommand;
import com.epam.conference.command.impl.SignInCommand;
import com.epam.conference.command.impl.SignOutCommand;
import com.epam.conference.command.impl.routing.ToLoginPageCommand;
import com.epam.conference.command.impl.routing.ToMainPageCommand;
import com.epam.conference.command.impl.routing.ToProfilePageCommand;
import com.epam.conference.command.impl.routing.ToRegisterPageCommand;

public enum CommandMap {
    TO_MAIN_PAGE(new ToMainPageCommand()),
    TO_REGISTER_PAGE(new ToRegisterPageCommand()),
    TO_LOGIN_PAGE(new ToLoginPageCommand()),
    TO_PROFILE_PAGE(new ToProfilePageCommand()),
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
