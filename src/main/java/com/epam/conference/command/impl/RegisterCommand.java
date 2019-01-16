package com.epam.conference.command.impl;

import com.epam.conference.command.Command;
import com.epam.conference.command.ParameterValue;
import com.epam.conference.controller.Router;
import com.epam.conference.entity.ParticipantData;
import com.epam.conference.entity.Person;
import com.epam.conference.entity.Role;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.ParticipantService;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    private static final int PARTICIPANT_ROLE_ID = 2;

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(ParameterValue.LOGIN);
        String email = request.getParameter(ParameterValue.EMAIL);
        String password = request.getParameter(ParameterValue.PASSWORD);
        String name = request.getParameter(ParameterValue.NAME);
        String surname = request.getParameter(ParameterValue.SURNAME);

        ParticipantService participantService = new ParticipantService();

        Role role = new Role(PARTICIPANT_ROLE_ID);
        Person person = new Person(login, email, password, role);
        ParticipantData data = new ParticipantData(name, surname);

        // TODO: Check if already exists in DB
        try {
            participantService.createParticipant(person, data);
        } catch (ServiceException e) {
            request.setAttribute(ParameterValue.ERROR, e.getMessage());
        }
        return Router.PAGE_MAIN;
    }
}
