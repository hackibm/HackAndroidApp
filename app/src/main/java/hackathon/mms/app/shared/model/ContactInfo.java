package hackathon.mms.app.shared.model;

/**
 * Created by d4w1dk on 02/12/2016.
 */

public class ContactInfo {
    private String address;
    private String phone;
    private String openingHours;
    private Double longitude;
    private Double latitude;

    public ContactInfo(String address, String phone, String openingHours, Double longitude, Double latitude) {
        this.address = address;
        this.phone = phone;
        this.openingHours = openingHours;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
