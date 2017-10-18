package hkucs.card24;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.Jep;
import com.singularsys.jep.ParseException;
import com.singularsys.jep.functions.Random;

import static hkucs.card24.R.id.card4;

public class MainActivity extends AppCompatActivity {


    Button rePick;
    Button checkInput;
    Button clear;
    Button left;
    Button right;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    TextView expression;
    ImageButton[] cards;
    String number;
    String temp;
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number= getIntent().getStringExtra(Main2Activity.EXTRA_MESSAGE);

        cards = new ImageButton[4];
        cards[0] = (ImageButton) findViewById(R.id.card1);
        cards[1] = (ImageButton) findViewById(R.id.card2);
        cards[2] = (ImageButton) findViewById(R.id.card3);
        cards[3] = (ImageButton) findViewById(R.id.card4);
        initCardImage();
        rePick = (Button)findViewById(R.id.repick);
        checkInput = (Button)findViewById(R.id.checkinput);
        left = (Button)findViewById(R.id.left);
        right = (Button)findViewById(R.id.right);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multiply = (Button)findViewById(R.id.multiply);
        divide = (Button)findViewById(R.id.divide);
        clear = (Button)findViewById(R.id.clear);
        expression = (TextView)findViewById(R.id.input);
        expression.setHint("Please form an expression such that the result is "+number);
        pickCard();

