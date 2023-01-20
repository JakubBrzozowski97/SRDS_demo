//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import Cassandra.BackendSession;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pass {
    private static final String TABLE_NAME = "Passes";
    private List<Object> result = new ArrayList();
    private Session session;

    public Pass(BackendSession backend) {
        this.session = backend.getSession();
    }

    public List<Object> getPasses() {
        StringBuilder sb = new StringBuilder("SELECT * FROM Pass;");
        String query = sb.toString();
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<Object> passes = new ArrayList();
        rs.forEach((r) -> {
            passes.add(r.getInt("PassID"));
            passes.add(r.getInt("ClientID"));
            passes.add(r.getInt("Pass_typeID"));
            passes.add(r.getInt("remained_times"));
        });
        return passes;
    }

    public void addPass(UUID PassID, UUID ClientID, UUID Pass_typeID, Integer remained_times) {
        StringBuilder sb = (new StringBuilder("INSERT INTO "))
                .append(TABLE_NAME).append(" (PassID, ClientID, Pass_typeID, remained_times) ")
                .append("VALUES (").append(PassID)
                .append(", ").append(ClientID)
                .append(", ").append(Pass_typeID)
                .append(", ").append(remained_times)
                .append(");");
        String query = sb.toString();
        this.session.execute(query);
    }

    public void deletePass(UUID PassID) {
        StringBuilder sb = (new StringBuilder("DELETE FROM "))
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append("PassID ")
                .append("= ")
                .append(PassID)
                .append(";");
        String query = sb.toString();
        this.session.execute(query);
    }

}
