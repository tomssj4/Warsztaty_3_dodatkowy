package pl.coderslab.controllers.order;

import pl.coderslab.dao.*;
import pl.coderslab.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/addOrder")
public class AddOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean exit = false;
        String action = request.getParameter("action");

        Order order = getAtrributesFromFormAndSetOrder(request);
        request.setAttribute("statusList", new StatusDao().readAll());
        request.setAttribute("employeeList", new EmployeeDao().readAll());
        request.setAttribute("customerList", new CustomerDao().readAll());
        request.setAttribute("vehicleList", new VehicleDao().readAllForCustomer(order.getCustomerId()));
        switch (action) {
            case "customer": {
                order.setRepairedVehicleId(0);
                break;
            }
            case "vehicle": {
                if (order.getRepairedVehicleId() != 0) {
                    System.out.println(order.getStartRepairDate());
                    order.setCustomerId(new VehicleDao().read(order.getRepairedVehicleId()).getCustomerId());
                    request.setAttribute("vehicleList", new VehicleDao().readAllForCustomer(order.getCustomerId()));
                }
                break;
            }
            case "employee": {
                if (order.getEmployeeId() != 0) {
                    order.setManhourCost(new EmployeeDao().read(order.getEmployeeId()).getManhourCost());
                } else {
                    order.setManhourCost(0);
                }
                break;
            }
            case "create": {
                if (order.getRepairedVehicleId() != 0 && order.getEmployeeId() != 0) {
                    try {
                        new OrderDao().create(order);
                        exit = true;
                    } catch (RuntimeException ex) {
                        request.setAttribute("msg", ex.getMessage());
                    }
                } else {
                    request.setAttribute("msg", "Nieprawidłowo wypełniony arkusz ze zleceniem.");
                }
                break;
            }
        }

        if (!exit) {
            if (order.getRepairedVehicleId() == 0 && order.getCustomerId() == 0) {
                request.setAttribute("vehicleList", new VehicleDao().readAll());
            }
            request.setAttribute("order", order);
            request.getServletContext().getRequestDispatcher("/jsp/order/add_order.jsp").forward(request, response);
        } else {
            response.sendRedirect(getServletContext().getContextPath() + "/order/listOfOrders?msg=Dodano%20nowe%20zlecenie");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = getIntParameter(request, "customerId");
        Integer vehicleId = getIntParameter(request, "vehicleId");

        Order order = new Order();

        if (customerId != null) {
            order.setCustomerId(customerId);
            if (vehicleId != null) {
                order.setRepairedVehicleId(vehicleId);
            } else {
                order.setRepairedVehicleId(0);
            }
        }

        request.setAttribute("order", order);
        request.setAttribute("statusList", new StatusDao().readAll());
        request.setAttribute("employeeList", new EmployeeDao().readAll());
        request.setAttribute("customerList", new CustomerDao().readAll());
        request.setAttribute("vehicleList", new VehicleDao().readAllForCustomer(order.getCustomerId()));
        request.getServletContext().getRequestDispatcher("/jsp/order/add_order.jsp").forward(request, response);
    }

    private static Order getAtrributesFromFormAndSetOrder(HttpServletRequest request) {
        Order order = new Order();
        Integer statusId = getIntParameter(request, "statusId");
        Integer customerId = getIntParameter(request, "customerId");
        Integer vehicleId = getIntParameter(request, "vehicleId");
        Integer employeeId = getIntParameter(request, "employeeId");
        String startServiceDate = request.getParameter("startServiceDate");
        String plannedRepairDate = request.getParameter("plannedRepairDate");
        String startRepairDate = request.getParameter("startRepairDate");
        String problemDescription = request.getParameter("problemDescription");
        String repairDescription = request.getParameter("repairDescription");
        Double costRepairForClient = getDoubleParameter(request, "costRepairForClient");
        Double costOfUsedParts = getDoubleParameter(request, "costOfUsedParts");
        Double manhourCost = getDoubleParameter(request, "manhourCost");
        Integer numberOfManhour = getIntParameter(request, "numberOfManhour");
        if (statusId != null) order.setStatusId(statusId);
        if (customerId != null) order.setCustomerId(customerId);
        if (vehicleId != null) order.setRepairedVehicleId(vehicleId);
        if (employeeId != null) order.setEmployeeId(employeeId);
        if (!startServiceDate.equals("")) {
            order.setStartServiceDate(startServiceDate);
        } else {
            order.setStartServiceDate(null);
        }
        if (!plannedRepairDate.equals("")) {
            order.setPlannedRepairDate(plannedRepairDate);
        } else {
            order.setPlannedRepairDate(null);
        }
        if (!startRepairDate.equals("")) {
            order.setStartRepairDate(startRepairDate);
        } else {
            order.setStartRepairDate(null);
        }
        if (costRepairForClient != null) order.setCostRepairForClient(costRepairForClient);
        if (costOfUsedParts != null) order.setCostOfUsedParts(costOfUsedParts);
        if (manhourCost != null) order.setManhourCost(manhourCost);
        if (numberOfManhour != null) order.setNumberOfManhour(numberOfManhour);
        return order;
    }

    public static Integer getIntParameter(HttpServletRequest request, String parameterName) {
        try {
            return Integer.parseInt(request.getParameter(parameterName));
        } catch (Exception ex) {
            return null;
        }
    }

    public static Double getDoubleParameter(HttpServletRequest request, String parameterName) {
        try {
            return Double.parseDouble(request.getParameter(parameterName));
        } catch (Exception ex) {
            return null;
        }
    }
}