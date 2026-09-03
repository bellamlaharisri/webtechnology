package com.webtech;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Set response type
        response.setContentType("text/html");

        // Create PrintWriter
        PrintWriter out = response.getWriter();

        // Get current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String dateTime = currentDateTime.format(formatter);

        // Generate HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");

        out.println("<title>Welcome Servlet</title>");

        out.println("<style>");

        out.println("body {");
        out.println("font-family: Arial, sans-serif;");
        out.println("background: linear-gradient(135deg, #667eea, #764ba2);");
        out.println("text-align: center;");
        out.println("padding-top: 80px;");
        out.println("}");

        out.println(".container {");
        out.println("background: white;");
        out.println("width: 600px;");
        out.println("margin: auto;");
        out.println("padding: 40px;");
        out.println("border-radius: 20px;");
        out.println("box-shadow: 0 10px 30px rgba(0,0,0,0.3);");
        out.println("}");

        out.println("h1 {");
        out.println("color: #5a4fcf;");
        out.println("}");

        out.println("h2 {");
        out.println("color: #333;");
        out.println("}");

        out.println(".time {");
        out.println("color: #764ba2;");
        out.println("font-size: 22px;");
        out.println("font-weight: bold;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<h1>Welcome to Web Technology</h1>");

        out.println("<h2>Student Name: Bhavya Lakshmi</h2>");

        out.println("<h2>Course: B.Tech Information Technology</h2>");

        out.println("<h2>Current Date and Time</h2>");

        out.println("<p class='time'>" + dateTime + "</p>");

        out.println("<p>");
        out.println("This page is generated dynamically using Java Servlet.");
        out.println("</p>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }
}
