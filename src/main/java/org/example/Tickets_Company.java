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

public class Tickets_Company {
    private static final String TABLE_NAME = "Tickets_Companies";
    private List<Object> result = new ArrayList();
    private Session session;

    public Tickets_Company(BackendSession backend) {
        this.session = backend.getSession();
    }

    public List<Object> getTickets_Companies() {
        StringBuilder sb = new StringBuilder("SELECT * FROM Tickets_Companyies;");
        String query = sb.toString();
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<Object> tic_com = new ArrayList();
        rs.forEach((r) -> {
            tic_com.add(r.getInt("Tickets_CompanyID"));
            tic_com.add(r.getString("company_name"));
            tic_com.add(r.getString("NIP"));
            tic_com.add(r.getString("address"));
            tic_com.add(r.getString("email"));
        });
        return tic_com;
    }

    public String addTickets_Company(String company_name, String NIP, String address) {
        UUID Tickets_CompanyID = UUID.randomUUID();
        String email = company_name + "@gmail.com";
        StringBuilder sb = (new StringBuilder("INSERT INTO "))
                .append(TABLE_NAME)
                .append(" (Tickets_CompanyID, company_name, NIP, address, email)")
                .append(" VALUES (").append(Tickets_CompanyID)
                .append(", '").append(company_name)
                .append("', '").append(NIP)
                .append("', '").append(address)
                .append("', '").append(email)
                .append("');");
        String query = sb.toString();
        System.out.println(query);
        this.session.execute(query);
        return Tickets_CompanyID.toString();
    }

    public String delete_tickets_company(String Tickets_CompanyID) {
        StringBuilder sb = (new StringBuilder("DELETE FROM "))
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append(" Tickets_CompanyID=").append(Tickets_CompanyID)
                .append(";");
        String query = sb.toString();
        this.session.execute(query);
        return Tickets_CompanyID.toString();
    }
}
