package com.example.fnodar.nodarflorencia;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private List<Producto> productos;
    private Handler handler;

    public MyAdapter(List<Producto> productos, Handler handler) {
        this.productos = productos;
        this.handler = handler;

    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycle, viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        Producto p = this.productos.get(i);

        Log.d("holaDen",p.toString());
        viewHolder.tvNombre.setText(p.getNombre());

         viewHolder.tvCantidad.setText(p.getCantidad().toString());

        viewHolder.tvPrecioUnidad.setText(p.getPrecio().toString());

    }

    public void setProductos(List<Producto> p) {
        this.productos = p;
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
