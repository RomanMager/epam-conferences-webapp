package com.epam.conference.command.impl.routing;

import com.epam.conference.command.Command;

import javax.servlet.http.HttpServletRequest;

public class ToMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }
}
