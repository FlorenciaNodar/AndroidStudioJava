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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvProductos = super.findViewById(R.id.rvProductos);

        adapter = new MyAdapter(productos);

        rvProductos.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        rvProductos.setLayoutManager(layoutManager);

       /* Button btn = super.findViewById(R.id.buttonAgregar);

        btn.setOnClickListener(new MyListener(this));*/

        instance = this;

        // le paso algo que impelemente el callback
        Handler handler = new Handler(this);

        MyTheard m = new MyTheard(handler, "http://192.168.2.166:8080/productos.xml", TEXTO);
        m.start();

    }

    public static MainActivity getInstance() {
        return instance;
    }


    @Override
    public boolean handleMessage(Message msg) {
   if (msg.arg1 == TEXTO) {
       TextView t = this.findViewById(R.id.precio);

       Log.d("lista,", msg.obj.toString());
        }

        return false;
    }
}
