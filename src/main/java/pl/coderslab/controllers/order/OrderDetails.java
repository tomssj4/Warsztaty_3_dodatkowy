package pl.coderslab.controllers.order;

import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/orderDetails", "/order/orderDetails", "/vehicle/orderDetails", "/employee/orderDetails", "/customer/orderDetails"})
public class OrderDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer orderId = getIntParameter(request, "orderId");
        if (orderId != null) {
            request.setAttribute("order", new OrderDao().read(orderId));
            getServletContext().getRequestDispatcher("/jsp/order/order_details.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "Błąd : Nie podano indeksu zlecenia.");
            request.setAttribute("orders", new OrderDao().readAllFor("status_id", 3));
            getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
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