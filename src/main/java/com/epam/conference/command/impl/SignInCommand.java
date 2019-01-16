package com.epam.conference.command.impl;

import com.epam.conference.command.Command;
import com.epam.conference.command.ParameterValue;
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
        String login = request.getParameter(ParameterValue.LOGIN);
        String password = request.getParameter(ParameterValue.PASSWORD);

        ParticipantService participantService = new ParticipantService();

        Person participant;
        try {
            participant = participantService.findParticipant(login, password);

            if (participant != null) {
                HttpSession session = request.getSession();
                session.setAttribute(ParameterValue.LOGIN, participant.getLogin());
                session.setAttribute(ParameterValue.ROLE, participant.getRole().getRoleName());
                session.setAttribute(ParameterValue.PERSON_ID, participant.getPersonId());
                page = Router.PAGE_PROFILE;
            } else {
                request.setAttribute(ParameterValue.ERROR, "Incorrect login or password");
                page = Router.PAGE_ERROR;
            }
        } catch (ServiceException e) {
            request.setAttribute(ParameterValue.ERROR, e.getMessage());
            page = Router.PAGE_ERROR;
        }

        return page;
    }
}
