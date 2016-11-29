package hackathon.mms.app.domain.officeList;

import java.util.List;

import hackathon.mms.app.shared.model.DistrictOffice;
import hackathon.mms.app.shared.model.UserLocation;

/**
 * Created by ewa on 28.11.2016.
 */

public abstract class DistrictOfficeListContract {

    public interface DistrictOfficeListPresenter{
        List<DistrictOffice> getOfficeList(UserLocation userLocation);
    }

    public interface DistrictOfficeListView{
        void notifyDataChange();
    }
}
