package sg.edu.rp.c346.id21035817.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTile, tvSinger, tvYear, tvStars;
    EditText etSongTitle, etSinger, etYear;
    Button btnInsert, btnShowList;
    RadioGroup rgStar;
    RadioButton rbOne, rbTwo, rbThree, rbFour, rbFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTile = findViewById(R.id.tvTitle);
        tvSinger = findViewById(R.id.tvSinger);
        tvYear = findViewById(R.id.tvYear);
        tvStars = findViewById(R.id.tvStars);
        etSongTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        rgStar = findViewById(R.id.rgStar);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = etSongTitle.getText().toString();
                String Singer = etSinger.getText().toString();
                int Year = Integer.parseInt(etYear.getText().toString());
                int selected = rgStar.getCheckedRadioButtonId();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(Title,Singer,Year,Star);

                if (inserted_id != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,
                        ListView.class);
                startActivity(i);
            }
        });
    }
}