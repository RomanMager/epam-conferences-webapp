package com.epam.conference.command.impl;

import com.epam.conference.command.Command;
import com.epam.conference.controller.Router;

import javax.servlet.http.HttpServletRequest;

public class ToLoginPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Router.PAGE_LOGIN;
    }
}
