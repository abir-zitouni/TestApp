package dz.iskander.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity4 extends AppCompatActivity {
    Button btnDelete;
    DatabaseHelper myDb;
    EditText nom_medoc,categorie,date_de_peremption,ID ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        myDb = new DatabaseHelper(this);
        nom_medoc = (EditText) findViewById(R.id.editTextTextPersonName6);
        btnDelete = (Button) findViewById(R.id.button_sup);
        categorie = (EditText) findViewById(R.id.editTextTextPersonName7);
        date_de_peremption = (EditText) findViewById(R.id.editTextTextPersonName8);
        ID = (EditText) findViewById(R.id.editTextTextPersonName9);
        DeleteData();
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(ID.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(MainActivity4.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity4.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}