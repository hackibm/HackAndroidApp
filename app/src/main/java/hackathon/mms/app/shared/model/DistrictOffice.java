package hackathon.mms.app.shared.model;

/**
 * Created by ewa on 27.11.2016.
 */
public class DistrictOffice {

    private String id;
    private String name;

    public DistrictOffice(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
