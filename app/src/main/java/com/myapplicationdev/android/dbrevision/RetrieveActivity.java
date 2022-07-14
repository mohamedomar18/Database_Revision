package com.myapplicationdev.android.dbrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RetrieveActivity extends AppCompatActivity {

    Button btnGetNotes;
    TextView tvResults;
    ListView lv;
    ArrayAdapter<String> aa;
    ArrayList<Note> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        btnGetNotes = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);
        lv = findViewById(R.id.lv);

        al = new ArrayList<>();
        aa = new ArrayAdapter();
        lv.setAdapter(aa);

        btnGetNotes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the activity's Context


                // Insert a task
                ArrayList<String> data = db.getNotesInStrings();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += (i+1) + ". " + data.get(i) + "\n";
                }
                //Setting results


                //LIST VIEW
                DBHelper db2 = new DBHelper(RetrieveActivity.this);
                db2.close();

                al.clear();
                al.addAll(db2.getNotesInObjects());
                aa.notifyDataSetChanged();

            }
        });

    }
}