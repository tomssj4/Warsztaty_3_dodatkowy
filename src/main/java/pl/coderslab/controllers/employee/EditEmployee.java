package pl.coderslab.controllers.employee;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/editEmployee")
public class EditEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surame = request.getParameter("surame");
        String address = request.getParameter("address");
        int number = Integer.parseInt(request.getParameter("number"));
        String note = request.getParameter("note");
        double manhourCost = Double.parseDouble(request.getParameter("manhourCost"));
        Employee employee = new Employee(name, surame, address, number, note, manhourCost);
        employee.setId(id);

        try {
            new EmployeeDao().update(employee);
            response.sendRedirect(getServletContext().getContextPath() + "/employee/listOfEmployees?msg=Zaktualizowano%20dane%20pracownika");
        } catch (RuntimeException ex) {
            request.setAttribute("msg", ex.getMessage());
            request.setAttribute("employee", employee);
            getServletContext().getRequestDispatcher("/jsp/employee/edit_employee.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));

        if (employeeId != null) {
            request.setAttribute("employee", new EmployeeDao().read(employeeId));
            getServletContext().getRequestDispatcher("/jsp/employee/edit_employee.jsp").forward(request, response);
        }

    }
}
