//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import Cassandra.BackendSession;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ticket {
    private int TicketID;
    private static final String TABLE_NAME = "Tickets";
    private List<Object> result = new ArrayList();
    private Session session;

    public Ticket(BackendSession backend) {
        this.session = backend.getSession();
    }

    public List<Object> getTickets() {
        StringBuilder sb = new StringBuilder("SELECT * FROM TICKET;");
        String query = sb.toString();
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<Object> tickets = new ArrayList();
        rs.forEach((r) -> {
            tickets.add(r.getInt("TicketID"));
            tickets.add(r.getInt("EventID"));
            tickets.add(r.getInt("ClientID"));
            tickets.add(r.getInt("PlaceID"));
        });
        return tickets;
    }

    public String addTicket(String login, Integer PlaceID, String EventID) {
        UUID ticketID = UUID.randomUUID();
        StringBuilder sb = (new StringBuilder("INSERT INTO "))
                .append(TABLE_NAME).append("(TicketID, EventID, login, PlaceID) ")
                .append("VALUES (").append(ticketID)
                .append(", ").append(EventID)
                .append(", '").append(login)
                .append("', ").append(PlaceID)
                .append(");");
        String query = sb.toString();
        System.out.println(query);
        this.session.execute(query);
        return ticketID.toString();
    }

    public void deleteTicket(String login) {
        StringBuilder sb = (new StringBuilder("DELETE FROM "))
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append("login ")
                .append("= '")
                .append(login)
                .append("';");
        String query = sb.toString();
        this.session.execute(query);
    }

    public void deleteTicket(String login, String ticketID) {
        StringBuilder sb = (new StringBuilder("DELETE FROM "))
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append("login ")
                .append("= '")
                .append(login)
                .append("' AND ")
                .append("TicketID = ")
                .append(ticketID)
                .append(";");
        String query = sb.toString();
        this.session.execute(query);
    }

    public void updateTicket(String TicketID, String login) {

        StringBuilder sb = new StringBuilder("SELECT * FROM TICKETS")
                .append(" WHERE login='")
                .append("null")
                .append("' AND TicketID=")
                .append(TicketID)
                .append(";");
        String query = sb.toString();
        System.out.println(query);
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<String> tickets = new ArrayList();
        rs.forEach((r) -> {
            tickets.add(r.getUUID("TicketID").toString());
            tickets.add(r.getUUID("EventID").toString());
            tickets.add(r.getString("login"));
            tickets.add(String.valueOf(r.getInt("PlaceID")));
        });

        System.out.println(tickets);

        this.deleteTicket("null", tickets.get(0));
        this.addTicket(login, Integer.valueOf(tickets.get(3)), tickets.get(1));
    }
}
