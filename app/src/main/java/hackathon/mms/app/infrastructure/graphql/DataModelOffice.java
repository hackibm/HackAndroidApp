package hackathon.mms.app.infrastructure.graphql;

import java.util.List;

import hackathon.mms.app.shared.model.DistrictOffice;

/**
 * Created by EKolodziejska on 2016-12-01.
 */

public class DataModelOffice {

    private List<DistrictOffice> districtOffices;

    public List<DistrictOffice> getDistrictOffices() {
        return districtOffices;
    }
}
