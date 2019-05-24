package com.example.fnodar.nodarflorencia;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

public class MyTheard extends Thread {

    MainActivity mainActivity;
    LoginActivity loginActivity;
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

        if (this.imagenTexto == 1) {
            m.obj = XmlParser.parserXml(con.getString(url));
            Log.d("ESTAESLAQUEVA",m.obj.toString());
            this.handler.sendMessage(m);

        }else{
            String a = con.getString(url);
            try {
                JSONObject o = new JSONObject(a);
                m.obj = (String) o.get("type");
                this.handler.sendMessage(m);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
