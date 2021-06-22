package murach.email;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import murach.business.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddToEmailListServlet", value = "/addToEmailListServlet")
public class AddToEmailListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        //set attribute
        User user = new User(firstName, lastName,email);
        request.setAttribute("user", user);

        //get attribute
        User user2 = (User) request.getAttribute("user");
        out.println("<p> Object : " + user2 + "</p>");

        //primitive attribute
        int id = 1;
        request.setAttribute("id", id);

        int id2 = (Integer) request.getAttribute("id");
        out.println("<p> primitive : " + id2 +"</p>");
    }
}
