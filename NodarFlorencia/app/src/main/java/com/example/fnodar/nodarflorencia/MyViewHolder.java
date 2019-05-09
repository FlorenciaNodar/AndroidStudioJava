package com.example.fnodar.nodarflorencia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tvNombre;
    public TextView tvCantidad;
    public TextView tvPrecioUnidad;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        tvNombre = itemView.findViewById(R.id.nombre);
        tvCantidad = itemView.findViewById(R.id.cantidad);
        tvPrecioUnidad = itemView.findViewById(R.id.precio);
    }

    @Override
    public void onClick(View v) {
        /*MainActivity.getInstance().llamarPorTelefono(this.getLayoutPosition());*/
    }
}