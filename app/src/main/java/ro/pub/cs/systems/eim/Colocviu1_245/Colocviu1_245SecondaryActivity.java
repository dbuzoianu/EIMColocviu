package ro.pub.cs.systems.eim.Colocviu1_245;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Colocviu1_245SecondaryActivity extends AppCompatActivity {

    final public static int ADD_ELEMENTS = 12345;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        // intent from parent
        Intent intentFromParent = getIntent();
        Bundle data = intentFromParent.getExtras();
        // process information from data ...

        String toAdd = data.getString("toAdd");

        toAdd =  toAdd.substring(0, toAdd.length() - 1);

        int sum = 0;
        for (int i = 0; i < toAdd.length(); i++) {
            char a = toAdd.charAt(i);
            if (Character.isDigit(a)) {
                int b = Integer.parseInt(String.valueOf(a));
                sum = sum + b;
            }
        }

        // intent to parent
        Intent intentToParent = new Intent();
        intentToParent.putExtra("c", sum);
        setResult(RESULT_OK, intentToParent);
        finish();
    }
}
