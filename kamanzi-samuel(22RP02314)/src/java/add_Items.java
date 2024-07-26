/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */



/**
 *
 * @author Samuel
 */


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add_Items")
public class add_Items extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get item details from the form
        String itemName = request.getParameter("item");
        String costStr = request.getParameter("cost");

        if (itemName == null ||  costStr == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "USE REQUIRED DATA");
            return;
        }

        int quantity;
        double cost;

        try {
            
            cost = Double.parseDouble(costStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "USE NUMBER OR FLOAT");
            return;
        }

        // Retrieve existing cart cookies
        Cookie[] cookies = request.getCookies();
        StringBuilder cart = new StringBuilder();
        boolean cartFound = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    cart.append(cookie.getValue());
                    cartFound = true;
                }
            }
        }

        // Append new item to the cart
        if (cartFound) {
            cart.append("|");
        }
        cart.append(itemName).append(":").append(cost);

        // Create and add the cart cookie
        Cookie cartCookie = new Cookie("cart", cart.toString());
        cartCookie.setMaxAge(120 * 120 * 24); 
        response.addCookie(cartCookie);

        // Redirect to the view cart page
        response.sendRedirect("view_carts");
    }
}
