package org.example;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.*;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import Cassandra.BackendException;
import Cassandra.BackendSession;
import java.io.IOException;
import java.util.Properties;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.ResultSet;
import com.datastax.oss.driver.api.core.metadata.schema.ClusteringOrder;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.schema.CreateTable;
import com.datastax.oss.driver.api.querybuilder.schema.CreateTableStart;
import com.datastax.oss.driver.api.querybuilder.schema.CreateTableWithOptions;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import java.util.UUID;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import static com.datastax.driver.core.DataType.uuid;
import static com.datastax.oss.driver.api.querybuilder.SchemaBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.toOctalString;
import static org.junit.Assert.*;

public class Main {
    public static void main(String[] args) throws BackendException{

        BackendSession backend = new BackendSession("config.properties");

        Chart_elements chartElements = new Chart_elements(backend);
        UUID clientID = UUID.randomUUID();

        chartElements.addChart_elements(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), clientID );
        chartElements.addChart_elements(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), clientID );
        chartElements.addChart_elements(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), clientID );
        chartElements.addChart_elements(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), clientID );
        System.out.println(chartElements.get_user_chart(clientID));



        //Tickets ticks = new Tickets(backend);
        //ticks.addTicket(4,4,4,4);
        // System.out.println(ticks.getTickets());
        // ticks.deleteTicket(4);
        // System.out.println(ticks.getTickets());
//        Tickets_Company tc = new Tickets_Company(backend);
//        System.out.print("1\n");
//
//        Ticket tics = new Ticket(backend);
//        System.out.print("2\n");
//        tics.addTicket(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), 1);
//        System.out.print("3\n");
//        Client client = new Client(backend);
//        System.out.print("4\n");
//        Place place = new Place(backend);
//        System.out.print("5\n");
//        place.addPlace(UUID.randomUUID(),"A");
//        System.out.print("6\n");
//        Event event = new Event(backend);
//        System.out.print("7\n");
//        Timestamp ts1 = Timestamp.valueOf("2018-09-01 09:01:15");
//        System.out.print("8\n");
//        Timestamp ts2 = Timestamp.valueOf("2018-09-01 10:01:15");
//        System.out.print("9\n");
//        event.addEvent(UUID.randomUUID(), "MECZyk","MECZ",ts1, ts2, 1);
//        System.out.print("10\n");

        //tc.addTickets_Company(1, "Ticketmaster", "473473667","Poznan");
        //Credit_card cc = new Credit_card(backend);
        //cc.addCredit_card(ClientID, Credit_cardsID, "NULL");
        //UUID ClientID = UUID.randomUUID();
//        client.addClient();
//        System.out.print("11\n");

        //System.out.println(client.getClients());
        //System.out.println(ClientID);



    }

}
