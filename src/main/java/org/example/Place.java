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

public class Place {
    private int PlaceID;
    private static final String TABLE_NAME = "Places";
    private List<Object> result = new ArrayList();
    private Session session;

    public Place(BackendSession backend) {
        this.session = backend.getSession();
    }

    public List<Object> getPlaces() {
        StringBuilder sb = new StringBuilder("SELECT * FROM Place;");
        String query = sb.toString();
        this.session.execute(query);
        ResultSet rs = this.session.execute(query);
        List<Object> places = new ArrayList();
        rs.forEach((r) -> {
            places.add(r.getInt("PlaceID"));
            places.add(r.getString("sector"));
            places.add(r.getString("code_place"));
        });
        return places;
    }

    public String addPlace(Integer placeID, String sector) {
        StringBuilder sb = (new StringBuilder("INSERT INTO "))
                .append(TABLE_NAME).append(" (PlaceID, sector) ")
                .append("VALUES (").append(placeID)
                .append(", '")
                .append(sector)
                .append("');");
        String query = sb.toString();
        this.session.execute(query);
        return placeID.toString();

    }

    public void deletePlace(UUID PlaceID) {
        StringBuilder sb = (new StringBuilder("DELETE FROM "))
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append("PlaceID ")
                .append("= ")
                .append(PlaceID)
                .append(";");
        String query = sb.toString();
        this.session.execute(query);
    }
}
