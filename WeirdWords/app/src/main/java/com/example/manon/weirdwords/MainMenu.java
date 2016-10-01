package com.example.manon.weirdwords;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenu extends Activity implements View.OnClickListener{


    private Button play_button = null;
    private Button quit_button = null;
    private Button credits_button = null;

    private ImageButton undo_button = null;
    private ImageButton clue_button = null;
    private ImageButton param_button = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Init boutons toolbar
        undo_button = (ImageButton)findViewById(R.id.undo_button);
        clue_button = (ImageButton)findViewById(R.id.indice_button);
        param_button = (ImageButton)findViewById(R.id.param_button);

        // Initialisation 3 boutons menu
        play_button = (Button)findViewById(R.id.play_button);
        quit_button = (Button)findViewById(R.id.quit_button);
        credits_button = (Button)findViewById(R.id.credits_button);





        // Activation toolbar


        undo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        // FIN Activation toolbar


        // Activation boutons


        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appel = new Intent(MainMenu.this, ChoosePackMenu.class);
                startActivity(appel);
            }
        });

        quit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        // FIN activation boutons



    }

    @Override
    public void onClick(View v) {



    }
}
