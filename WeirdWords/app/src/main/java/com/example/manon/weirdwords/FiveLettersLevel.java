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

public class FiveLettersLevel extends AppCompatActivity implements View.OnClickListener{


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
    private android.widget.Button saisie4;
    private android.widget.Button saisie5;

    private boolean isSaisie1Locked = false;
    private boolean isSaisie2Locked = false;
    private boolean isSaisie3Locked = false;
    private boolean isSaisie4Locked = false;
    private boolean isSaisie5Locked = false;

    // Parametrage zone de saisie
    private int focusSaisie = 0;
    private char[] saisie = {' ', ' ', ' ', ' ', ' '};
    private String answer1;
    private String answer2;
    private ImageView image = null;
    private int nbOfClues;
    private int usedClues;
    private boolean clueMode;


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

    private String levelS =" "  ;
    private String pass;

    static FiveLettersLevel FiveLettersLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_five_letters_level);
        FiveLettersLevel = this;

        // Init boutons toolbar
        undo_button = (ImageButton)findViewById(R.id.undo_button);
        clue_button = (ImageButton)findViewById(R.id.clue_button);
        param_button = (ImageButton)findViewById(R.id.param_button);

        image = (ImageView)findViewById(R.id.level_image);


        ///////////// Recup valeur niveau ///////////////////

        Bundle objectbunble  = this.getIntent().getExtras();
        // récupération de la valeur
        levelS = objectbunble.getString("passInfo");



        //////////////// Recup valeur memoire interne ///////////////////

        FileInputStream input = null;
        String read = null;
        char[] readBuffer = new char[26];
        InputStreamReader isr = null;

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

        //////////////// FIN //////////////

        clueMode = false;
        usedClues = 0;

        nbOfClues = getClueNb();


        if(levelS.charAt(11) == 'w'){
            WinActivity.getInstance().finish();
        }else{
            ChooseLevelMenu.getInstance().finish();
        }


        // Personnalisation image
        if(levelS.equals("level=6x.1xn") || levelS.equals("level=6x.1xw") || levelS.equals(null)){

            answer1 = "CRABE";
            answer2 = "CRABE";
            image.setBackgroundResource(R.mipmap.level_6_1);

            clavier1 = "C";
            clavier2 = "O";
            clavier3 = "P";
            clavier4 = "T";
            clavier5 = "R";
            clavier6 = "Q";
            clavier7 = "A";
            clavier8 = "U";
            clavier9 = "S";
            clavier10 = "E";
            clavier11 = "K";
            clavier12 = "W";
            clavier13 = "M";
            clavier14 = "B";
            clavier15 = "T";
            clavier16 = "W";
            clavier17 = "Y";
            clavier18 = "T";


        }else if(levelS.equals("level=6x.2xn") || levelS.equals("level=6x.2xw")) {
            image.setBackgroundResource(R.mipmap.level_6_2);
            answer1 = "POCHE";
            answer2 = "CHOPE";
            clavier1 = "P";
            clavier2 = "S";
            clavier3 = "A";
            clavier4 = "Y";
            clavier5 = "E";
            clavier6 = "R";
            clavier7 = "A";
            clavier8 = "L";
            clavier9 = "I";
            clavier10 = "E";
            clavier11 = "V";
            clavier12 = "H";
            clavier13 = "F";
            clavier14 = "O";
            clavier15 = "Z";
            clavier16 = "E";
            clavier17 = "C";
            clavier18 = "W";

        }else if(levelS.equals("level=6x.3xn") || levelS.equals("level=6x.3xw")){

            image.setBackgroundResource(R.mipmap.level_6_3);

            answer1 = "TASSE";
            answer2 = "STASE";
            clavier1 = "Q";
            clavier2 = "M";
            clavier3 = "A";
            clavier4 = "E";
            clavier5 = "B";
            clavier6 = "S";
            clavier7 = "A";
            clavier8 = "K";
            clavier9 = "W";
            clavier10 = "E";
            clavier11 = "I";
            clavier12 = "S";
            clavier13 = "B";
            clavier14 = "G";
            clavier15 = "Y";
            clavier16 = "E";
            clavier17 = "P";
            clavier18 = "T";

        }else if(levelS.equals("level=6x.4xn") || levelS.equals("level=6x.4xw")){

            image.setBackgroundResource(R.mipmap.level_6_4);

            answer1 = "ARBRE";
            answer2 = "BARRE";
            clavier1 = "R";
            clavier2 = "T";
            clavier3 = "W";
            clavier4 = "U";
            clavier5 = "O";
            clavier6 = "A";
            clavier7 = "I";
            clavier8 = "E";
            clavier9 = "R";
            clavier10 = "C";
            clavier11 = "N";
            clavier12 = "F";
            clavier13 = "S";
            clavier14 = "E";
            clavier15 = "R";
            clavier16 = "H";
            clavier17 = "B";
            clavier18 = "Z";
        }else if(levelS.equals("level=6x.5xn") || levelS.equals("level=6x.5xw")){
            image.setBackgroundResource(R.mipmap.level_6_5);
            answer1 = "PAINS";
            answer2 = "SAPIN";
            clavier1 = "B";
            clavier2 = "A";
            clavier3 = "D";
            clavier4 = "U";
            clavier5 = "N";
            clavier6 = "P";
            clavier7 = "E";
            clavier8 = "P";
            clavier9 = "S";
            clavier10 = "A";
            clavier11 = "W";
            clavier12 = "I";
            clavier13 = "E";
            clavier14 = "U";
            clavier15 = "H";
            clavier16 = "E";
            clavier17 = "N";
            clavier18 = "A";
        }else if(levelS.equals("level=6x.6xn") || levelS.equals("level=6x.6xw")){
            image.setBackgroundResource(R.mipmap.level_6_6);

            answer1 = "COTON";
            answer2 = "COTON";
            clavier1 = "M";
            clavier2 = "O";
            clavier3 = "I";
            clavier4 = "K";
            clavier5 = "E";
            clavier6 = "C";
            clavier7 = "K";
            clavier8 = "T";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "O";
            clavier12 = "T";
            clavier13 = "R";
            clavier14 = "I";
            clavier15 = "N";
            clavier16 = "W";
            clavier17 = "A";
            clavier18 = "S";
        }else if(levelS.equals("level=6x.7xn") || levelS.equals("level=6x.7xw")){
            image.setBackgroundResource(R.mipmap.level_6_7);
            answer1 = "TERRE";
            answer2 = "TERRE";
            clavier1 = "M";
            clavier2 = "T";
            clavier3 = "D";
            clavier4 = "B";
            clavier5 = "E";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "R";
            clavier9 = "O";
            clavier10 = "A";
            clavier11 = "K";
            clavier12 = "M";
            clavier13 = "R";
            clavier14 = "L";
            clavier15 = "C";
            clavier16 = "E";
            clavier17 = "N";
            clavier18 = "R";
        }else if(levelS.equals("level=6x.8xn") || levelS.equals("level=6x.8xw")){
            image.setBackgroundResource(R.mipmap.level_6_8);

            answer1 = "AMOUR";
            answer2 = "AMOUR";
            clavier1 = "T";
            clavier2 = "M";
            clavier3 = "P";
            clavier4 = "U";
            clavier5 = "W";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "K";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "J";
            clavier18 = "L";
        }else if(levelS.equals("level=6x.9xn") || levelS.equals("level=6x.9xw")){
            image.setBackgroundResource(R.mipmap.level_6_9);

            answer1 = "TISSU";
            answer2 = "TISSU";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "S";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "S";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "Q";
            clavier17 = "M";
            clavier18 = "W";
        }else if(levelS.equals("level=6x.10n") || levelS.equals("level=6x.10w")){
            image.setBackgroundResource(R.mipmap.level_6_10);

            answer1 = "NUAGE";
            answer2 = "NUAGE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "N";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "T";
            clavier18 = "G";

        }else if(levelS.equals("level=7x.1xn") || levelS.equals("level=7x.1xw")){
            image.setBackgroundResource(R.mipmap.level_7_1);

            answer1 = "STYLO";
            answer2 = "STYLO";
            clavier1 = "W";
            clavier2 = "N";
            clavier3 = "T";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "Y";
            clavier7 = "M";
            clavier8 = "O";
            clavier9 = "R";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "S";
            clavier13 = "T";
            clavier14 = "S";
            clavier15 = "U";
            clavier16 = "S";
            clavier17 = "L";
            clavier18 = "Z";

        }else if(levelS.equals("level=7x.2xn") || levelS.equals("level=7x.2xw")){
            image.setBackgroundResource(R.mipmap.level_7_2);

            answer1 = "PIECE";
            answer2 = "EPICE";
            clavier1 = "T";
            clavier2 = "E";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "F";
            clavier6 = "J";
            clavier7 = "I";
            clavier8 = "Y";
            clavier9 = "P";
            clavier10 = "W";
            clavier11 = "I";
            clavier12 = "C";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "Q";
            clavier16 = "E";
            clavier17 = "O";
            clavier18 = "T";

        }else if(levelS.equals("level=7x.3xn") || levelS.equals("level=7x.3xw")){
            image.setBackgroundResource(R.mipmap.level_7_3);

            answer1 = "PELLE";
            answer2 = "PELLE";
            clavier1 = "E";
            clavier2 = "Q";
            clavier3 = "F";
            clavier4 = "U";
            clavier5 = "K";
            clavier6 = "O";
            clavier7 = "S";
            clavier8 = "U";
            clavier9 = "P";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "L";
            clavier13 = "M";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "B";
            clavier18 = "V";

        }else if(levelS.equals("level=7x.4xn") || levelS.equals("level=7x.4xw")){
            image.setBackgroundResource(R.mipmap.level_7_4);

            answer1 = "CREPE";
            answer2 = "PERCE";
            clavier1 = "Z";
            clavier2 = "R";
            clavier3 = "P";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "J";
            clavier9 = "E";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "Z";
            clavier13 = "C";
            clavier14 = "G";
            clavier15 = "T";
            clavier16 = "E";
            clavier17 = "F";
            clavier18 = "L";

        }else if(levelS.equals("level=7x.5xn") || levelS.equals("level=7x.5xw")){
            image.setBackgroundResource(R.mipmap.level_7_5);

            answer1 = "BERGE";
            answer2 = "GERBE";
            clavier1 = "I";
            clavier2 = "F";
            clavier3 = "G";
            clavier4 = "S";
            clavier5 = "D";
            clavier6 = "K";
            clavier7 = "A";
            clavier8 = "D";
            clavier9 = "M";
            clavier10 = "E";
            clavier11 = "I";
            clavier12 = "Q";
            clavier13 = "R";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "N";
            clavier18 = "B";

        }else if(levelS.equals("level=7x.6xn") || levelS.equals("level=7x.6xw")){
            image.setBackgroundResource(R.mipmap.level_7_6);

            answer1 = "SOEUR";
            answer2 = "ROUES";
            clavier1 = "T";
            clavier2 = "R";
            clavier3 = "S";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "M";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "G";
            clavier12 = "O";
            clavier13 = "B";
            clavier14 = "Y";
            clavier15 = "Q";
            clavier16 = "E";
            clavier17 = "W";
            clavier18 = "Q";

        }else if(levelS.equals("level=7x.7xn") || levelS.equals("level=7x.7xw")){
            image.setBackgroundResource(R.mipmap.level_7_7);

            answer1 = "FLEUR";
            answer2 = "FLEUR";
            clavier1 = "P";
            clavier2 = "A";
            clavier3 = "L";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "F";
            clavier7 = "A";
            clavier8 = "D";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "W";
            clavier12 = "R";
            clavier13 = "E";
            clavier14 = "I";
            clavier15 = "L";
            clavier16 = "E";
            clavier17 = "K";
            clavier18 = "L";

        }else if(levelS.equals("level=7x.8xn") || levelS.equals("level=7x.8xw")){
            image.setBackgroundResource(R.mipmap.level_7_8);

            answer1 = "TAPIS";
            answer2 = "TAPIS";
            clavier1 = "T";
            clavier2 = "M";
            clavier3 = "R";
            clavier4 = "A";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "S";
            clavier8 = "I";
            clavier9 = "M";
            clavier10 = "K";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "P";
            clavier16 = "E";
            clavier17 = "S";
            clavier18 = "L";
        }else if(levelS.equals("level=7x.9xn") || levelS.equals("level=7x.9xw")){
            image.setBackgroundResource(R.mipmap.level_7_9);

            answer1 = "SATAN";
            answer2 = "SATAN";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "S";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "N";
            clavier15 = "U";
            clavier16 = "W";
            clavier17 = "E";
            clavier18 = "J";
        }else if(levelS.equals("level=7x.10n") || levelS.equals("level=7x.10w")){
            image.setBackgroundResource(R.mipmap.level_7_10);

            answer1 = "FOLIE";
            answer2 = "FIOLE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "F";
        }else if(levelS.equals("level=8x.1xn") || levelS.equals("level=8x.1xw")){
            image.setBackgroundResource(R.mipmap.level_8_1);

            answer1 = "BULLE";
            answer2 = "BULLE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "B";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "L";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=8x.2xn") || levelS.equals("level=8x.2xw")){
            image.setBackgroundResource(R.mipmap.level_8_2);

            answer1 = "BRISE";
            answer2 = "SBIRE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=8x.3xn") || levelS.equals("level=8x.3xw")){
            image.setBackgroundResource(R.mipmap.level_8_3);

            answer1 = "DINDE";
            answer2 = "DINDE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=8x.4xn") || levelS.equals("level=8x.4xw")){
            image.setBackgroundResource(R.mipmap.level_8_4);

            answer1 = "SOUPE";
            answer2 = "SOUPE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=8x.5xn") || levelS.equals("level=8x.5xw")){
            image.setBackgroundResource(R.mipmap.level_8_5);

            answer1 = "BALAI";
            answer2 = "BALAI";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=8x.6xn") || levelS.equals("level=8x.6xw")){
            image.setBackgroundResource(R.mipmap.level_8_6);

            answer1 = "PATTE";
            answer2 = "PATTE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=8x.7xn") || levelS.equals("level=8x.7xw")){
            image.setBackgroundResource(R.mipmap.level_8_7);

            answer1 = "LAMPE";
            answer2 = "PALME";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=8x.8xn") || levelS.equals("level=8x.8xw")){
            image.setBackgroundResource(R.mipmap.level_8_8);

            answer1 = "LIVRE";
            answer2 = "LIVRE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "L";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "V";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "R";
        }else if(levelS.equals("level=8x.9xn") || levelS.equals("level=8x.9xw")){
            image.setBackgroundResource(R.mipmap.level_8_9);

            answer1 = "SOURIS";
            answer2 = "ROUSSI";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "R";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "O";
            clavier8 = "S";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "O";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "S";
        }else if(levelS.equals("level=8x.10n") || levelS.equals("level=8x.10w")){
            image.setBackgroundResource(R.mipmap.level_8_10);

            answer1 = "TUILE";
            answer2 = "UTILE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "U";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "I";
            clavier17 = "H";
            clavier18 = "E";

        }else if(levelS.equals("level=9x.1xn") || levelS.equals("level=9x.1xw")){
            image.setBackgroundResource(R.mipmap.level_9_1);

            answer1 = "MAJOR";
            answer2 = "MAJOR";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "Q";
            clavier18 = "L";
        }else if(levelS.equals("level=9x.2xn") || levelS.equals("level=9x.2xw")){
            image.setBackgroundResource(R.mipmap.level_9_2);

            answer1 = "ATOME";
            answer2 = "ATOME";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=9x.3xn") || levelS.equals("level=9x.3xw")){
            image.setBackgroundResource(R.mipmap.level_9_3);

            answer1 = "HERBE";
            answer2 = "HERBE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "E";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "H";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=9x.4xn") || levelS.equals("level=9x.4xw")){
            image.setBackgroundResource(R.mipmap.level_9_4);

            answer1 = "CLOWN";
            answer2 = "CLOWN";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "C";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "N";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "W";
            clavier17 = "H";
            clavier18 = "K";
        }else if(levelS.equals("level=9x.5xn") || levelS.equals("level=9x.5xw")){
            image.setBackgroundResource(R.mipmap.level_9_5);

            answer1 = "NIAIS";
            answer2 = "AINSI";
            clavier1 = "T";
            clavier2 = "N";
            clavier3 = "M";
            clavier4 = "I";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "W";
            clavier18 = "S";
        }else if(levelS.equals("level=9x.6xn") || levelS.equals("level=9x.6xw")){
            image.setBackgroundResource(R.mipmap.level_9_6);

            answer1 = "BULLE";
            answer2 = "BULLE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "L";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=9x.7xn") || levelS.equals("level=9x.7xw")){
            image.setBackgroundResource(R.mipmap.level_9_7);

            answer1 = "CHILI";
            answer2 = "CHILI";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "C";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "I";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=9x.8xn") || levelS.equals("level=9x.8xw")){
            image.setBackgroundResource(R.mipmap.level_9_8);

            answer1 = "MALLE";
            answer2 = "MALLE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "L";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";
        }else if(levelS.equals("level=9x.9xn") || levelS.equals("level=9x.9xw")){
            image.setBackgroundResource(R.mipmap.level_9_9);

            answer1 = "VIVRE";
            answer2 = "VIVRE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "V";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "V";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "K";
            clavier18 = "L";
        }else if(levelS.equals("level=9x.10n") || levelS.equals("level=9x.10w")){
            image.setBackgroundResource(R.mipmap.level_9_10);

            answer1 = "TARTE";
            answer2 = "RATTE";
            clavier1 = "T";
            clavier2 = "L";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "T";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "H";
            clavier18 = "L";


        }else if(levelS.equals("english=3x.1xn") || levelS.equals("english=3x.1xw")){

            image.setBackgroundResource(R.mipmap.level_3_1_ang);

            answer1 = "POWER";
            answer2 = "POWER";
            clavier1 = "E";
            clavier2 = "O";
            clavier3 = "Q";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "G";
            clavier7 = "A";
            clavier8 = "P";
            clavier9 = "Q";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "S";
            clavier13 = "W";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "E";
            clavier17 = "C";
            clavier18 = "E";

        }else if(levelS.equals("english=3x.2xn") || levelS.equals("english=3x.2xw")){

            image.setBackgroundResource(R.mipmap.level_3_2_ang);

            answer1 = "PHONE";
            answer2 = "PHEON";
            clavier1 = "U";
            clavier2 = "O";
            clavier3 = "I";
            clavier4 = "E";
            clavier5 = "R";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "H";
            clavier9 = "K";
            clavier10 = "I";
            clavier11 = "A";
            clavier12 = "N";
            clavier13 = "C";
            clavier14 = "L";
            clavier15 = "P";
            clavier16 = "O";
            clavier17 = "I";
            clavier18 = "R";

        }else if(levelS.equals("english=3x.3xn") || levelS.equals("english=3x.3xw")){

            image.setBackgroundResource(R.mipmap.level_3_3_ang);

            answer1 = "LEARN";
            answer2 = "RENAL";
            clavier1 = "E";
            clavier2 = "O";
            clavier3 = "M";
            clavier4 = "E";
            clavier5 = "L";
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

        }else if(levelS.equals("english=3x.4xn") || levelS.equals("english=3x.4xw")){

            image.setBackgroundResource(R.mipmap.level_3_4_ang);

            answer1 = "MOVIE";
            answer2 = "MOVIE";
            clavier1 = "E";
            clavier2 = "O";
            clavier3 = "Q";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "S";
            clavier9 = "V";
            clavier10 = "A";
            clavier11 = "D";
            clavier12 = "S";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "I";
            clavier17 = "M";
            clavier18 = "U";

        }else if(levelS.equals("english=3x.5xn") || levelS.equals("english=3x.5xw")){

            image.setBackgroundResource(R.mipmap.level_3_5_ang);

            answer1 = "SMALL";
            answer2 = "SMALL";
            clavier1 = "D";
            clavier2 = "L";
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
            clavier16 = "M";
            clavier17 = "P";
            clavier18 = "E";

        }else if(levelS.equals("english=3x.6xn") || levelS.equals("english=3x.6xw")){

            image.setBackgroundResource(R.mipmap.level_3_6_ang);

            answer1 = "TRUTH";
            answer2 = "TRUTH";
            clavier1 = "N";
            clavier2 = "O";
            clavier3 = "T";
            clavier4 = "E";
            clavier5 = "T";
            clavier6 = "H";
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
            clavier17 = "T";
            clavier18 = "M";

        }else if(levelS.equals("english=3x.7xn") || levelS.equals("english=3x.7xw")){

            image.setBackgroundResource(R.mipmap.level_3_7_ang);

            answer1 = "WHITE";
            answer2 = "WHITE";
            clavier1 = "H";
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
            clavier17 = "W";
            clavier18 = "I";


        }else if(levelS.equals("english=3x.8xn") || levelS.equals("english=3x.8xw")){

            image.setBackgroundResource(R.mipmap.level_3_8_ang);

            answer1 = "WOMAN";
            answer2 = "WOMAN";
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
            clavier12 = "N";
            clavier13 = "X";
            clavier14 = "U";
            clavier15 = "R";
            clavier16 = "G";
            clavier17 = "M";
            clavier18 = "E";

        }else if(levelS.equals("english=3x.9xn") || levelS.equals("english=3x.9xw")){

            image.setBackgroundResource(R.mipmap.level_3_9_ang);

            answer1 = "TOWEL";
            answer2 = "OWLET";
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

        }else if(levelS.equals("english=3x.10n") || levelS.equals("english=3x.10w")){

            image.setBackgroundResource(R.mipmap.level_3_10_ang);

            answer1 = "GLASS";
            answer2 = "GLASS";
            clavier1 = "E";
            clavier2 = "G";
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
            clavier16 = "S";
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
                    if(focusSaisie < 5){
                        button1.setBackgroundResource(R.mipmap.clavier_orange_pressed);
                        isButton1Pressed = true;
                        carac = button1.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();
                    }else {
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
                    if(focusSaisie < 5){
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton2Pressed = false;
                    removeCharacter(button2);
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
                    if(focusSaisie < 5){
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
                    button2.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton2Pressed = false;
                    removeCharacter(button2);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }
            }
        });

        // FIN - Activation des boutons

        // Activation zone de saisie

        saisie1 = (android.widget.Button) findViewById(R.id.blue_button1);
        saisie2 = (android.widget.Button) findViewById(R.id.blue_button2);
        saisie3 = (android.widget.Button) findViewById(R.id.blue_button3);
        saisie4 = (android.widget.Button) findViewById(R.id.blue_button4);
        saisie5 = (android.widget.Button) findViewById(R.id.blue_button5);

        focusSaisie = 0;



        undo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(levelS.charAt(6) == '2'){
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "4");
                    Intent undo = new Intent(FiveLettersLevel.this, ChooseLevelMenu.class);
                    undo.putExtras(objetbunble);
                    startActivity(undo);
                    finish();
                }else{
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "5");
                    Intent undo = new Intent(FiveLettersLevel.this, ChooseLevelMenu.class);
                    undo.putExtras(objetbunble);
                    startActivity(undo);
                    finish();
                }
            }
        });

        clue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clueMode == true) {
                    saisie1.setBackgroundResource(R.mipmap.saisie_clue);
                    saisie2.setBackgroundResource(R.mipmap.saisie_clue);
                    saisie3.setBackgroundResource(R.mipmap.saisie_clue);
                    saisie4.setBackgroundResource(R.mipmap.saisie_clue);
                    saisie5.setBackgroundResource(R.mipmap.saisie_clue);
                    updateSaisie();
                    usedClues = usedClues - 1;
                    nbOfClues++;
                    clueMode = false;
                    setClueNb(nbOfClues);
                    setClueButtonBackground(usedClues, nbOfClues);
                }else if(nbOfClues == 0){

                }else if(usedClues < 2){
                    saisie1.setBackgroundResource(R.mipmap.saisie);
                    saisie1.setText(" ");
                    saisie2.setBackgroundResource(R.mipmap.saisie);
                    saisie2.setText(" ");
                    saisie3.setBackgroundResource(R.mipmap.saisie);
                    saisie3.setText(" ");
                    saisie4.setBackgroundResource(R.mipmap.saisie);
                    saisie4.setText(" ");
                    saisie5.setBackgroundResource(R.mipmap.saisie);
                    saisie5.setText(" ");
                    clueMode = true;

                    usedClues++;
                    nbOfClues = nbOfClues - 1;
                    setClueNb(nbOfClues);
                    setClueButtonBackground(usedClues, nbOfClues);
                }else{

                }
            }
        });




        saisie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clueMode == false){
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
                    saisie1.setTextColor(Color.GRAY);
                    saisie1.setBackgroundResource(R.mipmap.saisie);
                    saisie2.setBackgroundResource(R.mipmap.saisie);
                    saisie3.setBackgroundResource(R.mipmap.saisie);
                    saisie4.setBackgroundResource(R.mipmap.saisie);
                    saisie5.setBackgroundResource(R.mipmap.saisie);
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
                    saisie2.setTextColor(Color.GRAY);
                    saisie1.setBackgroundResource(R.mipmap.saisie);
                    saisie2.setBackgroundResource(R.mipmap.saisie);
                    saisie3.setBackgroundResource(R.mipmap.saisie);
                    saisie4.setBackgroundResource(R.mipmap.saisie);
                    saisie5.setBackgroundResource(R.mipmap.saisie);
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
                    if(saisie3.getText().charAt(0) != ' ' && isSaisie3Locked == false){
                        carac = saisie3.getText().charAt(0);
                        saisie[2] = ' ';
                        releaseButton(carac);
                        updateSaisie();
                        determineFocusSaisie();
                    }else{

                    }
                }else{
                    clueMode = false;
                    saisie[2] = answer1.charAt(2);
                    saisie2.setTextColor(Color.GRAY);
                    saisie1.setBackgroundResource(R.mipmap.saisie);
                    saisie2.setBackgroundResource(R.mipmap.saisie);
                    saisie3.setBackgroundResource(R.mipmap.saisie);
                    saisie4.setBackgroundResource(R.mipmap.saisie);
                    saisie5.setBackgroundResource(R.mipmap.saisie);
                    updateSaisie();
                    determineFocusSaisie();
                    isWon();
                }
            }
        });

        saisie4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clueMode == false){
                    char carac;
                    if (saisie4.getText().charAt(0) != ' ' && isSaisie4Locked == false) {
                        carac = saisie4.getText().charAt(0);
                        saisie[3] = ' ';
                        releaseButton(carac);
                        updateSaisie();
                        determineFocusSaisie();
                    } else {

                    }
                }else{
                    clueMode = false;
                    saisie[3] = answer1.charAt(3);
                    saisie4.setTextColor(Color.GRAY);
                    saisie1.setBackgroundResource(R.mipmap.saisie);
                    saisie2.setBackgroundResource(R.mipmap.saisie);
                    saisie3.setBackgroundResource(R.mipmap.saisie);
                    saisie4.setBackgroundResource(R.mipmap.saisie);
                    saisie5.setBackgroundResource(R.mipmap.saisie);
                    updateSaisie();
                    determineFocusSaisie();
                    isWon();
                }
            }
        });

        saisie5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clueMode == false){
                    char carac;
                    if (saisie5.getText().charAt(0) != ' ' && isSaisie5Locked == false) {
                        carac = saisie5.getText().charAt(0);
                        saisie[4] = ' ';
                        releaseButton(carac);
                        updateSaisie();
                        determineFocusSaisie();
                    } else {

                    }
                }else{
                    clueMode = false;
                    saisie[4] = answer1.charAt(4);
                    saisie5.setTextColor(Color.GRAY);
                    saisie1.setBackgroundResource(R.mipmap.saisie);
                    saisie2.setBackgroundResource(R.mipmap.saisie);
                    saisie3.setBackgroundResource(R.mipmap.saisie);
                    saisie4.setBackgroundResource(R.mipmap.saisie);
                    saisie5.setBackgroundResource(R.mipmap.saisie);
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
            button14.setBackgroundResource(R.mipmap.clavier_jaune);
            isButton14Pressed = false;
        }else if(button15.getText().charAt(0) == carac && isButton15Pressed == true){
            button15.setBackgroundResource(R.mipmap.clavier_orange);
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
        }else if(saisie[3] == ' '){
            focus = 3;
        }else if(saisie[4] == ' '){
            focus = 4;
        }else{
            focus = 5;
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

        String string3 = Character.toString(saisie[3]);
        saisie4.setText(string3);

        String string4 = Character.toString(saisie[4]);
        saisie5.setText(string4);





    }

    public void removeCharacter(android.widget.Button button){

        // Chercher le caractere a supprimer
        int index;
        if(saisie[0] == button.getText().charAt(0)){
            index = 0;
        }else if(saisie[1] == button.getText().charAt(0)){
            index = 1;
        }else if(saisie[2] == button.getText().charAt(0)){
            index = 2;
        }else{
            index = 3;
        }
        // Supprmier le caractère
        saisie[index] = ' ';

    }

    public void win(){

        //création de notre item
        Intent defineIntent = new Intent(FiveLettersLevel.this, WinActivity.class);
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
        if(saisie[0] == answer1.charAt(0) && saisie[1] == answer1.charAt(1) && saisie[2] == answer1.charAt(2) && saisie[3] == answer1.charAt(3) && saisie[4] == answer1.charAt(4)){
            win();
        }else if(saisie[0] == answer2.charAt(0) && saisie[1] == answer2.charAt(1) && saisie[2] == answer2.charAt(2) && saisie[3] == answer2.charAt(3) && saisie[4] == answer2.charAt(4)){
            win();

        }else{

            }
    }

    public static FiveLettersLevel getInstance(){
        return FiveLettersLevel;
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





}