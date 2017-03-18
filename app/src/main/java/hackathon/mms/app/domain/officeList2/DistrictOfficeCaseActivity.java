package hackathon.mms.app.domain.officeList2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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
    DistrictOffice selectedCase;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_district_office_case);

        GraphQLRepository repo = new GraphQLRepository();

        List<DistrictOffice> caseList = new ArrayList<>();
        List<String> caseListString = new ArrayList<>();
        List<String> idListString = new ArrayList<>();
        Observable<DistrictOffice> caseListObs = repo.getDistrictOfficeCase();


        System.out.print(caseListObs.toString());

        caseListObs
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toList().subscribe(list -> {
                        caseList.addAll(list);
                        for(DistrictOffice doff: caseList){
                            idListString.add(doff.getId());
                            caseListString.add(doff.getName());
                        }
            Spinner spinner = (Spinner) findViewById(R.id.spinner2);
            ArrayAdapter<DistrictOffice> adapter = new ArrayAdapter<DistrictOffice>(this,android.R.layout.simple_spinner_item, caseList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int pos, long id) {
                    // An item was selected. You can retrieve the selected item using

                    select_item = idListString.get(pos);
                    selectedCase =   caseList.get(pos);

                    TableLayout ll = (TableLayout) findViewById(R.id.caseOfficesTable);

                    //TableRow row=(TableRow)findViewById(R.id.caseOfficesRow);
                    TableRow row= new TableRow(ll.getContext());
//                    for (int i = 0; i <2; i++) {

                      //  checkBox = new CheckBox(this);
                        TextView tv = new TextView(row.getContext());
                        tv.setText("selectedCase: " + selectedCase.getName());
//                        addBtn = new ImageButton(this);
//                        addBtn.setImageResource(R.drawable.add);
//                        minusBtn = new ImageButton(this);
//                        minusBtn.setImageResource(R.drawable.minus);
//                        qty = new TextView(this);
//                        checkBox.setText("hello");
//                        qty.setText("10");
//                        row.addView(checkBox);
//                        row.addView(minusBtn);
//                        row.addView(qty);
//                        row.addView(addBtn);
                        row.addView(tv);
                        ll.addView(row);

//                    }

                }


                @Override
                public void onNothingSelected(AdapterView<?> arg0) {

                }


            });

        },Throwable::printStackTrace);

        button = (Button) findViewById(R.id.tutaj);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Log.i("1", select_item);
                Log.i("1", selectedCase.getId()+" "+selectedCase.toString());
                TableLayout table = (TableLayout) findViewById(R.id.caseOfficesTable);
                for(int i =0 ; i < table.getChildCount(); i++) {
                    TableRow row = (TableRow) table.getChildAt(i);
                   // table.removeView(row);
                    row.removeAllViews();
                }
            }
        });

}}
