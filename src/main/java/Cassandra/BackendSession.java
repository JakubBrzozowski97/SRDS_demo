//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.Session;
import java.io.IOException;
import java.util.Properties;

public class BackendSession {
    private Session session;

    public BackendSession(String configFilename) throws BackendException {
        Properties properties = new Properties();

        try {
            properties.load(BackendSession.class.getClassLoader().getResourceAsStream(configFilename));
        } catch (IOException var8) {
            var8.printStackTrace();
        }

        String contactPoint = properties.getProperty("contact_point");
        String keyspace = properties.getProperty("keyspace");
        Cluster cluster = Cluster.builder().addContactPoint(contactPoint).withQueryOptions((new QueryOptions()).setConsistencyLevel(ConsistencyLevel.ONE)).build();
        this.session = cluster.connect();

        try {
            this.session = cluster.connect(keyspace);
            System.out.println("Polaczano z klastrem " + keyspace);
        } catch (Exception var7) {
            System.out.println("ERR: Could not connect to the cluster " +    var7.getMessage() + ".");
        }

    }

    public Session getSession() {
        return this.session;
    }
}
