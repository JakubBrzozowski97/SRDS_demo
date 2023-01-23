import Cassandra.BackendException;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws BackendException, InterruptedException {
        test1();

        TimeUnit.SECONDS.sleep(10);

        clear_after_test1();
    }

    public static void test1() throws BackendException {
        DBHandler db = new DBHandler("config.properties");
        db.add_new_user("mateuszbiernacki@mateusz.pl", "user1", "Mateusz",
                "Biernacki", "661062019", "123123123123", "1999", "123");

    }

    public static void clear_after_test1() throws BackendException {
        DBHandler db = new DBHandler("config.properties");
        db.delete_user("user1");
    }
}
