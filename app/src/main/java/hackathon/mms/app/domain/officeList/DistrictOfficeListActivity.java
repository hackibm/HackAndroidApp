package hackathon.mms.app.domain.officeList;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hackathon.mms.app.R;
import hackathon.mms.app.shared.model.DistrictOffice;

public class DistrictOfficeListActivity extends AppCompatActivity
        implements DistrictOfficeListFragment.OnDistrictOfficeSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_office_list);


        Fragment districtOfficeListFrag = DistrictOfficeListFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.districe_office_list_container, districtOfficeListFrag)
        .commit();
    }

    @Override
    public void onDistrictOfficeSelected(DistrictOffice districtOffice) {

    }
}
