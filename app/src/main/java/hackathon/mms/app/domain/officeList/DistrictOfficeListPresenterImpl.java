package hackathon.mms.app.domain.officeList;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import hackathon.mms.app.shared.model.DistrictOffice;
import hackathon.mms.app.shared.model.UserLocation;
import hackathon.mms.app.domain.officeList.DistrictOfficeListContract.DistrictOfficeListView;
import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ewa on 28.11.2016.
 */
public class DistrictOfficeListPresenterImpl implements DistrictOfficeListContract.DistrictOfficeListPresenter {

    private WeakReference<DistrictOfficeListView> districtOfficeListViewRef;
    private final List<DistrictOffice> districtOffices;

    private GraphQLRepository repository;

    public DistrictOfficeListPresenterImpl(DistrictOfficeListView districtOfficeListView,
                                           GraphQLRepository repository) {
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
                .subscribe(newList -> {
                            districtOffices.clear();
                            districtOffices.addAll(newList);
                            if (districtOfficeListViewRef.get() != null)
                                districtOfficeListViewRef.get().notifyDataChange();

                        },
                        Throwable::printStackTrace
                );

        return districtOffices;
    }
}
