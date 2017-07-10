package com.example.raj.atmm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Button b1,b2,b3,b4,b5;
    EditText et1,et2;
    TextView tv;
    long Balance=10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button) findViewById(R.id.button5);
        b1=(Button) findViewById(R.id.button);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        tv=(TextView)findViewById(R.id.textView);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        b5.setVisibility(View.INVISIBLE);
        et2.setVisibility(View.INVISIBLE);
        tv.setVisibility(View.INVISIBLE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pin=et1.getText().toString();

                if(Pin.isEmpty())
                {
                    et1.setError("Empty");
                }
                else
                {
                    int pin=Integer.parseInt(Pin);
                    if (pin==1234)
                    {
                       // et1.setError("Valid User");
                        b2.setVisibility(View.VISIBLE);
                        b3.setVisibility(View.VISIBLE);
                        b4.setVisibility(View.VISIBLE);
                        b5.setVisibility(View.VISIBLE);
                        et2.setVisibility(View.VISIBLE);
                        tv.setVisibility(View.VISIBLE);
                        b1.setVisibility(View.INVISIBLE);
                        et1.setVisibility(View.INVISIBLE);
                    }
                    else {
                        et1.setError("Invalid Password");
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=et2.getText().toString();
                long amount=Long.parseLong(s1);
                if(amount>Balance)
                {
                    tv.setText("No funds available");
                }
                else if(amount%100==0)
                {
                    Balance=Balance-amount;
                    tv.setText(""+Balance);
                   SmsManager sms= SmsManager.getDefault();
                    sms.sendTextMessage("984812345",null,"You have withdrwan:"+amount+"\n"+"Current balance is:"+Balance,null,null);
                }
                else
                {
                    tv.setText("Invalid entry");
                }


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=et2.getText().toString();
                long amount=Long.parseLong(s1);
                Balance=Balance+amount;
                tv.setText(""+Balance);
                SmsManager sms= SmsManager.getDefault();
                sms.sendTextMessage("984812345",null,"Your account has been credited with amount of:"+amount+"\n"+"Current balance is:"+Balance,null,null);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(""+Balance);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setVisibility(View.INVISIBLE);
                b3.setVisibility(View.INVISIBLE);
                b4.setVisibility(View.INVISIBLE);
                b5.setVisibility(View.INVISIBLE);
                et2.setVisibility(View.INVISIBLE);
                tv.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.VISIBLE);
                et1.setVisibility(View.VISIBLE);
            }
        });

    }
}
