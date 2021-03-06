package com.example.manon.weirdwords;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeLettersLevel extends AppCompatActivity implements View.OnClickListener{


    // initialisation saisie

    // initialisation clavier
    private android.widget.Button button1 = null;
    private android.widget.Button button2 = null;
    private android.widget.Button button3 = null;
    private android.widget.Button button4 = null;
    private android.widget.Button button5 = null;
    private android.widget.Button button6 = null;
    private android.widget.Button button7 = null;
    private android.widget.Button button8 = null;
    private android.widget.Button button9 = null;
    private android.widget.Button button10 = null;
    private android.widget.Button button11 = null;
    private android.widget.Button button12 = null;
    private android.widget.Button button13 = null;
    private android.widget.Button button14 = null;
    private android.widget.Button button15 = null;
    private android.widget.Button button16 = null;
    private android.widget.Button button17 = null;
    private android.widget.Button button18 = null;

    //toolbar
    private ImageButton undo_button = null;
    private ImageButton clue_button = null;
    private ImageButton param_button = null;

    // variables isButtonPressed (clavier)
    private boolean isButton1Pressed = false;
    private boolean isButton2Pressed = false;
    private boolean isButton3Pressed = false;
    private boolean isButton4Pressed = false;
    private boolean isButton5Pressed = false;
    private boolean isButton6Pressed = false;
    private boolean isButton7Pressed = false;
    private boolean isButton8Pressed = false;
    private boolean isButton9Pressed = false;
    private boolean isButton10Pressed = false;
    private boolean isButton11Pressed = false;
    private boolean isButton12Pressed = false;
    private boolean isButton13Pressed = false;
    private boolean isButton14Pressed = false;
    private boolean isButton15Pressed = false;
    private boolean isButton16Pressed = false;
    private boolean isButton17Pressed = false;
    private boolean isButton18Pressed = false;

    // initialisation zone de saisie
    private android.widget.Button saisie1;
    private android.widget.Button saisie2;
    private android.widget.Button saisie3;

    // Parametrage zone de saisie
    private int focusSaisie = 0;
    private char[] saisie = {' ', ' ', ' '};
    private String answer1;
    private String answer2;
    private ImageView image = null;
    private int nbOfClues;
    private int usedClues;
    private boolean clueMode;

    private boolean isSaisie1Locked = false;
    private boolean isSaisie2Locked = false;
    private boolean isSaisie3Locked = false;


    //Clavier
    private String clavier1;
    private String clavier2;
    private String clavier3;
    private String clavier4;
    private String clavier5;
    private String clavier6;
    private String clavier7;
    private String clavier8;
    private String clavier9;
    private String clavier10;
    private String clavier11;
    private String clavier12;
    private String clavier13;
    private String clavier14;
    private String clavier15;
    private String clavier16;
    private String clavier17;
    private String clavier18;

    private String levelS;
    private String pass;

    static ThreeLettersLevel ThreeLettersLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_three_letters_level);
        ThreeLettersLevel = this;

        // Init boutons toolbar
        undo_button = (ImageButton)findViewById(R.id.undo_button);
        clue_button = (ImageButton)findViewById(R.id.clue_button);
        param_button = (ImageButton)findViewById(R.id.param_button);

        image = (ImageView)findViewById(R.id.level_image);

        ///////////// Recup valeur niveau ///////////////////

        Bundle objetbunble  = this.getIntent().getExtras();
        // récupération de la valeur
        levelS = objetbunble.getString("passInfo");



        //////////////// Recup valeur memoire interne ///////////////////



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

        pass = read1.substring(0, 16);



        //////////////// FIN //////////////

        // CLUENB
        FileInputStream input2 = null;
        String read2 = null;
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

        if(read2.charAt(6) == 'x'){
            read2 = read2.charAt(5) + "";
        }else if(read2.charAt(7) == 'x'){
            read2 = read2.charAt(5) + read2.charAt(6) + "";
        }else{
            read2 = read2.charAt(5) + read2.charAt(6) + read2.charAt(7) + "";
        }

        nbOfClues = Integer.parseInt(read2);

        // FIN CLUENB

        clueMode = false;
        usedClues = 0;
        setClueButtonBackground(0, nbOfClues);





        String levelSTest = new String(levelS + "xxxxxxxxxxxx");




        if(levelSTest.charAt(11) == 'w' || levelSTest.charAt(13) == 'w'){
            WinActivity.getInstance().finish();
        }else if(levelSTest.charAt(11) == 'n' || levelSTest.charAt(13) == 'n'){
            ChooseLevelMenu.getInstance().finish();
        }else if(levelSTest.charAt(11) == 'd'){
            FirstStep.getInstance().finish();
            SecondStep.getInstance().finish();
            ThirdStep.getInstance().finish();
            FourthStep.getInstance().finish();
            FifthStep.getInstance().finish();
            levelS = levelS.substring(0, 11) + "w";
        }else{

        }





        // Personnalisation image
        if(levelS.equals("level=1x.1xn") || levelS.equals("level=1x.1xw") || levelS.equals(null) || levelS.equals("level=1x.1xd")){
            answer1 = "BAR";
            answer2 = "BAR";
            image.setBackgroundResource(R.mipmap.level_1_1);

            clavier1 = "M";
            clavier2 = "O";
            clavier3 = "D";
            clavier4 = "Y";
            clavier5 = "E";
            clavier6 = "R";
            clavier7 = "A";
            clavier8 = "U";
            clavier9 = "M";
            clavier10 = "T";
            clavier11 = "I";
            clavier12 = "W";
            clavier13 = "B";
            clavier14 = "N";
            clavier15 = "R";
            clavier16 = "C";
            clavier17 = "M";
            clavier18 = "E";


        }else if(levelS.equals("level=1x.2xn") || levelS.equals("level=1x.2xw")) {
            image.setBackgroundResource(R.mipmap.level_1_2);
            answer1 = "RAT";
            answer2 = "ART";
            clavier1 = "M";
            clavier2 = "T";
            clavier3 = "D";
            clavier4 = "U";
            clavier5 = "E";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "K";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "F";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "E";
            clavier17 = "M";
            clavier18 = "E";

        }else if(levelS.equals("level=1x.3xn") || levelS.equals("level=1x.3xw")){

            image.setBackgroundResource(R.mipmap.level_1_3);

            answer1 = "ELU";
            answer2 = "LUE";
            clavier1 = "H";
            clavier2 = "O";
            clavier3 = "Q";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "K";
            clavier9 = "W";
            clavier10 = "A";
            clavier11 = "U";
            clavier12 = "S";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "E";
            clavier17 = "P";
            clavier18 = "E";

        }else if(levelS.equals("level=1x.4xn") || levelS.equals("level=1x.4xw")){

            image.setBackgroundResource(R.mipmap.level_1_4);

            answer1 = "BUS";
            answer2 = "USB";
            clavier1 = "M";
            clavier2 = "T";
            clavier3 = "D";
            clavier4 = "U";
            clavier5 = "E";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "E";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "N";
            clavier12 = "F";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "O";
            clavier17 = "S";
            clavier18 = "K";
        }else if(levelS.equals("level=1x.5xn") || levelS.equals("level=1x.5xw")){
            image.setBackgroundResource(R.mipmap.level_1_5);
            answer1 = "ANE";
            answer2 = "ANE";
            clavier1 = "R";
            clavier2 = "T";
            clavier3 = "H";
            clavier4 = "U";
            clavier5 = "E";
            clavier6 = "S";
            clavier7 = "E";
            clavier8 = "P";
            clavier9 = "N";
            clavier10 = "A";
            clavier11 = "W";
            clavier12 = "F";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "X";
            clavier16 = "E";
            clavier17 = "M";
            clavier18 = "O";
        }else if(levelS.equals("level=1x.6xn") || levelS.equals("level=1x.6xw")){
        image.setBackgroundResource(R.mipmap.level_1_6);

            answer1 = "TOT";
            answer2 = "TOT";
        clavier1 = "M";
        clavier2 = "T";
        clavier3 = "D";
        clavier4 = "U";
        clavier5 = "E";
        clavier6 = "H";
        clavier7 = "A";
        clavier8 = "S";
        clavier9 = "M";
        clavier10 = "A";
        clavier11 = "O";
        clavier12 = "F";
        clavier13 = "T";
        clavier14 = "L";
        clavier15 = "R";
        clavier16 = "U";
        clavier17 = "M";
        clavier18 = "P";
    }else if(levelS.equals("level=1x.7xn") || levelS.equals("level=1x.7xw")){
            image.setBackgroundResource(R.mipmap.level_1_7);
            answer1 = "LIT";
            answer2 = "LIT";
            clavier1 = "M";
            clavier2 = "T";
            clavier3 = "D";
            clavier4 = "T";
            clavier5 = "E";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "K";
            clavier9 = "O";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "A";
            clavier13 = "P";
            clavier14 = "L";
            clavier15 = "C";
            clavier16 = "E";
            clavier17 = "N";
            clavier18 = "R";
        }else if(levelS.equals("level=1x.8xn") || levelS.equals("level=1x.8xw")){
            image.setBackgroundResource(R.mipmap.level_1_8);

            answer1 = "FOU";
            answer2 = "OUF";
            clavier1 = "T";
            clavier2 = "T";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "T";
            clavier13 = "B";
            clavier14 = "F";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "I";
            clavier18 = "L";
        }else if(levelS.equals("level=1x.9xn") || levelS.equals("level=1x.9xw")){
            image.setBackgroundResource(R.mipmap.level_1_9);

            answer1 = "EAU";
            answer2 = "EAU";
            clavier1 = "M";
            clavier2 = "O";
            clavier3 = "D";
            clavier4 = "Z";
            clavier5 = "E";
            clavier6 = "H";
            clavier7 = "A";
            clavier8 = "S";
            clavier9 = "M";
            clavier10 = "S";
            clavier11 = "Q";
            clavier12 = "F";
            clavier13 = "P";
            clavier14 = "L";
            clavier15 = "O";
            clavier16 = "U";
            clavier17 = "M";
            clavier18 = "P";
        }else if(levelS.equals("level=1x.10n") || levelS.equals("level=1x.10w")) {
            image.setBackgroundResource(R.mipmap.level_1_10);

            answer1 = "VER";
            answer2 = "VER";
            clavier1 = "M";
            clavier2 = "T";
            clavier3 = "D";
            clavier4 = "U";
            clavier5 = "E";
            clavier6 = "H";
            clavier7 = "G";
            clavier8 = "M";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "V";
            clavier12 = "E";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "W";
            clavier16 = "T";
            clavier17 = "M";
            clavier18 = "R";


        }else if(levelS.equals("level=2x.1xn") || levelS.equals("level=2x.1xw") || levelS.equals("level=2x.1xd")){
                answer1 = "RIZ";
                answer2 = "RIZ";
                image.setBackgroundResource(R.mipmap.level_2_1);

                clavier1 = "M";
                clavier2 = "O";
                clavier3 = "I";
                clavier4 = "Y";
                clavier5 = "E";
                clavier6 = "R";
                clavier7 = "A";
                clavier8 = "U";
                clavier9 = "M";
                clavier10 = "T";
                clavier11 = "I";
                clavier12 = "W";
                clavier13 = "B";
                clavier14 = "Z";
                clavier15 = "R";
                clavier16 = "C";
                clavier17 = "M";
                clavier18 = "E";


            }else if(levelS.equals("level=2x.2xn") || levelS.equals("level=2x.2xw")) {
                image.setBackgroundResource(R.mipmap.level_2_2);
                answer1 = "LOI";
                answer2 = "LOI";
                clavier1 = "M";
                clavier2 = "T";
                clavier3 = "D";
                clavier4 = "U";
                clavier5 = "O";
                clavier6 = "J";
                clavier7 = "A";
                clavier8 = "I";
                clavier9 = "M";
                clavier10 = "A";
                clavier11 = "I";
                clavier12 = "F";
                clavier13 = "B";
                clavier14 = "L";
                clavier15 = "R";
                clavier16 = "E";
                clavier17 = "M";
                clavier18 = "E";

            }else if(levelS.equals("level=2x.3xn") || levelS.equals("level=2x.3xw")){

                image.setBackgroundResource(R.mipmap.level_2_3);

                answer1 = "QUI";
                answer2 = "QUI";
                clavier1 = "H";
                clavier2 = "O";
                clavier3 = "Q";
                clavier4 = "E";
                clavier5 = "T";
                clavier6 = "J";
                clavier7 = "A";
                clavier8 = "K";
                clavier9 = "I";
                clavier10 = "A";
                clavier11 = "U";
                clavier12 = "S";
                clavier13 = "B";
                clavier14 = "L";
                clavier15 = "R";
                clavier16 = "E";
                clavier17 = "P";
                clavier18 = "E";

            }else if(levelS.equals("level=2x.4xn") || levelS.equals("level=2x.4xw")){

                image.setBackgroundResource(R.mipmap.level_2_4);

                answer1 = "MAI";
                answer2 = "AMI";
                clavier1 = "M";
                clavier2 = "T";
                clavier3 = "D";
                clavier4 = "U";
                clavier5 = "E";
                clavier6 = "J";
                clavier7 = "A";
                clavier8 = "E";
                clavier9 = "M";
                clavier10 = "A";
                clavier11 = "N";
                clavier12 = "F";
                clavier13 = "B";
                clavier14 = "L";
                clavier15 = "R";
                clavier16 = "I";
                clavier17 = "S";
                clavier18 = "K";
            }else if(levelS.equals("level=2x.5xn") || levelS.equals("level=2x.5xw")){
                image.setBackgroundResource(R.mipmap.level_2_5);
                answer1 = "PAS";
                answer2 = "SPA";
                clavier1 = "R";
                clavier2 = "T";
                clavier3 = "H";
                clavier4 = "U";
                clavier5 = "E";
                clavier6 = "S";
                clavier7 = "E";
                clavier8 = "P";
                clavier9 = "N";
                clavier10 = "A";
                clavier11 = "P";
                clavier12 = "F";
                clavier13 = "B";
                clavier14 = "L";
                clavier15 = "X";
                clavier16 = "E";
                clavier17 = "M";
                clavier18 = "O";
            }else if(levelS.equals("level=2x.6xn") || levelS.equals("level=2x.6xw")){
                image.setBackgroundResource(R.mipmap.level_2_6);

                answer1 = "MER";
                answer2 = "MER";
                clavier1 = "M";
                clavier2 = "T";
                clavier3 = "D";
                clavier4 = "U";
                clavier5 = "E";
                clavier6 = "H";
                clavier7 = "A";
                clavier8 = "S";
                clavier9 = "M";
                clavier10 = "A";
                clavier11 = "O";
                clavier12 = "F";
                clavier13 = "T";
                clavier14 = "L";
                clavier15 = "R";
                clavier16 = "U";
                clavier17 = "M";
                clavier18 = "P";
            }else if(levelS.equals("level=2x.7xn") || levelS.equals("level=2x.7xw")){
                image.setBackgroundResource(R.mipmap.level_2_7);
                answer1 = "VIE";
                answer2 = "VIE";
                clavier1 = "M";
                clavier2 = "T";
                clavier3 = "D";
                clavier4 = "T";
                clavier5 = "E";
                clavier6 = "J";
                clavier7 = "A";
                clavier8 = "K";
                clavier9 = "O";
                clavier10 = "A";
                clavier11 = "I";
                clavier12 = "A";
                clavier13 = "P";
                clavier14 = "V";
                clavier15 = "C";
                clavier16 = "E";
                clavier17 = "N";
                clavier18 = "R";
            }else if(levelS.equals("level=2x.8xn") || levelS.equals("level=2x.8xw")){
                image.setBackgroundResource(R.mipmap.level_2_8);

                answer1 = "JEU";
                answer2 = "JEU";
                clavier1 = "T";
                clavier2 = "T";
                clavier3 = "M";
                clavier4 = "U";
                clavier5 = "P";
                clavier6 = "J";
                clavier7 = "A";
                clavier8 = "O";
                clavier9 = "M";
                clavier10 = "A";
                clavier11 = "I";
                clavier12 = "T";
                clavier13 = "B";
                clavier14 = "F";
                clavier15 = "U";
                clavier16 = "E";
                clavier17 = "I";
                clavier18 = "L";
            }else if(levelS.equals("level=2x.9xn") || levelS.equals("level=2x.9xw")){
                image.setBackgroundResource(R.mipmap.level_2_9);

                answer1 = "POT";
                answer2 = "TOP";
                clavier1 = "M";
                clavier2 = "O";
                clavier3 = "D";
                clavier4 = "Z";
                clavier5 = "E";
                clavier6 = "H";
                clavier7 = "A";
                clavier8 = "S";
                clavier9 = "M";
                clavier10 = "S";
                clavier11 = "Q";
                clavier12 = "F";
                clavier13 = "P";
                clavier14 = "L";
                clavier15 = "O";
                clavier16 = "K";
                clavier17 = "M";
                clavier18 = "T";
            }else if(levelS.equals("level=2x.10n") || levelS.equals("level=2x.10w")){
                image.setBackgroundResource(R.mipmap.level_2_10);

                answer1 = "SEL";
                answer2 = "LES";
                clavier1 = "M";
                clavier2 = "T";
                clavier3 = "D";
                clavier4 = "U";
                clavier5 = "E";
                clavier6 = "S";
                clavier7 = "G";
                clavier8 = "M";
                clavier9 = "M";
                clavier10 = "A";
                clavier11 = "Q";
                clavier12 = "E";
                clavier13 = "B";
                clavier14 = "L";
                clavier15 = "R";
                clavier16 = "U";
                clavier17 = "M";
                clavier18 = "O";


            }else if(levelS.equals("english=1x.1xn") || levelS.equals("english=1x.1xw")){

            image.setBackgroundResource(R.mipmap.level_1_1_ang);

            answer1 = "ICE";
            answer2 = "ICE";
            clavier1 = "E";
            clavier2 = "O";
            clavier3 = "C";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "G";
            clavier7 = "A";
            clavier8 = "S";
            clavier9 = "Q";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "S";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "E";
            clavier17 = "C";
            clavier18 = "E";

        }else if(levelS.equals("english=1x.2xn") || levelS.equals("english=1x.2xw")){

            image.setBackgroundResource(R.mipmap.level_1_2_ang);

            answer1 = "RUN";
            answer2 = "RUN";
            clavier1 = "U";
            clavier2 = "O";
            clavier3 = "I";
            clavier4 = "E";
            clavier5 = "R";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "S";
            clavier9 = "W";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "N";
            clavier13 = "C";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "O";
            clavier17 = "I";
            clavier18 = "R";

        }else if(levelS.equals("english=1x.3xn") || levelS.equals("english=1x.3xw")){

            image.setBackgroundResource(R.mipmap.level_1_3_ang);

            answer1 = "JAM";
            answer2 = "JAM";
            clavier1 = "E";
            clavier2 = "O";
            clavier3 = "M";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "S";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "S";
            clavier13 = "A";
            clavier14 = "H";
            clavier15 = "R";
            clavier16 = "Q";
            clavier17 = "N";
            clavier18 = "E";

        }else if(levelS.equals("english=1x.4xn") || levelS.equals("english=1x.4xw")){

            image.setBackgroundResource(R.mipmap.level_1_4_ang);

            answer1 = "BED";
            answer2 = "BED";
            clavier1 = "E";
            clavier2 = "O";
            clavier3 = "Q";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "S";
            clavier9 = "W";
            clavier10 = "A";
            clavier11 = "D";
            clavier12 = "S";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "E";
            clavier17 = "Y";
            clavier18 = "E";

        }else if(levelS.equals("english=1x.5xn") || levelS.equals("english=1x.5xw")){

            image.setBackgroundResource(R.mipmap.level_1_5_ang);

            answer1 = "KID";
            answer2 = "KID";
            clavier1 = "D";
            clavier2 = "O";
            clavier3 = "E";
            clavier4 = "U";
            clavier5 = "K";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "K";
            clavier9 = "W";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "S";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "E";
            clavier17 = "P";
            clavier18 = "E";

        }else if(levelS.equals("english=1x.6xn") || levelS.equals("english=1x.6xw")){

            image.setBackgroundResource(R.mipmap.level_1_6_ang);

            answer1 = "MAN";
            answer2 = "MAN";
            clavier1 = "N";
            clavier2 = "O";
            clavier3 = "Q";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "R";
            clavier9 = "W";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "S";
            clavier13 = "P";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "U";
            clavier17 = "P";
            clavier18 = "M";

        }else if(levelS.equals("english=1x.7xn") || levelS.equals("english=1x.7xw")){

            image.setBackgroundResource(R.mipmap.level_1_7_ang);

            answer1 = "LEG";
            answer2 = "LEG";
            clavier1 = "E";
            clavier2 = "O";
            clavier3 = "Q";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "S";
            clavier9 = "G";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "S";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "P";
            clavier16 = "E";
            clavier17 = "S";
            clavier18 = "I";


        }else if(levelS.equals("english=1x.8xn") || levelS.equals("english=1x.8xw")){

            image.setBackgroundResource(R.mipmap.level_1_8_ang);

            answer1 = "BEE";
            answer2 = "BEE";
            clavier1 = "E";
            clavier2 = "O";
            clavier3 = "U";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "S";
            clavier9 = "W";
            clavier10 = "H";
            clavier11 = "I";
            clavier12 = "S";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "G";
            clavier17 = "P";
            clavier18 = "E";

        }else if(levelS.equals("english=1x.9xn") || levelS.equals("english=1x.9xw")){

            image.setBackgroundResource(R.mipmap.level_1_9_ang);

            answer1 = "HUG";
            answer2 = "HUG";
            clavier1 = "E";
            clavier2 = "O";
            clavier3 = "Q";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "U";
            clavier7 = "A";
            clavier8 = "B";
            clavier9 = "W";
            clavier10 = "A";
            clavier11 = "M";
            clavier12 = "I";
            clavier13 = "H";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "E";
            clavier17 = "J";
            clavier18 = "G";

        }else if(levelS.equals("english=1x.10n") || levelS.equals("english=1x.10w")){

            image.setBackgroundResource(R.mipmap.level_1_10_ang);

            answer1 = "CUT";
            answer2 = "CUT";
            clavier1 = "E";
            clavier2 = "O";
            clavier3 = "U";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "S";
            clavier9 = "W";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "H";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "H";
            clavier17 = "C";
            clavier18 = "E";

        }else{

        }



        // Init boutons clavier
        button1 = (android.widget.Button) findViewById(R.id.button1);
        button2 = (android.widget.Button) findViewById(R.id.button2);
        button3 = (android.widget.Button) findViewById(R.id.button3);
        button4 = (android.widget.Button) findViewById(R.id.button4);
        button5 = (android.widget.Button) findViewById(R.id.button5);
        button6 = (android.widget.Button) findViewById(R.id.button6);
        button7 = (android.widget.Button) findViewById(R.id.button7);
        button8 = (android.widget.Button) findViewById(R.id.button8);
        button9 = (android.widget.Button) findViewById(R.id.button9);
        button10 = (android.widget.Button) findViewById(R.id.button10);
        button11 = (android.widget.Button) findViewById(R.id.button11);
        button12 = (android.widget.Button) findViewById(R.id.button12);
        button13 = (android.widget.Button) findViewById(R.id.button13);
        button14 = (android.widget.Button) findViewById(R.id.button14);
        button15 = (android.widget.Button) findViewById(R.id.button15);
        button16 = (android.widget.Button) findViewById(R.id.button16);
        button17 = (android.widget.Button) findViewById(R.id.button17);
        button18 = (android.widget.Button) findViewById(R.id.button18);

        // Personnalisation boutons clavier
        button1.setText(clavier1);
        button2.setText(clavier2);
        button3.setText(clavier3);
        button4.setText(clavier4);
        button5.setText(clavier5);
        button6.setText(clavier6);
        button7.setText(clavier7);
        button8.setText(clavier8);
        button9.setText(clavier9);
        button10.setText(clavier10);
        button11.setText(clavier11);
        button12.setText(clavier12);
        button13.setText(clavier13);
        button14.setText(clavier14);
        button15.setText(clavier15);
        button16.setText(clavier16);
        button17.setText(clavier17);
        button18.setText(clavier18);

        button1.setOnClickListener(new View.OnClickListener(){
          @Override
            public void onClick(View v){
              char carac;
                      if(isButton1Pressed == false && clueMode == false){
                          if(focusSaisie < 3){
                              button1.setBackgroundResource(R.mipmap.clavier_orange_pressed);
                              isButton1Pressed = true;
                              carac = button1.getText().charAt(0);
                              saisie[focusSaisie] = carac;
                              updateSaisie();
                              determineFocusSaisie();
                              isWon();
                          }else{
                              // Rien ne se passe : zone de saisie pleine
                          }

                      }else if(clueMode == false){
                          button1.setBackgroundResource(R.mipmap.clavier_orange);
                          isButton1Pressed = false;
                          removeCharacter(button1);
                          updateSaisie();
                          determineFocusSaisie();
                      }else{

                      }

          }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    char carac;
                    if(isButton2Pressed == false && clueMode == false){
                        if(focusSaisie < 3){
                            button2.setBackgroundResource(R.mipmap.clavier_jaune_pressed);
                            isButton2Pressed = true;
                            carac = button2.getText().charAt(0);
                            saisie[focusSaisie] = carac;
                            updateSaisie();
                            determineFocusSaisie();
                            isWon();

                        }else{
                            // Rien ne se passe : zone de saisie pleine
                        }

                    }else if(clueMode == false){
                        button2.setBackgroundResource(R.mipmap.clavier_jaune);
                        isButton2Pressed = false;
                        removeCharacter(button2);
                        updateSaisie();
                        determineFocusSaisie();
                    }else{

                    }
                }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton3Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button3.setBackgroundResource(R.mipmap.clavier_vert_pressed);
                        isButton3Pressed = true;
                        carac = button3.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button3.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton3Pressed = false;
                    removeCharacter(button3);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton4Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button4.setBackgroundResource(R.mipmap.clavier_orange_pressed);
                        isButton4Pressed = true;
                        carac = button4.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button4.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton4Pressed = false;
                    removeCharacter(button4);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });



        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton5Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button5.setBackgroundResource(R.mipmap.clavier_jaune_pressed);
                        isButton5Pressed = true;
                        carac = button5.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button5.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton5Pressed = false;
                    removeCharacter(button5);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton6Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button6.setBackgroundResource(R.mipmap.clavier_vert_pressed);
                        isButton6Pressed = true;
                        carac = button6.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button6.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton6Pressed = false;
                    removeCharacter(button6);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton7Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button7.setBackgroundResource(R.mipmap.clavier_jaune_pressed);
                        isButton7Pressed = true;
                        carac = button7.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button7.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton7Pressed = false;
                    removeCharacter(button7);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton8Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button8.setBackgroundResource(R.mipmap.clavier_vert_pressed);
                        isButton8Pressed = true;
                        carac = button8.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button8.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton8Pressed = false;
                    removeCharacter(button8);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton9Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button9.setBackgroundResource(R.mipmap.clavier_orange_pressed);
                        isButton9Pressed = true;
                        carac = button9.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button9.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton9Pressed = false;
                    removeCharacter(button9);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton10Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button10.setBackgroundResource(R.mipmap.clavier_jaune_pressed);
                        isButton10Pressed = true;
                        carac = button10.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button10.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton10Pressed = false;
                    removeCharacter(button10);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton11Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button11.setBackgroundResource(R.mipmap.clavier_vert_pressed);
                        isButton11Pressed = true;
                        carac = button11.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button11.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton11Pressed = false;
                    removeCharacter(button11);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton12Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button12.setBackgroundResource(R.mipmap.clavier_orange_pressed);
                        isButton12Pressed = true;
                        carac = button12.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button12.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton12Pressed = false;
                    removeCharacter(button12);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton13Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button13.setBackgroundResource(R.mipmap.clavier_vert_pressed);
                        isButton13Pressed = true;
                        carac = button13.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button13.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton13Pressed = false;
                    removeCharacter(button13);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton14Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button14.setBackgroundResource(R.mipmap.clavier_orange_pressed);
                        isButton14Pressed = true;
                        carac = button14.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button14.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton14Pressed = false;
                    removeCharacter(button14);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton15Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button15.setBackgroundResource(R.mipmap.clavier_jaune_pressed);
                        isButton15Pressed = true;
                        carac = button15.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button15.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton15Pressed = false;
                    removeCharacter(button15);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton16Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button16.setBackgroundResource(R.mipmap.clavier_vert_pressed);
                        isButton16Pressed = true;
                        carac = button16.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button16.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton16Pressed = false;
                    removeCharacter(button16);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton17Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button17.setBackgroundResource(R.mipmap.clavier_orange_pressed);
                        isButton17Pressed = true;
                        carac = button17.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button17.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton17Pressed = false;
                    removeCharacter(button17);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });


        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton18Pressed == false && clueMode == false){
                    if(focusSaisie < 3){
                        button18.setBackgroundResource(R.mipmap.clavier_jaune_pressed);
                        isButton18Pressed = true;
                        carac = button18.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else if(clueMode == false){
                    button18.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton18Pressed = false;
                    removeCharacter(button18);
                    updateSaisie();
                    determineFocusSaisie();
                }
                else{

                }
            }
        });

        // FIN - Activation des boutons

        // Activation zone de saisie

        saisie1 = (android.widget.Button) findViewById(R.id.blue_button1);
        saisie2 = (android.widget.Button) findViewById(R.id.blue_button2);
        saisie3 = (android.widget.Button) findViewById(R.id.blue_button3);

        focusSaisie = 0;

        undo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(levelS.substring(0, 7).equals("english")){
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "ang1");
                    Intent undo = new Intent(ThreeLettersLevel.this, ChooseLevelMenu.class);
                    undo.putExtras(objetbunble);
                    startActivity(undo);
                    finish();
                }else if(levelS.charAt(6) == '1'){
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "1");
                    Intent undo = new Intent(ThreeLettersLevel.this, ChooseLevelMenu.class);
                    undo.putExtras(objetbunble);
                    startActivity(undo);
                    finish();
                }else if(levelS.charAt(6) == '2'){
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "2");
                    Intent undo = new Intent(ThreeLettersLevel.this, ChooseLevelMenu.class);
                    undo.putExtras(objetbunble);
                    startActivity(undo);
                    finish();
                }else{

                }
            }
        });

        clue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clueMode == true) {
                    saisie1.setBackgroundResource(R.mipmap.saisie);
                    saisie2.setBackgroundResource(R.mipmap.saisie);
                    saisie3.setBackgroundResource(R.mipmap.saisie);
                    updateSaisie();
                    usedClues = usedClues - 1;
                    nbOfClues++;
                    clueMode = false;
                    setClueNb(nbOfClues);
                    setClueButtonBackground(usedClues, nbOfClues);
                }else if(nbOfClues == 0){

                    }else if(usedClues < 2){
                        saisie1.setBackgroundResource(R.mipmap.saisie_clue);
                        saisie1.setText(" ");
                        saisie2.setBackgroundResource(R.mipmap.saisie_clue);
                        saisie2.setText(" ");
                        saisie3.setBackgroundResource(R.mipmap.saisie_clue);
                        saisie3.setText(" ");
                        clueMode = true;

                        usedClues++;
                        nbOfClues = nbOfClues - 1;
                        setClueNb(nbOfClues);
                        setClueButtonBackground(usedClues, nbOfClues);
                    }else{
                    }
                }

        });


        param_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appel = new Intent(ThreeLettersLevel.this, Settings.class);
                startActivity(appel);
            }
        });




        saisie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(clueMode == false ){
                    char carac;
                    if (saisie1.getText().charAt(0) != ' ' && isSaisie1Locked == false) {
                        carac = saisie1.getText().charAt(0);
                        saisie[0] = ' ';
                        releaseButton(carac);
                        updateSaisie();
                        determineFocusSaisie();

                    } else {

                    }
                }else{
                    clueMode = false;
                    saisie[0] = answer1.charAt(0);
                    isSaisie1Locked = true;
                    saisie1.setTextColor(Color.GRAY);
                    saisie1.setBackgroundResource(R.mipmap.saisie);
                    saisie2.setBackgroundResource(R.mipmap.saisie);
                    saisie3.setBackgroundResource(R.mipmap.saisie);
                    updateSaisie();
                    determineFocusSaisie();
                    isWon();
                }
            }
        });

        saisie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(clueMode == false){
                    char carac;
                    if(saisie2.getText().charAt(0) != ' ' && isSaisie2Locked == false){
                        carac = saisie2.getText().charAt(0);
                        saisie[1] = ' ';
                        releaseButton(carac);
                        updateSaisie();
                        determineFocusSaisie();
                    }else{

                    }
                }else{
                    clueMode = false;
                    saisie[1] = answer1.charAt(1);
                    isSaisie2Locked = true;
                    saisie2.setTextColor(Color.GRAY);
                    saisie1.setBackgroundResource(R.mipmap.saisie);
                    saisie2.setBackgroundResource(R.mipmap.saisie);
                    saisie3.setBackgroundResource(R.mipmap.saisie);
                    updateSaisie();
                    determineFocusSaisie();
                    isWon();
                }
            }
        });

        saisie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(clueMode == false){
                    char carac;
                    if (saisie3.getText().charAt(0) != ' ' && isSaisie3Locked == false) {
                        carac = saisie3.getText().charAt(0);
                        saisie[2] = ' ';
                        releaseButton(carac);
                        updateSaisie();
                        determineFocusSaisie();
                    } else {

                    }
                }else{
                    clueMode = false;
                    saisie[2] = answer1.charAt(2);
                    isSaisie3Locked = true;
                    saisie3.setTextColor(Color.GRAY);
                    saisie1.setBackgroundResource(R.mipmap.saisie);
                    saisie2.setBackgroundResource(R.mipmap.saisie);
                    saisie3.setBackgroundResource(R.mipmap.saisie);
                    updateSaisie();
                    determineFocusSaisie();
                    isWon();
                }

            }
        });












    }
    @Override
    public void onClick(android.view.View v){
    }


    public void releaseButton(char carac){
        if(button1.getText().charAt(0) == carac && isButton1Pressed == true){
            button1.setBackgroundResource(R.mipmap.clavier_orange);
            isButton1Pressed = false;
        }else if(button2.getText().charAt(0) == carac && isButton2Pressed == true){
            button2.setBackgroundResource(R.mipmap.clavier_jaune);
            isButton2Pressed = false;
        }else if(button3.getText().charAt(0) == carac && isButton3Pressed == true){
            button3.setBackgroundResource(R.mipmap.clavier_vert);
            isButton3Pressed = false;
        }else if(button4.getText().charAt(0) == carac && isButton4Pressed == true){
            button4.setBackgroundResource(R.mipmap.clavier_orange);
            isButton4Pressed = false;
        }else if(button5.getText().charAt(0) == carac && isButton5Pressed == true){
            button5.setBackgroundResource(R.mipmap.clavier_jaune);
            isButton5Pressed = false;
        }else if(button6.getText().charAt(0) == carac && isButton6Pressed == true){
            button6.setBackgroundResource(R.mipmap.clavier_vert);
            isButton6Pressed = false;
        }else if(button7.getText().charAt(0) == carac && isButton7Pressed == true){
            button7.setBackgroundResource(R.mipmap.clavier_jaune);
            isButton7Pressed = false;
        }else if(button8.getText().charAt(0) == carac && isButton8Pressed == true){
            button8.setBackgroundResource(R.mipmap.clavier_vert);
            isButton8Pressed = false;
        }else if(button9.getText().charAt(0) == carac && isButton9Pressed == true){
            button9.setBackgroundResource(R.mipmap.clavier_orange);
            isButton9Pressed = false;
        }else if(button10.getText().charAt(0) == carac && isButton10Pressed == true){
            button10.setBackgroundResource(R.mipmap.clavier_jaune);
            isButton10Pressed = false;
        }else if(button11.getText().charAt(0) == carac && isButton11Pressed == true){
            button11.setBackgroundResource(R.mipmap.clavier_vert);
            isButton11Pressed = false;
        }else if(button12.getText().charAt(0) == carac && isButton12Pressed == true){
            button12.setBackgroundResource(R.mipmap.clavier_orange);
            isButton12Pressed = false;
        }else if(button13.getText().charAt(0) == carac && isButton13Pressed == true){
            button13.setBackgroundResource(R.mipmap.clavier_vert);
            isButton13Pressed = false;
        }else if(button14.getText().charAt(0) == carac && isButton14Pressed == true){
            button14.setBackgroundResource(R.mipmap.clavier_orange);
            isButton14Pressed = false;
        }else if(button15.getText().charAt(0) == carac && isButton15Pressed == true){
            button15.setBackgroundResource(R.mipmap.clavier_jaune);
            isButton15Pressed = false;
        }else if(button16.getText().charAt(0) == carac && isButton16Pressed == true){
            button16.setBackgroundResource(R.mipmap.clavier_vert);
            isButton16Pressed = false;
        }else if(button17.getText().charAt(0) == carac && isButton17Pressed == true){
            button17.setBackgroundResource(R.mipmap.clavier_orange);
            isButton17Pressed = false;
        }else{
            button18.setBackgroundResource(R.mipmap.clavier_jaune);
            isButton18Pressed = false;
        }
    }


    public void determineFocusSaisie(){
        int focus = 0;
        if(saisie[0] == ' '){
            focus = 0;
        }else if(saisie[1] == ' '){
            focus = 1;
        }else if(saisie[2] == ' '){
            focus = 2;
        }else{
            focus = 3;
        }
        focusSaisie = focus;
    }


    public void updateSaisie(){
        String string0 = Character.toString(saisie[0]);
        saisie1.setText(string0);

        String string1 = Character.toString(saisie[1]);
        saisie2.setText(string1);

        String string2 = Character.toString(saisie[2]);
        saisie3.setText(string2);



    }


    public void removeCharacter(android.widget.Button button){

        // Chercher le caractere a supprimer
        int index;
        if(saisie[0] == button.getText().charAt(0)){
            index = 0;
        }else if(saisie[1] == button.getText().charAt(0)){
            index = 1;
        }else {
            index = 2;
        }
        // Supprmier le caractère
        saisie[index] = ' ';

    }


    public void win(){

        //création de notre item
        Intent defineIntent = new Intent(ThreeLettersLevel.this, WinActivity.class);
        // objet qui vas nous permettre de passe des variables ici la variable passInfo
        Bundle objetbunble = new Bundle();

        objetbunble.putString("passInfo", levelS);
        // on passe notre objet a notre activities
        defineIntent.putExtras(objetbunble );
        // on appelle notre activité
        startActivity(defineIntent);
        finish();





    }

    public void isWon(){
        boolean isWon;
        if(saisie[0] == answer1.charAt(0) && saisie[1] == answer1.charAt(1) && saisie[2] == answer1.charAt(2)){
            win();
        }else if(saisie[0] == answer2.charAt(0) && saisie[1] == answer2.charAt(1) && saisie[2] == answer2.charAt(2)){
            win();
        }else{

        }
    }

    public static ThreeLettersLevel getInstance(){
        return ThreeLettersLevel;
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
        nb2_1 = Integer.parseInt("" + nb1_carac);
        nb2_2 = Integer.parseInt("" + nb2_carac);

        // FIN

        if(nb1_1 < nb2_1){
            bool = false;
        }else{
            bool = true;
        }

        return bool;

    }







}
