package hackathon.mms.app.officeList;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hackathon.mms.app.model.DistrictOffice;
import hackathon.mms.app.model.UserLocation;
import hackathon.mms.app.officeList.DistrictOfficeListContract.DistrictOfficeListView;
import hackathon.mms.app.repository.DistrictOfficesRepository;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ewa on 28.11.2016.
 */
public class DistrictOfficeListPresenterImpl implements DistrictOfficeListContract.DistrictOfficeListPresenter {

    private WeakReference<DistrictOfficeListView> districtOfficeListViewRef;
    private List<DistrictOffice> districtOffices;

    private DistrictOfficesRepository repository;

    public DistrictOfficeListPresenterImpl(DistrictOfficeListView districtOfficeListView,
                                           DistrictOfficesRepository repository) {
        districtOfficeListViewRef = new WeakReference<>(districtOfficeListView);
        districtOffices = new ArrayList<>();
        this.repository = repository;
    }

    @Override
    public List<DistrictOffice> getOfficeList(UserLocation userLocation) {
        Observable<DistrictOffice> observable = repository.getDistrictOffices();

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toList()
                .subscribe(districtOffices -> {
                            districtOffices.clear();
                            districtOffices.addAll(districtOffices);
                            if (districtOfficeListViewRef.get() != null)
                                districtOfficeListViewRef.get().notifyDataChange();

                        },
                        Throwable::printStackTrace
                );

        return districtOffices;
    }
}
