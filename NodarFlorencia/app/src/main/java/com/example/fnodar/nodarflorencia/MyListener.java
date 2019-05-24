package com.example.fnodar.nodarflorencia;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

public class MyListener implements View.OnClickListener, Handler.Callback{
    Activity activity ;
    MainActivity mainActivity;


    public MyListener(Activity activity) {
        this.activity = activity;
    }
    @Override
    public void onClick(View v) {



        if (v.getId() == R.id.button) {
            EditText mail = (EditText)activity.findViewById(R.id.mail);
            EditText clave = (EditText)activity.findViewById(R.id.clave);
            String correo = mail.getText().toString();
            String correoReplace = correo.replace("\n","");

            String contra = clave.getText().toString();

            Handler handler = new Handler(this);

            MyTheard m = new MyTheard(handler, "http://192.168.2.185:3000/login/"+correoReplace+"/"+contra, 2);
            m.start();



        }
         else {
             activity.finish();
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        String rol = (String) msg.obj;
        if(rol.equals("Admin") || rol.equals("User")){
            Intent i = new Intent(activity, MainActivity.class);
            i.putExtra("rol", rol);
            activity.startActivity(i);
            activity.finish();
        }

        return false;

    }
}
