package com.example.manon.weirdwords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FifthStep extends AppCompatActivity implements View.OnClickListener{

    static FifthStep FifthStep;
    private Button next;
    private ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_step);

        FifthStep = this;



        next = (Button) findViewById(R.id.next);
        back = (ImageButton)findViewById(R.id.undo_button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle level1 = new Bundle();
                level1.putString("passInfo", "level=1x.1xd");
                Intent next = new Intent(FifthStep.this, ThreeLettersLevel.class);
                next.putExtras(level1);
                startActivity(next);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FifthStep.getInstance().finish();
            }
        });
    }

    @Override
    public void onClick(View view) {


    }


    public static FifthStep getInstance(){
        return FifthStep;
    }

}
