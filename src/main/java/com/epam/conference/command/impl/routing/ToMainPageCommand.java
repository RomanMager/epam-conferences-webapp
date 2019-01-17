package com.epam.conference.command.impl.routing;

import com.epam.conference.command.Command;
import com.epam.conference.command.ParameterValue;
import com.epam.conference.controller.Router;
import com.epam.conference.entity.Conference;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ToMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page;

        List<Conference> conferences = new ArrayList<>();
        ConferenceService service = new ConferenceService();

        try {
            conferences = service.findAllConferences();
            page = Router.PAGE_MAIN;
        } catch (ServiceException e) {
            request.setAttribute(ParameterValue.ERROR, e);
            page = Router.PAGE_ERROR;
        }

        request.setAttribute("conferences", conferences);

        return page;
    }
}
