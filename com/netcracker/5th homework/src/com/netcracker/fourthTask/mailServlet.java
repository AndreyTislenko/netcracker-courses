package com.netcracker.fourthTask;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class mailServlet extends HttpServlet {

    private String addresser = "fakeemailforglebstask@mail.ru";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String addressee = request.getParameter("email");
        String subject = request.getParameter("subject");
        String cc = request.getParameter("cc"); //array of emails
        String textMessage = request.getParameter("message");

        String host = "smtp.mail.ru";
        String password = "andrey1995";

        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", host);



        // Get the default Session object.
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(addresser, password);
                    }
                });

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(addresser));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(addressee));
            if(cc != null && !cc.isBlank()) {
                for(String recipient: cc.split(",")) {
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient.trim()));
                }
            }

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(textMessage);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully.");

            printWriter.println("<html>");
            printWriter.println("  <head>");
            printWriter.println("  </head>");
            printWriter.println("  <body>");
            printWriter.println("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                                    "Sent Successfully! <br>" +
                                    "---> Your addressee: " + addressee + ".<br>");
            if(cc != null && !cc.isBlank()) {
                printWriter.println("---> Another addressees: " + cc);
            }
            printWriter.println("</p>");
            printWriter.println("  </body>");
            printWriter.println("</html>");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            printWriter.println("<html>");
            printWriter.println("  <head>");
            printWriter.println("  </head>");
            printWriter.println("  <body>");
            printWriter.println("<p style='background-color:red; color:white; padding:20px 20px 20px 20px'>" +
                                    "Error! <br>" +
                                    "---> Something went wrong! " +
                                "</p>");
            printWriter.println("  </body>");
            printWriter.println("</html>");
        }

    }
}
