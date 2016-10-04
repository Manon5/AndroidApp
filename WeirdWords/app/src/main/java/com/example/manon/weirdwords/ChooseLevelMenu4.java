package com.example.manon.weirdwords;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class ChooseLevelMenu4 extends AppCompatActivity {
    private ImageButton undo_button = null;
    private ImageButton clue_button = null;
    private ImageButton param_button = null;


    private ImageButton level1 = null;
    private ImageButton level2 = null;
    private ImageButton level3 = null;
    private ImageButton level4 = null;
    private ImageButton level5 = null;
    private ImageButton level6 = null;
    private ImageButton level7 = null;
    private ImageButton level8 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level_menu4);
        // Init boutons toolbar
        undo_button = (ImageButton)findViewById(R.id.undo_button);
        clue_button = (ImageButton)findViewById(R.id.indice_button);
        param_button = (ImageButton)findViewById(R.id.param_button);
        // Activation bouton retour
        undo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        // Init boutons levels
        level1 = (ImageButton)findViewById(R.id.level_1);
        level2 = (ImageButton)findViewById(R.id.level_2);
        level3 = (ImageButton)findViewById(R.id.level_3);
        level4 = (ImageButton)findViewById(R.id.level_4);
        level5 = (ImageButton)findViewById(R.id.level_5);
        level6 = (ImageButton)findViewById(R.id.level_6);
        level7 = (ImageButton)findViewById(R.id.level_7);
        level8 = (ImageButton)findViewById(R.id.level_8);


        // Activation level 1
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent defineIntent = new Intent(ChooseLevelMenu4.this, FiveLettersLevel.class);
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", "level 4.1n");
                defineIntent.putExtras(objetbunble );
                startActivity(defineIntent);
            }
        });

        // Activation level 2
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent defineIntent = new Intent(ChooseLevelMenu4.this, FiveLettersLevel.class);
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", "level 4.2n");
                defineIntent.putExtras(objetbunble );
                startActivity(defineIntent);
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent defineIntent = new Intent(ChooseLevelMenu4.this, FiveLettersLevel.class);
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", "level 4.3n");
                defineIntent.putExtras(objetbunble );
                startActivity(defineIntent);
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //création de notre item
                Intent defineIntent = new Intent(ChooseLevelMenu4.this, FiveLettersLevel.class);
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", "level 4.4n");
                defineIntent.putExtras(objetbunble );
                startActivity(defineIntent);
            }
        });

        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //création de notre item
                Intent defineIntent = new Intent(ChooseLevelMenu4.this, FiveLettersLevel.class);
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", "level 4.5n");
                defineIntent.putExtras(objetbunble );
                startActivity(defineIntent);
            }
        });

        level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //création de notre item
                Intent defineIntent = new Intent(ChooseLevelMenu4.this, FiveLettersLevel.class);
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", "level 4.6n");
                defineIntent.putExtras(objetbunble );
                startActivity(defineIntent);
            }
        });

        level7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //création de notre item
                Intent defineIntent = new Intent(ChooseLevelMenu4.this, FiveLettersLevel.class);
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", "level 4.7n");
                defineIntent.putExtras(objetbunble );
                startActivity(defineIntent);
            }
        });

        level8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //création de notre item
                Intent defineIntent = new Intent(ChooseLevelMenu4.this, FiveLettersLevel.class);
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", "level 4.8n");
                defineIntent.putExtras(objetbunble );
                startActivity(defineIntent);
            }
        });
    }
}
