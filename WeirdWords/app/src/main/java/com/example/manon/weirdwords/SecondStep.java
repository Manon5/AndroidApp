package com.example.manon.weirdwords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondStep extends AppCompatActivity implements View.OnClickListener {

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_step);


        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(SecondStep.this, ThirdStep.class);
                startActivity(next);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
