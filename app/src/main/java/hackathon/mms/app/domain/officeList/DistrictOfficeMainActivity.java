package hackathon.mms.app.domain.officeList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import hackathon.mms.app.R;
import hackathon.mms.app.domain.officeList2.DistrictOfficeListActivity;

public class DistrictOfficeMainActivity extends AppCompatActivity
         {

    Button buttonCase, buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_office_list);

        buttonList = (Button) findViewById(R.id.dictrict_office_list_btn) ;

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DistrictOfficeMainActivity.this, DistrictOfficeListActivity.class);
                startActivity(intent);
            }
        });
    }






}
