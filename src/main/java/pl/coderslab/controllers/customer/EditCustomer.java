package pl.coderslab.controllers.customer;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/editCustomer")
public class EditCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String birthDate = request.getParameter("birthDate");
        String email = request.getParameter("email");
        Customer customer = new Customer(name, surname, birthDate, email);
        customer.setId(id);

        try {
            new CustomerDao().update(customer);
            response.sendRedirect(getServletContext().getContextPath() + "/customer/listOfCustomers?msg=Zaktulizowano%20dane%klienta");
        } catch (RuntimeException ex) {
            request.setAttribute("msg", ex.getMessage());
            request.setAttribute("customer", customer);
            getServletContext().getRequestDispatcher("/jsp/customer/edit_customer.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = getIntParameter(request, "customerId");

        if (customerId != null) {
            request.setAttribute("customer", new CustomerDao().read(customerId));
            getServletContext().getRequestDispatcher("/jsp/customer/edit_customer.jsp").forward(request, response);
        }

    }

    public static Integer getIntParameter(HttpServletRequest request, String parameterName) {
        try {
            return Integer.parseInt(request.getParameter(parameterName));
        } catch (Exception ex) {
            return null;
        }
    }
}
