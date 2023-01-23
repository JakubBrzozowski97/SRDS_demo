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

public class Chart_elements {
    private int Credit_cardsID;
    private static final String TABLE_NAME = "Chart_elements";
    private List<Object> result = new ArrayList();
    private Session session;

    public Chart_elements(BackendSession backend) {
        this.session = backend.getSession();
    }

    public List<Object> Chart_elements() {
        StringBuilder sb = new StringBuilder("SELECT * FROM Chart_elements;");
        String query = sb.toString();
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<Object> chartelem = new ArrayList();
        rs.forEach((r) -> {
            chartelem.add(r.getInt("Chart_elementsID"));
            chartelem.add(r.getInt("TicketID"));
            chartelem.add(r.getInt("PassID"));
            chartelem.add(r.getInt("ClientID"));
        });
        return chartelem;
    }

    // Zwraca koszyk danego użytkownika
    public List<UUID> get_user_chart(UUID ClientID) {
        StringBuilder sb = (new StringBuilder("SELECT Chart_elementsID FROM ")).append(TABLE_NAME)
                .append(" WHERE ")
                .append("ClientID ")
                .append("= ")
                .append(ClientID)
                .append(";");
        String query = sb.toString();
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<UUID> chartelem = new ArrayList();
        rs.forEach((r) -> {
            chartelem.add(r.getUUID("Chart_elementsID"));
        });
        return chartelem;
    }

    // Zwraca szczegóły konkretnego produktu z koszyka. Ze wzglęgu na działanie Cassandra potrzebne jest tutaj
    // ClientID.
    public List<UUID> get_user_chart_element(UUID ClientID, UUID ElementID) {
        StringBuilder sb = (new StringBuilder("SELECT * FROM ")).append(TABLE_NAME)
                .append(" WHERE ")
                .append("ClientID ")
                .append("= ")
                .append(ClientID)
                .append(" AND ")
                .append("Chart_elementsID ")
                .append("= ")
                .append(ElementID)
                .append(";");
        String query = sb.toString();
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<UUID> chartelem = new ArrayList();
        rs.forEach((r) -> {
            chartelem.add(r.getUUID("Chart_elementsID"));
            chartelem.add(r.getUUID("TicketID"));
            chartelem.add(r.getUUID("PassID"));
            chartelem.add(r.getUUID("ClientID"));
        });
        return chartelem;
    }

    public void addChart_elements(UUID Chart_elementsID, UUID TicketID, UUID PassID, UUID ClientID) {
        StringBuilder sb = (new StringBuilder("INSERT INTO "))
                .append(TABLE_NAME).append("(Chart_elementsID, TicketID, PassID, ClientID)")
                .append("VALUES (").append(Chart_elementsID)
                .append(", ").append(TicketID)
                .append(", ").append(PassID)
                .append(", ").append(ClientID)
                .append(");");
        String query = sb.toString();
        this.session.execute(query);
    }

    public void deleteChart_elements(UUID Chart_elementsID) {
        StringBuilder sb = (new StringBuilder("DELETE FROM "))
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append("Chart_elementsID ")
                .append("= ")
                .append(Chart_elementsID)
                .append(";");
        String query = sb.toString();
        this.session.execute(query);
    }

}


