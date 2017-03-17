package hackathon.mms.app.domain.officeList2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hackathon.mms.app.R;
import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import hackathon.mms.app.shared.model.DistrictOffice;
import hackathon.mms.app.shared.model.Group;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A fragment representing a single DistrictOffice detail screen.
 * This fragment is either contained in a {@link DistrictOfficeListActivity}
 * in two-pane mode (on tablets) or a {@link DistrictOfficeDetailActivity}
 * on handsets.
 */


public class DistrictOfficeDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private DistrictOffice mItem;

    private String districtOfficeId;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DistrictOfficeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            String udId = getArguments().getString(ARG_ITEM_ID);
            districtOfficeId = udId;
            Log.i("District2" , "Setting districtOfficeId: " + districtOfficeId );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.districtoffice_detail, container, false);


        GraphQLRepository repo1 = new GraphQLRepository();
        Log.i("District2" , "Get details for districtOfficeId: " + districtOfficeId );
        Observable<DistrictOffice> observable = repo1.getDistrictOfficeByID(districtOfficeId);

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                doff ->
                {
                    Log.i("District2" , "Office: " + doff.getId()+" "+doff.getName()+" "+doff.getContactInfo().getAddress());
                    Activity activity = this.getActivity();
                    CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
                    if (appBarLayout != null) {
                        String sep = "_____________________________________\n";
                        appBarLayout.setTitle(prepareUDName(doff.getName()));
                        StringBuilder sb = new StringBuilder();
                        sb.append("Adres: " + prepareAddress(doff.getContactInfo().getAddress())).append("\n");
                        sb.append(sep);
                        for(Group g : doff.getGroups()){
                            sb.append("Sprawa: " + g.getNazwaGroupy() +"\n" +
                                     "Liczba oczekujących: " + g.getLiczbaKlwKolejce()+"\n"+
                                      "Średni czas obsługi: " + g.getCzasObslugi()+" min \n");
                            sb.append(sep);
                        }
                        String udInfo =  sb.toString();
                        Log.i("District2" , "udInfo: " + udInfo);
                        ((TextView) rootView.findViewById(R.id.districtoffice_detail)).setText(udInfo);
                    }
                    mItem = doff;
                },
                Throwable::printStackTrace);

        return rootView;
    }

    private String prepareAddress(String address){
        String result = address;
        try {
            String[] arr = address.split(",");
            result = arr[0] + ", " + arr[1].split(" ")[1];
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private String prepareUDName(String udName){
        String result = udName;
        try {
            result =  "UD " + result.split(" ")[2];
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
