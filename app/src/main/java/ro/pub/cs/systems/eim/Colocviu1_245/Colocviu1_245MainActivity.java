package ro.pub.cs.systems.eim.Colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_245MainActivity extends AppCompatActivity {

    final public static int ADD_ELEMENTS = 12345;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView nextTerm = (TextView)findViewById(R.id.editText_nextTerm);
            TextView allTerms = (TextView)findViewById(R.id.editText_allTerms);

            int term = Integer.valueOf(nextTerm.getText().toString());

            if(allTerms.getText().toString() != "") {
                String newText = allTerms.getText().toString() + term + '+';
                allTerms.setText(newText);
            } else {
                allTerms.setText(term + '+');
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);

        Button buttonAdd = (Button) findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(buttonClickListener);

        Button buttonCompute = (Button) findViewById(R.id.button_compute);
        buttonCompute.setOnClickListener(
            new ButtonClickListener() {

                @Override
                public void onClick(View view) {
                    TextView allTerms = (TextView)findViewById(R.id.editText_allTerms);

                    Intent intent = new Intent("ro.pub.cs.systems.eim.Colocviu1_245.Colocviu1_245SecondaryActivity");
                    intent.putExtra("toAdd", allTerms.getText().toString());

                    startActivityForResult(intent, ADD_ELEMENTS);
                }
            }
        );
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        super.onActivityResult(requestCode, resultCode, intent);

        switch (requestCode) {
            case ADD_ELEMENTS:
                Bundle data = intent.getExtras();
                Integer sum = data.getInt("sum");
                Toast.makeText(this, "The activity returned with sum " + sum, Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // apelarea metodei din activitatea parinte este recomandata, dar nu obligatorie
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // apelarea metodei din activitatea parinte este recomandata, dar nu obligatorie
        super.onRestoreInstanceState(savedInstanceState);
    }
}
