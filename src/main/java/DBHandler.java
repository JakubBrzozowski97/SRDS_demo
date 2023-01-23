import Cassandra.BackendException;
import Cassandra.BackendSession;
import org.example.Client;

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



}
