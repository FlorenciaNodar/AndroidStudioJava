package com.example.fnodar.nodarflorencia;

import android.os.Handler;
import android.os.Message;

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
        m.arg1 = this.imagenTexto;

        if (this.imagenTexto == MainActivity.TEXTO) {
            m.obj = XmlParser.parserXml(con.getString(url));
        }
        else {
            m.obj = con.getByteArray(url);
        }

        this.handler.sendMessage(m);
    }
}
