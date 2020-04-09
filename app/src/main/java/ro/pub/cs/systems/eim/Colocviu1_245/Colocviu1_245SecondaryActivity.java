package ro.pub.cs.systems.eim.Colocviu1_245;

public class Colocviu1_245SecondaryActivity {

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_another);

        // intent from parent
        Intent intentFromParent = getIntent();
        Bundle data = intentFromParent.getExtras();
        // process information from data ...

        // intent to parent
        Intent intentToParent = new Intent();
        intent.putExtra("ro.pub.cs.systems.eim.lab04.anotherKey", anotherValue);
        setResult(RESULT_OK, intentToParent);
        finish();
    }
}
