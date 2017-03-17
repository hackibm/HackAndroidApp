package hackathon.mms.app.domain.officeList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import hackathon.mms.app.R;
import hackathon.mms.app.domain.officeList2.DistrictOfficeCaseActivity;
import hackathon.mms.app.domain.officeList2.DistrictOfficeListActivity;

public class DistrictOfficeMainActivity extends AppCompatActivity
         {

    Button buttonCase, buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_office_list);
        buttonCase = (Button) findViewById(R.id.GoogleMapBtn);
        buttonCase.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent intent = new Intent(DistrictOfficeMainActivity.this, DistrictOfficeCaseActivity.class);
                                              startActivity(intent);
                                          }
                                      });
        buttonList = (Button) findViewById(R.id.dictrict_office_list_btn) ;
        buttonCase = (Button) findViewById(R.id.dictrict_office_list_cases_btn) ;

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DistrictOfficeMainActivity.this, DistrictOfficeListActivity.class);
                startActivity(intent);
            }
        });

        buttonCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=52.1879919,20.9461545,15&daddr=52.2084261,20.944414,12"));
                startActivity(intent);
            }
        });
    }






}
