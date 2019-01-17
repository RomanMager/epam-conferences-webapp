package com.epam.conference.command.impl.admin;

import com.epam.conference.command.Command;
import com.epam.conference.controller.Router;

import javax.servlet.http.HttpServletRequest;

public class CreateConference implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Router.PAGE_CREATE_CONFERENCE;
    }
}
