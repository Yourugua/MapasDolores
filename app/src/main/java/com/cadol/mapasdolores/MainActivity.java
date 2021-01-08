package com.cadol.mapasdolores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private GridView gridView;
    private GridAdapter adapter;
    ArrayList<CADOL> cadol;

    private static Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        toolbar =  findViewById(R.id.toolbar);

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

        cadol = new ArrayList<CADOL>();
        cadol.add( new CADOL( R.drawable.dsc_0013_mod,"C.A.DOL.", -33.528266311538765,-58.22779655456544));
        cadol.add( new CADOL(R.drawable.frente_nuevo_super,"Supermercado C.A.DOL", -33.531906321556065, -58.21496486663819));
        cadol.add( new CADOL(R.drawable.dsc_0026,"Granero C.A.DOL.",-33.51959048562168, -58.22925567626954));
        cadol.add( new CADOL(R.drawable.express,"Express",-33.53398561968548, -58.20893526077271));

        gridView = (GridView) findViewById(R.id.grilla);
        adapter = new GridAdapter(this, cadol);
        gridView.setAdapter((ListAdapter) adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.macerca:
                Intent i = new Intent(MainActivity.this, acerca.class);
                startActivity(i);
                break;
        };
        return super.onOptionsItemSelected(item);
    }

    public static void mapas(double lat, double lon, String quien) {
      Double latitud = lat;
      Double longitud = lon;
      String quien_tmp = quien;

      Intent intent = new Intent(mContext, MapsActivity.class);
      intent.putExtra("La_Latitud",latitud);
      intent.putExtra("La_Longitud", longitud);
      intent.putExtra("Lugar", quien_tmp);

      mContext.startActivity( intent);
    }
}