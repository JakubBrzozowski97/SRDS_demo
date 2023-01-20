//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import Cassandra.BackendException;
import Cassandra.BackendSession;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class Client {
    private int ClientID;
    private static final String TABLE_NAME = "Clients";
    private List<Object> result = new ArrayList();
    private Faker faker = new Faker(new Locale("pl-PL"));
    private Session session;
    public BackendSession backend = new BackendSession("config.properties");

    public Client(BackendSession backend) throws BackendException {
        this.session = backend.getSession();
    }

    public List<Object> getClients() {
        StringBuilder sb = new StringBuilder("SELECT * FROM Client;");
        String query = sb.toString();
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<Object> clients = new ArrayList();
        rs.forEach((r) -> {
            clients.add(r.getUUID("ClientID"));
            clients.add(r.getString("name"));
            clients.add(r.getString("surname"));
            clients.add(r.getString("login"));
            clients.add(r.getString("email"));
            clients.add(r.getUUID("Credit_cardsID"));
            clients.add(r.getString("tel_number"));
        });
        return clients;
    }

    public void addClient() {
        Random generator = new Random();
        int num1 = generator.nextInt(600) + 100;
        int num2 = generator.nextInt(641) + 100;
        int num3 = generator.nextInt(899) + 100;
        String var10000 = Integer.toString(num1);
        String string1 = var10000 + "-" + Integer.toString(num2) + "-" + Integer.toString(num3);
        String firstName = this.faker.name().firstName();
        String lastName = this.faker.name().lastName();
        UUID ClientID = UUID.randomUUID();
        UUID Credit_cardsID = UUID.randomUUID();
        String login = firstName + lastName;
        String email = login + "@client.com";
        Credit_card Cc = new Credit_card(this.backend);
        Cc.addCredit_card(ClientID, Credit_cardsID, "NULL");
        StringBuilder sb = (new StringBuilder("INSERT INTO "))
                .append(TABLE_NAME).append(" (ClientID, name, surname, login, email, Credit_cardsID, tel_number) ")
                .append("VALUES (").append(ClientID)
                .append(", '").append(firstName)
                .append("', '").append(lastName)
                .append("', '").append(login)
                .append("', '").append(email)
                .append("', ").append(Credit_cardsID)
                .append(", '").append(string1)
                .append("');");
        String query = sb.toString();
        this.session.execute(query);
    }

    public void deleteClient(UUID ClientID) {
        StringBuilder sb = (new StringBuilder("DELETE FROM "))
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append("ClientID ")
                .append("= ")
                .append(ClientID)
                .append(";");
        String query = sb.toString();
        this.session.execute(query);
    }

}
