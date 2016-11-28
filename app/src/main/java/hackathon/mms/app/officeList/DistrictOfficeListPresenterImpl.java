package hackathon.mms.app.officeList;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hackathon.mms.app.model.DistrictOffice;
import hackathon.mms.app.model.UserLocation;
import hackathon.mms.app.officeList.DistrictOfficeListContract.DistrictOfficeListView;
import hackathon.mms.app.repository.DistrictOfficesRepository;

/**
 * Created by ewa on 28.11.2016.
 */
public class DistrictOfficeListPresenterImpl implements DistrictOfficeListContract.DistrictOfficeListPresenter{

    private WeakReference<DistrictOfficeListView> districtOfficeListViewRef;
    private List<DistrictOffice> districtOffices;

    private DistrictOfficesRepository repository;

    public DistrictOfficeListPresenterImpl(DistrictOfficeListView districtOfficeListView,
                                           DistrictOfficesRepository repository){
        districtOfficeListViewRef = new WeakReference<>(districtOfficeListView);
        districtOffices = new ArrayList<>();
        this.repository = repository;
    }

    @Override
    public List<DistrictOffice> getOfficeList(UserLocation userLocation) {
        repository.getDistrictOffices().subscribe(districtOffice -> districtOffices.add(districtOffice));

        return districtOffices;
    }
}
