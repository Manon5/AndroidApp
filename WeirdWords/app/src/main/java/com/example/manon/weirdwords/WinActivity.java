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
            nbOfClues = nbOfClues + 5;
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
            nbOfClues = nbOfClues + 5;
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
            nbOfClues = nbOfClues + 5;
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
            nbOfClues = nbOfClues + 5;
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
        bool = isLevelMax(levelS);
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

    public boolean isLevelMax(String levelTest){


        // TRaitement levelTest

        String levelTestNb1 = new String(levelTest.substring(6, 8));
        String levelTestNb2 = new String(levelTest.substring(9, 11));
        int nbTest1;
        int nbTest2;

        if(levelTestNb1.equals("1x")){
            nbTest1 = 1;
        }else if(levelTestNb1.equals("2x")){
            nbTest1 = 2;
        }else if(levelTestNb1.equals("3x")){
            nbTest1 = 3;
        }else if(levelTestNb1.equals("4x")){
            nbTest1 = 4;
        }else if(levelTestNb1.equals("5x")){
            nbTest1 = 5;
        }else if(levelTestNb1.equals("6x")){
            nbTest1 = 6;
        }else if(levelTestNb1.equals("7x")){
            nbTest1 = 7;
        }else if(levelTestNb1.equals("8x")){
            nbTest1 = 8;
        }else if(levelTestNb1.equals("9x")){
            nbTest1 = 9;
        }else if(levelTestNb1.equals("10")){
            nbTest1 = 10;
        }else{
            nbTest1 = 0;
        }

        if(levelTestNb2.equals("1x")){
            nbTest2 = 1;
        }else if(levelTestNb2.equals("2x")){
            nbTest2 = 2;
        }else if(levelTestNb2.equals("3x")){
            nbTest2 = 3;
        }else if(levelTestNb2.equals("4x")){
            nbTest2 = 4;
        }else if(levelTestNb2.equals("5x")){
            nbTest2 = 5;
        }else if(levelTestNb2.equals("6x")){
            nbTest2 = 6;
        }else if(levelTestNb2.equals("7x")){
            nbTest2 = 7;
        }else if(levelTestNb2.equals("8x")){
            nbTest2 = 8;
        }else if(levelTestNb2.equals("9x")){
            nbTest2 = 9;
        }else if(levelTestNb2.equals("10")){
            nbTest2 = 10;
        }else{
            nbTest2 = 0;
        }


        // FIN




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

        // Traitement levelMax
        String levelMax = new String(read);
        String levelMaxNb1 = new String(levelMax.substring(10,12));
        String levelMaxNb2 = new String(levelMax.substring(13, 15));
        int nbMax1;
        int nbMax2;

        if(levelMaxNb1.equals("1x")){
            nbMax1 = 1;
        }else if(levelMaxNb1.equals("2x")){
            nbMax1 = 2;
        }else if(levelMaxNb1.equals("3x")){
            nbMax1 = 3;
        }else if(levelMaxNb1.equals("4x")){
            nbMax1 = 4;
        }else if(levelMaxNb1.equals("5x")){
            nbMax1 = 5;
        }else if(levelMaxNb1.equals("6x")){
            nbMax1 = 6;
        }else if(levelMaxNb1.equals("7x")){
            nbMax1 = 7;
        }else if(levelMaxNb1.equals("8x")){
            nbMax1 = 8;
        }else if(levelMaxNb1.equals("9x")){
            nbMax1 = 9;
        }else if(levelMaxNb1.equals("10")){
            nbMax1 = 10;
        }else{
            nbMax1 = 0;
        }

        if(levelMaxNb2.equals("1x")){
            nbMax2 = 1;
        }else if(levelMaxNb2.equals("2x")){
            nbMax2 = 2;
        }else if(levelMaxNb2.equals("3x")){
            nbMax2 = 3;
        }else if(levelMaxNb2.equals("4x")){
            nbMax2 = 4;
        }else if(levelMaxNb2.equals("5x")){
            nbMax2 = 5;
        }else if(levelMaxNb2.equals("6x")){
            nbMax2 = 6;
        }else if(levelMaxNb2.equals("7x")){
            nbMax2 = 7;
        }else if(levelMaxNb2.equals("8x")){
            nbMax2 = 8;
        }else if(levelMaxNb2.equals("9x")){
            nbMax2 = 9;
        }else if(levelMaxNb2.equals("10")){
            nbMax2 = 10;
        }else{
            nbMax2 = 0;
        }

        //FIN



        // Test final
        boolean bool = false;

        if(nbMax1 == nbTest1 && nbMax2 == nbTest2){
            bool = true;
        }else{
            bool = false;
        }


        //
        return bool;

    }


    }

