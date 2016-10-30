package com.example.manon.weirdwords;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WinActivity extends Activity implements View.OnClickListener{

    private Button next_level_button = null;
    private String levelS;
    private String pass;
    private String pass2;
    private String levelS2;
    private String clueInfo ;
    private int i;

    static WinActivity WinActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        WinActivity = this;
        Bundle objetbunble  = this.getIntent().getExtras();
        // récupération de la valeur
        pass = objetbunble.getString("passInfo");
        if(pass.charAt(6) == '1'){
            ThreeLettersLevel.getInstance().finish();
        }else{
            FiveLettersLevel.getInstance().finish();
        }

        // Construire levelS
        levelS = pass.substring(0, 10);
        // Construire clueInfo
        clueInfo = pass.substring(10);





        if(levelS.equals("level 1.1w") || levelS.equals("level 1.1n")){
            levelS2 = "level 1.2w";
        }else if(levelS.equals("level 1.2w") || levelS.equals("level 1.2n")){
            levelS2 = "level 1.3w";
        }else if(levelS.equals("level 1.3w") || levelS.equals("level 1.3n")){
            levelS2 = "level 1.4w";
        }else if(levelS.equals("level 1.4w") || levelS.equals("level 1.4n")){
            levelS2 = "level 1.5w";
        }else if(levelS.equals("level 1.5w") || levelS.equals("level 1.5n")){
        levelS2 = "level 1.6w";
        }else if(levelS.equals("level 1.6w") || levelS.equals("level 1.6n")){
            levelS2 = "level 1.7w";
        }else if(levelS.equals("level 1.7w") || levelS.equals("level 1.7n")){
            levelS2 = "level 1.8w";
        }else if(levelS.equals("level 1.8w") || levelS.equals("level 1.8n")){
            levelS2= "level 2.1w";
        }else if(levelS.equals("level 2.1w") || levelS.equals("level 2.1n")){
            levelS2="level 2.2w";
        }else if(levelS.equals("level 2.2w") || levelS.equals("level 2.2n")){
            levelS2="level 2.3w";
        }else if(levelS.equals("level 2.3w") || levelS.equals("level 2.3n")){
            levelS2="level 2.4w";
        }else if(levelS.equals("level 2.4w") || levelS.equals("level 2.4n")){
            levelS2="level 2.5w";
        }else if(levelS.equals("level 2.5w") || levelS.equals("level 2.5n")){
            levelS2="level 2.6w";
        }else if(levelS.equals("level 2.6w") || levelS.equals("level 2.6n")){
            levelS2="level 2.7w";
        }else if(levelS.equals("level 2.7w") || levelS.equals("level 2.7n")){
            levelS2="level 2.8w";
        }else if(levelS.equals("level 2.8w") || levelS.equals("level 2.8n")){
        levelS2="level 3.1w";
        }else if(levelS.equals("level 3.1w") || levelS.equals("level 3.1n")){
            levelS2="level 3.2w";
        }else if(levelS.equals("level 3.2w") || levelS.equals("level 3.2n")){
            levelS2="level 3.3w";
        }else if(levelS.equals("level 3.3w") || levelS.equals("level 3.3n")){
            levelS2="level 3.4w";
        }else if(levelS.equals("level 3.4w") || levelS.equals("level 3.4n")){
            levelS2="level 3.5w";
        }else if(levelS.equals("level 3.5w") || levelS.equals("level 3.5n")){
            levelS2="level 3.6w";
        }else if(levelS.equals("level 3.6w") || levelS.equals("level 3.6n")){
            levelS2="level 3.7w";
        }else if(levelS.equals("level 3.7w") || levelS.equals("level 3.7n")){
            levelS2="level 3.8w";
        }else if(levelS.equals("level 3.8w") || levelS.equals("level 3.8n")){
            levelS2="level 4.1w";
        }else if(levelS.equals("level 4.1w") || levelS.equals("level 4.1n")){
            levelS2="level 4.2w";
        }else if(levelS.equals("level 4.2w") || levelS.equals("level 4.2n")){
            levelS2="level 4.3w";
        }else if(levelS.equals("level 4.3w") || levelS.equals("level 4.3n")){
            levelS2="level 4.4w";
        }else if(levelS.equals("level 4.4w") || levelS.equals("level 4.4n")){
            levelS2="level 4.5w";
        }else if(levelS.equals("level 4.5w") || levelS.equals("level 4.5n")){
            levelS2="level 4.6w";
        }else if(levelS.equals("level 4.6w") || levelS.equals("level 4.6n")){
            levelS2="level 4.7w";
        }else if(levelS.equals("level 4.7w") || levelS.equals("level 4.7n")){
            levelS2="level 4.8w";
        }else if(levelS.equals("evel 4.8w") || levelS.equals("level 4.8n")){
            levelS2="level 5.1w";
        }else if(levelS.equals("level 5.1w") || levelS.equals("level 5.1n")){
            levelS2="level 5.2w";
        }else if(levelS.equals("level 5.2w") || levelS.equals("level 5.2n")){
            levelS2="level 5.3w";
        }else if(levelS.equals("level 5.3w") || levelS.equals("level 5.3n")){
            levelS2="level 5.4w";
        }else if(levelS.equals("level 5.4w") || levelS.equals("level 5.4n")){
            levelS2="level 5.5w";
        }else if(levelS.equals("level 5.5w") || levelS.equals("level 5.5n")){
            levelS2="level 5.6w";
        }else if(levelS.equals("level 5.6w") || levelS.equals("level 5.6n")){
            levelS2="level 5.7w";
        }else if(levelS.equals("level 5.7w") || levelS.equals("level 5.7n")){
            levelS2="level 5.8w";
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

                // determiner clueInfo

                clueInfo = pass.substring(10);
                // FIN
                pass2 = levelS2 + clueInfo;

                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", pass2);
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
}
