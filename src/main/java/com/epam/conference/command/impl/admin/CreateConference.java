package com.epam.conference.command.impl.admin;

import com.epam.conference.command.Command;
import com.epam.conference.command.ParameterValue;
import com.epam.conference.controller.Router;
import com.epam.conference.entity.Conference;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;

public class CreateConference implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String title = request.getParameter(ParameterValue.TITLE);
        String topic = request.getParameter(ParameterValue.TOPIC);
        String description = request.getParameter(ParameterValue.DESCRIPTION);

        ConferenceService conferenceService = new ConferenceService();

        Conference conference = new Conference(title, topic, description);

        try {
            conferenceService.createConference(conference);
        } catch (ServiceException e) {
            request.setAttribute(ParameterValue.ERROR, e.getMessage());
        }

        return Router.PAGE_MAIN;
    }
}
