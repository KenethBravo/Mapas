package com.kenethriascos.mapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap m_map;
    boolean mapReady = false;

   static final CameraPosition PASTO = CameraPosition.builder()
            .target(new LatLng(1.2089284,-77.2779443))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204,-122.3491))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();

    static final CameraPosition DUBLIN = CameraPosition.builder()
            .target(new LatLng(53.3478,-6.2597))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();

    static final CameraPosition TOKYO= CameraPosition.builder()
            .target(new LatLng(35.6895,139.6917))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnNormal = (Button) findViewById(R.id.id_btn_Seattle);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changuePosition(SEATTLE);
                //m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        Button btnSatelite = (Button) findViewById(R.id.id_btn_Dublin);
        btnSatelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changuePosition(DUBLIN);
                //m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        Button btnHibrido = (Button) findViewById(R.id.id_btn_Tokyo);
        btnHibrido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changuePosition(TOKYO);
                //m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //metodo para manejo de mapas

        mapReady=true;
        m_map = googleMap;

        //LatLng pasto = new LatLng(1.2089284,-77.2779443);// valores de latitud y longitud
        //CameraPosition target = CameraPosition.builder().target(pasto).zoom(15).build(); // saber donde se ponra esa ubicacion y que sum tendra

        //m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target)); // a objeto mapa vaya y establesca toda la configuraion

        //m_map.animateCamera(CameraUpdateFactory.newCameraPosition(),10000, null);
        changuePosition(PASTO);
    }

    public void changuePosition(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target),3000, null);
    }

}
