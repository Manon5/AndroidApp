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
    private String answer;
    private int level;
    private ImageView image = null;
    private double randomD;
    private int randomI;
    private int nbOfClues;
    private int usedClues;


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
    private String pass2;
    private String clueInfo;

    static ThreeLettersLevel ThreeLettersLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_three_letters_level);
        ThreeLettersLevel = this;


        image = (ImageView)findViewById(R.id.level_image);

        Bundle objetbunble  = this.getIntent().getExtras();
        // récupération de la valeur
        pass = objetbunble.getString("passInfo");
        System.out.print(pass);

        levelS = pass.substring(0, 10);
        System.out.print(levelS);
        clueInfo = pass.substring(10);
        System.out.print(clueInfo);


        // Init boutons toolbar
        undo_button = (ImageButton)findViewById(R.id.undo_button);
        clue_button = (ImageButton)findViewById(R.id.indice_button);
        param_button = (ImageButton)findViewById(R.id.param_button);

        usedClues = 0;

        if(clueInfo.charAt(7) == '0'){
            nbOfClues = 0;
        }else if(clueInfo.charAt(7) == '1'){
            nbOfClues = 1;
        }else if(clueInfo.charAt(7) == '2'){
            nbOfClues = 2;
        }else if(clueInfo.charAt(7) == '3'){
            nbOfClues = 3;
        }else if(clueInfo.charAt(7) == '4'){
            nbOfClues = 4;
        }else if(clueInfo.charAt(7) == '5'){
            nbOfClues = 5;
        }else if(clueInfo.charAt(7) == '6'){
            nbOfClues = 6;
        }else{
            nbOfClues = 7;
        }

        setClueButtonBackground(true, nbOfClues);


        if(levelS.charAt(9) == 'w'){
            WinActivity.getInstance().finish();
        }else{

        }


        // Personnalisation image
        if(levelS.equals("level 1.1n") || levelS.equals("level 1.1w") || levelS.equals(null)){

            answer = "BAR";
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


        }else if(levelS.equals("level 1.2n") || levelS.equals("level 1.2w")) {
            image.setBackgroundResource(R.mipmap.level_1_2);
            answer = "LIT";
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

        }else if(levelS.equals("level 1.3n") || levelS.equals("level 1.3w")){

            image.setBackgroundResource(R.mipmap.level_1_3);

            answer = "RAT";
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
            clavier11 = "I";
            clavier12 = "S";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "R";
            clavier16 = "E";
            clavier17 = "P";
            clavier18 = "E";

        }else if(levelS.equals("level 1.4n") || levelS.equals("level 1.4w")){

            image.setBackgroundResource(R.mipmap.level_1_4);

            answer = "FOU";
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
            clavier17 = "M";
            clavier18 = "K";
        }else if(levelS.equals("level 1.5n") || levelS.equals("level 1.5w")){
            image.setBackgroundResource(R.mipmap.level_1_5);
            answer = "MER";
            clavier1 = "R";
            clavier2 = "T";
            clavier3 = "H";
            clavier4 = "U";
            clavier5 = "E";
            clavier6 = "S";
            clavier7 = "E";
            clavier8 = "P";
            clavier9 = "M";
            clavier10 = "A";
            clavier11 = "W";
            clavier12 = "F";
            clavier13 = "B";
            clavier14 = "L";
            clavier15 = "X";
            clavier16 = "E";
            clavier17 = "M";
            clavier18 = "O";
        }else if(levelS.equals("level 1.6n") || levelS.equals("level 1.6w")){
        image.setBackgroundResource(R.mipmap.level_1_6);

            answer = "BUS";
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
        clavier11 = "Q";
        clavier12 = "F";
        clavier13 = "B";
        clavier14 = "L";
        clavier15 = "R";
        clavier16 = "U";
        clavier17 = "M";
        clavier18 = "P";
    }else if(levelS.equals("level 1.7n") || levelS.equals("level 1.7w")){
            image.setBackgroundResource(R.mipmap.level_1_7);
            answer = "ROC";
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
        }else if(levelS.equals("level 1.8n") || levelS.equals("level 1.8w")){
            image.setBackgroundResource(R.mipmap.level_1_8);

            answer = "TOT";
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
            clavier14 = "L";
            clavier15 = "U";
            clavier16 = "E";
            clavier17 = "I";
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
                      if(isButton1Pressed == false){
                          if(focusSaisie < 3){
                              button1.setBackgroundResource(R.mipmap.small_button_pressed);
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
                          button1.setBackgroundResource(R.mipmap.small_button);
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
                    if(isButton2Pressed == false){
                        if(focusSaisie < 3){
                            button2.setBackgroundResource(R.mipmap.small_button_pressed);
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
                        button2.setBackgroundResource(R.mipmap.small_button);
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
                if(isButton3Pressed == false){
                    if(focusSaisie < 3){
                        button3.setBackgroundResource(R.mipmap.small_button_pressed);
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
                    button3.setBackgroundResource(R.mipmap.small_button);
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
                if(isButton4Pressed == false){
                    if(focusSaisie < 3){
                        button4.setBackgroundResource(R.mipmap.small_button_pressed);
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
                    button4.setBackgroundResource(R.mipmap.small_button);
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
                if(isButton5Pressed == false){
                    if(focusSaisie < 3){
                        button5.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton5Pressed = true;
                        carac = button5.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button5.setBackgroundResource(R.mipmap.small_button);
                    isButton5Pressed = false;
                    removeCharacter(button5);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton6Pressed == false){
                    if(focusSaisie < 3){
                        button6.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton6Pressed = true;
                        carac = button6.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button6.setBackgroundResource(R.mipmap.small_button);
                    isButton6Pressed = false;
                    removeCharacter(button6);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton7Pressed == false){
                    if(focusSaisie < 3){
                        button7.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton7Pressed = true;
                        carac = button7.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button7.setBackgroundResource(R.mipmap.small_button);
                    isButton7Pressed = false;
                    removeCharacter(button7);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton8Pressed == false){
                    if(focusSaisie < 3){
                        button8.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton8Pressed = true;
                        carac = button8.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button8.setBackgroundResource(R.mipmap.small_button);
                    isButton8Pressed = false;
                    removeCharacter(button8);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton9Pressed == false){
                    if(focusSaisie < 3){
                        button9.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton9Pressed = true;
                        carac = button9.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button9.setBackgroundResource(R.mipmap.small_button);
                    isButton9Pressed = false;
                    removeCharacter(button9);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton10Pressed == false){
                    if(focusSaisie < 3){
                        button10.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton10Pressed = true;
                        carac = button10.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button10.setBackgroundResource(R.mipmap.small_button);
                    isButton10Pressed = false;
                    removeCharacter(button10);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton11Pressed == false){
                    if(focusSaisie < 3){
                        button11.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton11Pressed = true;
                        carac = button11.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button11.setBackgroundResource(R.mipmap.small_button);
                    isButton11Pressed = false;
                    removeCharacter(button11);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton12Pressed == false){
                    if(focusSaisie < 3){
                        button12.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton12Pressed = true;
                        carac = button12.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button12.setBackgroundResource(R.mipmap.small_button);
                    isButton12Pressed = false;
                    removeCharacter(button12);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton13Pressed == false){
                    if(focusSaisie < 3){
                        button13.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton13Pressed = true;
                        carac = button13.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button13.setBackgroundResource(R.mipmap.small_button);
                    isButton13Pressed = false;
                    removeCharacter(button13);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton14Pressed == false){
                    if(focusSaisie < 3){
                        button14.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton14Pressed = true;
                        carac = button14.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button14.setBackgroundResource(R.mipmap.small_button);
                    isButton14Pressed = false;
                    removeCharacter(button14);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton15Pressed == false){
                    if(focusSaisie < 3){
                        button15.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton15Pressed = true;
                        carac = button15.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button15.setBackgroundResource(R.mipmap.small_button);
                    isButton15Pressed = false;
                    removeCharacter(button15);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton16Pressed == false){
                    if(focusSaisie < 3){
                        button16.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton16Pressed = true;
                        carac = button16.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button16.setBackgroundResource(R.mipmap.small_button);
                    isButton16Pressed = false;
                    removeCharacter(button16);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton17Pressed == false){
                    if(focusSaisie < 3){
                        button17.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton17Pressed = true;
                        carac = button17.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button17.setBackgroundResource(R.mipmap.small_button);
                    isButton17Pressed = false;
                    removeCharacter(button17);
                    updateSaisie();
                    determineFocusSaisie();
                }
            }
        });


        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char carac;
                if(isButton18Pressed == false){
                    if(focusSaisie < 3){
                        button18.setBackgroundResource(R.mipmap.small_button_pressed);
                        isButton18Pressed = true;
                        carac = button18.getText().charAt(0);
                        saisie[focusSaisie] = carac;
                        updateSaisie();
                        determineFocusSaisie();
                        isWon();

                    }else{
                        // Rien ne se passe : zone de saisie pleine
                    }

                }else{
                    button18.setBackgroundResource(R.mipmap.small_button);
                    isButton18Pressed = false;
                    removeCharacter(button18);
                    updateSaisie();
                    determineFocusSaisie();
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
                finish();
            }
        });

        clue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usedClues == 0){
                    saisie1.setTextColor(Color.GRAY);
                    saisie[0] = answer.charAt(0);
                    updateSaisie();
                    determineFocusSaisie();
                    isWon();
                    nbOfClues = nbOfClues - 1;
                    usedClues = usedClues + 1;
                    setClueButtonBackground(true, nbOfClues);
                }else if(usedClues == 1){
                    saisie[1] = answer.charAt(1);
                    focusSaisie ++;
                    saisie2.setTextColor(Color.GRAY);
                    updateSaisie();
                    determineFocusSaisie();
                    isWon();
                    nbOfClues = nbOfClues - 1;
                    usedClues = usedClues + 1;
                    setClueButtonBackground(false, nbOfClues);



                }else{

                }



            }
        });




        saisie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char carac;
                if (saisie1.getText().charAt(0) != ' ' && usedClues == 0) {
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












    }
    @Override
    public void onClick(android.view.View v){
    }


    public void releaseButton(char carac){
        if(button1.getText().charAt(0) == carac && isButton1Pressed == true){
            button1.setBackgroundResource(R.mipmap.small_button);
            isButton1Pressed = false;
        }else if(button2.getText().charAt(0) == carac && isButton2Pressed == true){
            button2.setBackgroundResource(R.mipmap.small_button);
            isButton2Pressed = false;
        }else if(button3.getText().charAt(0) == carac && isButton3Pressed == true){
            button3.setBackgroundResource(R.mipmap.small_button);
            isButton3Pressed = false;
        }else if(button4.getText().charAt(0) == carac && isButton4Pressed == true){
            button4.setBackgroundResource(R.mipmap.small_button);
            isButton4Pressed = false;
        }else if(button5.getText().charAt(0) == carac && isButton5Pressed == true){
            button5.setBackgroundResource(R.mipmap.small_button);
            isButton5Pressed = false;
        }else if(button6.getText().charAt(0) == carac && isButton6Pressed == true){
            button6.setBackgroundResource(R.mipmap.small_button);
            isButton6Pressed = false;
        }else if(button7.getText().charAt(0) == carac && isButton7Pressed == true){
            button7.setBackgroundResource(R.mipmap.small_button);
            isButton7Pressed = false;
        }else if(button8.getText().charAt(0) == carac && isButton8Pressed == true){
            button8.setBackgroundResource(R.mipmap.small_button);
            isButton8Pressed = false;
        }else if(button9.getText().charAt(0) == carac && isButton9Pressed == true){
            button9.setBackgroundResource(R.mipmap.small_button);
            isButton9Pressed = false;
        }else if(button10.getText().charAt(0) == carac && isButton10Pressed == true){
            button10.setBackgroundResource(R.mipmap.small_button);
            isButton10Pressed = false;
        }else if(button11.getText().charAt(0) == carac && isButton11Pressed == true){
            button11.setBackgroundResource(R.mipmap.small_button);
            isButton11Pressed = false;
        }else if(button12.getText().charAt(0) == carac && isButton12Pressed == true){
            button12.setBackgroundResource(R.mipmap.small_button);
            isButton12Pressed = false;
        }else if(button13.getText().charAt(0) == carac && isButton13Pressed == true){
            button13.setBackgroundResource(R.mipmap.small_button);
            isButton13Pressed = false;
        }else if(button14.getText().charAt(0) == carac && isButton14Pressed == true){
            button14.setBackgroundResource(R.mipmap.small_button);
            isButton14Pressed = false;
        }else if(button15.getText().charAt(0) == carac && isButton15Pressed == true){
            button15.setBackgroundResource(R.mipmap.small_button);
            isButton15Pressed = false;
        }else if(button16.getText().charAt(0) == carac && isButton16Pressed == true){
            button16.setBackgroundResource(R.mipmap.small_button);
            isButton16Pressed = false;
        }else if(button17.getText().charAt(0) == carac && isButton17Pressed == true){
            button17.setBackgroundResource(R.mipmap.small_button);
            isButton17Pressed = false;
        }else{
            button18.setBackgroundResource(R.mipmap.small_button);
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

        clueInfo = "//clue=" + nbOfClues;
        pass2 = levelS + clueInfo;

        objetbunble.putString("passInfo", pass2);
        // on passe notre objet a notre activities
        defineIntent.putExtras(objetbunble );
        // on appelle notre activité
        startActivity(defineIntent);
        finish();





    }

    public void isWon(){
        boolean isWon;
        if(saisie[0] == answer.charAt(0) && saisie[1] == answer.charAt(1) && saisie[2] == answer.charAt(2)){
            win();
        }else{

        }
    }

    public static ThreeLettersLevel getInstance(){
        return ThreeLettersLevel;
    }


    public void setClueButtonBackground(boolean isEnabled,int nbOfClues){
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
