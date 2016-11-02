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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChooseLevelMenu2 extends Activity implements View.OnClickListener{

    private ImageButton undo_button = null;
    private ImageButton help_button = null;
    private ImageButton param_button = null;

    private String passInfo = null;
    private String clueInfo = null;
    private String levelInfo = null;
    private int levelMax = 1;
    private int level = 0;
    private String carac1 = null;
    private String carac2 = null;
    private int nb1 = 1;
    private int nb2 = 1;
    private int opacity;

    private ImageButton level1 = null;
    private ImageButton level2 = null;
    private ImageButton level3 = null;
    private ImageButton level4 = null;
    private ImageButton level5 = null;
    private ImageButton level6 = null;
    private ImageButton level7 = null;
    private ImageButton level8 = null;
    private ImageButton level9 = null;
    private ImageButton level10 = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level_menu2);

        // Init boutons toolbar
        undo_button = (ImageButton) findViewById(R.id.undo_button);
        help_button = (ImageButton) findViewById(R.id.help_button);
        param_button = (ImageButton) findViewById(R.id.param_button);

        // Activation boutons toolbar
        undo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        help_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        param_button.setOnClickListener(new View.OnClickListener(){
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
        level9 = (ImageButton)findViewById(R.id.level_9);
        level10 = (ImageButton)findViewById(R.id.level_10);




        FileInputStream input = null;
        String read = null;
        char[] readBuffer = new char[28];
        InputStreamReader isr = null;

        try {

            input = openFileInput("USERINFOS");

            isr = new InputStreamReader(input);
            isr.read(readBuffer);
            read = new String(readBuffer);


        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        passInfo = read;
        clueInfo = passInfo.substring(16);
        levelInfo = passInfo.substring(0, 16);


        // Traitement pour obtenir levelMax

        nb1 = Integer.parseInt("" + levelInfo.charAt(10));
        nb2 = Integer.parseInt("" + levelInfo.charAt(13)) ;
        opacity = 180;

        // Afficher en fonction des niveaux accessibles

        if(nb2 <= 1){
            level2.getBackground().setAlpha(opacity);
            level3.getBackground().setAlpha(opacity);
            level4.getBackground().setAlpha(opacity);
            level5.getBackground().setAlpha(opacity);
            level6.getBackground().setAlpha(opacity);
            level7.getBackground().setAlpha(opacity);
            level8.getBackground().setAlpha(opacity);
            level9.getBackground().setAlpha(opacity);
            level10.getBackground().setAlpha(opacity);
        }else if(nb2 <= 2){
            level3.getBackground().setAlpha(opacity);
            level4.getBackground().setAlpha(opacity);
            level5.getBackground().setAlpha(opacity);
            level6.getBackground().setAlpha(opacity);
            level7.getBackground().setAlpha(opacity);
            level8.getBackground().setAlpha(opacity);
            level9.getBackground().setAlpha(opacity);
            level10.getBackground().setAlpha(opacity);
        }else if(nb2 <= 3){
            level4.getBackground().setAlpha(opacity);
            level5.getBackground().setAlpha(opacity);
            level6.getBackground().setAlpha(opacity);
            level7.getBackground().setAlpha(opacity);
            level8.getBackground().setAlpha(opacity);
            level9.getBackground().setAlpha(opacity);
            level10.getBackground().setAlpha(opacity);
        }else if(nb2 <= 4){
            level5.getBackground().setAlpha(opacity);
            level6.getBackground().setAlpha(opacity);
            level7.getBackground().setAlpha(opacity);
            level8.getBackground().setAlpha(opacity);
            level9.getBackground().setAlpha(opacity);
            level10.getBackground().setAlpha(opacity);
        }else if(nb2 <= 5){
            level6.getBackground().setAlpha(opacity);
            level7.getBackground().setAlpha(opacity);
            level8.getBackground().setAlpha(opacity);
            level9.getBackground().setAlpha(opacity);
            level10.getBackground().setAlpha(opacity);
        }else if(nb2 <= 6){
            level7.getBackground().setAlpha(opacity);
            level8.getBackground().setAlpha(opacity);
            level9.getBackground().setAlpha(opacity);
            level10.getBackground().setAlpha(opacity);
        }else if(nb2 <= 7){
            level8.getBackground().setAlpha(opacity);
            level9.getBackground().setAlpha(opacity);
            level10.getBackground().setAlpha(opacity);
        }else if(nb2 <= 8){
            level9.getBackground().setAlpha(opacity);
            level10.getBackground().setAlpha(opacity);
        }else if(nb2 <= 9) {
            level10.getBackground().setAlpha(opacity);
        }else{

        }






        // Activation level 1
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //création de notre item
                Intent defineIntent = new Intent(ChooseLevelMenu2.this, FourLettersLevel.class);
                // objet qui vas nous permettre de passe des variables ici la variable passInfo
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", "level=2x.1xn");
                // on passe notre objet a notre activities
                defineIntent.putExtras(objetbunble );
                // on appelle notre activité
                startActivity(defineIntent);
            }
        });

        // Activation level 2
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nb2 <= 1){

                }else{
                    //création de notre item
                    Intent defineIntent = new Intent(ChooseLevelMenu2.this, FourLettersLevel.class);
                    // objet qui vas nous permettre de passe des variables ici la variable passInfo
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "level=2x.2xn");
                    // on passe notre objet a notre activities
                    defineIntent.putExtras(objetbunble);
                    // on appelle notre activité
                    startActivity(defineIntent);
                }
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nb2 <= 2){

                }else{
                    //création de notre item
                    Intent defineIntent = new Intent(ChooseLevelMenu2.this, FourLettersLevel.class);
                    // objet qui vas nous permettre de passe des variables ici la variable passInfo
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "level=2x.3xn");
                    // on passe notre objet a notre activities
                    defineIntent.putExtras(objetbunble);
                    // on appelle notre activité
                    startActivity(defineIntent);
                }
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nb2 <= 3){

                }else{
                    //création de notre item
                    Intent defineIntent = new Intent(ChooseLevelMenu2.this, FourLettersLevel.class);
                    // objet qui vas nous permettre de passe des variables ici la variable passInfo
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "level=2x.4xn");
                    // on passe notre objet a notre activities
                    defineIntent.putExtras(objetbunble);
                    // on appelle notre activité
                    startActivity(defineIntent);
                }
            }
        });

        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nb2 <= 4){

                }else{
                    //création de notre item
                    Intent defineIntent = new Intent(ChooseLevelMenu2.this, FourLettersLevel.class);
                    // objet qui vas nous permettre de passe des variables ici la variable passInfo
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "level=2x.5xn");
                    // on passe notre objet a notre activities
                    defineIntent.putExtras(objetbunble);
                    // on appelle notre activité
                    startActivity(defineIntent);
                }
            }
        });

        level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nb2 <= 5){

                }else{
                    //création de notre item
                    Intent defineIntent = new Intent(ChooseLevelMenu2.this, FourLettersLevel.class);
                    // objet qui vas nous permettre de passe des variables ici la variable passInfo
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "level=2x.6xn");
                    // on passe notre objet a notre activities
                    defineIntent.putExtras(objetbunble);
                    // on appelle notre activité
                    startActivity(defineIntent);
                }
            }
        });

        level7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nb2 <= 6){

                }else{
                    //création de notre item
                    Intent defineIntent = new Intent(ChooseLevelMenu2.this, FourLettersLevel.class);
                    // objet qui vas nous permettre de passe des variables ici la variable passInfo
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "level=2x.7xn");
                    // on passe notre objet a notre activities
                    defineIntent.putExtras(objetbunble);
                    // on appelle notre activité
                    startActivity(defineIntent);
                }
            }
        });

        level8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nb2 <= 7){

                }else{
                    //création de notre item
                    Intent defineIntent = new Intent(ChooseLevelMenu2.this, FourLettersLevel.class);
                    // objet qui vas nous permettre de passe des variables ici la variable passInfo
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "level=2x.8xn");
                    // on passe notre objet a notre activities
                    defineIntent.putExtras(objetbunble);
                    // on appelle notre activité
                    startActivity(defineIntent);
                }
            }
        });

        level9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nb2 <= 8){

                }else{
                    //création de notre item
                    Intent defineIntent = new Intent(ChooseLevelMenu2.this, FourLettersLevel.class);
                    // objet qui vas nous permettre de passe des variables ici la variable passInfo
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "level=2x.9xn");
                    // on passe notre objet a notre activities
                    defineIntent.putExtras(objetbunble);
                    // on appelle notre activité
                    startActivity(defineIntent);
                }
            }
        });

        level10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nb2 <= 9){

                }else{
                    //création de notre item
                    Intent defineIntent = new Intent(ChooseLevelMenu2.this, FourLettersLevel.class);
                    // objet qui vas nous permettre de passe des variables ici la variable passInfo
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "level=2x.10n");
                    // on passe notre objet a notre activities
                    defineIntent.putExtras(objetbunble);
                    // on appelle notre activité
                    startActivity(defineIntent);
                }
            }
        });





    }

    @Override
    public void onClick(View v) {

    }
}