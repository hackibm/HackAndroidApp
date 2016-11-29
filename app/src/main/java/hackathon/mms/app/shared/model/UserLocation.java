package hackathon.mms.app.shared.model;

/**
 * Created by ewa on 28.11.2016.
 */

public class UserLocation {
    private double longitude;
    private double latitude;

    public UserLocation(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
