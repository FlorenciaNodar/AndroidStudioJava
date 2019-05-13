package com.example.fnodar.nodarflorencia;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;

public class MyTheard extends Thread {

    private Handler handler;
    private String url;
    private int imagenTexto;

    public MyTheard(Handler handler, String url, int imagenTexto) {
        this.handler = handler;
        this.url = url;
        this.imagenTexto = imagenTexto;
    }


    @Override
    public void run() {

        HttpConection con = new HttpConection();
        Message m = new Message();

        if (this.imagenTexto == MainActivity.TEXTO) {
            m.obj = XmlParser.parserXml(con.getString(url));
            Log.d("ESTAESLAQUEVA",m.obj.toString());
        }

        this.handler.sendMessage(m);
    }
}
