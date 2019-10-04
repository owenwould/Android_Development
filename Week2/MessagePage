package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;

public class MessagePage extends AppCompatActivity {


    TextView displayText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_page);

        displayText = findViewById(R.id.messageDisplay);
        Intent intent = getIntent();
        Bundle x = new Bundle();
        x = intent.getExtras();

        String message = "",fullMessage="";
        StringBuilder p = new StringBuilder();
        String[] array =  {MainActivity.sMessage,MainActivity.sSpinner,MainActivity.sCheckbox,MainActivity.sRadiobuton,MainActivity.sSwitch};

        //displayText.setText(x.getString(MainActivity.sMessage));



        for (int i=0; i < array.length; i++)
        {

           if (i < 2)
           {
               if (x.containsKey(array[i]))
               {
                   message = array[i] + ":" + " "+  x.getString(array[i]);
                   p.append(message);

               }
           }
           else
               {
                   if (x.containsKey(array[i]))
                   {
                       Boolean b = x.getBoolean(array[i]);

                       if (b)
                       {
                          message = array[i] +":" + " is selected" ;
                       }
                       else {
                           message = array[i] +":" + " is not selected";
                       }

                       p.append(message);
                   }
           }
           p.append("\n");
        }
        fullMessage = p.toString();
        displayText.setText(fullMessage);




    }
}
