package com.hfad.grimreaper_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.configure);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            { opensetvalue(); }
        });

    }

            public void opensetvalue(){
        Intent intent=new Intent(this,setvalue.class);
        startActivity(intent);
            }

}
