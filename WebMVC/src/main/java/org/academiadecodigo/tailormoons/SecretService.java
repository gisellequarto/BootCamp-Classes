package org.academiadecodigo.tailormoons;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecretService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Agent agent = new Agent();
        agent.setName("James");
        agent.setSurname("Bond");

        req.setAttribute("agent", agent);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

        requestDispatcher.forward(req, resp);

    }

}
