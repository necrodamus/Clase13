package andres.curso.clase13;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText Etn, Etd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Etn = findViewById(R.id.text1);
        Etd = findViewById(R.id.multi1);
    }

    public void onSave(View view) {
        String SEtn = Etn.getText().toString();
        String SEtd = Etd.getText().toString();
        SharedPreferences preferences = getSharedPreferences( "outlook", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(SEtn,SEtd);
        obj_editor.commit();
        Resources res = getResources();
        Toast.makeText(this, res.getString(R.string.msgSave),Toast.LENGTH_LONG).show();

    }

    public void onSearch(View view) {
        String SEtn = Etn.getText().toString();
        SharedPreferences preferences = getSharedPreferences( "outlook", Context.MODE_PRIVATE);
        String SData = preferences.getString(SEtn,"");
        Resources res = getResources();
        if(SData.length() == 0){
            Toast.makeText(this, res.getString(R.string.msgError),Toast.LENGTH_LONG).show();
        }else {
            Etd.setText(SData.toString());
        }
    }


    public void onClear(View view) {
        Etn.setText("");
        Etd.setText("");
    }

}
