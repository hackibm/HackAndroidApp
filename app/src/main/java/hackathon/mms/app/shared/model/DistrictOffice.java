package hackathon.mms.app.shared.model;

import java.util.List;

/**
 * Created by ewa on 27.11.2016.
 */
public class DistrictOffice {

    private String id;
    private String name;
    private ContactInfo contactInfo;
    private List<Group> groups;

    public DistrictOffice(String id, String name, ContactInfo contactInfo, List<Group> groups) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.groups = groups;
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

    public List<Group> getGroups(){
        return groups;
    }

}
