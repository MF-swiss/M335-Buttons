package ch.wiss.m335_buttons;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private static final String TAG = "M335";

    private EditText etName;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // keine Typangabe. Sonst entstehen neue lokale Variablen.
        etName = findViewById(R.id.etName);
        tvOutput = findViewById(R.id.tvOutput);

        findViewById(R.id.btnGreet).setOnClickListener(this);
        findViewById(R.id.btnCount).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String name = etName.getText().toString();

        if (id == R.id.btnGreet) {
            Log.d(TAG, "Greet clicked. Name: " + name);
            tvOutput.setText("Hallo " + name + "!");
            Toast.makeText(this, "Hallo " + name + "!", Toast.LENGTH_LONG).show();

        } else if (id == R.id.btnCount) {
            Log.d(TAG, "Count clicked.");
            tvOutput.setText("Dein Name hat " + name.length() + " Zeichen.");

        } else if (id == R.id.btnClear) {
            Log.d(TAG, "Clear clicked.");
            etName.setText("");
            tvOutput.setText("");
        }
    }
}