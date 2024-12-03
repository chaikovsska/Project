package com.example;

import java.time.LocalDate;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import com.example.Model.Payment;
import com.example.Model.Client;
import com.example.DAO.ClientDAO;

@Path("/process-payment")
public class PaymentResource {

    private ClientDAO clientDAO = new ClientDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response processPayment(Payment payment) {
        try {
            // Отримуємо користувача за email
            int userId = clientDAO.getUserIdByEmail(payment.getEmail());
            if (userId == 0) {
                return Response.status(Response.Status.NOT_FOUND).entity("Користувач не знайдений").build();
            }

            // Перевіряємо, чи немає активного абонемента
            boolean hasActiveMembership = clientDAO.hasActiveMembership(userId);
            if (hasActiveMembership) {
                return Response.status(Response.Status.BAD_REQUEST).entity("У вас вже є активний абонемент").build();
            }

            // Визначення тривалості абонемента та розрахунок дати завершення
            int duration = clientDAO.getMembershipDuration(payment.getMembershipId());
            if (duration <= 0) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Невірний абонемент").build();
            }

            // Створюємо клієнта
            Client newClient = new Client();
            newClient.setUserId(userId);
            newClient.setMembershipId(payment.getMembershipId());
            newClient.setStartDate(LocalDate.now());
            newClient.setEndDate(LocalDate.now().plusDays(duration));

            int clientId = clientDAO.createClient(newClient);

            // Додаємо платіж
            payment.setClientId(clientId);
            payment.setMethod("online"); // Автоматично встановлюємо метод
            payment.setAmount(clientDAO.getMembershipPrice(payment.getMembershipId())); // Отримуємо ціну абонемента
            clientDAO.addPaymentRecord(payment);

            return Response.status(Response.Status.OK).entity("Оплата успішна, абонемент активовано").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Помилка обробки оплати").build();
        }
    }
}