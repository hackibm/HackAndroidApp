package hackathon.mms.app.shared.model;

import java.util.Comparator;
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

    @Override
    public String toString() {
        return getName();
    }

    public static class DistrictComparatorByGroupServiceTime implements Comparator<DistrictOffice> {

        @Override
        public int compare(DistrictOffice d1, DistrictOffice d2) {
            int result = -1;
            if(d1!=null && d2!=null){
                if(d1.getGroups()!=null && d1.getGroups().size()>0 && d2.getGroups()!=null && d2.getGroups().size()>0){
                    return new Group.GroupComparatorByServiceTime().compare(d1.getGroups().get(0), d2.getGroups().get(0));
                }
            }
            return result;
        }
    }
}
