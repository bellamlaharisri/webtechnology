package com.campusconnect;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentRegistrationServlet")
public class StudentRegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Request-specific local variables
        String name = request.getParameter("name");
        String regno = request.getParameter("regno");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String semester = request.getParameter("semester");


        // Empty-field validation
        if (name == null || name.trim().isEmpty() ||
            regno == null || regno.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            department == null || department.trim().isEmpty() ||
            semester == null || semester.trim().isEmpty()) {

            displayError(out);

            return;
        }


        // Dynamic result page
        out.println("""
            <!DOCTYPE html>
            <html>
            <head>

            <meta charset="UTF-8">

            <meta name="viewport"
                  content="width=device-width, initial-scale=1.0">

            <title>Registration Successful</title>

            <style>

                * {
                    box-sizing: border-box;
                }

                body {
                    margin: 0;
                    min-height: 100vh;

                    font-family:
                        "Segoe UI",
                        Arial,
                        sans-serif;

                    background:
                        radial-gradient(
                            circle at top left,
                            #dbeafe,
                            transparent 35%
                        ),
                        radial-gradient(
                            circle at bottom right,
                            #ede9fe,
                            transparent 35%
                        ),
                        #f8fafc;

                    display: flex;
                    align-items: center;
                    justify-content: center;

                    padding: 25px;
                }

                .result-card {
                    width: 100%;
                    max-width: 720px;

                    background: white;

                    border-radius: 26px;

                    overflow: hidden;

                    box-shadow:
                        0 25px 70px
                        rgba(15,23,42,0.14);
                }

                .top {
                    padding: 40px;

                    background:
                        linear-gradient(
                            135deg,
                            #111827,
                            #312e81,
                            #4f46e5
                        );

                    color: white;

                    text-align: center;
                }

                .success-icon {
                    width: 70px;
                    height: 70px;

                    margin: auto;

                    border-radius: 50%;

                    display: flex;
                    align-items: center;
                    justify-content: center;

                    background:
                        rgba(255,255,255,0.15);

                    font-size: 32px;
                }

                .top h1 {
                    margin: 18px 0 8px;
                }

                .top p {
                    margin: 0;

                    color: #dbeafe;
                }

                .content {
                    padding: 35px;
                }

                .section-title {
                    font-size: 18px;

                    font-weight: 700;

                    color: #1e293b;

                    margin-bottom: 20px;
                }

                .details {
                    display: grid;

                    grid-template-columns:
                        1fr 1fr;

                    gap: 15px;
                }

                .detail-box {
                    padding: 18px;

                    background: #f8fafc;

                    border: 1px solid #e2e8f0;

                    border-radius: 14px;
                }

                .detail-box.full {
                    grid-column: span 2;
                }

                .label {
                    font-size: 11px;

                    font-weight: 700;

                    letter-spacing: 1px;

                    color: #64748b;

                    text-transform: uppercase;

                    margin-bottom: 7px;
                }

                .value {
                    font-size: 16px;

                    font-weight: 600;

                    color: #172033;

                    word-break: break-word;
                }

                .footer {
                    margin-top: 28px;

                    display: flex;

                    gap: 12px;
                }

                .button {
                    flex: 1;

                    text-align: center;

                    padding: 14px;

                    border-radius: 11px;

                    text-decoration: none;

                    font-weight: 600;

                    font-size: 14px;
                }

                .primary {
                    background: #4f46e5;

                    color: white;
                }

                .secondary {
                    background: #f1f5f9;

                    color: #475569;
                }

                @media(max-width:600px) {

                    .details {
                        grid-template-columns: 1fr;
                    }

                    .detail-box.full {
                        grid-column: span 1;
                    }

                    .content {
                        padding: 22px;
                    }

                    .footer {
                        flex-direction: column;
                    }
                }

            </style>

            </head>

            <body>

            <div class="result-card">

                <div class="top">

                    <div class="success-icon">
                        ✓
                    </div>

                    <h1>
                        Registration Successful
                    </h1>

                    <p>
                        Student details submitted successfully
                    </p>

                </div>

                <div class="content">

                    <div class="section-title">
                        Submitted Student Details
                    </div>

                    <div class="details">
            """);

        // Student Name
        out.println("""
                    <div class="detail-box full">
                        <div class="label">
                            Student Name
                        </div>

                        <div class="value">
            """);

        out.println(name);

        out.println("""
                        </div>
                    </div>
            """);


        // Register Number
        out.println("""
                    <div class="detail-box">

                        <div class="label">
                            Register Number
                        </div>

                        <div class="value">
            """);

        out.println(regno);

        out.println("""
                        </div>
                    </div>
            """);


        // Email
        out.println("""
                    <div class="detail-box">

                        <div class="label">
                            Email
                        </div>

                        <div class="value">
            """);

        out.println(email);

        out.println("""
                        </div>
                    </div>
            """);


        // Department
        out.println("""
                    <div class="detail-box">

                        <div class="label">
                            Department
                        </div>

                        <div class="value">
            """);

        out.println(department);

        out.println("""
                        </div>
                    </div>
            """);


        // Semester
        out.println("""
                    <div class="detail-box">

                        <div class="label">
                            Semester
                        </div>

                        <div class="value">
            """);

        out.println(semester);

        out.println("""
                        </div>
                    </div>

                    </div>

                    <div class="footer">

                        <a
                            href="index.html"
                            class="button primary">

                            Register Another Student

                        </a>

                        <a
                            href="index.html"
                            class="button secondary">

                            Back to Form

                        </a>

                    </div>

                </div>

            </div>

            </body>
            </html>
            """);
    }


    // Validation error page
    private void displayError(PrintWriter out) {

        out.println("""
            <!DOCTYPE html>

            <html>

            <head>

            <meta charset="UTF-8">

            <title>Registration Error</title>

            <style>

                body {
                    margin: 0;

                    min-height: 100vh;

                    font-family: Arial;

                    background: #f8fafc;

                    display: flex;

                    justify-content: center;

                    align-items: center;
                }

                .error-card {
                    width: 90%;
                    max-width: 500px;

                    background: white;

                    padding: 45px;

                    text-align: center;

                    border-radius: 22px;

                    box-shadow:
                        0 20px 50px
                        rgba(0,0,0,0.1);
                }

                .icon {
                    width: 65px;
                    height: 65px;

                    margin: auto;

                    border-radius: 50%;

                    background: #fee2e2;

                    color: #dc2626;

                    display: flex;

                    justify-content: center;

                    align-items: center;

                    font-size: 30px;

                    font-weight: bold;
                }

                h2 {
                    color: #1e293b;

                    margin-top: 20px;
                }

                p {
                    color: #64748b;
                }

                a {
                    display: inline-block;

                    margin-top: 20px;

                    padding: 13px 25px;

                    background: #4f46e5;

                    color: white;

                    text-decoration: none;

                    border-radius: 10px;
                }

            </style>

            </head>

            <body>

            <div class="error-card">

                <div class="icon">
                    !
                </div>

                <h2>
                    Registration Incomplete
                </h2>

                <p>
                    Please fill in all required fields
                    before submitting the form.
                </p>

                <a href="index.html">
                    Return to Registration
                </a>

            </div>

            </body>

            </html>
            """);
    }
}
