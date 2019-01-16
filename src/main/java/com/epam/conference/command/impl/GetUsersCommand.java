package com.epam.conference.command.impl;

import com.epam.conference.command.Command;
import com.epam.conference.command.ParameterValue;
import com.epam.conference.controller.Router;
import com.epam.conference.entity.Person;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.ParticipantService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GetUsersCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page;

        List<Person> participants = new ArrayList<>();
        ParticipantService service = new ParticipantService();

        try {
            participants = service.findAllParticipants();
            page = Router.PAGE_PARTICIPANTS;
        } catch (ServiceException e) {
            request.setAttribute(ParameterValue.ERROR, e);
            page = Router.PAGE_ERROR;
        }

        request.getSession().setAttribute(ParameterValue.PARTICIPANTS, participants);
        request.setAttribute(ParameterValue.PARTICIPANTS, participants);
        return page;
    }
}
