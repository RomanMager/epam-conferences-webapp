package com.epam.conference.command.impl.routing;

import com.epam.conference.command.Command;
import com.epam.conference.controller.Router;

import javax.servlet.http.HttpServletRequest;

public class ToMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Router.PAGE_MAIN;
    }
}
