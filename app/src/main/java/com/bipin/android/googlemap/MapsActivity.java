package com.bipin.android.googlemap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int REQUEST_PLACE_PICKER = 1;
    private String TAG = "MAP_TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        // Hello Map

        /** // Add a marker in Sydney and move the camera
         LatLng sydney = new LatLng(-34, 151);
         mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
         mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
         */


        // Change the Map Type
        /**
         // Other supported types include: MAP_TYPE_NORMAL,
         // MAP_TYPE_TERRAIN, MAP_TYPE_HYBRID and MAP_TYPE_NONE
         mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
         * **/


        // Indoor Maps
        /**
         // Some buildings have indoor maps. Center the camera over
         // the building, and a floor picker will automatically appear.
         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
         new LatLng(-33.86997, 151.2089), 18));
         **/


        // Custom Markers and Info windows
        /**
         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
         new LatLng(41.889, -87.622), 16));

         // You can customize the marker image using images bundled with
         // your app, or dynamically generated bitmaps.
         mMap.addMarker(new MarkerOptions()
         .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
         .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
         .position(new LatLng(41.889, -87.622)));
         * **/


        // Flat Markers
        /**
         LatLng mapCenter = new LatLng(41.889, -87.622);

         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter, 13));

         // Flat markers will rotate when the map is rotated,
         // and change perspective when the map is tilted.
         mMap.addMarker(new MarkerOptions()
         .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
         .position(mapCenter)
         .flat(true)
         .rotation(245));

         CameraPosition cameraPosition = CameraPosition.builder()
         .target(mapCenter)
         .zoom(13)
         .bearing(90)
         .build();

         // Animate the change in camera view over 2 seconds
         mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
         2000, null);
         * **/


        // Polylines
        /**
         *
         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
         new LatLng(-18.142, 178.431), 2));

         // Polylines are useful for marking paths and routes on the map.
         mMap.addPolyline(new PolylineOptions().geodesic(true)
         .add(new LatLng(-33.866, 151.195))  // Sydney
         .add(new LatLng(-18.142, 178.431))  // Fiji
         .add(new LatLng(21.291, -157.821))  // Hawaii
         .add(new LatLng(37.423, -122.091))  // Mountain View
         );         *
         * **/

    }


    // Autocomplete Widget (intent, fullscreen mode)
/**
    // PLACES_API_ACCESS_NOT_CONFIGURED ERROR due to disabled GOOGLE PLACE API FOR ANDROID
    public void findPlace(View view){
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ESTABLISHMENT)
                .build();
        try {

            Intent intent =
                    new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .setFilter(typeFilter)
                            .build(this);
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException e) {
            // TODO: Handle the error.
        } catch (GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i(TAG, "Place: " + place.getName());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                // TODO: Handle the error.
                Log.i(TAG, status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }
*/




/**    public void findPlace(View view){

        // Construct an intent for the place picker
        try {
            PlacePicker.IntentBuilder intentBuilder =
                    new PlacePicker.IntentBuilder();
            Intent intent = intentBuilder.build(this);
            // Start the intent by requesting a result,
            // identified by a request code.
            startActivityForResult(intent, REQUEST_PLACE_PICKER);

        } catch (GooglePlayServicesRepairableException e) {
            // ...
        } catch (GooglePlayServicesNotAvailableException e) {
            // ...
        }

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {

        if (requestCode == REQUEST_PLACE_PICKER
                && resultCode == Activity.RESULT_OK) {

            // The user has selected a place. Extract the name and address.
            final Place place = PlacePicker.getPlace(data, this);

            final CharSequence name = place.getName();
            final CharSequence address = place.getAddress();
            String attributions = PlacePicker.getAttributions(data);
            if (attributions == null) {
                attributions = "";
            }

            Log.i(TAG, name + " " + address + " " + Html.fromHtml(attributions));

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }*/

}
