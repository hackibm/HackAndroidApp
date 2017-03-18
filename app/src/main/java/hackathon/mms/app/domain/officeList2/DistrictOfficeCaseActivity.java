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
import hackathon.mms.app.shared.model.CaseModel;
import hackathon.mms.app.shared.model.DistrictOffice;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DistrictOfficeCaseActivity extends AppCompatActivity {

    String select_item = "nic tu nie ma";
    CaseModel selectedCase;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_district_office_case);

        GraphQLRepository repo = new GraphQLRepository();

        List<CaseModel> caseList = new ArrayList<>();

        Observable<CaseModel> caseListObs = repo.getDistrictOfficeCase();


        caseListObs
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toList().subscribe(list -> {
            Log.i("list:", list.get(0).getName());
            caseList.addAll(list);
            for (CaseModel s : caseList) {
                Log.i("1", s.getName());
            }

            Spinner spinner = (Spinner) findViewById(R.id.spinner2);
            ArrayAdapter<CaseModel> adapter = new ArrayAdapter<CaseModel>(this, android.R.layout.simple_spinner_item, caseList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int pos, long id) {
                    // An item was selected. You can retrieve the selected item using

                    selectedCase = caseList.get(pos);

//                    TableLayout ll = (TableLayout) findViewById(R.id.caseOfficesTable);
//
//                    TableRow row= new TableRow(ll.getContext());
//                    TextView tv = new TextView(row.getContext());
//                    tv.setText("selectedCase: " + selectedCase.getName());
//                    row.addView(tv);
//                    ll.addView(row);

                    clearTable();
                    System.out.println("XXXXXXX: " + "selectedCase: " + selectedCase.getName());
                    Observable<DistrictOffice> caseListObs = repo.getOfficesForCase("identityCard");
                    System.out.println("getOfficesForCase invoked");
                    caseListObs
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .toList().subscribe(list -> {
                        for (DistrictOffice s : list) {
                            Log.i("1", s.getName() + " groups: " + s.getGroups());
                            if (s.getGroups() != null && s.getGroups().size() > 0) {
                                Log.i("   2", s.getGroups().get(0).getCzasObslugi());
                            }
                        }
                        updateTable(list);
                    });

                }


                @Override
                public void onNothingSelected(AdapterView<?> arg0) {

                }


            });

        }, Throwable::printStackTrace);

//        button = (Button) findViewById(R.id.tutaj);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("1", selectedCase.getId() + " " + selectedCase.toString());
//                clearTable();
//            }
//        });

    }

    private void updateTable(List<DistrictOffice> districtOffices) {
        TableLayout ll = (TableLayout) findViewById(R.id.caseOfficesTable);
        for (DistrictOffice doff : districtOffices) {
            TableRow row = new TableRow(ll.getContext());
            TextView tv = new TextView(row.getContext());
            tv.setText(prepareTextForOffice(doff));
            row.addView(tv);
            ll.addView(row);
        }
    }

    private String prepareTextForOffice(DistrictOffice doff) {
        StringBuilder sb = new StringBuilder();
        sb.append(doff.getName() + "\n");
        if (doff.getGroups().size() > 0) {
            sb.append("     Średni czas obsługi: " + doff.getGroups().get(0).getLiczbaKlwKolejce() + "\n");
            sb.append("     Łączny czas obsługi: " + doff.getGroups().get(0).getLacznyCzasObslugi() + "\n");
            sb.append("     Liczba klientów w kolejce: " + doff.getGroups().get(0).getLiczbaKlwKolejce() + "\n");
        }
        return sb.toString();
    }


    private void clearTable(){
        TableLayout table = (TableLayout) findViewById(R.id.caseOfficesTable);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            // table.removeView(row);
            row.removeAllViews();
        }
    }

}
