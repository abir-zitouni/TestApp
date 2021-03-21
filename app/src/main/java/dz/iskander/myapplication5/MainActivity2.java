package dz.iskander.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper myDb;
    Button btnAddData;
    EditText nom_medicament, Categorie, date_de_peremption, editTextId;
    private final String url="http://192.168.43.141/www/db_insert.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myDb = new DatabaseHelper(this);
        nom_medicament = (EditText) findViewById(R.id.editTextTextPersonName);
        Categorie = (EditText) findViewById(R.id.editTextTextPersonName2);
        date_de_peremption = (EditText) findViewById(R.id.editTextTextPersonName3);
        btnAddData = (Button) findViewById(R.id.button);
       AddData();
    }
    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(nom_medicament.getText().toString(),
                                Categorie.getText().toString(),
                                date_de_peremption.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(MainActivity2.this, "Medicament insére", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity2.this, "Medicament non insére", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    /*
    public void btnAddData(View view) {
        String n1 = nom_medicament.getText().toString();
        String n2 = Categorie.getText().toString();
        String n3 = date_de_peremption.getText().toString();
        String qryString="?t1="+n1+"&t2="+n2+"&t3="+n3;
        class dbclass extends AsyncTask<String,Void,String>
        {
            protected void OnPostExecute(String data) {
                nom_medicament.setText("");
                Categorie.setText("");
                date_de_peremption.setText("");


            }
            protected String doInBackground(String... param){
                try {
                    URL url = new URL(param[0]);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    BufferedReader br = new BufferedReader((new InputStreamReader(conn.getInputStream())));
                }
                catch(Exception ex){

                    return ex.getMessage();
                }


                return null ;
            }

        }
        dbclass obj=new dbclass();
        obj.execute(url+qryString);
    }*/

}