package com.calci;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TipServlet")
public class TipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double bill = Double.parseDouble(request.getParameter("billAmount"));
        int tipPercent = Integer.parseInt(request.getParameter("tipPercentage"));
        double tip = bill * tipPercent / 100;
        double total = bill + tip;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Tip Calculation Result</h2>");
        out.println("<p>Bill Amount: " + bill + "</p>");
        out.println("<p>Tip Percentage: " + tipPercent + "%</p>");
        out.println("<p>Tip Amount: " + tip + "</p>");
        out.println("<p>Total Amount: " + total + "</p>");
        out.println("<a href='index.html'>Back</a>");
        out.println("</body></html>");
    }
}
