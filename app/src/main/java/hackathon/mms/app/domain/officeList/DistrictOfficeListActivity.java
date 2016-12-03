package hackathon.mms.app.domain.officeList;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import hackathon.mms.app.R;
import hackathon.mms.app.shared.model.DistrictOffice;

import static android.R.attr.button;
import static android.R.attr.onClick;

public class DistrictOfficeListActivity extends AppCompatActivity
        implements DistrictOfficeListFragment.OnDistrictOfficeSelectedListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_office_list);

        button = (Button) findViewById(R.id.dictrict_office_list_cases_btn) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DistrictOfficeListActivity.this, DistrictOfficeItemInformation.class);
                startActivity(intent);
            }
        });

        Fragment districtOfficeListFrag = DistrictOfficeListFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.districe_office_list_container, districtOfficeListFrag)
        .commit();
    }

    public void openItemInfo(View view){
        Intent intent = new Intent(DistrictOfficeListActivity.this, DistrictOfficeItemInformation.class);
        startActivity(intent);

    }

    @Override
    public void onDistrictOfficeSelected(DistrictOffice districtOffice) {

    }


}
