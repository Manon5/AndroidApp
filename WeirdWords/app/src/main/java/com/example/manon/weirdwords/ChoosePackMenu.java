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
    private ImageButton allemand_1 = null;
    private ImageButton allemand_2 = null;
    private ImageButton italien_1 = null;
    private ImageButton italien_2 = null;
    private ImageButton prenoms_1 = null;
    private ImageButton prenoms_2 = null;
    private Button classic = null;
    private Button special = null;
    private ImageButton button0 = null;
    private ImageButton button1 = null;
    private ImageButton button2 = null;
    private ImageButton button3 = null;
    private ImageButton button4 = null;
    private ImageButton button5 = null;
    private ImageButton button6 = null;
    private ImageButton button7 = null;
    private ImageButton button8 = null;
    private ImageButton button9 = null;
    private ImageButton button10 = null;
    private ImageButton button11 = null;
    private ImageButton button12 = null;

    private String passMax;
    private String levelMax;
    private int levelI;

    private int level_max = 0;
    private String passInfo;
    private int opacity = 150;

    private int nbOfClues;
    private String specialMode;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle objetbunble  = this.getIntent().getExtras();
        // récupération de la valeur
        specialMode = objetbunble.getString("passInfo");


        if(specialMode.equals("true")){

            setContentView(R.layout.activity_choose_pack_menu2);

            // Init boutons toolbar
            undo_button = (ImageButton)findViewById(R.id.undo_button);
            clue_button = (ImageButton)findViewById(R.id.clue_button);
            param_button = (ImageButton)findViewById(R.id.param_button);

            //Init boutons menu
            anglais_1 = (ImageButton)findViewById(R.id.anglais1);
            anglais_2 = (ImageButton)findViewById(R.id.anglais2);

            allemand_1 = (ImageButton)findViewById(R.id.allemand1);
            allemand_2 = (ImageButton)findViewById(R.id.allemand2);

            italien_1 = (ImageButton)findViewById(R.id.italien1);
            italien_2 = (ImageButton)findViewById(R.id.italien2);

            prenoms_1 = (ImageButton)findViewById(R.id.prenoms1);
            prenoms_2 = (ImageButton)findViewById(R.id.prenoms2);



            // Gérer l'opacité

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
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "ang1");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            anglais_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "ang2");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            allemand_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "ang3");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            allemand_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "nom1");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            italien_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "nom2");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            italien_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "nom2");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            prenoms_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "nom2");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            prenoms_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "nom2");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });



        }else{

            setContentView(R.layout.activity_choose_pack_menu);

            // Init boutons toolbar
            undo_button = (ImageButton)findViewById(R.id.undo_button);
            clue_button = (ImageButton)findViewById(R.id.clue_button);
            param_button = (ImageButton)findViewById(R.id.param_button);


            // Recup niv max



            //Init boutons menu
            button0 = (ImageButton)findViewById(R.id.button0);
            button1 = (ImageButton)findViewById(R.id.button1);
            button2 = (ImageButton)findViewById(R.id.button2);
            button3 = (ImageButton)findViewById(R.id.button3);
            button4 = (ImageButton)findViewById(R.id.button4);
            button5 = (ImageButton)findViewById(R.id.button5);
            button6 = (ImageButton)findViewById(R.id.button6);
            button7 = (ImageButton)findViewById(R.id.button7);
            button8 = (ImageButton)findViewById(R.id.button8);
            button9 = (ImageButton)findViewById(R.id.button9);
            button10 = (ImageButton)findViewById(R.id.button10);
            button11 = (ImageButton)findViewById(R.id.button11);
            button12 = (ImageButton)findViewById(R.id.button12);




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
            setClueButtonBackground(0, nbOfClues);
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

            levelMax = levelMax.charAt(10) + "" + passMax.charAt(11);


            if(levelMax.length() == 1){
            }else{
                levelMax = levelMax.charAt(0) + "";

            }

            levelI = Integer.parseInt(levelMax);



            // Opacity
            int opacity = 180;

            if(levelI == 0){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(opacity);
                button2.getBackground().setAlpha(opacity);
                button3.getBackground().setAlpha(opacity);
                button4.getBackground().setAlpha(opacity);
                button5.getBackground().setAlpha(opacity);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
                button10.getBackground().setAlpha(opacity);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 1){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(opacity);
                button3.getBackground().setAlpha(opacity);
                button4.getBackground().setAlpha(opacity);
                button5.getBackground().setAlpha(opacity);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
                button10.getBackground().setAlpha(opacity);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 2){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(opacity);
                button4.getBackground().setAlpha(opacity);
                button5.getBackground().setAlpha(opacity);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
                button10.getBackground().setAlpha(opacity);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 3){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(opacity);
                button5.getBackground().setAlpha(opacity);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
                button10.getBackground().setAlpha(opacity);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 4){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(opacity);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
                button10.getBackground().setAlpha(opacity);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 5){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(opacity);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
                button10.getBackground().setAlpha(opacity);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 6){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(opacity);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
                button10.getBackground().setAlpha(opacity);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 7){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(opacity);
                button9.getBackground().setAlpha(opacity);
                button10.getBackground().setAlpha(opacity);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 8){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(opacity);
                button10.getBackground().setAlpha(opacity);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 9){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(255);
                button10.getBackground().setAlpha(opacity);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 10){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(255);
                button10.getBackground().setAlpha(255);
                button11.getBackground().setAlpha(opacity);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 11){
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(255);
                button10.getBackground().setAlpha(255);
                button11.getBackground().setAlpha(255);
                button12.getBackground().setAlpha(opacity);
            }else if(levelI == 12) {
                button0.getBackground().setAlpha(255);
                button1.getBackground().setAlpha(255);
                button2.getBackground().setAlpha(255);
                button3.getBackground().setAlpha(255);
                button4.getBackground().setAlpha(255);
                button5.getBackground().setAlpha(255);
                button6.getBackground().setAlpha(255);
                button7.getBackground().setAlpha(255);
                button8.getBackground().setAlpha(255);
                button9.getBackground().setAlpha(255);
                button10.getBackground().setAlpha(255);
                button11.getBackground().setAlpha(255);
                button12.getBackground().setAlpha(255);
            }else{

            }






            // Activation boutons men

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 0){
                        Intent level0 = new Intent(ChoosePackMenu.this, FirstStep.class);
                        startActivity(level0);
                    }else{

                    }
                }
            });

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

            button10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 10){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "10");
                        Intent level10 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level10.putExtras(objetbunble);
                        startActivity(level10);
                    }else{

                    }
                }
            });

            button11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 11){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "11");
                        Intent level11 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level11.putExtras(objetbunble);
                        startActivity(level11);
                    }else{

                    }
                }
            });

            button12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(levelI >= 12){
                        Bundle objetbunble = new Bundle();
                        objetbunble.putString("passInfo", "12");
                        Intent level12 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                        level12.putExtras(objetbunble);
                        startActivity(level12);
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
