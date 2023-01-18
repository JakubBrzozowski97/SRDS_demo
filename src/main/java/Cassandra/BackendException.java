package Cassandra;

public class Backend extends Exception {
    private static final long serialVersionUID = 1L;

    public Backend(String message) {
        super(message);
    }

    public Backend(Exception e) {
        super(e);
    }

    public Backend(String message, Exception e) {
        super(message, e);
    }
}
