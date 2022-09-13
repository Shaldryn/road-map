package com.dmdev.http.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        forward(req, resp);
//        include(req, resp);
        redirect(req, resp);
    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/flights");
    }

    private void include(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/flights")
                .include(req, resp);

        /**
         * не имеет значение, так как в /flights printwriter в try-resources,
         * после того как поток закрывается при выходе из try
         * возвращается resp, если убрать try-resources то можно добавлять в ответ
         */
        var writer = resp.getWriter();
        writer.write("Hello 2");
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/flights")
                .forward(req, resp);

        /**
         * не имеет значение, так как в /flights printwriter в try-resources,
         * после того как поток закрывается при выходе из try
         * возвращается resp, да и в forward такое невозможно реализовать
         */
        var writer = resp.getWriter();
        writer.write("Hello 2");

//        getServletContext().getRequestDispatcher()

//        req.setAttribute("1", "234");
//        requestDispatcher.forward(req, resp);
    }
}
