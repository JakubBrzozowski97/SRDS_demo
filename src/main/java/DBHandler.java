import Cassandra.BackendException;
import Cassandra.BackendSession;
import org.example.*;

import java.util.List;

public class DBHandler {
    BackendSession backendSession;
    public DBHandler(String configFilename) throws BackendException {
        backendSession = new BackendSession(configFilename);
    }

    public String add_new_user(String email, String login, String name, String surname, String tel_number,
                             String credit_card_number, String valid_data, String cvv)
            throws BackendException {
        Client user_handler = new Client(this.backendSession);
        return user_handler.addClient(name, surname, login, email, tel_number, credit_card_number, cvv, valid_data);
    }

    public String delete_user(String login) throws BackendException {
        Client user_handler = new Client(this.backendSession);
        user_handler.deleteClient(login);
        return login;
    }

    public String add_ticket_company(String name, String nip, String address){
        Tickets_Company ticketsCompany = new Tickets_Company(this.backendSession);
        return ticketsCompany.addTickets_Company(name, nip, address);
    }

    public String delete_ticket_company(String companyID){
        Tickets_Company ticketsCompany = new Tickets_Company(this.backendSession);
        return ticketsCompany.delete_tickets_company(companyID);
    }

    public String add_place(int placeID, String sector){
        Place place = new Place(this.backendSession);
        return place.addPlace(placeID, sector);
    }

    public void delete_place(int placeID){
        Place place = new Place(this.backendSession);
        place.deletePlace(placeID);
    }

    public String add_ticket(Integer placeID, String eventID){
        Ticket ticket = new Ticket(this.backendSession);
        return ticket.addTicket("null", placeID, eventID);
    }

    public void delete_ticket(String login){
        Ticket ticket = new Ticket(this.backendSession);
        ticket.deleteTicket(login);
    }

    public String add_event(String event_name, String event_type, String event_start, String event_stop, String Tickets_CompanyID){
        Event event = new Event(this.backendSession);
        return event.addEvent(event_name, event_type, event_start, event_stop, Tickets_CompanyID);
    }

    public void delete_event(String eventID){
        Event event = new Event(this.backendSession);
        event.deleteEvent(eventID);
    }

    public String add_to_chart(String login, String ticketID){
        Chart_elements chartElements = new Chart_elements(this.backendSession);
        return chartElements.addChart_elements(ticketID, login);
    }
    public void delete_from_chart(String login){
        Chart_elements chartElements = new Chart_elements(this.backendSession);
        chartElements.deleteChart_elements(login);
    }

    public void delete_from_chart(String login, String elementID, String ticketID){
        Chart_elements chartElements = new Chart_elements(this.backendSession);
        chartElements.deleteChart_elements(elementID, login, ticketID);
    }
    
    public void buy(String login){
        Chart_elements chartElements = new Chart_elements(this.backendSession);
        Ticket ticket = new Ticket(this.backendSession);

        List<String> bought_tickets = chartElements.get_user_ticket_from_chart(login);

        bought_tickets.forEach((ticketID) -> ticket.updateTicket(ticketID, login));
    }


}
