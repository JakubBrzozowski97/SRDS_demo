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

public class Pass_type {
    private int Credit_cardsID;
    private static final String TABLE_NAME = "Pass_types";
    private List<Object> result = new ArrayList();
    private Session session;

    public Pass_type(BackendSession backend) {
        this.session = backend.getSession();
    }

    public List<Object> getPass_type() {
        StringBuilder sb = new StringBuilder("SELECT * FROM Pass_types;");
        String query = sb.toString();
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<Object> ptypes = new ArrayList();
        rs.forEach((r) -> {
            ptypes.add(r.getInt("Pass_typeID"));
            ptypes.add(r.getInt("EventID"));
            ptypes.add(r.getString("pass_name"));
            ptypes.add(r.getInt("number_of_events"));
        });
        return ptypes;
    }

    public void addPass_type(UUID Pass_typeID, UUID EventID, String pass_name, Integer number_of_events) {
        StringBuilder sb = (new StringBuilder("INSERT INTO "))
                .append(TABLE_NAME)
                .append("(Pass_typeID, EventID, pass_name, number_of_events)")
                .append("VALUES (").append(Pass_typeID)
                .append(", ").append(EventID)
                .append(", '").append(pass_name)
                .append("', ").append(number_of_events)
                .append(");");
        String query = sb.toString();
        this.session.execute(query);
    }
}
