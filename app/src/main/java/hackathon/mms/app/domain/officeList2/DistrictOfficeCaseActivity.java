package hackathon.mms.app.domain.officeList2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import hackathon.mms.app.R;
import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import hackathon.mms.app.shared.model.DistrictOffice;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DistrictOfficeCaseActivity extends AppCompatActivity {

    String select_item = "nic tu nie ma";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_district_office_case);

        GraphQLRepository repo = new GraphQLRepository();

        List<DistrictOffice> caseList = new ArrayList<>();
        List<String> caseListString = new ArrayList<>();

        Observable<DistrictOffice> caseListObs = repo.getDistrictOfficeCase();

        Log.i("HEJ", "hej");
        System.out.print(caseListObs.toString());

        caseListObs
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toList().subscribe(list -> {
                        caseList.addAll(list);
                        for(DistrictOffice doff: caseList){

                            caseListString.add(doff.getName());
                        }
            Spinner spinner = (Spinner) findViewById(R.id.spinner2);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, caseListString);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int pos, long id) {
                    // An item was selected. You can retrieve the selected item using

                    select_item = (String) parent.getItemAtPosition(pos);
                    adapter.notifyDataSetChanged();
                }


                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    System.out.print("wowwiwpojohakjshfdjsadksahd");
                }


            });

        },Throwable::printStackTrace);

        button = (Button) findViewById(R.id.tutaj);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Log.i("1", select_item);
            }
        });

}}
