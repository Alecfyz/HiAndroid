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

        inlineButton = findViewById(R.id.btn_internal);
        finalButton = findViewById(R.id.btn_final);
        inputEditText = findViewById(R.id.edtxt_custName); //клавиатура для поля по дефолту выключена при активации активити - через манифест. При клике включается.
        inlineCheckBox = findViewById(R.id.chkbx_intrnl);
        swtcher1 = findViewById(R.id.swtch_downleft);
        greetingsTextView = findViewById(R.id.greetings_text_view);


        inlineButton.setOnClickListener(v -> {
            agreedCheckBox = inlineCheckBox.isChecked() ? "НЕ " : " "; // добавим немного логики "согласен/НЕ согласен продать душу"
            agreedCheckBox += "согласен";
            String customerName = inputEditText.getText().toString();
            if (customerName == "") customerName = "Вася Пупкин";
            agreedCheckBox = "Customer " + customerName.toUpperCase() + " is " + agreedCheckBox + " to sell his soul";
            greetingsTextView.setText(agreedCheckBox);
            Toast.makeText(this, agreedCheckBox, Toast.LENGTH_LONG).show();
        });


        finalButton.setOnClickListener(v -> {
            setContentView(R.layout.activity_second);
        });

    }

}

