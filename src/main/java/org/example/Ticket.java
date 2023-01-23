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
                .append(", ").append(login) //chyba nie trzeba zmieniać na uuid
                .append(", ").append(PlaceID)
                .append(");");
        String query = sb.toString();
        this.session.execute(query);
        return ticketID.toString();
    }

    public void deleteTicket(String TicketID, String login, Integer PlaceID) {
        StringBuilder sb = (new StringBuilder("DELETE FROM "))
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append("login ")
                .append("= ")
                .append(login)
                .append(";");
        String query = sb.toString();
        this.session.execute(query);
    }

    public void updateTicket(String TicketID, String login) {
        StringBuilder sb = (new StringBuilder("UPDATE "))
                .append(TABLE_NAME)
                .append(" SET ")
                .append("login = ")
                .append(login)
                .append(" WHERE ")
                .append("login ")
                .append("='null'")
                .append(" AND TicketID = '")
                .append(TicketID)
                .append("';");
        String query = sb.toString();
        this.session.execute(query);
    }
}
