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

    private ImageButton level_0_arrow = null;
    private ImageButton level_1_arrow = null;
    private ImageButton level_2_arrow = null;
    private ImageButton level_3_arrow = null;
    private ImageButton level_4_arrow = null;
    private ImageButton level_5_arrow = null;

    private ImageButton anglais_1_arrow = null;
    private ImageButton anglais_2_arrow = null;
    private ImageButton anglais_3_arrow = null;
    private ImageButton prenom_1_arrow = null;
    private ImageButton prenom_2_arrow = null;
    private Button classic = null;
    private Button special = null;
    private ImageButton button0 = null;
    private ImageButton button1 = null;
    private ImageButton button2 = null;
    private ImageButton button3 = null;
    private ImageButton button4 = null;
    private ImageButton button5 = null;
    private ImageButton button6 = null;

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
            anglais_1_arrow = (ImageButton)findViewById(R.id.arrow_anglais_1);
            anglais_2_arrow = (ImageButton)findViewById(R.id.arrow_anglais_2);
            anglais_3_arrow = (ImageButton)findViewById(R.id.arrow_anglais_3);
            prenom_1_arrow = (ImageButton)findViewById(R.id.arrow_prenom_1);
            prenom_2_arrow = (ImageButton)findViewById(R.id.arrow_prenom_2);

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

            anglais_1_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "ang1");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            anglais_2_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "ang2");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            anglais_3_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "ang3");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            prenom_1_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "nom1");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            prenom_2_arrow.setOnClickListener(new View.OnClickListener() {
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

            //Init boutons menu
            level_0_arrow = (ImageButton)findViewById(R.id.arrow_button_0);
            level_1_arrow = (ImageButton)findViewById(R.id.arrow_button_1);
            level_2_arrow = (ImageButton)findViewById(R.id.arrow_button_2);
            level_3_arrow = (ImageButton)findViewById(R.id.arrow_button_3);
            level_4_arrow = (ImageButton)findViewById(R.id.arrow_button_4);
            level_5_arrow = (ImageButton)findViewById(R.id.arrow_button_5);



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











            // Activation boutons men

            level_0_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent level0 = new Intent(ChoosePackMenu.this, FirstStep.class);
                    startActivity(level0);
                }
            });

            level_1_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "1");
                    Intent level1 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level1.putExtras(objetbunble);
                    startActivity(level1);
                }
            });

            level_2_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "2");
                    Intent level2 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level2.putExtras(objetbunble);
                    startActivity(level2);
                }
            });

            level_3_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "3");
                    Intent level3 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level3.putExtras(objetbunble);
                    startActivity(level3);

                }
            });

            level_4_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "4");
                    Intent level4 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level4.putExtras(objetbunble);
                    startActivity(level4);
                }
            });

            level_5_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "5");
                    Intent level5 = new Intent(ChoosePackMenu.this, ChooseLevelMenu.class);
                    level5.putExtras(objetbunble);
                    startActivity(level5);
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
