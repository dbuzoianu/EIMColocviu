package ro.pub.cs.systems.eim.Colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_245MainActivity extends AppCompatActivity {

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
    }
}
