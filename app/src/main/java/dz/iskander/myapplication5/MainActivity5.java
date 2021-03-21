package dz.iskander.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity5 extends AppCompatActivity {
    private Button Button_Ajouter;
    private Button Button_Suprimer;
    private Button Button_View ;
    private final static int Second_Call_Activity = 1234 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Button_Ajouter = (Button) findViewById(R.id.Button_Ajouter) ;
        Button_Suprimer = (Button) findViewById(R.id.button_Suprimer) ;
        Button_View = (Button) findViewById(R.id.Afficher_Liste);
        Button_Ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(
                        MainActivity5.this,

                        dz.iskander.myapplication5.MainActivity2.class


                );
                startActivityForResult(Intent, Second_Call_Activity);
            }
        });

     Button_Suprimer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent Intent = new Intent(
                    MainActivity5.this,

                    dz.iskander.myapplication5.MainActivity4.class


            );
            startActivityForResult(Intent, Second_Call_Activity);
        }
    });
        Button_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(
                        MainActivity5.this,

                        dz.iskander.myapplication5.MainActivity3.class


                );
                startActivityForResult(Intent, Second_Call_Activity);
            }
        });



    }
    }
