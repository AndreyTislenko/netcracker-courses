package com.netcracker.thirdTask;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String userAgent = req.getHeader("User-Agent");

        String date = req.getReader().readLine();
        System.out.println(date);

        res.setContentType("text/html");

        PrintWriter printWriter = res.getWriter();
        printWriter.println("<html>");
        printWriter.println("  <head>");
        printWriter.println("     <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-latest.min.js\"></script>");
        printWriter.println("  </head>");
        printWriter.println("  <body>");
        printWriter.println("     <div>Your browser: " + BrowserGetter.getBrowser(userAgent) + "</div>");
        if(date != null) {
            System.out.println("inside if");
            date = date.split("\"")[3];
            printWriter.println("     <div>Your time and date: " + date + "</div>");
        } else {
            System.out.println("inside else");
            printWriter.println("<script type=\"text/javascript\" src=\"/js/getTimeZoneOffsetScript.js\"></script>");
        }
        System.out.println("end");
        printWriter.println("  </body>");
        printWriter.println("</html>");
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        doGet(req, res);
    }
}
