package com.epam.conference.controller;

import com.epam.conference.command.Command;
import com.epam.conference.command.CommandMap;
import com.epam.conference.pool.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final String COMMAND = "command";
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
    @Override
    public void destroy() {
        ConnectionPool.getInstance().destroy();
    }
    
    @Override
    public void init() {
        ConnectionPool.getInstance();
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get parameter with name "command"
        String action = req.getParameter(COMMAND);
        // get command from command map
        Command command = CommandMap.valueOf(action.toUpperCase()).getCommand();
        // execute command
        String page = command.execute(req);
        // forward
        req.getRequestDispatcher(page).forward(req, resp);
    }
}
