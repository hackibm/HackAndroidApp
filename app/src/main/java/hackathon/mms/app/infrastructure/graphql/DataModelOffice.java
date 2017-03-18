package hackathon.mms.app.infrastructure.graphql;

import java.util.List;

import hackathon.mms.app.shared.model.CaseModel;
import hackathon.mms.app.shared.model.DistrictOffice;

/**
 * Created by EKolodziejska on 2016-12-01.
 */

public class DataModelOffice {

    private List<DistrictOffice> districtOffices;
    private List<CaseModel> caseModel;

    public List<DistrictOffice> getDistrictOffices() {
        return districtOffices;
    }
    public List<CaseModel> getCaseModel(){

        return caseModel;
    }
}
