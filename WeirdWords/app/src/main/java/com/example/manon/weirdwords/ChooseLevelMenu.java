package com.example.manon.weirdwords;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChooseLevelMenu extends Activity implements View.OnClickListener {

    private ImageButton undo_button = null;
    private ImageButton help_button = null;
    private ImageButton param_button = null;
    private ImageButton clue_button = null;


    private String passInfo = null;
    private String clueInfo = null;
    private String levelInfo = null;
    private String levelS = null;
    private char levelC = ' ';
    private int levelI = 0;
    private int levelMax = 1;
    private int level = 0;
    private String carac1 = null;
    private String carac2 = null;
    private int nb1 = 1;
    private int nb2 = 1;
    private int opacity;
    private int test;
    private  int nbOfClues;

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

    private GoogleApiClient client;
    static ChooseLevelMenu ChooseLevelMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level_menu);

        ChooseLevelMenu = this;
        // Init boutons toolbar
        undo_button = (ImageButton) findViewById(R.id.undo_button);
        help_button = (ImageButton) findViewById(R.id.help_button);
        param_button = (ImageButton) findViewById(R.id.param_button);
        clue_button = (ImageButton) findViewById(R.id.clue_button);

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
                Intent appel = new Intent(ChooseLevelMenu.this, Settings.class);
                startActivity(appel);
            }
        });

        nbOfClues = getClueNb();
        setClueButtonBackground(0, nbOfClues);



        // Init boutons levels
        level1 = (ImageButton) findViewById(R.id.level_1);
        level2 = (ImageButton) findViewById(R.id.level_2);
        level3 = (ImageButton) findViewById(R.id.level_3);
        level4 = (ImageButton) findViewById(R.id.level_4);
        level5 = (ImageButton) findViewById(R.id.level_5);
        level6 = (ImageButton) findViewById(R.id.level_6);
        level7 = (ImageButton) findViewById(R.id.level_7);
        level8 = (ImageButton) findViewById(R.id.level_8);
        level9 = (ImageButton) findViewById(R.id.level_9);
        level10 = (ImageButton) findViewById(R.id.level_10);



        /////////////// Recup memoire interne ///////////////








        // NAMESMAX
        FileInputStream input4 = null;
        String read4 = null;
        char[] readBuffer4 = new char[26];
        InputStreamReader isr4 = null;

        // Recuperation de la valeur
        try {

            input4 = openFileInput("NAMESMAX");

            isr4 = new InputStreamReader(input4);
            isr4.read(readBuffer4);
            read4 = new String(readBuffer4);


        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        // FIN NAMESMAX






        ///////////// Recup valeur niveau ///////////////////

        Bundle objectbunble  = this.getIntent().getExtras();
        // récupération de la valeur
        levelS = objectbunble.getString("passInfo");

        if(levelS.length() == 1){

            //////////////////////////////// NIVEAU CLASSIQUES ///////////////////////////////

            // LEVELMAX
            FileInputStream input1 = null;
            String read1 = null;
            char[] readBuffer1 = new char[26];
            InputStreamReader isr1 = null;

            try {

                input1 = openFileInput("LEVELMAX");

                isr1 = new InputStreamReader(input1);
                isr1.read(readBuffer1);
                read1 = new String(readBuffer1);


            } catch (FileNotFoundException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }

            passInfo = read1;
            levelInfo = passInfo.substring(0, 16);


            levelC = levelS.charAt(0);
            levelI = Integer.parseInt(levelS);


            // Traitement pour obtenir levelMax

            nb1 = Integer.parseInt("" + levelInfo.charAt(10));
            nb2 = Integer.parseInt("" + levelInfo.charAt(13)) ;
            opacity = 180;

            // Gerer l'affichage

            if(levelS.equals("1")){
                level1.setBackgroundResource(R.mipmap.level_1_1_mini);
                level2.setBackgroundResource(R.mipmap.level_1_2_mini);
                level3.setBackgroundResource(R.mipmap.level_1_3_mini);
                level4.setBackgroundResource(R.mipmap.level_1_4_mini);
                level5.setBackgroundResource(R.mipmap.level_1_5_mini);
                level6.setBackgroundResource(R.mipmap.level_1_6_mini);
                level7.setBackgroundResource(R.mipmap.level_1_7_mini);
                level8.setBackgroundResource(R.mipmap.level_1_8_mini);
                level9.setBackgroundResource(R.mipmap.level_1_9_mini);
                level10.setBackgroundResource(R.mipmap.level_1_10_mini);
            }else if(levelS.equals("2")){
                level1.setBackgroundResource(R.mipmap.level_2_1_mini);
                level2.setBackgroundResource(R.mipmap.level_2_2_mini);
                level3.setBackgroundResource(R.mipmap.level_2_3_mini);
                level4.setBackgroundResource(R.mipmap.level_2_4_mini);
                level5.setBackgroundResource(R.mipmap.level_2_5_mini);
                level6.setBackgroundResource(R.mipmap.level_2_6_mini);
                level7.setBackgroundResource(R.mipmap.level_2_7_mini);
                level8.setBackgroundResource(R.mipmap.level_2_8_mini);
                level9.setBackgroundResource(R.mipmap.level_2_9_mini);
                level10.setBackgroundResource(R.mipmap.level_2_10_mini);
            }else if(levelS.equals("3")){
                level1.setBackgroundResource(R.mipmap.level_3_1_mini);
                level2.setBackgroundResource(R.mipmap.level_3_2_mini);
                level3.setBackgroundResource(R.mipmap.level_3_3_mini);
                level4.setBackgroundResource(R.mipmap.level_3_4_mini);
                level5.setBackgroundResource(R.mipmap.level_3_5_mini);
                level6.setBackgroundResource(R.mipmap.level_3_6_mini);
                level7.setBackgroundResource(R.mipmap.level_3_7_mini);
                level8.setBackgroundResource(R.mipmap.level_3_8_mini);
                level9.setBackgroundResource(R.mipmap.level_3_9_mini);
                level10.setBackgroundResource(R.mipmap.level_3_10_mini);
            }else if(levelS.equals("4")){
                level1.setBackgroundResource(R.mipmap.level_4_1_mini);
                level2.setBackgroundResource(R.mipmap.level_4_2_mini);
                level3.setBackgroundResource(R.mipmap.level_4_3_mini);
                level4.setBackgroundResource(R.mipmap.level_4_4_mini);
                level5.setBackgroundResource(R.mipmap.level_4_5_mini);
                level6.setBackgroundResource(R.mipmap.level_4_6_mini);
                level7.setBackgroundResource(R.mipmap.level_4_7_mini);
                level8.setBackgroundResource(R.mipmap.level_4_8_mini);
                level9.setBackgroundResource(R.mipmap.level_4_9_mini);
                level10.setBackgroundResource(R.mipmap.level_4_10_mini);
            }else if(levelS.equals("5")){
                level1.setBackgroundResource(R.mipmap.level_5_1_mini);
                level2.setBackgroundResource(R.mipmap.level_5_2_mini);
                level3.setBackgroundResource(R.mipmap.level_5_3_mini);
                level4.setBackgroundResource(R.mipmap.level_5_4_mini);
                level5.setBackgroundResource(R.mipmap.level_5_5_mini);
                level6.setBackgroundResource(R.mipmap.level_5_6_mini);
                level7.setBackgroundResource(R.mipmap.level_5_7_mini);
                level8.setBackgroundResource(R.mipmap.level_5_8_mini);
                level9.setBackgroundResource(R.mipmap.level_5_9_mini);
                level10.setBackgroundResource(R.mipmap.level_5_10_mini);
            }else if(levelS.equals("6")){
                level1.setBackgroundResource(R.mipmap.level_5_1_mini);
                level2.setBackgroundResource(R.mipmap.level_5_2_mini);
                level3.setBackgroundResource(R.mipmap.level_5_3_mini);
                level4.setBackgroundResource(R.mipmap.level_5_4_mini);
                level5.setBackgroundResource(R.mipmap.level_5_5_mini);
                level6.setBackgroundResource(R.mipmap.level_5_6_mini);
                level7.setBackgroundResource(R.mipmap.level_5_7_mini);
                level8.setBackgroundResource(R.mipmap.level_5_8_mini);
                level9.setBackgroundResource(R.mipmap.level_5_9_mini);
                level10.setBackgroundResource(R.mipmap.level_5_10_mini);
            }else if(levelS.equals("7")){
                level1.setBackgroundResource(R.mipmap.level_5_1_mini);
                level2.setBackgroundResource(R.mipmap.level_5_2_mini);
                level3.setBackgroundResource(R.mipmap.level_5_3_mini);
                level4.setBackgroundResource(R.mipmap.level_5_4_mini);
                level5.setBackgroundResource(R.mipmap.level_5_5_mini);
                level6.setBackgroundResource(R.mipmap.level_5_6_mini);
                level7.setBackgroundResource(R.mipmap.level_5_7_mini);
                level8.setBackgroundResource(R.mipmap.level_5_8_mini);
                level9.setBackgroundResource(R.mipmap.level_5_9_mini);
                level10.setBackgroundResource(R.mipmap.level_5_10_mini);
            }else if(levelS.equals("8")){
                level1.setBackgroundResource(R.mipmap.level_5_1_mini);
                level2.setBackgroundResource(R.mipmap.level_5_2_mini);
                level3.setBackgroundResource(R.mipmap.level_5_3_mini);
                level4.setBackgroundResource(R.mipmap.level_5_4_mini);
                level5.setBackgroundResource(R.mipmap.level_5_5_mini);
                level6.setBackgroundResource(R.mipmap.level_5_6_mini);
                level7.setBackgroundResource(R.mipmap.level_5_7_mini);
                level8.setBackgroundResource(R.mipmap.level_5_8_mini);
                level9.setBackgroundResource(R.mipmap.level_5_9_mini);
                level10.setBackgroundResource(R.mipmap.level_5_10_mini);
            }else if(levelS.equals("9")){
                level1.setBackgroundResource(R.mipmap.level_5_1_mini);
                level2.setBackgroundResource(R.mipmap.level_5_2_mini);
                level3.setBackgroundResource(R.mipmap.level_5_3_mini);
                level4.setBackgroundResource(R.mipmap.level_5_4_mini);
                level5.setBackgroundResource(R.mipmap.level_5_5_mini);
                level6.setBackgroundResource(R.mipmap.level_5_6_mini);
                level7.setBackgroundResource(R.mipmap.level_5_7_mini);
                level8.setBackgroundResource(R.mipmap.level_5_8_mini);
                level9.setBackgroundResource(R.mipmap.level_5_9_mini);
                level10.setBackgroundResource(R.mipmap.level_5_10_mini);
            }else if(levelS.equals("10")){
                level1.setBackgroundResource(R.mipmap.level_5_1_mini);
                level2.setBackgroundResource(R.mipmap.level_5_2_mini);
                level3.setBackgroundResource(R.mipmap.level_5_3_mini);
                level4.setBackgroundResource(R.mipmap.level_5_4_mini);
                level5.setBackgroundResource(R.mipmap.level_5_5_mini);
                level6.setBackgroundResource(R.mipmap.level_5_6_mini);
                level7.setBackgroundResource(R.mipmap.level_5_7_mini);
                level8.setBackgroundResource(R.mipmap.level_5_8_mini);
                level9.setBackgroundResource(R.mipmap.level_5_9_mini);
                level10.setBackgroundResource(R.mipmap.level_5_10_mini);
            }else if(levelS.equals("11")){
                level1.setBackgroundResource(R.mipmap.level_5_1_mini);
                level2.setBackgroundResource(R.mipmap.level_5_2_mini);
                level3.setBackgroundResource(R.mipmap.level_5_3_mini);
                level4.setBackgroundResource(R.mipmap.level_5_4_mini);
                level5.setBackgroundResource(R.mipmap.level_5_5_mini);
                level6.setBackgroundResource(R.mipmap.level_5_6_mini);
                level7.setBackgroundResource(R.mipmap.level_5_7_mini);
                level8.setBackgroundResource(R.mipmap.level_5_8_mini);
                level9.setBackgroundResource(R.mipmap.level_5_9_mini);
                level10.setBackgroundResource(R.mipmap.level_5_10_mini);
            }else if(levelS.equals("12")){
                level1.setBackgroundResource(R.mipmap.level_5_1_mini);
                level2.setBackgroundResource(R.mipmap.level_5_2_mini);
                level3.setBackgroundResource(R.mipmap.level_5_3_mini);
                level4.setBackgroundResource(R.mipmap.level_5_4_mini);
                level5.setBackgroundResource(R.mipmap.level_5_5_mini);
                level6.setBackgroundResource(R.mipmap.level_5_6_mini);
                level7.setBackgroundResource(R.mipmap.level_5_7_mini);
                level8.setBackgroundResource(R.mipmap.level_5_8_mini);
                level9.setBackgroundResource(R.mipmap.level_5_9_mini);
                level10.setBackgroundResource(R.mipmap.level_5_10_mini);
            }else{

            }




            // Afficher en fonction des niveaux accessibles

            if(nb1 < levelI) {
                test = 0;
                level1.getBackground().setAlpha(opacity);
                level2.getBackground().setAlpha(opacity);
                level3.getBackground().setAlpha(opacity);
                level4.getBackground().setAlpha(opacity);
                level5.getBackground().setAlpha(opacity);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb1 > levelI){
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(255);
                level7.getBackground().setAlpha(255);
                level8.getBackground().setAlpha(255);
                level9.getBackground().setAlpha(255);
                level10.getBackground().setAlpha(255);
                test = 10;
            }else if(nb2 == 1){
                test = 2;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(opacity);
                level3.getBackground().setAlpha(opacity);
                level4.getBackground().setAlpha(opacity);
                level5.getBackground().setAlpha(opacity);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 2){
                test = 3;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(opacity);
                level4.getBackground().setAlpha(opacity);
                level5.getBackground().setAlpha(opacity);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 3){
                test = 4;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(opacity);
                level5.getBackground().setAlpha(opacity);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 4){
                test = 5;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(opacity);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 5){
                test = 6;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 6){
                test = 7;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(255);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 7){
                test = 8;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(255);
                level7.getBackground().setAlpha(255);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 8){
                test = 9;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(255);
                level7.getBackground().setAlpha(255);
                level8.getBackground().setAlpha(255);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 9) {
                test = 10;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(255);
                level7.getBackground().setAlpha(255);
                level8.getBackground().setAlpha(255);
                level9.getBackground().setAlpha(255);
                level10.getBackground().setAlpha(opacity);
            }else{

            }


            // Activation level 1
            level1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test >= 1){

                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "level=" + levelC + "x.1xn");

                        //création de notre item
                        if(levelC == '1'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '4' || levelC == '5'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }








                }
            });

            // Activation level 2
            level2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test > 2){

                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "level=" + levelC + "x.2xn");

                        //création de notre item
                        if(levelC == '1'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }

                }
            });

            level3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(test > 3){

                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "level=" + levelC + "x.3xn");

                        //création de notre item
                        if(levelC == '1'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });

            level4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(test > 4){

                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "level=" + levelC + "x.4xn");

                        //création de notre item
                        if(levelC == '1'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });

            level5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(test > 5){

                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "level=" + levelC + "x.5xn");

                        //création de notre item
                        if(levelC == '1'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }

                }
            });

            level6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(test > 6){

                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "level=" + levelC + "x.6xn");

                        //création de notre item
                        if(levelC == '1'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });

            level7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(test > 7){

                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "level=" + levelC + "x.7xn");

                        //création de notre item
                        if(levelC == '1'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });

            level8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(test > 8){

                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "level=" + levelC + "x.8xn");

                        //création de notre item
                        if(levelC == '1'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }

                }
            });

            // Activation level 9
            level9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(test > 9){

                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "level=" + levelC + "x.9xn");

                        //création de notre item
                        if(levelC == '1'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });

            // Activation level 10
            level10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(test >= 10){

                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "level=" + levelC + "x.10n");

                        //création de notre item
                        if(levelC == '1'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(levelC == '2' || levelC == '3'){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }



                }
            });


        }else if(levelS.substring(0, 3).equals("ang")){

            //////////////////////////////// NIVEAU ANGLAIS ///////////////////////////////

            // ENGLISHMAX
            FileInputStream input3 = null;
            String read3 = null;
            char[] readBuffer3 = new char[26];
            InputStreamReader isr3 = null;

            // Recuperation de la valeur
            try {

                input3 = openFileInput("ENGLISHMAX");

                isr3 = new InputStreamReader(input3);
                isr3.read(readBuffer3);
                read3 = new String(readBuffer3);


            } catch (FileNotFoundException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }

            // FIN ENGLISHMAX

            nb1 = Integer.parseInt(read3.charAt(12) + "");
            nb2 = Integer.parseInt(read3.charAt(15) + "");





            if(levelS.equals("ang1")){
                // Anglais 1

                    level1.setBackgroundResource(R.mipmap.level_1_1_ang_mini);
                    level2.setBackgroundResource(R.mipmap.level_1_2_ang_mini);
                    level3.setBackgroundResource(R.mipmap.level_1_3_ang_mini);
                    level4.setBackgroundResource(R.mipmap.level_1_4_ang_mini);
                    level5.setBackgroundResource(R.mipmap.level_1_5_ang_mini);
                    level6.setBackgroundResource(R.mipmap.level_1_6_ang_mini);
                    level7.setBackgroundResource(R.mipmap.level_1_7_ang_mini);
                    level8.setBackgroundResource(R.mipmap.level_1_8_ang_mini);
                    level9.setBackgroundResource(R.mipmap.level_1_9_ang_mini);
                    level10.setBackgroundResource(R.mipmap.level_1_10_ang_mini);




            }else if(levelS.equals("ang2")){
                // Anglais 2

            }else{
                // Anglais 3

            }


            opacity = 180;

           if(nb2 == 1){
                test = 2;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(opacity);
                level3.getBackground().setAlpha(opacity);
                level4.getBackground().setAlpha(opacity);
                level5.getBackground().setAlpha(opacity);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 2){
                test = 3;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(opacity);
                level4.getBackground().setAlpha(opacity);
                level5.getBackground().setAlpha(opacity);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 3){
                test = 4;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(opacity);
                level5.getBackground().setAlpha(opacity);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 4){
                test = 5;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(opacity);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 5){
                test = 6;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(opacity);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 6){
                test = 7;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(255);
                level7.getBackground().setAlpha(opacity);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 7){
                test = 8;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(255);
                level7.getBackground().setAlpha(255);
                level8.getBackground().setAlpha(opacity);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 8){
                test = 9;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(255);
                level7.getBackground().setAlpha(255);
                level8.getBackground().setAlpha(255);
                level9.getBackground().setAlpha(opacity);
                level10.getBackground().setAlpha(opacity);
            }else if(nb2 == 9) {
                test = 10;
                level1.getBackground().setAlpha(255);
                level2.getBackground().setAlpha(255);
                level3.getBackground().setAlpha(255);
                level4.getBackground().setAlpha(255);
                level5.getBackground().setAlpha(255);
                level6.getBackground().setAlpha(255);
                level7.getBackground().setAlpha(255);
                level8.getBackground().setAlpha(255);
                level9.getBackground().setAlpha(255);
                level10.getBackground().setAlpha(opacity);
            }else{

            }


            // Activation level 1
            level1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test >= 1){
                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "english=" + nb1 + "x.1xn");

                        //création de notre item
                        if(nb1 == 1){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 2){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 3){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });




            // Activation level 2
            level2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test > 2){
                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "english=" + nb1 + "x.2xn");

                        //création de notre item
                        if(nb1 == 1){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 2){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 3){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });



            // Activation level 3
            level3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test > 3){
                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "english=" + nb1 + "x.3xn");

                        //création de notre item
                        if(nb1 == 1){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 2){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 3){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });


            // Activation level 4
            level4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test > 4){
                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "english=" + nb1 + "x.4xn");

                        //création de notre item
                        if(nb1 == 1){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 2){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 3){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });


            // Activation level 5
            level5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test > 5){
                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "english=" + nb1 + "x.5xn");

                        //création de notre item
                        if(nb1 == 1){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 2){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 3){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });


            // Activation level 6
            level6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test > 6){
                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "english=" + nb1 + "x.6xn");

                        //création de notre item
                        if(nb1 == 1){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 2){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 3){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });


            // Activation level 7
            level7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test > 7){
                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "english=" + nb1 + "x.7xn");

                        //création de notre item
                        if(nb1 == 1){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 2){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 3){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });


            // Activation level 8
            level8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test > 8){
                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "english=" + nb1 + "x.8xn");

                        //création de notre item
                        if(nb1 == 1){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 2){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 3){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });


            // Activation level 9
            level9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test > 9){
                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "english=" + nb1 + "x.9xn");

                        //création de notre item
                        if(nb1 == 1){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 2){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 3){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });


            // Activation level 10
            level10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(test > 10){
                        // objet qui vas nous permettre de passe des variables ici la variable passInfo
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "english=" + nb1 + "x.10n");

                        //création de notre item
                        if(nb1 == 1){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, ThreeLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 2){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FourLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);
                        }else if(nb1 == 3){
                            Intent defineIntent = new Intent(ChooseLevelMenu.this, FiveLettersLevel.class);
                            defineIntent.putExtras(objetbunble);
                            // on appelle notre activité
                            startActivity(defineIntent);

                        }else{

                        }
                    }else{

                    }
                }
            });




        }







        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ChooseLevelMenu Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.manon.weirdwords/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ChooseLevelMenu Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.manon.weirdwords/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


    public static ChooseLevelMenu getInstance(){
        return ChooseLevelMenu;
    }

    @Override
    protected void onResume() {

        super.onResume();
        this.onCreate(null);
    }



    public void setClueButtonBackground(int usedClues,int nbOfClues){
        boolean isEnabled;
        if(usedClues < 2){
            isEnabled = true;
        }else{
            isEnabled = false;
        }


        if(isEnabled == true){
            // Bouton normal
            if(nbOfClues == 0){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_0);
            }else if(nbOfClues == 1){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_1);
            }else if(nbOfClues == 2){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_2);
            }else if(nbOfClues == 3){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_3);
            }else if(nbOfClues == 4){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_4);
            }else if(nbOfClues == 5){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_5);
            }else if(nbOfClues == 6){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_6);
            }else if(nbOfClues == 7){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_7);
            }else if(nbOfClues == 8){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_8);
            }else if(nbOfClues == 9){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_9);
            }else{
                clue_button.setBackgroundResource(R.mipmap.icone_indice_10);
            }


        }else{
            // Bouton desactive


            if(nbOfClues == 0){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_0);
            }else if(nbOfClues == 1){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_1);
            }else if(nbOfClues == 2){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_2);
            }else if(nbOfClues == 3){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_3);
            }else if(nbOfClues == 4){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_4);
            }else if(nbOfClues == 5){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_5);
            }else if(nbOfClues == 6){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_6);
            }else if(nbOfClues == 7){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_7);
            }else if(nbOfClues == 8){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_8);
            }else if(nbOfClues == 9){
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_9);
            }else{
                clue_button.setBackgroundResource(R.mipmap.icone_indice_desactive_10);
            }
        }

    }

    public int getClueNb() {

        FileInputStream input2 = null;
        String read2 = null;
        String clueNb = null;
        int nbOfClues = 0;
        char[] readBuffer2 = new char[8];
        InputStreamReader isr2 = null;

        // Recuperation de la valeur
        try {

            input2 = openFileInput("CLUENB");

            isr2 = new InputStreamReader(input2);
            isr2.read(readBuffer2);
            read2 = new String(readBuffer2);


        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        // Traitement pour obtenir nbOfClues //
        clueNb = read2.substring(5);
        if (clueNb.charAt(2) != 'x') {
            clueNb = "" + clueNb.charAt(0) + clueNb.charAt(1) + clueNb.charAt(2);
        } else if (clueNb.charAt(1) != 'x') {
            clueNb = "" + clueNb.charAt(0) + clueNb.charAt(1);
        } else {
            clueNb = "" + clueNb.charAt(0);
        }

        // Determiner nbOfClues et adapter le bouton
        nbOfClues = Integer.parseInt(clueNb);

        return nbOfClues;
    }

}


