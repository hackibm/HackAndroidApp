package hackathon.mms.app.shared.model;

/**
 * Created by d4w1dk on 02/12/2016.
 */

public class ContactInfo {
    private String address;
    private String phone;

    public ContactInfo(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
