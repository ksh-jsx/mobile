package google.shkim.example.com.mp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;


public class google extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    PlaceAutocompleteFragment placeAutoComplete;
    private static final String DEBUG_TAG = "{LOG_ANDROID}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        initViews();
    }

    private void initViews() {
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete);

        Log.d(DEBUG_TAG, "a");

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {

                // TODO: Get info about the selected place.

                final LatLng location = place.getLatLng();
                Log.d(DEBUG_TAG, "name : " + place.getName());
                Log.d(DEBUG_TAG, "address : " + place.getAddress());
                Log.d(DEBUG_TAG, "id : " + place.getId());
                Log.d(DEBUG_TAG, "location : " + location.latitude + ", " + location.longitude);
                //세부정보 가져오기


                mMap.animateCamera(CameraUpdateFactory.newLatLng(location));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 15));


            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("LOG", "An error occurred: " + status);
            }
        });
    }  //검색바에 장소 정보 적용

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}
