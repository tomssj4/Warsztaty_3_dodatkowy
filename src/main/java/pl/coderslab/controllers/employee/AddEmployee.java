package pl.coderslab.controllers.employee;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/addEmployee")
public class AddEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        int number = Integer.parseInt(request.getParameter("number"));
        String note = request.getParameter("note");
        double manhourCost = Double.parseDouble(request.getParameter("manhourCost"));
        Employee employee = new Employee(name, surname, address, number, note, manhourCost);

        try {
            new EmployeeDao().create(employee);
            response.sendRedirect(getServletContext().getContextPath() + "/employee/listOfEmployees?msg=Dodano%20nowego%20pracownika%20do%20listy");
        } catch (RuntimeException ex) {
            request.setAttribute("employee", employee);
            request.setAttribute("msg", ex.getMessage());
            getServletContext().getRequestDispatcher("/jsp/employee/add_employee.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/employee/add_employee.jsp").forward(request, response);
    }

}