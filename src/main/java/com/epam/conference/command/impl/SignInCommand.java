package com.epam.conference.command.impl;

import com.epam.conference.command.Command;
import com.epam.conference.controller.Router;
import com.epam.conference.entity.Person;
import com.epam.conference.service.ParticipantService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ParticipantService participantService = new ParticipantService();

        Person participant = participantService.findParticipant(login, password);

        if (participant != null) {
            HttpSession session = request.getSession();
            session.setAttribute("login", participant.getLogin());
            session.setAttribute("role", participant.getRole());
            session.setAttribute("personId", participant.getPersonId());
            page = Router.PAGE_PROFILE;
        } else {
            request.setAttribute("error", "Incorrect login or password");
            page = Router.PAGE_MAIN; // TODO: replace with error page
        }

        return page;
    }
}