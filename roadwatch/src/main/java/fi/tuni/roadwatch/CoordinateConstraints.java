package fi.tuni.roadwatch;

public class CoordinateConstraints {

    public CoordinateConstraints(Double minLon, Double minLat, Double maxLon, Double maxLat) {
        this.minLon = minLon;
        this.minLat = minLat;

        this.maxLon = maxLon;
        this.maxLat = maxLat;

    }

    public final Double minLon;
    public final Double minLat;

    public final Double maxLon;
    public final Double maxLat;

    public String getAsString(Character c) {
        return "" + minLon + c + minLat + c + maxLon + c + maxLat;
    }

    public String getAsMaintenanceString(){
        return  "xMin="+minLon+
                "yMin="+minLat+
                "xMax="+maxLon+
                "yMax="+maxLat;
    }
}
