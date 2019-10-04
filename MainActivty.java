package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    private View.OnClickListener onClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (v.getId() == R.id.sendButton)
            {
                sendMessage();
            }

        }

    };



    private AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            sSpinnerText = parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    public static String sSpinner = "SPINNERTEXT",sMessage="MESSAGE",sCheckbox="CHECKBOX",sRadiobuton="RADIOBUTTON",sSwitch="SWITCH";
    String sSpinnerText = "";
    Spinner spinner;
    Button sendButton;
    EditText inputBox;
    CheckBox checkBox;
    RadioButton radioButton;
    Switch switchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(onClickListener);
        inputBox = findViewById(R.id.sendMessageText);
        spinner = findViewById(R.id.spinner1);
        checkBox = findViewById(R.id.checkBox);
        radioButton = findViewById(R.id.radioButton);
        switchButton = findViewById(R.id.switch1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinnerText,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(onItemSelectedListener);
    }


    private void sendMessage()
    {
        Intent intent = new Intent(this,MessagePage.class);
        intent.putExtra(sMessage,inputBox.getText().toString());

        if (spinner.getSelectedItem() !=null)
        {
            intent.putExtra(sSpinner,spinner.getSelectedItem().toString());
        }


        if (checkBox.isChecked())
        {
          intent.putExtra(sCheckbox, true);
        }
        else {
            intent.putExtra(sCheckbox,false);
        }

        if (radioButton.isChecked()) {
            intent.putExtra(sRadiobuton,true);
        }
        else {
            intent.putExtra(sRadiobuton,false);
        }

        if (switchButton.isChecked()) {
            intent.putExtra(sSwitch,true);

        }
        else {
            intent.putExtra(sSwitch,false);
        }






        startActivity(intent);
    }



}
