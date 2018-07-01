package com.example.manon.weirdwords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Settings extends AppCompatActivity implements View.OnClickListener{

    private Button reinit;
    private boolean reinit_mode = false;
    private int nbOfClues;
    private ImageButton undo_button;
    private ImageButton clue_button;
    private ImageButton help_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        reinit = (Button)findViewById(R.id.reinit_button);
        undo_button = (ImageButton)findViewById(R.id.undo_button);
        clue_button = (ImageButton)findViewById(R.id.clue_button);



        nbOfClues = getClueNb();

        undo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        reinit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reinit_mode == false){
                    reinit_mode = true;
                    reinit.setBackgroundResource(R.mipmap.large_menu_item_red);
                }else{
                    reinit_mode = false;
                    reinit.setBackgroundResource(R.mipmap.large_menu_item);
                    reinit();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    public void reinit(){
        FileOutputStream output = null;
        String param1 = "level_max=1x.1xn";
        String param2 = "clue=8xx";
        String param3 = "english_max=1x.1xn";
        String param4 = "names_max=0x.0xn";
        String param5 = "german_max=0x.0xn";
        String param6 = "italian_max=0x.0xn";

        // LEVELMAX
        try {
            output = openFileOutput("LEVELMAX", MODE_PRIVATE);
            output.write(param1.getBytes());
            if(output != null)
                output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // CLUENB
        try {
            output = openFileOutput("CLUENB", MODE_PRIVATE);
            output.write(param2.getBytes());
            if(output != null)
                output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // ENGLISHMAX
            FileOutputStream output3 = null;

            try {
                output3 = openFileOutput("ENGLISHMAX", MODE_PRIVATE);
                output3.write(param3.getBytes());
                if(output3 != null)
                    output3.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        // NAMESMAX
        FileOutputStream output4 = null;

        try {
            output4 = openFileOutput("NAMESMAX", MODE_PRIVATE);
            output4.write(param4.getBytes());
            if(output4 != null)
                output4.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        // GERMANMAX
        FileOutputStream output5 = null;

        try {
            output5 = openFileOutput("GERMANMAX", MODE_PRIVATE);
            output5.write(param5.getBytes());
            if(output5 != null)
                output5.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // ITALIANMAX
        FileOutputStream output6 = null;

        try {
            output6 = openFileOutput("ITALIANMAX", MODE_PRIVATE);
            output6.write(param6.getBytes());
            if(output6 != null)
                output6.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


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
