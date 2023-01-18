package Cassandra;

import com.datastax.driver.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.datastax.driver.core.PreparedStatement;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BackendSession {

    public static final Logger logger = LoggerFactory.getLogger(BackendSession.class);

    private Session session;

    public BackendSession(String contactPoint, String keyspace) throws BackendException {

        Cluster cluster = Cluster.builder().addContactPoint(contactPoint).build();
        try {
            session = cluster.connect(keyspace);
        } catch (Exception e) {
            throw new BackendException("Could not connect to the cluster. " + e.getMessage() + ".", e);
        }
        //prepareStatements();

}

    private static PreparedStatement DELETE_ALL_FROM_CLIENTS;
    private static PreparedStatement DELETE_ALL_FROM_PASS;
    private static PreparedStatement DELETE_ALL_FROM_PASS_TYPE;
    private static PreparedStatement DELETE_ALL_FROM_PLACE;
    private static PreparedStatement DELETE_ALL_FROM_EVENT;
    private static PreparedStatement DELETE_ALL_TICKETS_COMPANY;
    private static PreparedStatement DELETE_ALL_CHART_ELEMENTS;
    private static PreparedStatement DELETE_ALL_CREDIT_CARD;
    private static PreparedStatement DELETE_ALL_FROM_TICKET;

    private static PreparedStatement SELECT_ALL_FROM_TICKETS;
    private static PreparedStatement SELECT_ALL_FROM_CLIENTS;
    private static PreparedStatement SELECT_ALL_FROM_EVENTS;

    private static PreparedStatement INSERT_INTO_CLIENTS;
    private static PreparedStatement INSERT_INTO_FROM_PASS;
    private static PreparedStatement INSERT_INTO_FROM_PASS_TYPE;
    private static PreparedStatement INSERT_INTO_FROM_PLACE;
    private static PreparedStatement INSERT_INTO_FROM_EVENT;
    private static PreparedStatement INSERT_INTO_TICKETS_COMPANY;
    private static PreparedStatement INSERT_INTO_CHART_ELEMENTS;
    private static PreparedStatement INSERT_INTO_CREDIT_CARD;
    private static PreparedStatement INSERT_INTO_FROM_TICKET;