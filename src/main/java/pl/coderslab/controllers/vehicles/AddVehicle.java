package pl.coderslab.controllers.vehicles;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.models.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/vehicle/addVehicle", "/customer/addVehicle", "/order/addVehicle"})
public class AddVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String productionYear = request.getParameter("productionYear");
        String plateNumber = request.getParameter("plateNumber");
        String nextServiceDate = request.getParameter("nextServiceDate");
        Integer customerId = getIntParameter(request, "customerId");
        Integer orderId = getIntParameter(request, "orderId");

        Vehicle vehicle = new Vehicle(model, brand, productionYear, plateNumber, nextServiceDate, customerId);

        try {
            vehicle = new VehicleDao().create(vehicle);
            if (getCatalogueName(request).equals("customer")) {
                response.sendRedirect(getServletContext().getContextPath() + "/customer/customerVehicle?msg=Dodano%20nowy%20pojazd&customerId=" + customerId);
            }
            if (getCatalogueName(request).equals("vehicle")) {
                response.sendRedirect(getServletContext().getContextPath() + "/vehicle/listOfVehicles?msg=Dodanow%20nowy%20pojazd&customerId=" + customerId);
            }
            if (getCatalogueName(request).equals("order")) {
                response.sendRedirect(getServletContext().getContextPath() + "/order/editOrder?orderId=" + orderId + "&customerId=" + customerId + "&vehicleId=" + vehicle.getId());
            }
        } catch (RuntimeException ex) {
            request.setAttribute("customerId", customerId);
            request.setAttribute("orderId", orderId);
            request.setAttribute("cat", getCatalogueName(request));
            request.setAttribute("listOfCustomers", new CustomerDao().readAll());
            request.setAttribute("msg", ex.getMessage());
            request.setAttribute("vehicle", vehicle);
            getServletContext().getRequestDispatcher("/jsp/vehicle/add_vehicle.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = getIntParameter(request, "customerId");
        Integer orderId = getIntParameter(request, "orderId");
        request.setAttribute("customerId", customerId);
        request.setAttribute("orderId", orderId);
        request.setAttribute("cat", getCatalogueName(request));
        request.setAttribute("listOfCustomers", new CustomerDao().readAll());
        Vehicle vehicle = new Vehicle();
        if (customerId != null) {
            vehicle.setCustomerId(customerId);
        }
        request.setAttribute("vehicle", vehicle);
        getServletContext().getRequestDispatcher("/jsp/vehicle/add_vehicle.jsp").forward(request, response);
    }

    public static Integer getIntParameter(HttpServletRequest request, String parameterName) {
        try {
            return Integer.parseInt(request.getParameter(parameterName));
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getCatalogueName(HttpServletRequest request) {
        String[] uriTab = (request.getRequestURI().split("/"));
        return uriTab[uriTab.length - 2];
    }

}