package com.davidbenes.mapnavigation;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.davidbenes.mapnavigation.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.davidbenes.mapnavigation.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in puskesmas bukit hindu and move the camera
        LatLng puskesmasbukithindu = new LatLng(-2.205326, 113.909335);
        mMap.addMarker(new MarkerOptions().position(puskesmasbukithindu).title("Marker in puskesmasbukithindu"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(puskesmasbukithindu));

        // Add a marker in upr and move the camera
        LatLng WATCHIDAC = new LatLng(-2.200909, 113.906275);
        mMap.addMarker(new MarkerOptions().position(WATCHIDAC).title("Marker in WATCHIDAC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(WATCHIDAC));

        mMap.addPolyline(new PolylineOptions().add(
                puskesmasbukithindu,
                new LatLng(-2.205326, 113.909335),
                new LatLng(-2.204541, 113.906933),
                new LatLng(-2.201858, 113.908319),
                new LatLng(-2.200856, 113.906207),
                new LatLng(-2.201009, 113.906126),
                new LatLng(-2.200909, 113.906275),
                WATCHIDAC
                ).width(10)
                        .color(Color.BLUE)
        );
    }
}