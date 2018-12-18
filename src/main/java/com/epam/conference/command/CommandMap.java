package com.epam.conference.command;

import com.epam.conference.command.impl.*;

public enum CommandMap {
    SIGN_IN(new SignIn()),
    SIGN_OUT(new SignOut()),
    REGISTER(new Register()),
    TO_LOGIN_PAGE(new ToLoginPage()),
    TO_MAIN_PAGE(new ToMainPage());
    
    private final Command command;
    
    CommandMap(Command command) {
        this.command = command;
    }
    
    public Command getCommand() {
        return command;
    }
}
