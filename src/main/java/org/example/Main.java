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




        //Tickets ticks = new Tickets(backend);
        //ticks.addTicket(4,4,4,4);
        // System.out.println(ticks.getTickets());
        // ticks.deleteTicket(4);
        // System.out.println(ticks.getTickets());
        Tickets_Company tc = new Tickets_Company(backend);
        Ticket tics = new Ticket(backend);
        tics.addTicket(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), 1);
        Client client = new Client(backend);
        Place place = new Place(backend);
        place.addPlace(UUID.randomUUID(),"A");
        Event event = new Event(backend);
        Timestamp ts1 = Timestamp.valueOf("2018-09-01 09:01:15");
        Timestamp ts2 = Timestamp.valueOf("2018-09-01 10:01:15");
        event.addEvent(UUID.randomUUID(), "MECZyk","MECZ",ts1, ts2, 1);
        tc.addTickets_Company(1, "Ticketmaster", "473473667","Poznan");
        //Credit_card cc = new Credit_card(backend);
        //cc.addCredit_card(ClientID, Credit_cardsID, "NULL");
        //UUID ClientID = UUID.randomUUID();
        client.addClient();
        //System.out.println(client.getClients());
        //System.out.println(ClientID);



    }

}
