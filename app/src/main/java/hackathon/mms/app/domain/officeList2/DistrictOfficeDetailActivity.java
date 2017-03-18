package hackathon.mms.app.domain.officeList2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import hackathon.mms.app.R;

/**
 * An activity representing a single DistrictOffice detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link DistrictOfficeListActivity}.
 */
public class DistrictOfficeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_districtoffice_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        Button buttonNavigation;
        buttonNavigation = (Button) findViewById(R.id.buttonNavigate);
        buttonNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=52.1879919,20.9461545,15&daddr=52.2084261,20.944414,12"));
                startActivity(intent);
            }
        });

        Button buttonShowOnMap = (Button) findViewById(R.id.buttonShowOnMap);

//            String udId = getArguments().getString(ARG_ITEM_ID);

        System.out.println("----officeId (item_id):  " + getIntent().getExtras().get("item_id"));

        buttonShowOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DistrictOfficeDetailActivity.this, DistrictOfficeMap.class);
                intent.putExtra("Latitude", (Double) getIntent().getExtras().get("Latitude"));
                intent.putExtra("Longitude", (Double) getIntent().getExtras().get("Longitude"));
                intent.putExtra("officeName", (String) getIntent().getExtras().get("officeName"));
                //intent.putA
                startActivity(intent);
            }
        });



        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(DistrictOfficeDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(DistrictOfficeDetailFragment.ARG_ITEM_ID));
            DistrictOfficeDetailFragment fragment = new DistrictOfficeDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.districtoffice_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, DistrictOfficeListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
