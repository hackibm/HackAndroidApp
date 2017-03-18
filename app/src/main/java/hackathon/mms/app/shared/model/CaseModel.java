package hackathon.mms.app.shared.model;

/**
 * Created by ewa on 27.11.2016.
 */
public class CaseModel {

    private String id;
    private String name;
    private String[] groupNames;

    public CaseModel(String id, String name, String[] groupNames) {
        this.id = id;
        this.name = name;
        this.groupNames = groupNames;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String[] getGroupNames(){
        return groupNames;
    }

    @Override
    public String toString() {
        return getName();
    }
}
