package com.example.hiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputEditText;
    private Button inlineButton;
    private Button finalButton;
    private CheckBox inlineCheckBox;
    private Switch swtcher1;
    private String agreedCheckBox;
    private TextView greetingsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inlineButton = findViewById(R.id.in_scrollview_button);
        finalButton = findViewById(R.id.btn_final);
        inputEditText = findViewById(R.id.fullname_edit_text); //клавиатура для поля по дефолту выключена при активации активити - через манифест. При клике включается.
        inlineCheckBox = findViewById(R.id.in_scrollview_checkbox);
        swtcher1 = findViewById(R.id.only_switcher);
        greetingsTextView = findViewById(R.id.greetings_text_view);


        inlineButton.setOnClickListener(v -> {
            agreedCheckBox = inlineCheckBox.isChecked() ? "НЕ согласен" : "согласен"; // добавим немного логики "согласен/НЕ согласен продать душу"
            String customerName = inputEditText.getText().toString();
            String cName;
            if (customerName.equals("")) {
                cName = getString(R.string.fake_name);
            } else { cName = customerName; }
            agreedCheckBox = "Юзер " + cName.toUpperCase()  + " " +agreedCheckBox + " продать свою душу.";
            greetingsTextView.setText(agreedCheckBox);
            Toast.makeText(this, agreedCheckBox, Toast.LENGTH_LONG).show();
        });


        finalButton.setOnClickListener(v -> {
            setContentView(R.layout.activity_second);
        });

    }

}

