package hackathon.mms.app.domain.officeList2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import hackathon.mms.app.R;

public class DistrictOfficeMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Double longitude=null;
    private Double latitude=null;
    private String officeName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_office_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        latitude = (Double) getIntent().getExtras().get("Latitude");
        longitude = (Double) getIntent().getExtras().get("Longitude");
        officeName = (String) getIntent().getExtras().get("officeName");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        System.out.println("onMapReady latitude="+latitude+" longitude="+longitude);
        if(latitude!=null && longitude!=null) {
            // Add a marker in Sydney and move the camera
            LatLng marker = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions().position(marker).title(officeName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
            CameraUpdate zoom=CameraUpdateFactory.zoomTo(17);
            mMap.animateCamera(zoom);
        }
    }
}
