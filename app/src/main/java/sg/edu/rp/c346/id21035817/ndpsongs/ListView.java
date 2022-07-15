package sg.edu.rp.c346.id21035817.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {

    Button btnListView;
    ListView lv;
    ArrayList<Song> alSong;
    ArrayAdapter aaSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        btnListView = findViewById(R.id.btnListView);
        lv = findViewById(R.id.lv);

        alSong = new ArrayList<Song>();
        aaSong = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, alSong);
        lv.setAdapter(aaSong);

        DBHelper dbh = new DBHelper(ListView.this);
        alSong.clear();
        alSong.addAll(dbh.getAllSongs());
        aaSong.notifyDataSetChanged();

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dbh = new DBHelper(ListView.this);

                // Insert a task
                ArrayList<String> data = dbh.getStarSongs();
                dbh.close();

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = alSong.get(position);
                Intent i = new Intent(ListView.this,
                        EditText.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}