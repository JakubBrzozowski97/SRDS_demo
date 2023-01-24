import Cassandra.BackendException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws BackendException, InterruptedException {
        //test1();
        dis_test();
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
        db.add_to_chart(login_to_delete, tickets.get(0));
        db.add_to_chart(login_to_delete, tickets.get(1));


        TimeUnit.SECONDS.sleep(5);
        try{
            db.buy(login_to_delete);
        } catch (Exception e) {
            System.out.println(e.toString());
        }


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
        db.delete_from_chart(login_to_delete);
    }

    public static void dis_test() throws BackendException, InterruptedException {
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

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start t1");
                try {
                    dis_test_1t(login_to_delete, tickets.get(0), tickets.get(1));
                } catch (BackendException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("stop t1");

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start t2");
                try {
                    dis_test_2t(login_to_delete, tickets.get(2), tickets.get(3));
                } catch (BackendException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("stop t2");

            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start t3");
                try {
                    dis_test_3t(login_to_delete, tickets.get(4), tickets.get(5));
                } catch (BackendException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("stop t3");
            }
        });
        t1.start();
        t2.start();
        t3.start();

        TimeUnit.SECONDS.sleep(15);
        System.out.println("START DELETING METHOD");
        clear_after_test1(login_to_delete, ticket_company_to_delete, event_to_delete);

    }

    public static void dis_test_1t(String login, String ticket1, String ticket2) throws BackendException, InterruptedException {
        DBHandler db = new DBHandler("config.properties");
        db.add_to_chart(login, ticket1);
        db.add_to_chart(login, ticket2);


        TimeUnit.SECONDS.sleep(5);
        try{
            db.buy(login);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void dis_test_2t(String login, String ticket1, String ticket2) throws BackendException, InterruptedException {
        DBHandler db = new DBHandler("config2.properties");
        db.add_to_chart(login, ticket1);
        db.add_to_chart(login, ticket2);

    }
    public static void dis_test_3t(String login, String ticket1, String ticket2) throws BackendException, InterruptedException {
        DBHandler db = new DBHandler("config3.properties");
        db.add_to_chart(login, ticket1);
        db.add_to_chart(login, ticket2);

    }

}
