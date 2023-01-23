import Cassandra.BackendException;

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

        for (int i = 0; i < 10; i++){
            db.add_place(i, "A");
        }




        TimeUnit.SECONDS.sleep(10);
        clear_after_test1(login_to_delete, ticket_company_to_delete);
    }

    public static void clear_after_test1(String login_to_delete,
                                         String ticket_company_to_delete) throws BackendException {
        DBHandler db = new DBHandler("config.properties");
        db.delete_user(login_to_delete);
        db.delete_ticket_company(ticket_company_to_delete);

        for (int i = 0; i < 10; i++){
            db.delete_place(i);
        }
    }
}
