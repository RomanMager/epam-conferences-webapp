package com.epam.conference.command.impl;

import com.epam.conference.command.Command;

import javax.servlet.http.HttpServletRequest;

public class SignIn implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }
}
