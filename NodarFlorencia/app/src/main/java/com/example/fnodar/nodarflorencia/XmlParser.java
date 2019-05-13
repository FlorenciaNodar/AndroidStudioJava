package com.example.fnodar.nodarflorencia;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
    public static List<Producto> parserXml (String productos) {
        List<Producto> prods = new ArrayList<>();

        XmlPullParser xml = Xml.newPullParser();

        try {
            xml.setInput(new StringReader(productos));

            int event = xml.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                if (event == XmlPullParser.START_TAG) {

                    if ("producto".equals(xml.getName())) {
                        Log.d("GETNAME",xml.getName());
                        Producto p = new Producto();
                        xml.nextTag();

                        if ("id".equals(xml.getName())) {
                           xml.nextText();
                         xml.nextTag();
                       }

                        if ("nombre".equals(xml.getName())) {
                            Log.d("GETNOMBRE",xml.getName());

                            p.setNombre(xml.nextText());
                            xml.nextTag();
                        }

                        if ("precio".equals(xml.getName())) {
                            Log.d("GETPRECIO",xml.getName());

                            p.setPrecio(Double.parseDouble(xml.nextText()));
                            xml.nextTag();
                        }

                        if ("cantidad".equals(xml.getName())) {
                            p.setCantidad(Integer.parseInt(xml.nextText()));
                            xml.nextTag();
                        }

                        prods.add(p);
                    }
                }

                event = xml.next();
            }


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prods;
    }
}
