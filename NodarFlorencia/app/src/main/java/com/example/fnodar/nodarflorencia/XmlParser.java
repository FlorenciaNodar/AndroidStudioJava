package com.example.fnodar.nodarflorencia;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
    public static List<Producto> parserXml(String listaProductos){
        List<Producto> productos = new ArrayList<>();
        XmlPullParser xml = Xml.newPullParser();


        try {

            xml.setInput(new StringReader(listaProductos));
            int event = xml.getEventType();
            Producto p = null;
            while(event != XmlPullParser.END_DOCUMENT){

                if(event == XmlPullParser.START_TAG){
                    if("producto".equals(xml.getName())){
                        p = new Producto();

                    }else
                    if("nombre".equals(xml.getName())){
                    String n = xml.nextText();
                        p.setNombre(n);
                    }
                    if("cantidad".equals(xml.getName())){

                        String e = xml.nextText();
                        p.setCantidad(e);

                    }else if("precio".equals(xml.getName())) {
                        String pu = xml.nextText();
                        p.setPrecioUnidad(Double.parseDouble(pu));
                    }
                    productos.add(p);

                }

                event = xml.next();

            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
