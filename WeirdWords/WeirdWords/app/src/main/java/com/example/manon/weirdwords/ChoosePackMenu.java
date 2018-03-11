package com.example.manon.weirdwords;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChoosePackMenu extends Activity implements View.OnClickListener{

    private ImageButton undo_button = null;
    private ImageButton clue_button = null;
    private ImageButton param_button = null;


    private ImageButton anglais_1 = null;
    private ImageButton anglais_2 = null;
    private ImageButton anglais_3 = null;
    private ImageButton prenoms_1 = null;
    private ImageButton prenoms_2 = null;
    private Button classic = null;
    private Button special = null;
    private ImageButton button1 = null;
    private ImageButton button2 = null;
    private ImageButton button3 = null;
    private ImageButton button4 = null;
    private ImageButton button5 = null;
    private ImageButton button6 = null;
    private ImageButton button7 = null;
    private ImageButton button8 = null;
    private ImageButton button9 = null;

    private int eng1;
    private int eng2;
    private int ger1;
    private int ger2;
    private int ita1;
    private int ita2;
    private int nom1;
    private int nom2;

    private String passMax;
    private String levelMax;
    private int levelI;

    private int level_max = 0;
    private String passInfo;
    private int opacity = 130;

    private int nbOfClues;
    private String specialMode;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle objetbunble  = this.getIntent().getExtras();
        // récupération de la valeur
        specialMode = objetbunble.getString("passInfo");

        ///////////////////////////////////////////////////////////////////////////
        /////////////////// MODE SPECIAL //////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////
        if(specialMode.equals("true")){

            setContentView(R.layout.activity_choose_pack_menu2);

            // Init boutons toolbar
            undo_button = (ImageButton)findViewById(R.id.undo_button);
            clue_button = (ImageButton)findViewById(R.id.clue_button);
            param_button = (ImageButton)findViewById(R.id.param_button);

            //Init boutons menu
            anglais_1 = (ImageButton)findViewById(R.id.anglais1);
            anglais_2 = (ImageButton)findViewById(R.id.anglais2);
            anglais_3 = (ImageButton)findViewById(R.id.anglais3);
;

            prenoms_1 = (ImageButton)findViewById(R.id.prenoms1);
            prenoms_2 = (ImageButton)findViewById(R.id.prenoms2);



            ////// ENGLISHMAX ///////
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

            //Traitement
            String engMax = new String(read3);
            String Seng1 = "" + engMax.charAt(12) + engMax.charAt(13);
            String Seng2 = "" + engMax.charAt(15) + engMax.charAt(16);

            if(Seng1.charAt(1) == 'x'){
                Seng1 = "" + Seng1.charAt(0);
            }else{

            }

            if(Seng2.charAt(1) == 'x'){
                Seng2 = "" + Seng2.charAt(0);
            }else{

            }

            eng1 = Integer.parseInt(Seng1);
            eng2 = Integer.parseInt(Seng2);

            /////// FIN ENGLISHMAX /////////



            /////// NAMESMAX ////////
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
            //Traitement
            String nomMax = new String(read4);
            String Snom1 = "" + nomMax.charAt(12) + nomMax.charAt(13);
            String Snom2 = "" + nomMax.charAt(15) + nomMax.charAt(16);

            if(Snom1.charAt(1) == 'x'){
                Snom1 = "" + Snom1.charAt(0);
            }else{

            }

            if(Snom2.charAt(1) == 'x'){
                Snom2 = "" + Snom2.charAt(0);
            }else{

            }

            nom1 = Integer.parseInt(Seng1);
            nom2 = Integer.parseInt(Seng2);


            /////// FIN NAMESMAX ////////




            /////// GERMANMAX ///////////
            FileInputStream input5 = null;
            String read5 = null;
            char[] readBuffer5 = new char[26];
            InputStreamReader isr5 = null;

            // Recuperation de la valeur
            try {

                input5 = openFileInput("GERMANMAX");

                isr5 = new InputStreamReader(input5);
                isr5.read(readBuffer5);
                read5 = new String(readBuffer5);


            } catch (FileNotFoundException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }

            //Traitement
            String gerMax = new String(read5);
            String Sger1 = "" + gerMax.charAt(11) + gerMax.charAt(12);
            String Sger2 = "" + gerMax.charAt(14) + gerMax.charAt(15);

            if(Sger1.charAt(1) == 'x'){
                Sger1 = "" + Sger1.charAt(0);
            }else{

            }

            if(Sger2.charAt(1) == 'x'){
                Sger2 = "" + Sger2.charAt(0);
            }else{

            }

            ger1 = Integer.parseInt(Sger1);
            ger2 = Integer.parseInt(Sger2);

            ///////// FIN GERMANMAX /////////////



            /////////// ITALIANMAX ////////////
            FileInputStream input6 = null;
            String read6 = null;
            char[] readBuffer6 = new char[26];
            InputStreamReader isr6 = null;

            // Recuperation de la valeur
            try {

                input6 = openFileInput("ITALIANMAX");

                isr6 = new InputStreamReader(input6);
                isr6.read(readBuffer6);
                read6 = new String(readBuffer6);


            } catch (FileNotFoundException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }

            //Traitement
            String itaMax = new String(read6);
            String Sita1 = "" + itaMax.charAt(12) + itaMax.charAt(13);
            String Sita2 = "" + itaMax.charAt(15) + itaMax.charAt(16);

            if(Sita1.charAt(1) == 'x'){
                Sita1 = "" + Sita1.charAt(0);
            }else{

            }

            if(Sita2.charAt(1) == 'x'){
                Sita2 = "" + Sita2.charAt(0);
            }else{

            }

            ita1 = Integer.parseInt(Sita1);
            ita2 = Integer.parseInt(Sita2);

            ///////// FIN ITALIANMAX /////////////



            ////////// OPACITE //////////////
            opacity = 100;


            // anglais
            if(eng1 == 0){
                anglais_1.getBackground().setAlpha(opacity);
                anglais_2.getBackground().setAlpha(opacity);
                anglais_3.getBackground().setAlpha(opacity);
            }else if(eng1 == 1){
                anglais_1.getBackground().setAlpha(255);
                anglais_2.getBackground().setAlpha(opacity);
                anglais_3.getBackground().setAlpha(opacity);
            }else if(eng1 == 2){
                anglais_1.getBackground().setAlpha(255);
                anglais_2.getBackground().setAlpha(255);
                anglais_3.getBackground().setAlpha(opacity);
            }else{
                anglais_1.getBackground().setAlpha(255);
                anglais_2.getBackground().setAlpha(255);
                anglais_3.getBackground().setAlpha(255);
            }



            // prenoms
            if(nom1 == 0){

                prenoms_1.getBackground().setAlpha(opacity);
                prenoms_2.getBackground().setAlpha(opacity);
            }else if(nom1 == 1){
                prenoms_1.getBackground().setAlpha(255);
                prenoms_2.getBackground().setAlpha(opacity);
            }else if(nom1 == 2){
                prenoms_1.getBackground().setAlpha(255);
                prenoms_2.getBackground().setAlpha(255);
            }else{
                prenoms_1.getBackground().setAlpha(25);
                prenoms_2.getBackground().setAlpha(25);
            }





            classic = (Button)findViewById(R.id.classic_button);
            special = (Button)findViewById(R.id.special_button);


            classic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "false");
                    Intent appel = new Intent(ChoosePackMenu.this, ChoosePackMenu.class);
                    appel.putExtras(objetbunble);
                    startActivity(appel);
                    finish();
                }
            });

            anglais_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(eng1 >= 1){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "ang1");
                        Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level1.putExtras(objetbunble);
                        startActivity(level1);
                    }else{

                    }
                }
            });

            anglais_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(eng1 >= 2){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "ang2");
                        Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level1.putExtras(objetbunble);
                        startActivity(level1);
                    }else{

                    }

                }
            });

            anglais_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(eng1 >= 3){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "ang3");
                        Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level1.putExtras(objetbunble);
                        startActivity(level1);
                    }else{

                    }

                }
            });



            prenoms_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(nom1 >= 1){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "nom1");
                        Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level1.putExtras(objetbunble);
                        startActivity(level1);
                    }else{

                    }

                }
            });

            prenoms_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(nom1 >= 2){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "nom2");
                        Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level1.putExtras(objetbunble);
                        startActivity(level1);
                    }else{

                    }

                }
            });



            ///////////////////////////////////////////////////////////////////////////
            /////////////////// MODE NORMAL ///////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////
        }else{

            setContentView(R.layout.activity_choose_pack_menu);

            // Init boutons toolbar
            undo_button = (ImageButton)findViewById(R.id.undo_button);
            clue_button = (ImageButton)findViewById(R.id.clue_button);
            param_button = (ImageButton)findViewById(R.id.param_button);


            // Recup niv max



            //Init boutons menu
            button1 = (ImageButton)findViewById(R.id.button1);
            button2 = (ImageButton)findViewById(R.id.button2);
            button3 = (ImageButton)findViewById(R.id.button3);
            button4 = (ImageButton)findViewById(R.id.button4);
            button5 = (ImageButton)findViewById(R.id.button5);
            button6 = (ImageButton)findViewById(R.id.button6);
            button7 = (ImageButton)findViewById(R.id.button7);
            button8 = (ImageButton)findViewById(R.id.button8);
            button9 = (ImageButton)findViewById(R.id.button9);




            classic = (Button)findViewById(R.id.classic_button);
            special = (Button)findViewById(R.id.special_button);


            special.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "true");
                    Intent appel = new Intent(ChoosePackMenu.this, ChoosePackMenu.class);
                    appel.putExtras(objetbunble);
                    startActivity(appel);
                    finish();
                    recreate();
                }
            });



            nbOfClues = getClueNb();
            // Activation bouton retour
            undo_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });


            param_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent appel = new Intent(ChoosePackMenu.this, Settings.class);
                    startActivity(appel);
                }
            });



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

            passMax = read1;
            levelMax = passMax.substring(0, 16);

            levelMax = levelMax.charAt(10) + "" + levelMax.charAt(11);


            //Enlever l'eventuel "x"
            if(levelMax.charAt(1) == 'x'){
                levelMax = levelMax.charAt(0) + "";
            }else{

            }

            levelI = Integer.parseInt(levelMax);



            // Opacity
            int opacity = 100;

            if(levelI == 0){
                button1.getBackground().setAlpha(opacity);
                button2.getBackground().setAlpha(opacity);
                button3.getBackground().setAlpha(opacity);
                button4.getBackground().setAlpha(opacity);
                button5.getBackground().setAlpha(opacity);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
            }else if(levelI == 1){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(opacity);
                button3.getBackground().setAlpha(opacity);
                button4.getBackground().setAlpha(opacity);
                button5.getBackground().setAlpha(opacity);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
            }else if(levelI == 2){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(opacity);
                button4.getBackground().setAlpha(opacity);
                button5.getBackground().setAlpha(opacity);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
            }else if(levelI == 3){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(opacity);
                button5.getBackground().setAlpha(opacity);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
            }else if(levelI == 4){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(opacity);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
            }else if(levelI == 5){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
            }else if(levelI == 6){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
            }else if(levelI == 7){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
            }else if(levelI == 8){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(opacity);
            }else if(levelI == 9){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(255);
            }else if(levelI == 10){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(255);
            }else if(levelI == 11){
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(255);
            }else if(levelI == 12) {
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(255);
            }else{

                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(255);
            }






            // Activation boutons men



            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 1){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "1");
                        Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level1.putExtras(objetbunble);
                        startActivity(level1);
                    }else{

                    }

                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 2){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "2");
                        Intent level2 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level2.putExtras(objetbunble);
                        startActivity(level2);
                    }else{

                    }

                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 3){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "3");
                        Intent level3 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level3.putExtras(objetbunble);
                        startActivity(level3);
                    }else{

                    }

                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 4){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "4");
                        Intent level4 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level4.putExtras(objetbunble);
                        startActivity(level4);
                    }else{

                    }
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 5){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "5");
                        Intent level5 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level5.putExtras(objetbunble);
                        startActivity(level5);
                    }else{

                    }
                }
            });

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 6){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "6");
                        Intent level6 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level6.putExtras(objetbunble);
                        startActivity(level6);
                    }else{

                    }
                }
            });

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 7){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "7");
                        Intent level7 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level7.putExtras(objetbunble);
                        startActivity(level7);
                    }else{

                    }
                }
            });

            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 8){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "8");
                        Intent level8 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level8.putExtras(objetbunble);
                        startActivity(level8);
                    }else{

                    }
                }
            });

            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 9){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "9");
                        Intent level9 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level9.putExtras(objetbunble);
                        startActivity(level9);
                    }else{

                    }
                }
            });





        }






    }

    @Override
    public void onClick(View v) {

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
