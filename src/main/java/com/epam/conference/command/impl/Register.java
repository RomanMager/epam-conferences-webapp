package com.epam.conference.command.impl;

import com.epam.conference.command.Command;
import com.epam.conference.controller.Router;
import com.epam.conference.entity.ParticipantData;
import com.epam.conference.entity.Person;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.ParticipantService;

import javax.servlet.http.HttpServletRequest;

public class Register implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        ParticipantService participantService = new ParticipantService();

        Person person = new Person(login, email, password);
        ParticipantData data = new ParticipantData(name, surname);

        // TODO: Check if already exists in DB
        try {
            participantService.createParticipant(person, data);
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage()); // TODO: Is it a valid way to handle exceptions in commands?
        }
        return Router.PAGE_MAIN;
    }
}
