package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentResultServlet")
public class StudentResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Request-specific local variables
        String name = request.getParameter("name");
        String regno = request.getParameter("regno");

        String mark1Str = request.getParameter("mark1");
        String mark2Str = request.getParameter("mark2");
        String mark3Str = request.getParameter("mark3");


        // Missing value validation
        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty() ||
            mark1Str == null || mark1Str.trim().isEmpty() ||
            mark2Str == null || mark2Str.trim().isEmpty() ||
            mark3Str == null || mark3Str.trim().isEmpty()) {

            showError(out, "Please fill all required fields.");
            return;
        }


        try {

            int mark1 = Integer.parseInt(mark1Str);
            int mark2 = Integer.parseInt(mark2Str);
            int mark3 = Integer.parseInt(mark3Str);


            // Marks validation
            if (mark1 < 0 || mark1 > 100 ||
                mark2 < 0 || mark2 > 100 ||
                mark3 < 0 || mark3 > 100) {

                showError(out, "Marks must be between 0 and 100.");
                return;
            }


            // Calculations
            int total = mark1 + mark2 + mark3;

            double average = total / 3.0;

            int highest = Math.max(
                    mark1,
                    Math.max(mark2, mark3)
            );


            // Pass / Fail
            String status;

            if (mark1 >= 40 &&
                mark2 >= 40 &&
                mark3 >= 40) {

                status = "PASS";

            } else {

                status = "FAIL";
            }


            // Advanced Result Page

            out.println("<!DOCTYPE html>");

            out.println("<html>");
            out.println("<head>");

            out.println("<title>Student Result</title>");

            out.println("<style>");

            out.println("""
                * {
                    box-sizing: border-box;
                }

                body {
                    margin: 0;
                    font-family: Arial, sans-serif;
                    background: #f1f5f9;
                    padding: 40px 20px;
                    color: #172033;
                }

                .container {
                    max-width: 850px;
                    margin: auto;
                    background: white;
                    border-radius: 24px;
                    overflow: hidden;
                    box-shadow: 0 20px 50px rgba(0,0,0,.12);
                }

                .header {
                    padding: 35px;
                    color: white;
                    background: linear-gradient(
                        135deg,
                        #172033,
                        #4f46e5
                    );
                }

                .header h1 {
                    margin: 0 0 8px;
                }

                .header p {
                    margin: 0;
                    opacity: .8;
                }

                .content {
                    padding: 35px;
                }

                .student {
                    display: grid;
                    grid-template-columns: 1fr 1fr;
                    gap: 15px;
                    margin-bottom: 30px;
                }

                .info-box {
                    padding: 18px;
                    background: #f8fafc;
                    border-radius: 14px;
                }

                .label {
                    color: #64748b;
                    font-size: 13px;
                    margin-bottom: 5px;
                }

                .value {
                    font-size: 18px;
                    font-weight: bold;
                }

                .results {
                    display: grid;
                    grid-template-columns:
                        repeat(4, 1fr);
                    gap: 15px;
                }

                .result-card {
                    padding: 22px;
                    text-align: center;
                    border-radius: 16px;
                    background: #f8fafc;
                }

                .result-card h3 {
                    margin: 0 0 10px;
                    font-size: 14px;
                    color: #64748b;
                }

                .result-card p {
                    margin: 0;
                    font-size: 25px;
                    font-weight: bold;
                    color: #4f46e5;
                }

                .status {
                    margin-top: 25px;
                    padding: 18px;
                    text-align: center;
                    border-radius: 14px;
                    font-size: 22px;
                    font-weight: bold;
                }

                .pass {
                    background: #dcfce7;
                    color: #15803d;
                }

                .fail {
                    background: #fee2e2;
                    color: #dc2626;
                }

                .subjects {
                    margin-top: 30px;
                }

                .subjects table {
                    width: 100%;
                    border-collapse: collapse;
                }

                th, td {
                    padding: 15px;
                    text-align: left;
                    border-bottom: 1px solid #e2e8f0;
                }

                th {
                    background: #f8fafc;
                }

                .back {
                    display: inline-block;
                    margin-top: 25px;
                    padding: 13px 22px;
                    background: #4f46e5;
                    color: white;
                    text-decoration: none;
                    border-radius: 10px;
                }

                @media(max-width:700px) {
                    .student,
                    .results {
                        grid-template-columns: 1fr;
                    }

                    .content {
                        padding: 20px;
                    }
                }
            """);

            out.println("</style>");

            out.println("</head>");

            out.println("<body>");


            out.println("<div class='container'>");


            // Header
            out.println("<div class='header'>");

            out.println("<h1>Student Result</h1>");

            out.println(
                "<p>Servlet-Based Result Processing System</p>"
            );

            out.println("</div>");


            out.println("<div class='content'>");


            // Student Information
            out.println("<div class='student'>");

            out.println("<div class='info-box'>");

            out.println("<div class='label'>STUDENT NAME</div>");

            out.println(
                "<div class='value'>" + name + "</div>"
            );

            out.println("</div>");


            out.println("<div class='info-box'>");

            out.println("<div class='label'>REGISTER NUMBER</div>");

            out.println(
                "<div class='value'>" + regno + "</div>"
            );

            out.println("</div>");

            out.println("</div>");


            // Result Cards
            out.println("<div class='results'>");


            out.println("<div class='result-card'>");

            out.println("<h3>TOTAL</h3>");

            out.println("<p>" + total + "</p>");

            out.println("</div>");


            out.println("<div class='result-card'>");

            out.println("<h3>AVERAGE</h3>");

            out.println(
                "<p>" +
                String.format("%.2f", average) +
                "</p>"
            );

            out.println("</div>");


            out.println("<div class='result-card'>");

            out.println("<h3>HIGHEST</h3>");

            out.println("<p>" + highest + "</p>");

            out.println("</div>");


            out.println("<div class='result-card'>");

            out.println("<h3>SUBJECTS</h3>");

            out.println("<p>3</p>");

            out.println("</div>");


            out.println("</div>");


            // Subject Table
            out.println("<div class='subjects'>");

            out.println("<table>");

            out.println("<tr>");
            out.println("<th>Subject</th>");
            out.println("<th>Mark</th>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Subject 1</td>");
            out.println("<td>" + mark1 + "</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Subject 2</td>");
            out.println("<td>" + mark2 + "</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Subject 3</td>");
            out.println("<td>" + mark3 + "</td>");
            out.println("</tr>");

            out.println("</table>");

            out.println("</div>");


            // Status
            String statusClass =
                    status.equals("PASS") ? "pass" : "fail";

            out.println(
                "<div class='status " +
                statusClass +
                "'>"
            );

            out.println("RESULT STATUS: " + status);

            out.println("</div>");


            out.println(
                "<a class='back' href='index.html'>" +
                "← Enter Another Student" +
                "</a>"
            );


            out.println("</div>");

            out.println("</div>");

            out.println("</body>");

            out.println("</html>");

        } catch (NumberFormatException e) {

            showError(
                out,
                "Please enter valid numeric marks."
            );
        }
    }


    private void showError(PrintWriter out, String message) {

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Validation Error</title>");

        out.println("""
            <style>
                body {
                    font-family: Arial;
                    background: #f1f5f9;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    min-height: 100vh;
                }

                .error {
                    background: white;
                    padding: 40px;
                    border-radius: 20px;
                    text-align: center;
                    box-shadow: 0 15px 40px rgba(0,0,0,.1);
                }

                h2 {
                    color: #dc2626;
                }

                a {
                    display: inline-block;
                    margin-top: 20px;
                    padding: 12px 20px;
                    background: #4f46e5;
                    color: white;
                    text-decoration: none;
                    border-radius: 8px;
                }
            </style>
        """);

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='error'>");

        out.println("<h2>Validation Error</h2>");

        out.println("<p>" + message + "</p>");

        out.println(
            "<a href='index.html'>Go Back</a>"
        );

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }
}
