package org.example;
import java.io.IOException;
import java.util.Properties;
import java.util.*;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import java.io.IOException;
import java.util.Properties;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.ResultSet;
import com.datastax.oss.driver.api.core.metadata.schema.ClusteringOrder;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.schema.CreateTable;
import com.datastax.oss.driver.api.querybuilder.schema.CreateTableStart;
import com.datastax.oss.driver.api.querybuilder.schema.CreateTableWithOptions;

import static com.datastax.oss.driver.api.querybuilder.SchemaBuilder.*;

import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

public class Main {

    private static final String PROPERTIES_FILENAME = "config.properties";
    public static void main(String[] args) throws IOException{
        String contactPoint = null;
        String keyspace = null;

        Scanner input = new Scanner(System.in);

        Cluster cluster;
        Session session;

        Properties properties = new Properties();

        try {
            properties.load(Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILENAME));

            contactPoint = properties.getProperty("contact_point");
            keyspace = properties.getProperty("keyspace");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        cluster = Cluster.builder().addContactPoint(contactPoint).build();
        session = cluster.connect(keyspace);


        /*StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("coss").append("(")
                .append("id uuid PRIMARY KEY, ")
                .append("title text,")
                .append("subject text);");

        String query = sb.toString();
        session.execute(query);*/

        StringBuilder sb1 =new StringBuilder("INSERT INTO ")
                .append("coss ")
                .append("(id, title, subject) ")
                .append("VALUES ")
                .append("(uuid(), 'sraki', 'pierdziaki');");

        String query1 = sb1.toString();
        session.execute(query1);

/*
        StringBuilder sb1 = new StringBuilder("DELETE FROM ")
                .append("kejspejs.coss ")
                .append("WHERE id= ")
                .append("078d0315-97d7-41c0-97c9-c9472a7f424d ")
                .append("IF EXISTS;");

        String query1 = sb1.toString();
        session.execute(query1);
*/

        session.close();
        cluster.close();
    }

}