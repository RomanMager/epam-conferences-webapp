package com.epam.conference.command.impl;

import com.epam.conference.command.Command;
import com.epam.conference.controller.Router;
import com.epam.conference.entity.Person;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.ParticipantService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        // String email = request.getParameter("email");

        ParticipantService participantService = new ParticipantService();

        Person participant;
        try {
            participant = participantService.findParticipant(login, password);

            if (participant != null) {
                HttpSession session = request.getSession();
                session.setAttribute("login", participant.getLogin());
                session.setAttribute("role", participant.getRole().getRoleName());
                session.setAttribute("personId", participant.getPersonId());
                page = Router.PAGE_PROFILE;
            } else {
                request.setAttribute("error", "Incorrect login or password");
                page = Router.PAGE_ERROR;
            }
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            page = Router.PAGE_ERROR;
        }

        return page;
    }
}
