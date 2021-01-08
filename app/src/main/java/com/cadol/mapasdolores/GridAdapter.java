package com.cadol.mapasdolores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.cadol.mapasdolores.MainActivity;


public class GridAdapter extends BaseAdapter {

   ArrayList<CADOL> cadol;
   private Context context;
   Activity activity;

    public GridAdapter (Context context, ArrayList<CADOL> cadol){
        this.cadol = cadol;
        this.context = context;
    }
    @Override
    public int getCount() {
        return cadol.size();
    }

    @Override
    public Object getItem(int position) {
        return cadol.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_grid, null);

        }

        final  CADOL Cadol = cadol.get(position);

        ImageView imagen = (ImageView) convertView.findViewById(R.id.imagen);
        TextView tituloTv = (TextView) convertView.findViewById(R.id.tvLugar);

        imagen.setImageResource(Cadol.getFoto());
        tituloTv.setText(Cadol.getNombre());

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat_tmp = Cadol.getLat();
                double lon_tmp = Cadol.getLon();
                String quien_tmp = Cadol.getNombre();

                MainActivity.mapas (lat_tmp, lon_tmp, quien_tmp);
            }
        });

        return convertView;
    }


}


/*
   // Metodo constructor
   public GridAdapter(ArrayList<CADOL> cadol, Activity activity) {
     this.cadol = cadol;
     this.activity= activity;
  }

  // infla el layout y lo pasar al viewholder para que obtenga los views
  @NonNull
  @Override
  public GridAdapter.CadolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
    return new CadolViewHolder(v);
  }

  // Asocia cada elemento de la lista con cada View
  @Override
  public void onBindViewHolder(@NonNull CadolViewHolder holder, int position) {
    final  CADOL Cadol = cadol.get(position);
    CadolViewHolder.imgFoto.setImageResource(Cadol.getFoto());
    CadolViewHolder.tvLugar.setText(Cadol.getNombre());
  }

  @Override
  public int getItemCount() {
    return cadol.size();
  }

  public static class CadolViewHolder extends RecyclerView.ViewHolder {

     public static ImageView imgFoto;
     private static TextView tvLugar;

     public CadolViewHolder(@NonNull View itemView) {
       super(itemView);

       imgFoto = (ImageView) itemView.findViewById(R.id.imagen);
       tvLugar =  (TextView) itemView.findViewById(R.id.tvLugar);
     }
  }

    public class GridAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<String> arrayList;

        public GridAdapter (Context context, ArrayList<String> arrayList){
            this.arrayList = arrayList;
            this.context = context;
        }
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.item_grid, null);

            }

            TextView tituloTv = (TextView) convertView.findViewById(R.id.iv_tv_Titulo);
            tituloTv.setText(arrayList.get(position));
            return convertView;
        }

    }
*/
