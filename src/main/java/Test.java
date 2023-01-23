import Cassandra.BackendException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws BackendException, InterruptedException {
        test1();
    }

    public static void test1() throws BackendException, InterruptedException {
        DBHandler db = new DBHandler("config.properties");

        String login_to_delete = db.add_new_user("mateuszbiernacki@mateusz.pl", "user1", "Mateusz",
                "Biernacki", "661062019", "123123123123", "1999", "123");

        String ticket_company_to_delete = db.add_ticket_company("Firma001", "12345678", "Poznan 12 123 214");
        String event_to_delete = db.add_event("mecz", "mecz", "2011-02-03", "2011-02-03", ticket_company_to_delete);


        for (int i = 0; i < 10; i++){
            db.add_place(i, "A");
        }

        List<String> tickets = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            tickets.add(db.add_ticket(i, event_to_delete));
        }
        System.out.println(tickets);




        TimeUnit.SECONDS.sleep(10);
        clear_after_test1(login_to_delete, ticket_company_to_delete, event_to_delete);
    }

    public static void clear_after_test1(String login_to_delete,
                                         String ticket_company_to_delete,
                                         String event_to_delete) throws BackendException {
        DBHandler db = new DBHandler("config.properties");
        db.delete_user(login_to_delete);
        db.delete_ticket_company(ticket_company_to_delete);

        for (int i = 0; i < 10; i++){
            db.delete_place(i);
        }
        db.delete_ticket("null");
        db.delete_ticket(login_to_delete);
        db.delete_event(event_to_delete);
    }
}
