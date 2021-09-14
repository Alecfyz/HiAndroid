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
    private Switch swtch_downleft;
    private String agreed;
    private TextView greetings_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inlineButton = findViewById(R.id.btn_internal);
        finalButton = findViewById(R.id.btn_final);
        inputEditText = findViewById(R.id.edtxt_custName); //клавиатура для поля по дефолту выключена при активации активити - через манифест. При клике включается.
        inlineCheckBox = findViewById(R.id.chkbx_intrnl);
        swtch_downleft = findViewById(R.id.swtch_downleft);
        greetings_text_view = findViewById(R.id.greetings_text_view);


        inlineButton.setOnClickListener(v -> {
            agreed = inlineCheckBox.isChecked() ? "NOT agree" : "Agree"; // добавим немного логики "согласен/НЕ согласен продать душу"
            String customerName = inputEditText.getText().toString();
            if (customerName == "") customerName = "Вася Пупкин";
            agreed = "Customer " + customerName.toUpperCase() + " is " + agreed + " to sell his soul";
            greetings_text_view.setText(agreed);
            Toast.makeText(this, agreed, Toast.LENGTH_LONG).show();
        });


        finalButton.setOnClickListener(v -> {
            setContentView(R.layout.activity_second);
        });

    }

}

