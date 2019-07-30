package pl.coderslab.controllers.order;

import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/listOfOrders")
public class ListOfOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filter = request.getParameter("filter");
        if (filter != null) {
            request.setAttribute("filter", filter);
//            request.setAttribute("orders", new OrderDao().readAllFor("filter", filter));
        } else {
            request.setAttribute("orders", new OrderDao().readAll());
        }
        getServletContext().getRequestDispatcher("/jsp/order/list_of_orders.jsp").forward(request, response);
    }
}