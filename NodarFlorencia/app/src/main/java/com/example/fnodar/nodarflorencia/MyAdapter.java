package com.example.fnodar.nodarflorencia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private List<Producto> productos;

    public MyAdapter(List<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycle, viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        Producto p = this.productos.get(i);

        viewHolder.tvNombre.setText(p.getNombre());

        viewHolder.tvCantidad.setText(p.getCantidad());

        viewHolder.tvPrecioUnidad.setText(Double.toString(p.getPrecioUnidad()));

    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
