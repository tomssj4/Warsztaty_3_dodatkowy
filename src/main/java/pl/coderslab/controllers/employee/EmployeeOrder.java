package pl.coderslab.controllers.employee;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.StatusDao;
import pl.coderslab.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee/employeeOrder")
public class EmployeeOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        String statusId = request.getParameter("statusId");

        List<Order> orders;

        if (employeeId != null && employeeId != "") {
            request.setAttribute("employeeId", Integer.parseInt(employeeId));
            orders = new OrderDao().readAllFor("employee", Integer.parseInt(employeeId));
            leaveOnlyOrdersWithStatus(orders, statusId);
            request.setAttribute("orders", orders);
        } else {
            orders = new OrderDao().readAll();
            leaveOnlyOrdersWithStatus(orders, statusId);
            request.setAttribute("orders", orders);
        }

        if (statusId != null && statusId != "") {
            int intStatusId = Integer.parseInt(statusId);
            request.setAttribute("statusId", intStatusId);
        }

        request.setAttribute("statusList", new StatusDao().readAll());
        request.setAttribute("listOfEmployees", new EmployeeDao().readAll());
        getServletContext().getRequestDispatcher("/jsp/employee/employee_order.jsp").forward(request, response);

    }

    private void leaveOnlyOrdersWithStatus(List<Order> orders, String statusId) {
        if (statusId != null && statusId != "") {
            int intStatusId = Integer.parseInt(statusId);
            orders.removeIf(order -> order.getStatusId() != intStatusId);
        }
    }

}