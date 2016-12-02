package hackathon.mms.app.shared.model;

/**
 * Created by ewa on 27.11.2016.
 */
public class DistrictOffice {

    private String id;
    private String name;
    //private String address;
    private ContactInfo contactInfo;

    public DistrictOffice(String id, String name, ContactInfo contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
}
