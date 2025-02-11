package ac.id.unikom.challenge;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText meter;
    private EditText kilometer;
    private EditText centimeter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this, Meter.getInstance());
        initView();
    }

    private void initView() {
        meter = findViewById(R.id.meter);
        kilometer = findViewById(R.id.kilometer);
        centimeter = findViewById(R.id.centimeter);

        meter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.calculateLength(editable.toString());
            }
        });
    }

    @Override
    public void showKilometer(String kilometerValue) {
        kilometer.setText(kilometerValue);
    }

    @Override
    public void showCentimeter(String centimeterValue) {
        centimeter.setText(centimeterValue);
    }
}
