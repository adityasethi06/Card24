package hkucs.card24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.button1;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.hkucs.card24.MESSAGE";
    Button submit;
    EditText text;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        submit= (Button) findViewById(R.id.button1);
        text= (EditText) findViewById(R.id.editText4);

        submit.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId()==R.id.button1)
        {
            if(text.getText().toString().isEmpty()){
                Toast.makeText(Main2Activity.this, "You have to enter a Number!!!",
                        Toast.LENGTH_SHORT).show();
            }

            else
            {
                if(!text.getText().toString().isEmpty()){
                    String s=text.getText().toString();
                    int len=s.length();
                    int flag=0;
                    for(int i=0; i<=(len-1); i++)
                    {
                        if(s.charAt(i)>='0' && s.charAt(i)<='9'){}
                        else
                        {
                            flag=1;
                        }
                    }
                    if(flag==1){
                    Toast.makeText(Main2Activity.this, "Make sure its just a Number with no letters",
                            Toast.LENGTH_SHORT).show();}
                      else {
                           number = text.getText().toString();
                           Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                             intent.putExtra(EXTRA_MESSAGE, number);
                            startActivity(intent);
                            }

                }



            }
            /*else {
            number = text.getText().toString();
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            intent.putExtra(EXTRA_MESSAGE, number);
            startActivity(intent);
               }*/

        }


    }



}
