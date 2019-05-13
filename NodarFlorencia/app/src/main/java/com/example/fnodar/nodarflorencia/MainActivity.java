package com.example.fnodar.nodarflorencia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private static MainActivity instance;
    public MyAdapter adapter;
    public List<Producto> productos = new ArrayList<>();
    public static  final int TEXTO = 1;

    public static MainActivity getInstance() {
        return instance;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvProductos = super.findViewById(R.id.rvProductos);

        Handler handler = new Handler(this);

        MyTheard m = new MyTheard(handler, "http://172.17.88.33:8080/listaProductos.xml", TEXTO);
        m.start();

        adapter = new MyAdapter(productos, handler);

        rvProductos.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        rvProductos.setLayoutManager(layoutManager);

        instance = this;



    }



    @Override
    public boolean handleMessage(Message msg) {
        this.adapter.setProductos((List<Producto>) msg.obj);

        this.productos = (List<Producto>) msg.obj;
        Log.d("adsa",msg.obj.toString());

        this.adapter.notifyDataSetChanged();

        return false;

    }

    public void controlStock(Integer boton, int index) {

        Producto prod = productos.get(index);

        if (boton == 1 ) {
            prod.setCantidad(prod.getCantidad() + 1);
        } else if (boton == 2) {
            prod.setCantidad(prod.getCantidad() - 1);
        }

        this.adapter.notifyItemChanged(index);
    }
}
