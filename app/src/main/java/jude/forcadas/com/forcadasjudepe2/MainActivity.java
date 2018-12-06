package jude.forcadas.com.forcadasjudepe2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Fullname, Age, Gender;
    JudeicatorHelper Judge;
    Cursor Table;

    TextView RFullname, RAge, RGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Judge = new JudeicatorHelper(this);
        Table = Judge.selectAllRecords();

        Fullname = findViewById(R.id.editFullname);
        Age = findViewById(R.id.editAge);
        Gender = findViewById(R.id.editGender);

        RFullname = findViewById(R.id.resultFullname);
        RAge = findViewById(R.id.resultAge);
        RGender = findViewById(R.id.resultGender);
    }

    public void Save(View View){
        String saveFullname = Fullname.getText().toString().trim();
        String saveAge = Age.getText().toString().trim();
        String saveGender = Gender.getText().toString().trim();


        boolean JudeicatorInsert = Judge.insert(saveFullname, saveAge, saveGender);

        if(JudeicatorInsert == true){
            Toast.makeText(this, "Insertion successful", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this, "Insertion failed", Toast.LENGTH_SHORT).show();
    }

    private void JudeicatorDisplay(){
        RFullname.setText(Table.getString(1));
        RAge.setText(Table.getString(2));
        RGender.setText(Table.getString(3));
    }

    public void Search(View View){
        Table.moveToLast();
        JudeicatorDisplay();
    }
}
