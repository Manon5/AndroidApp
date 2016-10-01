package com.example.manon.weirdwords;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ChoosePackMenu extends Activity implements View.OnClickListener{

    private ImageButton undo_button = null;
    private ImageButton clue_button = null;
    private ImageButton param_button = null;
    private ImageButton level_1_button = null;
    private ImageButton level_2_button = null;
    private ImageButton level_3_button = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_pack_menu);

        // Init boutons toolbar
        undo_button = (ImageButton)findViewById(R.id.undo_button);
        clue_button = (ImageButton)findViewById(R.id.indice_button);
        param_button = (ImageButton)findViewById(R.id.param_button);

        //Init boutons menu
        level_1_button = (ImageButton)findViewById(R.id.arrow_button_1);
        level_2_button = (ImageButton)findViewById(R.id.arrow_button_2);
        level_3_button = (ImageButton)findViewById(R.id.arrow_button_3);

        // Activation bouton retour
        undo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        // Activation boutons menu

        level_1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                startActivity(level1);
            }
        });

        level_2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent level2 = new Intent(ChoosePackMenu.this, ChooseLevelMenu2.class);
                startActivity(level2);
            }
        });

        level_3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent level3 = new Intent(ChoosePackMenu.this, ChooseLevelMenu3.class);
                startActivity(level3);
            }
        });




    }

    @Override
    public void onClick(View v) {

    }





}
