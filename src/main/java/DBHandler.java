import Cassandra.BackendException;
import Cassandra.BackendSession;
import org.example.Client;
import org.example.Place;
import org.example.Ticket;
import org.example.Tickets_Company;

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

    public String add_place(int placeID, String sector){
        Place place = new Place(this.backendSession);
        return place.addPlace(placeID, sector);
    }

    public String add_ticket(Integer placeID, String eventID){
        Ticket ticket = new Ticket(this.backendSession);
        return ticket.addTicket("null", placeID, eventID);
    }

    public String add_to_chart(){return "pass";}
    public String delete_from_chart(){return "pass";}
    public String buy(){return "pass";}


}
