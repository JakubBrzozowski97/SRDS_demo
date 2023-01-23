package org.example;

import Cassandra.BackendException;
import Cassandra.BackendSession;

import java.util.List;

public class Main {
    public static void main(String[] args) throws BackendException{

        BackendSession backend = new BackendSession("config.properties");

        Client client = new Client(backend);
        //client.addClient("Mateusz", "Biernacki", "mb", "mb@etr.pl", "4325234624", "c342354623226", "324", "2345");
        List<String> list_of_clients_logins = client.getClients();
        System.out.println(list_of_clients_logins);
        System.out.println(client.getClient(list_of_clients_logins.get(0).toString()));
//        Chart_elements chartElements = new Chart_elements(backend);


//        UUID clientID = UUID.randomUUID();
//
//        chartElements.addChart_elements(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), clientID );
//        chartElements.addChart_elements(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), clientID );
//        chartElements.addChart_elements(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), clientID );
//        chartElements.addChart_elements(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), clientID );
//        var elements = chartElements.get_user_chart(clientID);
//        System.out.println(elements);
//        System.out.println(chartElements.get_user_chart_element(clientID, elements.get(0)));



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
        backend.getSession().close();
        System.out.println(backend.getSession().isClosed());


    }

}
