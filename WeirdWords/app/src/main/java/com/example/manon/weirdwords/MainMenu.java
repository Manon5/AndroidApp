package com.example.manon.weirdwords;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu extends Activity implements View.OnClickListener{


    private Button play_button = null;
    private Button quit_button = null;
    private Button credits_button = null;

    private ImageButton undo_button = null;
    private ImageButton clue_button = null;
    private ImageButton param_button = null;

    private int nbOfClues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Init boutons toolbar
        undo_button = (ImageButton)findViewById(R.id.undo_button);
        clue_button = (ImageButton)findViewById(R.id.clue_button);
        param_button = (ImageButton)findViewById(R.id.param_button);

        // Initialisation 3 boutons menu
        play_button = (Button)findViewById(R.id.play_button);
        quit_button = (Button)findViewById(R.id.quit_button);
        credits_button = (Button)findViewById(R.id.credits_button);


        // LEVELMAX
        FileInputStream input1 = null;
        String read1 = null;
        char[] readBuffer1 = new char[26];
        InputStreamReader isr1 = null;

        // Recuperation de la valeur
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

        if(read1 == null){
            FileOutputStream output = null;
            String param = "level_max=9x.8xn";

            try {
                output = openFileOutput("LEVELMAX", MODE_PRIVATE);
                output.write(param.getBytes());
                if(output != null)
                    output.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

        }

        // FIN LEVELMAX

        // CLUENB
        FileInputStream input2 = null;
        String read2 = null;
        int nbOfClues = 0;
        char[] readBuffer2 = new char[26];
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

        if(read2 == null){
            FileOutputStream output = null;
            String param = "clue=8xx";

            try {
                output = openFileOutput("CLUENB", MODE_PRIVATE);
                output.write(param.getBytes());
                if(output != null)
                    output.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

        }
        // FIN CLUENB



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

        if(read3 == null){
            FileOutputStream output = null;
            String param = "english_max=1x.4xn";

            try {
                output = openFileOutput("ENGLISHMAX", MODE_PRIVATE);
                output.write(param.getBytes());
                if(output != null)
                    output.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

        }
        // FIN ENGLISHMAX



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

        if(read4 == null){
            FileOutputStream output = null;
            String param = "names_max=1x.4xn";

            try {
                output = openFileOutput("NAMESMAX", MODE_PRIVATE);
                output.write(param.getBytes());
                if(output != null)
                    output.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

        }





        nbOfClues = getClueNb();
        setClueButtonBackground(0, nbOfClues);


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

                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", "false");
                Intent appel = new Intent(MainMenu.this, ChoosePackMenu.class);
                appel.putExtras(objetbunble);
                startActivity(appel);


            }
        });

        quit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        param_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appel = new Intent(MainMenu.this, Help.class);
                startActivity(appel);
            }
        });


        // FIN activation boutons



    }


    @Override
    protected void onResume() {

        super.onResume();
        this.onCreate(null);
    }

    @Override
    public void onClick(View v) {



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
        char[] readBuffer2 = new char[26];
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
