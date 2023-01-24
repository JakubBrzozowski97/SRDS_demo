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
import java.util.Random;
import java.util.UUID;

public class Credit_card {
    private int Credit_cardsID;
    private static final String TABLE_NAME = "Credit_cards";
    private List<Object> result = new ArrayList();
    private Session session;

    public Credit_card(BackendSession backend) {
        this.session = backend.getSession();
    }

    public List<Object> getCredit_cards() {
        StringBuilder sb = new StringBuilder("SELECT * FROM Credit_cards;");
        String query = sb.toString();
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<Object> Credit_card = new ArrayList();
        rs.forEach((r) -> {
            Credit_card.add(r.getInt("Credit_cardsID"));
            Credit_card.add(r.getInt("ClientID"));
            Credit_card.add(r.getString("back_code"));
            Credit_card.add(r.getString("valid_data"));
        });
        return Credit_card;
    }

    public void addCredit_card(String Credit_cardsID, UUID ClientID, String valid_data) {
        Random generator = new Random();
        int num1 = generator.nextInt(900) + 100;
        String back_code = Integer.toString(num1);
        StringBuilder sb = (new StringBuilder("INSERT INTO "))
                .append(TABLE_NAME)
                .append(" (Credit_cardsID, ClientID, back_code, valid_data)")
                .append(" VALUES (")
                .append(Credit_cardsID)
                .append(", ").append(ClientID)
                .append(", '").append(back_code)
                .append("', '").append(valid_data)
                .append("');");
        String query = sb.toString();
        this.session.execute(query);
    }

    public void addCredit_card(String Credit_cardsID, UUID ClientID, String valid_data, String cvv) {
        StringBuilder sb = (new StringBuilder("INSERT INTO "))
                .append(TABLE_NAME)
                .append(" (ClientID, Credit_cardsID, back_code, valid_data)")
                .append(" VALUES (")
                .append(ClientID)
                .append(", '").append(Credit_cardsID)
                .append("', '").append(cvv)
                .append("', '").append(valid_data)
                .append("');");
//        System.out.println(sb);
        String query = sb.toString();
        this.session.execute(query);
    }

    public void deleteCredit_card(UUID credit_cardID) {
        StringBuilder sb = (new StringBuilder("DELETE FROM "))
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append("credit_cardID ")
                .append("= ")
                .append(credit_cardID)
                .append(";");
        String query = sb.toString();
        this.session.execute(query);
    }

}
