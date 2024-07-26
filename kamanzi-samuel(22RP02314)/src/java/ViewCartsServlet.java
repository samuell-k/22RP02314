import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/view_carts")
public class ViewCartsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String cartItems = "";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    cartItems = cookie.getValue();
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        out.println(".container { max-width: 800px; margin: 0 auto; padding: 20px; background: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
        out.println("table { width: 100%; border-collapse: collapse; }");
        out.println("th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }");
        out.println("th { background-color: #f4f4f4; }");
        out.println(".actions a { text-decoration: none; color: #007bff; }");
        out.println(".actions a:hover { text-decoration: underline; }");
        out.println("</style></head><body>");
        out.println("<div class=\"container\">");
        out.println("<h1>Your Shopping Cart</h1>");

        if (cartItems.isEmpty()) {
            out.println("<p>Your cart is empty.</p>");
        } else {
            out.println("<form method='post' action='update_cart'>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Item</th>");
            out.println("<th>Cost</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            // Split and display items
            String[] items = cartItems.split("\\|");
            for (String item : items) {
                String[] itemDetails = item.split(":");
                if (itemDetails.length == 2) {
                    String itemName = itemDetails[0];
                    String itemCost = itemDetails[1];
                    out.println("<tr>");
                    out.println("<td>" + itemName + "</td>");
                    out.println("<td>" + itemCost + "</td>");
                    out.println("</tr>");
                }
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</form>");
        }

        out.println("<div class='actions'>");
        out.println("<a href='clear_carts'>Clear Cart</a>");
        out.println("</div>");
        out.println("<div class='actions'>");
        out.println("<a href='index.jsp'>Add items to Cart</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
