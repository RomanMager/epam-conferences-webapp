package com.epam.conference.command.impl;

import com.epam.conference.command.Command;

import javax.servlet.http.HttpServletRequest;

public class Register implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        throw new UnsupportedOperationException();
    }
}
