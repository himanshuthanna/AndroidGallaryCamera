package com.example.lenovo.intentwokshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {

   Button btn;
   int req_code1=1;
    int req_code2=2;
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.b1);
        i1=(ImageView)findViewById(R.id.img);


    }
    public void display(View view)
    {
        startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),req_code1);

    }
    public void gallary(View view)
    { Intent i2=new Intent();
        i2.setType("images/*");
        i2.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i2,"himanshu"),req_code2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && data!=null && resultCode==RESULT_OK) {
            Toast.makeText(this, "" + requestCode + resultCode, Toast.LENGTH_SHORT).show();
            Bundle s = data.getExtras();
            Bitmap bt = (Bitmap) s.get("data");

                i1.setImageBitmap(bt);

        }
        if(requestCode==2 && data!=null && resultCode==RESULT_OK) {
            Toast.makeText(this, "" + requestCode + resultCode, Toast.LENGTH_SHORT).show();
            Uri u=data.getData();
           try {
               Bitmap bt = MediaStore.Images.Media.getBitmap(getContentResolver(), u);
               i1.setImageBitmap(bt);
           }
           catch(Exception e){
               println("error");

            }

        }





    }


}
