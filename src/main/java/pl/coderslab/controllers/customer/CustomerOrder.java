package pl.coderslab.controllers.customer;

import pl.coderslab.dao.CustomerDao;
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

@WebServlet("/customer/customerOrder")
public class CustomerOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = getIntParameter(request, "customerId");
        Integer statusId = getIntParameter(request, "statusId");
        List<Order> orders;

        if (customerId != null) {
            request.setAttribute("customerId", customerId);
            orders = new OrderDao().readAllFor("customer", customerId);
            leaveOnlyOrdersWithStatus(orders, statusId);
            request.setAttribute("orders", orders);
        } else {
            orders = new OrderDao().readAll();
            leaveOnlyOrdersWithStatus(orders, statusId);
            request.setAttribute("orders", orders);
        }

        if (statusId != null) {
            request.setAttribute("statusId", statusId);
        }

        request.setAttribute("statusList", new StatusDao().readAll());
        request.setAttribute("customerList", new CustomerDao().readAll());

        getServletContext().getRequestDispatcher("/jsp/customer/customer_order.jsp").forward(request, response);
    }

    private void leaveOnlyOrdersWithStatus(List<Order> orders, Integer statusId) {
        if (statusId != null) {
            orders.removeIf(order -> order.getStatusId() != statusId);
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
