package hackathon.mms.app.domain.officeList;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import hackathon.mms.app.domain.officeList.DistrictOfficeListContract.DistrictOfficeListView;
import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import hackathon.mms.app.shared.model.DistrictOffice;
import hackathon.mms.app.shared.model.UserLocation;
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
        //observable.forEach(doff -> districtOffices.add(doff));
       //observable.onCompleted();


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
        //System.out.println("111 " + observable.toList() +" size: " + observable.toList().count());
        return districtOffices;

    }

    /*@Override
    public List<DistrictOffice> getOfficeList(UserLocation userLocation) {

        List<DistrictOffice> list = new ArrayList<DistrictOffice>();
        DistrictOffice doff = new DistrictOffice("ID1", "UD Bielany");
        DistrictOffice doff1 = new DistrictOffice("ID2", "UD Mokotow");
        list.add(doff);
        list.add(doff1);
        districtOffices.clear();
        districtOffices.addAll(list);
        return districtOffices;
    } */
}

