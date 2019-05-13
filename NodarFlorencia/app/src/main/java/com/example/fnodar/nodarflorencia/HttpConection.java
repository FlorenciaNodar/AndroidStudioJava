package com.example.fnodar.nodarflorencia;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConection {

    public String getString(String sUrl) {

        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        try {
            URL url = new URL(sUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            int res = conn.getResponseCode();

            if (res == 200) {
                InputStream is = conn.getInputStream();

                byte[] array = new byte[1024];

                int cant = 0 ;

                while ((cant = is.read(array))!= -1) {
                    bao.write(array, 0, cant);
                }

                is.close();
            }

            else {
                throw new Exception("Error en el servidor");
            }

        } catch (Exception e) {
            Log.d("ERROR", e.getMessage());
        }

        return new String(bao.toByteArray());
    }
}
