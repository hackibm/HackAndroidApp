package hackathon.mms.app.shared.model;

/**
 * Created by d4w1dk on 02/12/2016.
 */

public class ContactInfo {
    private String address;
    private String phone;
    private String openingHours;

    public ContactInfo(String address, String phone, String openingHours) {
        this.address = address;
        this.phone = phone;
        this.openingHours = openingHours;
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
}
