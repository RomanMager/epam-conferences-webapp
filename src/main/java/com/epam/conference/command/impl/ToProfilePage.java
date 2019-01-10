package com.epam.conference.command.impl;

import com.epam.conference.command.Command;
import com.epam.conference.controller.Router;
import com.epam.conference.entity.ParticipantData;
import com.epam.conference.entity.Person;
import com.epam.conference.service.ParticipantService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ToProfilePage implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page;

        int participantId = Integer.parseInt(request.getParameter("person_id"));

        ParticipantService participantService = new ParticipantService();
        Person participant = participantService.findParticipant(participantId);
        ParticipantData participantData = participantService.findParticipantData(participantId);

        if (participant != null) {
            HttpSession session = request.getSession();
            page = Router.PAGE_PROFILE;
        } else {
            request.setAttribute("error", "Incorrect login or password");
            page = Router.PAGE_MAIN; // TODO: replace with error page
        }

        return page;
    }
}
