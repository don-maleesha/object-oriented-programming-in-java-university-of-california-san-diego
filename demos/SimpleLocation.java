

public class SimpleLocation {

    public double latitude;
    public double longitude;

    public SimpleLocation(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public double distance(SimpleLocation other) {
        return getDist(this.latitude, this.longitude, other.latitude, other.longitude);
    }


    //Harvesine formula
    public double getDist(double lat1, double lon1, double lat2, double lon2) {
        
        int earthRadius = 6371; // in km

        // convert to radians
        double lat1rad = Math.toRadians(lat1);
        double lat2rad = Math.toRadians(lat2);
        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLon = Math.toRadians(lon2 - lon1);

        // Haversine formula
        double haversinePart = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) + Math.cos(lat1rad) * Math.cos(lat2rad) * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        // Angular distance in radians
        double angularDistance = 2 * Math.atan2(Math.sqrt(haversinePart), Math.sqrt(1 - haversinePart));

        // Distance in kilometers
        return earthRadius * angularDistance;
    }

}