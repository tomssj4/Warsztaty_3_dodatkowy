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

@WebServlet(urlPatterns = {"/vehicle/editVehicle", "/customer/editVehicle"})
public class EditVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String productionYear = request.getParameter("productionYear");
        String plateNumber = request.getParameter("plateNumber");
        String nextServiceDate = request.getParameter("nextServiceDate");
        Integer customerId = getIntParameter(request, "customerId");
        Vehicle vehicle = new Vehicle(model, brand, productionYear, plateNumber, nextServiceDate, customerId);
        vehicle.setId(id);

        try {
            new VehicleDao().update(vehicle);

            if (getCatalogueName(request).equals("customer")) {
                response.sendRedirect(getServletContext().getContextPath() + "/customer/customerVehicle?msg=Zaktulizowano%20dane%20pojazdu&customerId=" + customerId);
            } else {
                response.sendRedirect(getServletContext().getContextPath() + "/vehicle/listOfVehicles?msg=Zaktulizowano%20dane%20pojazdu&customerId=" + customerId);
            }
        } catch (RuntimeException ex) {
            request.setAttribute("msg", ex.getMessage());
            request.setAttribute("vehicle", vehicle);
            getServletContext().getRequestDispatcher("/jsp/vehicle/edit_vehicle.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer vehicleId = getIntParameter(request, "vehicleId");
        Integer customerId = getIntParameter(request, "customerId");
        request.setAttribute("customerId", customerId);
        request.setAttribute("cat", getCatalogueName(request));

        if (vehicleId != null) {
            request.setAttribute("customerList", new CustomerDao().readAll());
            request.setAttribute("vehicle", new VehicleDao().read(vehicleId));
            getServletContext().getRequestDispatcher("/jsp/vehicle/edit_vehicle.jsp").forward(request, response);
        }
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
