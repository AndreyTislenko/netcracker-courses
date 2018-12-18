package com.netcracker.firstAndSecondTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        //getting form
        String password = req.getParameter("password");
        String login = req.getParameter("login");

        System.out.println("login = " + login + ", password = " + password);

        /*res.setContentType("text/html");//setting the content type
        PrintWriter pw=res.getWriter();//get the stream to write the data*/

        if(Validation.validateLogin(login)) {

            //password is qwerty
            if (Validation.validatePassword(password)) {
                res.setContentType("text/html");//setting the content type
                PrintWriter pw = res.getWriter();//get the stream to write the data

                // writing html in the stream
                pw.println("<html><body>");
                pw.println("hello " + login);
                pw.println(", your password is correct!");
                pw.println("</body></html>");

                pw.close();//closing the stream
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(Validation.getWrongPasswordPage());
                rd.include(req, res);
            }
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(Validation.getIncorrectLoginPage());
            rd.include(req, res);
        }

        /*// writing html in the stream
        pw.println("<html><body>");
        pw.println("hello " + login);
        pw.println("</body></html>");

        pw.close();//closing the stream*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doGet(req, res);
    }
}
