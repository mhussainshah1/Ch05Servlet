package murach.email;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.UserIO;
import murach.business.User;
import murach.data.UserDB;

import java.io.IOException;

//Tomcat 7.0 or above
//@WebServlet(urlPatterns = {"/emailList", "/email/*"})
//@WebServlet(name = "EmailListServlet", urlPatterns = {"/emailList"}, initParams = {@WebInitParam(name = "relativePathToFile", value = "/WEB-INF/EmailList.txt")})
public class EmailListServlet extends HttpServlet {
    //declare an instance variable for page
    private int globalCount; //instance variables are not thread-safe

    @Override
    public void init() throws ServletException {
        globalCount = 0;//initialize the instance variable
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //update global count variable
        globalCount++;//this is not thread-safe
        System.out.println("EmailListServlet globalCount (instance variable): " + globalCount);

        String url = "/index.jsp";

        // get current action
        var action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            // (a) - forward to html page
//            url = "index.html";

            url = "/index.jsp";    // the "join" page
        } else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            //Debugging:
            System.out.println("EmailListServlet email: " + email);
            log("email=" + email);

            // store data in User object and save User object in database
            User user = new User(firstName, lastName, email);

            //validate the parameters
            String message;

            if (firstName == null || lastName == null || email == null ||
                    firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ) {
                message = "Please fill out all three text boxes.";
                //url = "/index.jsp";

            } else {
                message = "";
                // (b) - forward to jsp page
                url = "/thanks.jsp";   // the "thanks" page
                UserDB.insert(user);
            }

            /*
            ServletContext sc = this.getServletContext();
            String path = sc.getRealPath("/WEB-INF/EmailList.txt");
            try {
                UserIO.add(user, path);
            } catch (IOException e) {
                log("An exception occurred.", e);
            }
            */
            // set User object in request object and set URL
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }

        //(c) - forward to servlet
//        url= "/age";

        String custServEmail = this.getServletContext()
                .getInitParameter("custServEmail");
        System.out.println("EmailListServlet custServEmail (context variable): " + custServEmail);

        String relativePath = this.getServletConfig()
                .getInitParameter("relativePathToFile");
        System.out.println("EmailListServlet relativePath (servlet parameter):" + relativePath);

        // forward request and response objects to specified URL
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}