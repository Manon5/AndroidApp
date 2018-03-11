package com.example.manon.weirdwords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FirstStep extends AppCompatActivity implements View.OnClickListener{

    static FirstStep FirstStep;
    private Button next = null;
    private ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_step);
        FirstStep = this;


        next = (Button)findViewById(R.id.next);
        back = (ImageButton)findViewById(R.id.undo_button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(FirstStep.this, SecondStep.class);
                startActivity(next);
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstStep.getInstance().finish();
            }
        });
    }


    @Override
    public void onClick(View view) {

    }


    public static FirstStep getInstance(){
        return FirstStep;
    }
}
