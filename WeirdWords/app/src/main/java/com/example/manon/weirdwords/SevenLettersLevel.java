package com.example.manon.weirdwords;

import android.content.Intent;
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

public class SevenLettersLevel extends AppCompatActivity implements View.OnClickListener{


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
    private android.widget.Button saisie6;
    private android.widget.Button saisie7;


    // Parametrage zone de saisie
    private int focusSaisie = 0;
    private char[] saisie = {' ', ' ', ' ', ' ', ' ', ' ', ' '};
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

    static SevenLettersLevel SevenLettersLevel;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_seven_letters_level);
        SevenLettersLevel = this;


        image = (ImageView)findViewById(R.id.level_image);

        Bundle objetbunble  = this.getIntent().getExtras();
        // recupération de la valeur
        levelS = objetbunble.getString("passInfo");

        // Init boutons toolbar
        undo_button = (ImageButton)findViewById(R.id.undo_button);
        clue_button = (ImageButton)findViewById(R.id.clue_button);
        param_button = (ImageButton)findViewById(R.id.param_button);

        if(levelS.charAt(11) == 'w'){
            WinActivity.getInstance().finish();
        }else{
            ChooseLevelMenu.getInstance().finish();
        }


        // Personnalisation image
        if(levelS.equals("level=10.1xn") || levelS.equals("level=10.1xw") || levelS.equals(null)){

            answer1 = "POISSON";
            answer2 = "POISSON";
            image.setBackgroundResource(R.mipmap.level_10_1);

            clavier1 = "L";
            clavier2 = "O";
            clavier3 = "P";
            clavier4 = "T";
            clavier5 = "P";
            clavier6 = "Q";
            clavier7 = "A";
            clavier8 = "U";
            clavier9 = "S";
            clavier10 = "Z";
            clavier11 = "K";
            clavier12 = "W";
            clavier13 = "M";
            clavier14 = "F";
            clavier15 = "T";
            clavier16 = "X";
            clavier17 = "Y";
            clavier18 = "T";


        }else if(levelS.equals("level=10.2xn") || levelS.equals("level=10.2xw")) {
            image.setBackgroundResource(R.mipmap.level_10_2);

            answer1 = "CRAVATE";
            answer2 = "CRAVATE";
            clavier1 = "P";
            clavier2 = "S";
            clavier3 = "A";
            clavier4 = "Y";
            clavier5 = "V";
            clavier6 = "R";
            clavier7 = "A";
            clavier8 = "L";
            clavier9 = "I";
            clavier10 = "A";
            clavier11 = "V";
            clavier12 = "R";
            clavier13 = "F";
            clavier14 = "L";
            clavier15 = "Z";
            clavier16 = "E";
            clavier17 = "V";
            clavier18 = "G";

        }else if(levelS.equals("level=10.3xn") || levelS.equals("level=10.3xw")){

            image.setBackgroundResource(R.mipmap.level_10_3);

            answer1 = "FAMILLE";
            answer2 = "FAMILLE";
            clavier1 = "F";
            clavier2 = "O";
            clavier3 = "A";
            clavier4 = "E";
            clavier5 = "B";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "K";
            clavier9 = "W";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "K";
            clavier13 = "B";
            clavier14 = "G";
            clavier15 = "Y";
            clavier16 = "E";
            clavier17 = "P";
            clavier18 = "E";

        }else if(levelS.equals("level=10.4xn") || levelS.equals("level=10.4xw")){

            image.setBackgroundResource(R.mipmap.level_10_4);

            answer1 = "CLAVIER";
            answer2 = "CLAVIER";
            clavier1 = "M";
            clavier2 = "T";
            clavier3 = "S";
            clavier4 = "U";
            clavier5 = "O";
            clavier6 = "J";
            clavier7 = "I";
            clavier8 = "E";
            clavier9 = "S";
            clavier10 = "C";
            clavier11 = "N";
            clavier12 = "F";
            clavier13 = "S";
            clavier14 = "W";
            clavier15 = "R";
            clavier16 = "H";
            clavier17 = "X";
            clavier18 = "I";
        }else if(levelS.equals("level=10.5xn") || levelS.equals("level=10.5xw")){
            image.setBackgroundResource(R.mipmap.level_10_5);

            answer1 = "ALIMENT";
            answer2 = "ALIMENT";
            clavier1 = "B";
            clavier2 = "T";
            clavier3 = "D";
            clavier4 = "U";
            clavier5 = "N";
            clavier6 = "O";
            clavier7 = "E";
            clavier8 = "P";
            clavier9 = "S";
            clavier10 = "A";
            clavier11 = "W";
            clavier12 = "I";
            clavier13 = "E";
            clavier14 = "L";
            clavier15 = "H";
            clavier16 = "E";
            clavier17 = "N";
            clavier18 = "A";
        }else if(levelS.equals("level=10.6xn") || levelS.equals("level=10.6xw")){
            image.setBackgroundResource(R.mipmap.level_10_6);

            answer1 = "POTERIE";
            answer2 = "POTERIE";
            clavier1 = "M";
            clavier2 = "A";
            clavier3 = "I";
            clavier4 = "K";
            clavier5 = "E";
            clavier6 = "H";
            clavier7 = "K";
            clavier8 = "T";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "H";
            clavier12 = "T";
            clavier13 = "R";
            clavier14 = "I";
            clavier15 = "R";
            clavier16 = "U";
            clavier17 = "A";
            clavier18 = "J";
        }else if(levelS.equals("level=10.7xn") || levelS.equals("level=10.7xw")){
            image.setBackgroundResource(R.mipmap.level_10_7);

            answer1 = "INSECTE";
            answer2 = "INSECTE";
            clavier1 = "M";
            clavier2 = "T";
            clavier3 = "D";
            clavier4 = "B";
            clavier5 = "E";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "K";
            clavier9 = "O";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "M";
            clavier13 = "P";
            clavier14 = "L";
            clavier15 = "C";
            clavier16 = "E";
            clavier17 = "N";
            clavier18 = "R";
        }else if(levelS.equals("level=10.8xn") || levelS.equals("level=10.8xw")){
            image.setBackgroundResource(R.mipmap.level_10_8);

            answer1 = "ANALYSE";
            answer2 = "ANALYSE";
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

        }else if(levelS.equals("level=10.9xn") || levelS.equals("level=10.9xw")){
            image.setBackgroundResource(R.mipmap.level_10_9);

            answer1 = "CHEMISE";
            answer2 = "CHEMISE";
            clavier1 = "W";
            clavier2 = "N";
            clavier3 = "T";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "A";
            clavier7 = "M";
            clavier8 = "O";
            clavier9 = "R";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "X";
            clavier14 = "S";
            clavier15 = "U";
            clavier16 = "S";
            clavier17 = "H";
            clavier18 = "U";

        }else if(levelS.equals("level=10.10n") || levelS.equals("level=10.10w")){
            image.setBackgroundResource(R.mipmap.level_10_10);

            answer1 = "LANGAGE";
            answer2 = "LANGAGE";
            clavier1 = "T";
            clavier2 = "K";
            clavier3 = "M";
            clavier4 = "U";
            clavier5 = "F";
            clavier6 = "J";
            clavier7 = "I";
            clavier8 = "Y";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "C";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "D";
            clavier16 = "E";
            clavier17 = "O";
            clavier18 = "L";

        }else if(levelS.equals("level=11.1xn") || levelS.equals("level=11.1xw")){
            image.setBackgroundResource(R.mipmap.level_0_0);

            answer1 = "XXXXXXX";
            answer2 = "XXXXXXX";
            clavier1 = "S";
            clavier2 = "T";
            clavier3 = "F";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "O";
            clavier7 = "S";
            clavier8 = "U";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "R";
            clavier13 = "M";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "B";
            clavier18 = "P";

        }else if(levelS.equals("level=11.2xn") || levelS.equals("level=11.2xw")){
            image.setBackgroundResource(R.mipmap.level_0_0);

            answer1 = "XXXXXXX";
            answer2 = "XXXXXXX";
            clavier1 = "Z";
            clavier2 = "R";
            clavier3 = "P";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "A";
            clavier8 = "J";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "Z";
            clavier13 = "Y";
            clavier14 = "G";
            clavier15 = "T";
            clavier16 = "E";
            clavier17 = "F";
            clavier18 = "L";

        }else if(levelS.equals("level=11.3xn") || levelS.equals("level=11.3xw")){
            image.setBackgroundResource(R.mipmap.level_0_0);

            answer1 = "XXXXXXX";
            answer2 = "XXXXXXX";
            clavier1 = "I";
            clavier2 = "F";
            clavier3 = "M";
            clavier4 = "S";
            clavier5 = "D";
            clavier6 = "K";
            clavier7 = "A";
            clavier8 = "D";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "I";
            clavier12 = "Q";
            clavier13 = "S";
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "N";
            clavier18 = "L";

        }else if(levelS.equals("level=11.4xn") || levelS.equals("level=11.4xw")){
            image.setBackgroundResource(R.mipmap.level_0_0);

            answer1 = "XXXXXXX";
            answer2 = "XXXXXXX";
            clavier1 = "T";
            clavier2 = "M";
            clavier3 = "I";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "J";
            clavier7 = "M";
            clavier8 = "O";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "G";
            clavier12 = "R";
            clavier13 = "B";
            clavier14 = "Y";
            clavier15 = "Q";
            clavier16 = "O";
            clavier17 = "E";
            clavier18 = "L";

        }else if(levelS.equals("level=11.5xn") || levelS.equals("level=11.5xw")){
            image.setBackgroundResource(R.mipmap.level_0_0);

            answer1 = "XXXXXXX";
            answer2 = "XXXXXXX";
            clavier1 = "P";
            clavier2 = "A";
            clavier3 = "L";
            clavier4 = "U";
            clavier5 = "P";
            clavier6 = "B";
            clavier7 = "A";
            clavier8 = "D";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "W";
            clavier12 = "R";
            clavier13 = "E";
            clavier14 = "I";
            clavier15 = "K";
            clavier16 = "E";
            clavier17 = "B";
            clavier18 = "L";

        }else if(levelS.equals("level=11.6xn") || levelS.equals("level=11.6xw")){
            image.setBackgroundResource(R.mipmap.level_0_0);

            answer1 = "XXXXXXX";
            answer2 = "XXXXXXX";
            clavier1 = "T";
            clavier2 = "M";
            clavier3 = "R";
            clavier4 = "U";
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

        }else if(levelS.equals("level=11.7xn") || levelS.equals("level=11.7xw")){
            image.setBackgroundResource(R.mipmap.level_0_0);

            answer1 = "XXXXXXX";
            answer2 = "XXXXXXX";
            clavier1 = "T";
            clavier2 = "M";
            clavier3 = "R";
            clavier4 = "U";
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

        }else if(levelS.equals("level=11.8xn") || levelS.equals("level=11.8xw")){
            image.setBackgroundResource(R.mipmap.level_0_0);

            answer1 = "XXXXXXX";
            answer2 = "XXXXXXX";
            clavier1 = "T";
            clavier2 = "M";
            clavier3 = "R";
            clavier4 = "U";
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

        }else if(levelS.equals("level=11.9xn") || levelS.equals("level=11.9xw")){
            image.setBackgroundResource(R.mipmap.level_0_0);

            answer1 = "XXXXXXX";
            answer2 = "XXXXXXX";
            clavier1 = "T";
            clavier2 = "M";
            clavier3 = "R";
            clavier4 = "U";
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

        }else if(levelS.equals("level=11.10n") || levelS.equals("level=11.10w")){
            image.setBackgroundResource(R.mipmap.level_0_0);

            answer1 = "XXXXXXX";
            answer2 = "XXXXXXX";
            clavier1 = "T";
            clavier2 = "M";
            clavier3 = "R";
            clavier4 = "U";
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
                    if(focusSaisie < 7){
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

                }else{
                    button1.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton1Pressed = false;
                    removeCharacter(button1);
                    updateSaisie();
                    determineFocusSaisie();
                }

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton2Pressed == false && clueMode == false){
                    if(focusSaisie < 7){
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

                }else{
                    button2.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton2Pressed = false;
                    removeCharacter(button2);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton3Pressed == false && clueMode == false){
                    if(focusSaisie < 7){
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

                }else{
                    button3.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton3Pressed = false;
                    removeCharacter(button3);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton4Pressed == false && clueMode == false){
                    if(focusSaisie < 7){
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

                }else{
                    button4.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton4Pressed = false;
                    removeCharacter(button4);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });



        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton5Pressed == false && clueMode == false){
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_vert);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_orange);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
                    if(focusSaisie < 7){
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
                    button1.setBackgroundResource(R.mipmap.clavier_jaune);
                    isButton1Pressed = false;
                    removeCharacter(button1);
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
        saisie6 = (android.widget.Button) findViewById(R.id.blue_button6);
        saisie7 = (android.widget.Button) findViewById(R.id.blue_button7);

        focusSaisie = 0;


        undo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(levelS.charAt(6) == '2'){
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "10");
                    Intent undo = new Intent(SevenLettersLevel.this, ChooseLevelMenu.class);
                    undo.putExtras(objetbunble);
                    startActivity(undo);
                    finish();
                }else{
                    Bundle objetbunble = new Bundle();
                    objetbunble.putString("passInfo", "11");
                    Intent undo = new Intent(SevenLettersLevel.this, ChooseLevelMenu.class);
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
                    saisie1.setBackgroundResource(R.mipmap.button_blue);
                    saisie2.setBackgroundResource(R.mipmap.button_blue);
                    saisie3.setBackgroundResource(R.mipmap.button_blue);
                    saisie4.setBackgroundResource(R.mipmap.button_blue);
                    saisie5.setBackgroundResource(R.mipmap.button_blue);
                    saisie6.setBackgroundResource(R.mipmap.button_blue);
                    saisie7.setBackgroundResource(R.mipmap.button_blue);
                    updateSaisie();
                    usedClues = usedClues - 1;
                    nbOfClues++;
                    clueMode = false;
                    setClueNb(nbOfClues, pass);
                    setClueButtonBackground(usedClues, nbOfClues);
                }else if(nbOfClues == 0){

                }else if(usedClues < 2){
                    saisie1.setBackgroundResource(R.mipmap.button_blue_enabled);
                    saisie1.setText("?");
                    saisie2.setBackgroundResource(R.mipmap.button_blue_enabled);
                    saisie2.setText("?");
                    saisie3.setBackgroundResource(R.mipmap.button_blue_enabled);
                    saisie3.setText("?");
                    saisie4.setBackgroundResource(R.mipmap.button_blue_enabled);
                    saisie4.setText("?");
                    saisie5.setBackgroundResource(R.mipmap.button_blue_enabled);
                    saisie5.setText("?");
                    saisie6.setBackgroundResource(R.mipmap.button_blue_enabled);
                    saisie6.setText("?");
                    saisie7.setBackgroundResource(R.mipmap.button_blue_enabled);
                    saisie7.setText("?");
                    clueMode = true;

                    usedClues++;
                    nbOfClues = nbOfClues - 1;
                    setClueNb(nbOfClues, pass);
                    setClueButtonBackground(usedClues, nbOfClues);
                }else{

                }
            }
        });


        saisie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char carac;
                if (saisie1.getText().charAt(0) != ' ') {
                    carac = saisie1.getText().charAt(0);
                    saisie[0] = ' ';
                    releaseButton(carac);
                    updateSaisie();
                    determineFocusSaisie();
                } else {

                }
            }
        });

        saisie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char carac;
                if(saisie2.getText().charAt(0) != ' '){
                    carac = saisie2.getText().charAt(0);
                    saisie[1] = ' ';
                    releaseButton(carac);
                    updateSaisie();
                    determineFocusSaisie();
                }else{

                }


            }
        });

        saisie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char carac;
                if (saisie3.getText().charAt(0) != ' ') {
                    carac = saisie3.getText().charAt(0);
                    saisie[2] = ' ';
                    releaseButton(carac);
                    updateSaisie();
                    determineFocusSaisie();
                } else {

                }
            }
        });

        saisie4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char carac;
                if (saisie4.getText().charAt(0) != ' ') {
                    carac = saisie4.getText().charAt(0);
                    saisie[3] = ' ';
                    releaseButton(carac);
                    updateSaisie();
                    determineFocusSaisie();
                } else {

                }
            }
        });

        saisie5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char carac;
                if (saisie5.getText().charAt(0) != ' ') {
                    carac = saisie5.getText().charAt(0);
                    saisie[4] = ' ';
                    releaseButton(carac);
                    updateSaisie();
                    determineFocusSaisie();
                } else {

                }
            }
        });

        saisie6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char carac;
                if (saisie6.getText().charAt(0) != ' ') {
                    carac = saisie6.getText().charAt(0);
                    saisie[5] = ' ';
                    releaseButton(carac);
                    updateSaisie();
                    determineFocusSaisie();
                } else {

                }
            }
        });

        saisie7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char carac;
                if (saisie7.getText().charAt(0) != ' ') {
                    carac = saisie7.getText().charAt(0);
                    saisie[6] = ' ';
                    releaseButton(carac);
                    updateSaisie();
                    determineFocusSaisie();
                } else {

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
        }else if(saisie[3] == ' '){
            focus = 3;
        }else if(saisie[4] == ' '){
            focus = 4;
        }else if(saisie[5] == ' '){
            focus = 5;
        }else if(saisie[6] == ' '){
            focus = 6;
        }else{
            focus = 7;
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

        String string5 = Character.toString(saisie[5]);
        saisie6.setText(string5);

        String string6 = Character.toString(saisie[6]);
        saisie7.setText(string6);





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
        }else if(saisie[3] == button.getText().charAt(0)){
            index = 3;
        }else if(saisie[4] == button.getText().charAt(0)){
            index = 4;
        }else if(saisie[5] == button.getText().charAt(0)){
            index = 5;
        }else{
            index = 6;
        }
        // Supprmier le caractère
        saisie[index] = ' ';

    }

    public void win(){

        //création de notre item
        Intent defineIntent = new Intent(SevenLettersLevel.this, WinActivity.class);
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
        if(saisie[0] == answer1.charAt(0) && saisie[1] == answer1.charAt(1) && saisie[2] == answer1.charAt(2) && saisie[3] == answer1.charAt(3) && saisie[4] == answer1.charAt(4) && saisie[5] == answer1.charAt(5) && saisie[6] == answer1.charAt(6)){
            win();
        }else if(saisie[0] == answer2.charAt(0) && saisie[1] == answer2.charAt(1) && saisie[2] == answer2.charAt(2) && saisie[3] == answer2.charAt(3) && saisie[4] == answer2.charAt(4) && saisie[5] == answer2.charAt(5) && saisie[6] == answer2.charAt(6)){
            win();
        }else{

        }
    }

    public static SevenLettersLevel getInstance(){
        return SevenLettersLevel;
    }

    public void setClueNb(int nbOfClues, String param){


        FileOutputStream output = null;
        String clueNb = new String("" + nbOfClues);

        // Traitement clueNb
        if(nbOfClues < 10){
            clueNb = clueNb +"xx";
        }else if(nbOfClues < 100){
            clueNb = clueNb + "x";
        }else{

        }


        // Traitement param
        param = param.substring(0, param.length() - 3);
        param = param + clueNb;


        try {
            output = openFileOutput("USERINFOS", MODE_PRIVATE);
            output.write(param.getBytes());
            if(output != null)
                output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public int getClueNb(){

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
        if(clueNb.charAt(2) != 'x'){
            clueNb = "" + clueNb.charAt(0) + clueNb.charAt(1) + clueNb.charAt(2);
        }else if(clueNb.charAt(1) != 'x'){
            clueNb = "" + clueNb.charAt(0) + clueNb.charAt(1);
        }else{
            clueNb = "" + clueNb.charAt(0);
        }

        // Determiner nbOfClues et adapter le bouton
        nbOfClues = Integer.parseInt(clueNb);
        setClueButtonBackground(usedClues, nbOfClues);

        return nbOfClues;

    }

    public void setClueButtonBackground(int usedClues,int nbOfClues){
        boolean isEnabled;
        if(usedClues <= 2){
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






}