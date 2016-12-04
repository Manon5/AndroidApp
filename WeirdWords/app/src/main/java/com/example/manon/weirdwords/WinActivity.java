package com.example.manon.weirdwords;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class WinActivity extends Activity implements View.OnClickListener{

    private Button next_level_button = null;
    private String levelS;
    private String pass2;
    private String levelS2;
    private String clueInfo ;
    private String memoryInfo;
    private String levelMax;
    private int i;
    private int nbOfClues;


    static WinActivity WinActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        WinActivity = this;
        Bundle objetbunble  = this.getIntent().getExtras();
        // récupération de la valeur
        levelS = objetbunble.getString("passInfo");
        if(levelS.charAt(6) == '1'){
            ThreeLettersLevel.getInstance().finish();
        }else if(levelS.charAt(6) == '2'){
            FourLettersLevel.getInstance().finish();
        }else{

        }


        // Recuperer le nb d'indices
        nbOfClues = getClueNb();





        if(levelS.equals("level=1x.1xw") || levelS.equals("level=1x.1xn")){
            levelS2="level=1x.2xw";
        }else if(levelS.equals("level=1x.2xw") || levelS.equals("level=1x.2xn")){
            levelS2="level=1x.3xw";
        }else if(levelS.equals("level=1x.3xw") || levelS.equals("level=1x.3xn")){
            levelS2="level=1x.4xw";
        }else if(levelS.equals("level=1x.4xw") || levelS.equals("level=1x.4xn")){
            levelS2="level=1x.5xw";
        }else if(levelS.equals("level=1x.5xw") || levelS.equals("level=1x.5xn")){
            levelS2="level=1x.6xw";
        }else if(levelS.equals("level=1x.6xw") || levelS.equals("level=1x.6xn")){
            levelS2="level=1x.7xw";
        }else if(levelS.equals("level=1x.7xw") || levelS.equals("level=1x.7xn")){
            levelS2="level=1x.8xw";
        }else if(levelS.equals("level=1x.8xw") || levelS.equals("level=1x.8xn")){
            levelS2="level=1x.9xw";
        }else if(levelS.equals("level=1x.9xw") || levelS.equals("level=1x.9xn")){
            levelS2="level=1x.10w";
        }else if(levelS.equals("level=1x.10w") || levelS.equals("level=1x.10n")){
            levelS2="level=2x.1xw";
        }else if(levelS.equals("level=2x.1xw") || levelS.equals("level=2x.1xn")){
            levelS2="level=2x.2xw";
        }else if(levelS.equals("level=2x.2xw") || levelS.equals("level=2x.2xn")){
            levelS2="level=2x.3xw";
        }else if(levelS.equals("level=2x.3xw") || levelS.equals("level=2x.3xn")){
            levelS2="level=2x.4xw";
        }else if(levelS.equals("level=2x.4xw") || levelS.equals("level=2x.4xn")){
            levelS2="level=2x.5xw";
        }else if(levelS.equals("level=2x.5xw") || levelS.equals("level=2x.5xn")){
            levelS2="level=2x.6xw";
        }else if(levelS.equals("level=2x.6xw") || levelS.equals("level=2x.6xn")){
            levelS2="level=2x.7xw";
        }else if(levelS.equals("level=2x.7xw") || levelS.equals("level=2x.7xn")){
            levelS2="level=2x.8xw";
        }else if(levelS.equals("level=2x.8xw") || levelS.equals("level=2x.8xn")){
            levelS2="level=2x.9xw";
        }else if(levelS.equals("level=2x.9xw") || levelS.equals("level=2x.9xn")){
            levelS2="level=2x.10w";
        }else if(levelS.equals("level=2x.10w") || levelS.equals("level=2x.10n")){
            levelS2="level=3x.1xw";
        }else if(levelS.equals("level=3x.1xw") || levelS.equals("level=3x.1xn")){
            levelS2="level=3x.2xw";
        }else if(levelS.equals("level=3x.2xw") || levelS.equals("level=3x.2xn")){
            levelS2="level=3x.3xw";
        }else if(levelS.equals("level=3x.3xw") || levelS.equals("level=3x.3xn")){
            levelS2="level=3x.4xw";
        }else if(levelS.equals("level=3x.4xw") || levelS.equals("level=3x.4xn")){
            levelS2="level=3x.5xw";
        }else if(levelS.equals("level=3x.5xw") || levelS.equals("level=3x.5xn")){
            levelS2="level=3x.6xw";
        }else if(levelS.equals("level=3x.6xw") || levelS.equals("level=3x.6xn")){
            levelS2="level=3x.7xw";
        }else if(levelS.equals("level=3x.7xw") || levelS.equals("level=3x.7xn")){
            levelS2="level=3x.8xw";
        }else if(levelS.equals("level=3x.8xw") || levelS.equals("level=3x.8xn")){
            levelS2="level=3x.9xw";
        }else if(levelS.equals("level=3x.9xw") || levelS.equals("level=3x.9xn")){
            levelS2="level=3x.10w";
        }else if(levelS.equals("level 3x.10w") || levelS.equals("level=3x.10n")){
            levelS2="level=4x.1xw";
        }else if(levelS.equals("level=4x.1xw") || levelS.equals("level=4x.1xn")){
            levelS2="level=4x.2xw";
        }else if(levelS.equals("level=4x.2xw") || levelS.equals("level=4x.2xn")){
            levelS2="level=4x.3xw";
        }else if(levelS.equals("level=4x.3xw") || levelS.equals("level=4x.3xn")){
            levelS2="level=4x.4xw";
        }else if(levelS.equals("level=4x.4xw") || levelS.equals("level=4x.4xn")){
            levelS2="level=4x.5xw";
        }else if(levelS.equals("level=4x.5xw") || levelS.equals("level=4x.5xn")){
            levelS2="level=4x.6xw";
        }else if(levelS.equals("level=4x.6xw") || levelS.equals("level=4x.6xn")){
            levelS2="level=4x.7xw";
        }else if(levelS.equals("level=4x.7xw") || levelS.equals("level=4x.7xn")){
            levelS2="level=4x.8xw";
        }else if(levelS.equals("level=4x.8xw") || levelS.equals("level=4x.8xn")){
            levelS2="level=4x.9xw";
        }else if(levelS.equals("level=4x.9xw") || levelS.equals("level=4x.9xn")){
            levelS2="level=4x.10w";
        }else if(levelS.equals("level=4x.10w") || levelS.equals("level=4x.10n")){
            levelS2="level=5x.1xw";
        }else if(levelS.equals("level=5x.1xw") || levelS.equals("level=5x.1xn")){
            levelS2="level=5x.2xw";
        }else if(levelS.equals("level=5x.2xw") || levelS.equals("level=5x.2xn")){
            levelS2="level=5x.3xw";
        }else if(levelS.equals("level=5x.3xw") || levelS.equals("level=5x.3xn")){
            levelS2="level=5x.4xw";
        }else if(levelS.equals("level=5x.4xw") || levelS.equals("level=5x.4xn")){
            levelS2="level=5x.5xw";
        }else if(levelS.equals("level=5x.5xw") || levelS.equals("level=5x.5xn")){
            levelS2="level=5x.6xw";
        }else if(levelS.equals("level=5x.6xw") || levelS.equals("level=5x.6xn")){
            levelS2="level=5x.7xw";
        }else if(levelS.equals("level=5x.7xw") || levelS.equals("level=5x.7xn")){
            levelS2="level=5x.8xw";
        }else if(levelS.equals("level=5x.8xw") || levelS.equals("level=5x.8xn")){
            levelS2="level=5x.9xw";
        }else if(levelS.equals("level=5x.9xw") || levelS.equals("level=5x.9xn")){
            levelS2="level=5x.10xw";
        }else{

        }

        levelMax = levelS2.substring(0, 5) + "_max" + levelS2.substring(5);
        clueInfo = "//clue=" + nbOfClues;

        if(clueInfo.length() == 8) {
            clueInfo = clueInfo + "xx";
        }else if(clueInfo.length() == 9){
            clueInfo = clueInfo + "x";
        }else{
        }

        memoryInfo = levelMax + clueInfo;

        boolean bool;
        bool = isLevelMax(levelS2.charAt(7), levelS2.charAt(10));
        if(bool == true){
            FileOutputStream output = null;
            try {
                output = openFileOutput("USERINFOS", MODE_PRIVATE);
                output.write(memoryInfo.getBytes());
                if(output != null)
                    output.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

        }




        next_level_button = (Button)findViewById(R.id.next_level_button);
        next_level_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appel;
                if(levelS2.charAt(6) == '1'){
                    appel = new Intent(WinActivity.this, ThreeLettersLevel.class);
                }else if(levelS2.charAt(6) == '2'){
                    appel = new Intent(WinActivity.this, FourLettersLevel.class);
                }else  if(levelS2.charAt(6) == '3'){
                    appel = new Intent(WinActivity.this, FourLettersLevel.class);
                }else{
                    appel = new Intent(WinActivity.this, FiveLettersLevel.class);
                }



                // FIN
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", levelS2);
                appel.putExtras(objetbunble);
                startActivity(appel);


            }
        });
    }

    @Override
    public void onClick(View view) {




    }

    public static WinActivity getInstance(){
        return WinActivity;
    }



    public int getClueNb() {

        FileInputStream input = null;
        String read = null;
        String clueNb = null;
        int nbOfClues = 0;
        char[] readBuffer = new char[26];
        InputStreamReader isr = null;

        // Recuperation de la valeur
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

        // Traitement pour obtenir nbOfClues //
        clueNb = read.substring(23);
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

    public boolean isLevelMax(int nb1_1, int nb2_1){

        char nb1_carac;
        char nb2_carac;
        int nb1_2;
        int nb2_2;
        boolean bool;

        // Recuperer la valeur de la memoire interne

        FileInputStream input = null;
        String read = null;
        int nbOfClues = 0;
        char[] readBuffer = new char[26];
        InputStreamReader isr = null;

        // Recuperation de la valeur
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

        // Traitement des donnees
        nb1_carac = read.charAt(10);
        nb2_carac = read.charAt(13);
        nb1_2 = Integer.parseInt("" + nb1_carac);
        nb2_2 = Integer.parseInt("" + nb2_carac);

        // FIN

        if(nb1_1 <= nb1_2){
            bool = false;
        }else{
            bool = true;
        }

        return bool;

    }


    }

