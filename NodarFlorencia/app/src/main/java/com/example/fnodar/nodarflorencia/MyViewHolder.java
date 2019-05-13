package com.example.fnodar.nodarflorencia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tvNombre;
    public TextView tvCantidad;
    public TextView tvPrecioUnidad;

    public ImageView tvAgregar;
    public ImageView tvDisminuir;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.findViewById(R.id.agregar).setOnClickListener(this);
        itemView.findViewById(R.id.disminuir).setOnClickListener(this);

        tvAgregar = itemView.findViewById(R.id.agregar);
        tvDisminuir = itemView.findViewById(R.id.disminuir);
        tvNombre = itemView.findViewById(R.id.nombre);
        tvCantidad = itemView.findViewById(R.id.cantidad);
        tvPrecioUnidad = itemView.findViewById(R.id.precio);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == tvAgregar.getId())
        {
            MainActivity.getInstance().controlStock(1, this.getLayoutPosition());
        } else if (v.getId() == tvDisminuir.getId())
        {
            MainActivity.getInstance().controlStock(2, this.getLayoutPosition());
        }
    }
}