package com.hfad.grimreaper_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class setvalue extends AppCompatActivity {

    String y;
    String z;

    EditText c1;
    Button c2;

    EditText e1;
    Button e2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setvalue);

        c1=findViewById(R.id.Trynumber);
        c2=findViewById(R.id.chanceentry);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y=c1.getText().toString();
                if(Integer.valueOf(y)<=0)
                { Toast.makeText(getApplicationContext(),"Enter number greater than 0 " + y,Toast.LENGTH_SHORT).show();
                   z=String.valueOf(0); }

               if(Integer.valueOf(y)>=1)
               {Toast.makeText(getApplicationContext(),"Number of entries set as " + y,Toast.LENGTH_SHORT).show();
               }
            }
        });

        e1=findViewById(R.id.setanswer);
        e2=findViewById(R.id.forsettinganswer);
        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                z=e1.getText().toString();
                if(Integer.valueOf(z)>100||Integer.valueOf(z)<1)
                { Toast.makeText(getApplicationContext(),"Enter between 1-100 " ,Toast.LENGTH_SHORT).show();
                  z= String.valueOf(0);}                // TAKE CARE

                if(Integer.valueOf(z)<=100&&Integer.valueOf(z)>=1)
                {Toast.makeText(getApplicationContext(),"Answer set as " + z,Toast.LENGTH_SHORT).show();
                  Intent intent =new Intent(setvalue.this,Death.class);
                  intent.putExtra("ANSWER",z);
                    intent.putExtra("TRIES",y);
                  startActivity(intent);
                }
            }
        });
    }
}
