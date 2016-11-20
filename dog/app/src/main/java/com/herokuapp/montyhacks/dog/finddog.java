package com.herokuapp.montyhacks.dog;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class finddog extends FragmentActivity implements OnMapReadyCallback {

    String namee;
    String breed;
    double lat;
    double longi;
    String time;

    private GoogleMap mMap;

    public Button btnNewDog;

    public void init()
    {
        btnNewDog = (Button)findViewById(R.id.btnNewDog);
        btnNewDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(finddog.this, newDog.class);

                startActivity(toy);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddog);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        init();

        Intent bck = getIntent();
        namee = bck.getStringExtra("dogNamee");
        breed = bck.getStringExtra("dogBreed");
        lat = bck.getDoubleExtra("dogLat", 0);
        longi = bck.getDoubleExtra("dogLongi", 0);
        time = bck.getStringExtra("dogTime");
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
        LatLng mylocation = new LatLng(40.7446830, -73.9848740);
        mMap.addMarker(new MarkerOptions().position(mylocation).title("My location").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.7449719, -73.9851947)).title("Name: Sir Calvin").snippet("Breed: Beagle | Time Available: 10:00am to 12:30pm"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.7458474, -73.9841051)).title("Name: Mr. Matthew").snippet("Breed: Husky | Time Available: 11:00am to 12:00pm"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.7449719, -73.9851947)).title("Name: Sir Calvin").snippet("Breed: Beagle | Time Available: 10:00am to 12:30pm"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.7458474, -73.9841051)).title("Name: Mr. Matthew").snippet("Breed: Husky | Time Available: 11:00am to 12:00pm"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mylocation));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );
        LatLng addLocation = new LatLng(lat, longi);
        mMap.addMarker(new MarkerOptions().position(addLocation).title("Name: " + namee).snippet("Breed: " + breed + " | Time Available: " + time));
    }

    public void InfoWindowAdapter() {

    }


}
