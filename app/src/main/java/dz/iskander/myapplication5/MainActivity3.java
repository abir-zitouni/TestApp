package dz.iskander.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
        Button Viewalldata ;
        DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Viewalldata = (Button) findViewById(R.id.button2);
        myDb = new DatabaseHelper(this);
        viewAll();
    }
    public void viewAll() {
        Viewalldata.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :" + res.getString(0) + "\n");
                            buffer.append("Nom medicament :" + res.getString(1) + "\n");
                            buffer.append("Catégorie :" + res.getString(2) + "\n");
                            buffer.append("date peremption :" + res.getString(3) + "\n\n");
                        }

                        // Show all data
                        showMessage("Medicament", buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}