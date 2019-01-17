package com.epam.conference.command;

import com.epam.conference.command.impl.GetUsersCommand;
import com.epam.conference.command.impl.RegisterCommand;
import com.epam.conference.command.impl.SignInCommand;
import com.epam.conference.command.impl.SignOutCommand;
import com.epam.conference.command.impl.admin.CreateConferenceCommand;
import com.epam.conference.command.impl.routing.*;

public enum CommandMap {
    TO_MAIN_PAGE(new ToMainPageCommand()),
    TO_REGISTER_PAGE(new ToRegisterPageCommand()),
    TO_LOGIN_PAGE(new ToLoginPageCommand()),
    TO_PROFILE_PAGE(new ToProfilePageCommand()),
    TO_CREATE_CONFERENCE_PAGE(new ToCreateConferencePageCommand()),
    REGISTER(new RegisterCommand()),
    SIGN_IN(new SignInCommand()),
    SIGN_OUT(new SignOutCommand()),
    GET_USERS(new GetUsersCommand()),
    CREATE_CONFERENCE(new CreateConferenceCommand());

    private final Command command;

    CommandMap(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
