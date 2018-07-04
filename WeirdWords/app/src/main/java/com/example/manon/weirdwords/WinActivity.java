package com.example.manon.weirdwords;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class WinActivity extends Activity implements View.OnClickListener{

    private Button next_level_button = null;
    private TextView textArea = null;
    private String levelS;
    private String pass2;
    private String levelS2;
    private String clueInfo ;
    private String memoryInfo;
    private String levelMax;
    private int i;
    private int nbOfClues;
    private int specialLevel = 0;


    static WinActivity WinActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        WinActivity = this;
        Bundle objetbunble  = this.getIntent().getExtras();
        // récupération de la valeur
        levelS = objetbunble.getString("passInfo");
        if(levelS.charAt(6) == '1' || levelS.charAt(6) == '2'){
            ThreeLettersLevel.getInstance().finish();
        }else if(levelS.charAt(6) == '3'){
            FourLettersLevel.getInstance().finish();
        }else{

        }


        // Recuperer le nb d'indices
        nbOfClues = getClueNb();
        setClueNb(nbOfClues);

        int nb1;
        if(levelS.charAt(6) != 1){
            nb1 = Character.getNumericValue(levelS.charAt(6));

        }else if(levelS.charAt(7) == 'x'){
            nb1 = 1;
        }else{
            nb1 = 10 + Character.getNumericValue(levelS.charAt(7));
        }

        int nb2;

        if(levelS.charAt(9) != '1'){
            nb2 = Character.getNumericValue(levelS.charAt(9));


            Log.d("test", "1" + levelS.charAt(9));
        }else if(levelS.charAt(10) == 'x'){
            nb2 = 1;

            Log.d("test", "2");
        }else{
            nb2 = 10;

            Log.d("test", "3");
        }

        if(nb2 == 10){
            nb2 = 1;
            Log.d("test", "alerte");
            nb1 = nb1 + 1;
        }else{
            nb2 = nb2 + 1;
        }

        Log.d("test", "nb1 = " + nb1);
        Log.d("test", "nb2 = " + nb2);

        if(nb1 <= 9 && nb2 <= 9){
            levelS2="level=" + nb1 + "x." + nb2 + "xw";
        }else if (nb1 <= 9){
            levelS2="level=" + nb1 + "x." + nb2 + "w";
        }else if (nb2 <= 9){
            levelS2="level=" + nb1 + "." + nb2 + "xw";
        }else{
            levelS2="level=" + nb1 + "." + nb2 + "w";
        }












        if(levelS.equals("english=1x.1xw") || levelS.equals("english=1x.1xn")){
            levelS2="english=1x.2xw";
        }else if(levelS.equals("english=1x.2xw") || levelS.equals("english=1x.2xn")){
            levelS2="english=1x.3xw";
        }else if(levelS.equals("english=1x.3xw") || levelS.equals("english=1x.3xn")){
            levelS2="english=1x.4xw";
        }else if(levelS.equals("english=1x.4xw") || levelS.equals("english=1x.4xn")){
            levelS2="english=1x.5xw";
        }else if(levelS.equals("english=1x.5xw") || levelS.equals("english=1x.5xn")){
            levelS2="english=1x.6xw";
        }else if(levelS.equals("english=1x.6xw") || levelS.equals("english=1x.6xn")){
            levelS2="english=1x.7xw";
        }else if(levelS.equals("english=1x.7xw") || levelS.equals("english=1x.7xn")){
            levelS2="english=1x.8xw";
        }else if(levelS.equals("english=1x.8xw") || levelS.equals("english=1x.8xn")){
            levelS2="english=1x.9xw";
        }else if(levelS.equals("english=1x.9xw") || levelS.equals("english=1x.9xn")){
            levelS2="english=1x.10xw";
        }else{

        }







        next_level_button = (Button)findViewById(R.id.next_level_button);
        next_level_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appel;
                if(levelS2.charAt(6) == '1' || levelS2.charAt(6) == '2'){
                    appel = new Intent(WinActivity.this, ThreeLettersLevel.class);
                }else if(levelS2.charAt(6) == '3'|| levelS2.charAt(6) == '4' || levelS2.charAt(6) == '5' ){
                    appel = new Intent(WinActivity.this, FourLettersLevel.class);
                }else  if(levelS2.charAt(6) == '6' || levelS2.charAt(6) == '7' || levelS2.charAt(6) == '8' || levelS2.charAt(6) == '9'){
                    appel = new Intent(WinActivity.this, FiveLettersLevel.class);
                }else{
                    appel = new Intent(WinActivity.this, ThreeLettersLevel.class);
                }

                // FIN
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", levelS2);
                appel.putExtras(objetbunble);
                startActivity(appel);

            }
        });

        textArea = (TextView)findViewById(R.id.textArea);



        if(specialLevel == 1){
            // DEBLOQUER PACK LANGUES ETRANGERES
            FileOutputStream output = null;
            String param = "english_max=1x.1xn";

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





        }else if(specialLevel == 2){


            // DEBLOQUER PACK PRENOMS

            FileOutputStream output = null;
            String param = "names_max=1x.1xn";

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

        if(levelS2.substring(0, 5).equals("level")){
            levelMax = levelS2.substring(0, 5) + "_max" + levelS2.substring(5);

            // LEVELMAX

            boolean bool;
            bool = isLevelMax(levelS);
            if(bool == true){
                FileOutputStream output = null;
                try {
                    output = openFileOutput("LEVELMAX", MODE_PRIVATE);
                    output.write(levelMax.getBytes());
                    if(output != null)
                        output.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{

            }

        }else if(levelS2.substring(0, 7).equals("english")){

            levelMax = levelS2.substring(0, 7) + "_max" + levelS2.substring(7);

            FileOutputStream output = null;

            try {
                output = openFileOutput("ENGLISHMAX", MODE_PRIVATE);
                output.write(levelMax.getBytes());
                if(output != null)
                    output.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            next_level_button = (Button)findViewById(R.id.next_level_button);
            next_level_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent appel;
                    if(levelS2.charAt(8) == '1' || levelS2.charAt(8) == '2'){
                        appel = new Intent(WinActivity.this, ThreeLettersLevel.class);
                    }else if(levelS2.charAt(8) == '2'){
                        appel = new Intent(WinActivity.this, FourLettersLevel.class);
                    }else  if(levelS2.charAt(8) == '3'){
                        appel = new Intent(WinActivity.this, FiveLettersLevel.class);
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


        }else{

        }


    }

    @Override
    public void onClick(View view) {




    }

    public static WinActivity getInstance(){
        return WinActivity;
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

        FileInputStream input1 = null;
        String read1 = null;
        int nbOfClues = 0;
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

        // Traitement levelMax
        String levelMax = new String(read1);
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

    public void setClueNb(int nbOfClues){

        String param;

        FileOutputStream output = null;
        String clueNb = new String("" + nbOfClues);

        // Traitement clueNb
        if(nbOfClues < 10){
            clueNb = clueNb +"xx";
        }else if(nbOfClues < 100){
            clueNb = clueNb + "x";
        }else{

        }
        param = "clue=" + clueNb;




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


    }
    }

