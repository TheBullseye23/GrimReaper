package com.hfad.grimreaper_2;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Death extends AppCompatActivity {

    String x;
    int clickcount=0;

    EditText d1;
    Button d2;
    ConstraintLayout d3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death);

        d1=findViewById(R.id.Entry);
        d2=findViewById(R.id.guess);
        d3=findViewById(R.id.deathlayout);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String k = intent.getStringExtra("TRIES");
                clickcount++;


                x = d1.getText().toString();
                String q = intent.getStringExtra("ANSWER");
                if ((Integer.valueOf(q) == Integer.valueOf(x))&&clickcount<=Integer.valueOf(k))                      //verifying the guess (equal)
                 {Toast.makeText(getApplicationContext(), "Bang On!", Toast.LENGTH_SHORT).show();
                   d3.setBackgroundColor(Color.rgb(255,255,255));
                    onBackPressed();}
                if ((Integer.valueOf(q) < Integer.valueOf(x))&&clickcount<Integer.valueOf(k))
                {Toast.makeText(getApplicationContext(), "Oops,the person lived longer than destined", Toast.LENGTH_SHORT).show();
                   d3.setBackgroundColor(Color.argb( ((Integer.valueOf(x)-Integer.valueOf(q))*2),255,0,0));
                  onBackPressed();}
                if ((Integer.valueOf(q) > Integer.valueOf(x))&&clickcount<Integer.valueOf(k))
                {Toast.makeText(getApplicationContext(), "Oops,you reaped the person's soul a tad bit too soon", Toast.LENGTH_SHORT).show();
                    d3.setBackgroundColor(Color.argb(((Integer.valueOf(q)-Integer.valueOf(x))*2),0,0,255));
                  onBackPressed();}
                if ((Integer.valueOf(q) > Integer.valueOf(x))&&Integer.valueOf(k)<=clickcount)
                {Toast.makeText(getApplicationContext(), "You've exceeded your chances,Configure to try again!", Toast.LENGTH_SHORT).show();
                 Death.super.onBackPressed();}
                if ((Integer.valueOf(q) < Integer.valueOf(x))&&Integer.valueOf(k)<=clickcount)
                {  Toast.makeText(getApplicationContext(), "You've exceeded your chances,Configure to try again!", Toast.LENGTH_SHORT).show();
                   Death.super.onBackPressed();}
                if((Integer.valueOf(q) == Integer.valueOf(x))&&Integer.valueOf(k)<clickcount)
                { Toast.makeText(getApplicationContext(), "You've exceeded your chances,Configure to try again!", Toast.LENGTH_SHORT).show();
                  Death.super.onBackPressed();}

            };

        });

        if(savedInstanceState!=null)
        {
            clickcount=savedInstanceState.getInt("clickcount");
        }

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        savedInstanceState.putInt("clickcount",clickcount);
    }


    @Override
    public void onBackPressed()
    { }



}