        rePick.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                pickCard();
            }
        });

        cards[0].setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View view) {
                temp=expression.getText().toString();
                length=temp.length();
                //String s="Please form an expression such that the result is "+number;
                if(!temp.isEmpty())
                {
                if(!Character.isDigit(temp.charAt(length-1))) {
                    clickCard(0);
                   }
                }
                else
                {
                    clickCard(0);
                }
            }
        });

        cards[1].setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View view) {
                temp=expression.getText().toString();
                length=temp.length();
                //String s="Please form an expression such that the result is "+number;
                if(!temp.isEmpty())
                {
                    if(!Character.isDigit(temp.charAt(length-1))) {
                        clickCard(1);
                    }
                }
                else
                {
                    clickCard(1);
                }
            }
        });

        cards[2].setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View view) {
                temp=expression.getText().toString();
                length=temp.length();
                //String s="Please form an expression such that the result is "+number;
                if(!temp.isEmpty())
                {
                    if(!Character.isDigit(temp.charAt(length-1))) {
                        clickCard(2);
                    }
                }
                else
                {
                    clickCard(2);
                }
            }
        });

        cards[3].setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View view) {
                temp=expression.getText().toString();
                length=temp.length();
                //String s="Please form an expression such that the result is "+number;
                if(!temp.isEmpty())
                {
                    if(!Character.isDigit(temp.charAt(length-1))) {
                        clickCard(3);
                    }
                }
                else
                {
                    clickCard(3);
                }
            }
        });

        left.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view)
            {   if(!expression.getText().toString().isEmpty()) {
                temp = expression.getText().toString();
                length = temp.length();
                int flag = 0;

                if (temp.charAt(length - 1) > '0' && temp.charAt(length - 1) < '9'){// temp.charAt(length - 1)!=')') {
                    flag = 1;
                }
                if(temp.charAt(length - 1)==')')
                {
                    flag=1;
                }

                if (flag == 0) {
                    expression.append("(");
                }
                if (flag == 1) {
                    Toast.makeText(MainActivity.this, "Invalid Expression!!!",
                            Toast.LENGTH_SHORT).show();}
                }
                else
                   {expression.append("(");}
            }
        });

        right.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                temp=expression.getText().toString();
                length=temp.length();
                if(!temp.isEmpty()){
                     if((temp.charAt(length-1)!='+') && (temp.charAt(length-1)!='-') && (temp.charAt(length-1)!='*') && (temp.charAt(length-1)!='/') && (temp.charAt(length-1)!='(') && (temp.charAt(length-1)!=')'))
                     {expression.append(")");}
                      else
                     {Toast.makeText(MainActivity.this, "Invalid Expression!!!",
                             Toast.LENGTH_SHORT).show();}
                }
            }
        });

        plus.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {

                temp=expression.getText().toString();
                length=temp.length();
                if(!temp.isEmpty()) {
                    if ((temp.charAt(length - 1) != '+') && (temp.charAt(length - 1) != '-') && (temp.charAt(length - 1) != '*') && (temp.charAt(length - 1) != '/') && (temp.charAt(length - 1) != '('))
                      {expression.append("+");}
                    else
                      {Toast.makeText(MainActivity.this, "Invalid Expression!!!",
                              Toast.LENGTH_SHORT).show();}
                }
            }
        });

        minus.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                temp=expression.getText().toString();
                length=temp.length();
                if(!temp.isEmpty()) {
                    if ((temp.charAt(length - 1) != '+') && (temp.charAt(length - 1) != '-') && (temp.charAt(length - 1) != '*') && (temp.charAt(length - 1) != '/') && (temp.charAt(length - 1) != '('))
                        {expression.append("-");}
                    else
                    {Toast.makeText(MainActivity.this, "Invalid Expression!!!",
                            Toast.LENGTH_SHORT).show();}
                }
            }
        });

        multiply.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                temp=expression.getText().toString();
                length=temp.length();
                if(!temp.isEmpty()) {
                    if((temp.charAt(length-1)!='+') && (temp.charAt(length-1)!='-') && (temp.charAt(length-1)!='*') && (temp.charAt(length-1)!='/') && (temp.charAt(length-1)!='('))
                       {expression.append("*");}
                    else
                    {Toast.makeText(MainActivity.this, "Invalid Expression!!!",
                            Toast.LENGTH_SHORT).show();}
                }
            }
        });

        divide.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                temp=expression.getText().toString();
                length=temp.length();
                if(!temp.isEmpty()) {
                    if ((temp.charAt(length - 1) != '+') && (temp.charAt(length - 1) != '-') && (temp.charAt(length - 1) != '*') && (temp.charAt(length - 1) != '/') && (temp.charAt(length - 1) != '('))
                    {expression.append("/");}
                    else
                    {Toast.makeText(MainActivity.this, "Invalid Expression!!!",
                            Toast.LENGTH_SHORT).show();}
                }
            }
        });

        clear.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                setClear();
            }
        });

        checkInput.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                temp=expression.getText().toString();
                length=temp.length();
                if(!temp.isEmpty()) {
                       int flag=0;
                        int count=0;
                       for(int i=0; i<4; i++){
                       if(cards[i].isClickable()==true)
                           {
                               flag=1;
                           }
                       }
                       if(flag!=1) {
                           String inputStr = expression.getText().toString();
                           if (checkInput(inputStr)) {
                               Toast.makeText(MainActivity.this, "Correct Answer! WELL DONE",
                                       Toast.LENGTH_SHORT).show();
                               pickCard();
                           } else {
                               Toast.makeText(MainActivity.this, "!!!Wrong Answer Try Again OR Click on PICK for new cards!!!!",
                                       Toast.LENGTH_SHORT).show();
                               setClear();
                           }
                       }
                       else
                       {
                           Toast.makeText(MainActivity.this, "!!!YOU HAVE TO SELECT ALL CARDS!!!!",
                                   Toast.LENGTH_SHORT).show();
                       }
                }
            }
        });

        for(int i=0;i<4;i++){
            imageCount[i]=0;
        }
    }

    private void initCardImage() {
        for (int i = 0; i < 4; i++) {
            int resID = getResources().getIdentifier("back_0","drawable","hkucs.card24");
                    cards[i].setImageResource(resID);
        }


    }

    int[] data;
    int[] card;
    private void pickCard(){
        int count=0;
        int[] array=new int[4];
        for(int i=0; i<4;i++)
        {
            array[i]=0;
        }

        while(count<=4) {
            int flag=0;
            int n = (int) (Math.random() * 52 + 1);
            for(int i=0; i<4;i++)
            {
                if(array[i]==n)
                {
                   flag=1;
                }
            }
            if(flag==0){
            for(int i=0; i<4;i++)
            {
                if(array[i]==0) {
                    array[i] = n;
                   break;
                }

            } count++;
            }
        }
        for(int i=0; i<4;i++) {

        }
        data = new int[4];
        card=new int[4];

        card[0]=array[0];
        card[1]=array[1];
        card[2]=array[2];
        card[3]=array[3];

        data[0]=array[0]%13;
        data[1]=array[1]%13;
        data[2]=array[2]%13;
        data[3]=array[3]%13;
        for(int i=0; i<4;i++) {
            if(data[i]==0)
                data[i]=13;
        }
        setClear();
    }

    int[] imageCount=new int[4];

    private void setClear(){

        int resID;
        expression.setText("");
        for (int i = 0; i < 4; i++) {
            imageCount[i] = 0;
            resID = getResources().getIdentifier
                    ("card"+card[i],"drawable","hkucs.card24");
// Please replace “XXX” by your package name
                            cards[i].setImageResource(resID);
            cards[i].setClickable(true);
        }
    }

    private void clickCard(int i) {
        int resId;
        String num;
        Integer value;
        if (imageCount[i] == 0) {
            resId = getResources().getIdentifier("back_0","drawable","hkucs.card24");

                    cards[i].setImageResource(resId);
            cards[i].setClickable(false);
            value = data[i];
            num = value.toString();
            expression.append(num);
            imageCount[i] ++;
        }
    }


    private boolean checkInput(String input) {
        Jep jep = new Jep();
        Object res;
        try {
            jep.parse(input);
            res = jep.evaluate();
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,
                    "Wrong Expression", Toast.LENGTH_SHORT).show();
            return false;
        } catch (EvaluationException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,
                    "Wrong Expression", Toast.LENGTH_SHORT).show();
            return false;
        }
        Double ca = (Double)res;
        if (Math.abs(ca - Integer.parseInt(number)) < 1e-6)
            return true;
        return false;
    }



}
