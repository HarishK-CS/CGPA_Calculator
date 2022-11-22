package com.syndicate.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EeeSem6List extends AppCompatActivity {
    Button submit,clear,copy,s,a,b,c,d,e,f;
    TextView result,resultText;
    ImageView cpyIcon,back;
    EditText t1,t2,t3,t4,t5,t6,t7,t8,t9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eee_sem6_list);

        t1 = findViewById(R.id.txt1);
        t2 = findViewById(R.id.txt2);
        t3 = findViewById(R.id.txt3);
        t4 = findViewById(R.id.txt4);
        t5 = findViewById(R.id.txt5);
        t6 = findViewById(R.id.txt6);
        t7 = findViewById(R.id.txt7);
        t8 = findViewById(R.id.txt8);
        t9 = findViewById(R.id.txt9);

        back = findViewById(R.id.back);


        result = findViewById(R.id.ResultId);
        resultText = findViewById(R.id.ResultTextId);
        submit = findViewById(R.id.Btn_Submit);
        clear = findViewById(R.id.Btn_Clear);
        copy = findViewById(R.id.Btn_Copy);
        cpyIcon = findViewById(R.id.copy);

//        setupSemInputs();
        s = findViewById(R.id.S);
        a = findViewById(R.id.A);
        b = findViewById(R.id.B);
        c = findViewById(R.id.C);
        d = findViewById(R.id.D);
        e = findViewById(R.id.E);
        f = findViewById(R.id.F);

        t1.setShowSoftInputOnFocus(false);
        t2.setShowSoftInputOnFocus(false);
        t3.setShowSoftInputOnFocus(false);
        t4.setShowSoftInputOnFocus(false);
        t5.setShowSoftInputOnFocus(false);
        t6.setShowSoftInputOnFocus(false);
        t7.setShowSoftInputOnFocus(false);
        t8.setShowSoftInputOnFocus(false);
        t9.setShowSoftInputOnFocus(false);


        final int[] cursor = {0};
        final String[] txt = {"t1","t2","t3","t4","t5","t6","t7","t8","t9"};



        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cursor[0]<9){
                    switch(txt[cursor[0]]){
                        case "t1":
                            t1.setText("S");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("S");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("S");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("S");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("S");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("S");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("S");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("S");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("S");
                            cursor[0]++;
                            break;
                    }
                }else{
                    cursor[0]=0;
                }
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cursor[0]<9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("A");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("A");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("A");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("A");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("A");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("A");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("A");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("A");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("A");
                            cursor[0]++;
                            break;
                    }
                }else{
                    cursor[0]=0;
                }
            }

        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor[0] < 9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("B");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("B");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("B");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("B");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("B");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("B");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("B");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("B");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("B");
                            cursor[0]++;
                            break;
                    }
                } else {
                    cursor[0] = 0;
                }
            }

        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor[0] < 9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("C");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("C");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("C");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("C");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("C");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("C");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("C");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("C");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("C");
                            cursor[0]++;
                            break;
                    }
                }else{
                    cursor[0] = 0;
                }
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor[0] < 9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("D");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("D");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("D");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("D");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("D");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("D");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("D");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("D");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("D");
                            cursor[0]++;
                            break;
                    }
                }else{
                    cursor[0] = 0;
                }
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor[0] < 9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("E");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("E");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("E");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("E");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("E");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("E");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("E");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("E");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("E");
                            cursor[0]++;
                            break;
                    }
                }else{
                    cursor[0] = 0;
                }
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor[0] < 9) {
                    switch (txt[cursor[0]]) {
                        case "t1":
                            t1.setText("F");
                            cursor[0]++;
                            break;
                        case "t2":
                            t2.setText("F");
                            cursor[0]++;
                            break;
                        case "t3":
                            t3.setText("F");
                            cursor[0]++;
                            break;
                        case "t4":
                            t4.setText("F");
                            cursor[0]++;
                            break;
                        case "t5":
                            t5.setText("F");
                            cursor[0]++;
                            break;
                        case "t6":
                            t6.setText("F");
                            cursor[0]++;
                            break;
                        case "t7":
                            t7.setText("F");
                            cursor[0]++;
                            break;
                        case "t8":
                            t8.setText("F");
                            cursor[0]++;
                            break;
                        case "t9":
                            t9.setText("F");
                            cursor[0]++;
                            break;
                    }
                }else{
                    cursor[0] = 0;
                }
            }
        });



        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
                cursor[0]=0;
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText("");
                cursor[0]=1;
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t3.setText("");
                cursor[0]=2;
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t4.setText("");
                cursor[0]=3;
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t5.setText("");
                cursor[0]=4;
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t6.setText("");
                cursor[0]=5;
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t7.setText("");
                cursor[0]=6;
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t8.setText("");
                cursor[0]=7;
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t9.setText("");
                cursor[0]=8;
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EeeSem6List.this,EeeSemList.class);
                startActivity(intent);
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float res = calculate();
                result.setText(""+res);
                result.setVisibility(View.VISIBLE);
                cpyIcon.setVisibility(View.VISIBLE);
                copy.setVisibility(View.VISIBLE);
                resultText.setVisibility(View.VISIBLE);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                result.setVisibility(view.INVISIBLE);
                cpyIcon.setVisibility(View.INVISIBLE);
                copy.setVisibility(View.INVISIBLE);
                resultText.setVisibility(View.INVISIBLE);
                t1.requestFocus();
                cursor[0]=0;

            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                write();

            }
        });
        cpyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text",result.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(EeeSem6List.this,"GPA Copied",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public float calculate()
    {
        int val1,val2,val3,val4,val5,val6,val7,val8,val9;
        if (t1.getText().toString().equals("S")||t1.getText().toString().equals("s"))
        {
            val1=10;
        }else if(t1.getText().toString().equals("A")||t1.getText().toString().equals("a")){
            val1=9;
        }else if(t1.getText().toString().equals("B")||t1.getText().toString().equals("b")){
            val1=8;
        }else if(t1.getText().toString().equals("C")||t1.getText().toString().equals("c")){
            val1=7;
        }else if(t1.getText().toString().equals("D")||t1.getText().toString().equals("d")){
            val1=6;
        }else if(t1.getText().toString().equals("E")||t1.getText().toString().equals("e")){
            val1=5;
        }else{
            val1=0;
        }

        if (t2.getText().toString().equals("S")||t2.getText().toString().equals("s"))
        {
            val2=10;
        }else if(t2.getText().toString().equals("A")||t2.getText().toString().equals("a")){
            val2=9;
        }else if(t2.getText().toString().equals("B")||t2.getText().toString().equals("b")){
            val2=8;
        }else if(t2.getText().toString().equals("C")||t2.getText().toString().equals("c")){
            val2=7;
        }else if(t2.getText().toString().equals("D")||t2.getText().toString().equals("d")){
            val2=6;
        }else if(t2.getText().toString().equals("E")||t2.getText().toString().equals("e")){
            val2=5;
        }else{
            val2=0;
        }

        if (t3.getText().toString().equals("S")||t3.getText().toString().equals("s"))
        {
            val3=10;
        }else if(t3.getText().toString().equals("A")||t3.getText().toString().equals("a")){
            val3=9;
        }else if(t3.getText().toString().equals("B")||t3.getText().toString().equals("b")){
            val3=8;
        }else if(t3.getText().toString().equals("C")||t3.getText().toString().equals("c")){
            val3=7;
        }else if(t3.getText().toString().equals("D")||t3.getText().toString().equals("d")){
            val3=6;
        }else if(t3.getText().toString().equals("E")||t3.getText().toString().equals("e")){
            val3=5;
        }else{
            val3=0;
        }

        if (t4.getText().toString().equals("S")||t1.getText().toString().equals("s"))
        {
            val4=10;
        }else if(t4.getText().toString().equals("A")||t4.getText().toString().equals("a")){
            val4=9;
        }else if(t4.getText().toString().equals("B")||t4.getText().toString().equals("b")){
            val4=8;
        }else if(t4.getText().toString().equals("C")||t4.getText().toString().equals("c")){
            val4=7;
        }else if(t4.getText().toString().equals("D")||t4.getText().toString().equals("d")){
            val4=6;
        }else if(t4.getText().toString().equals("E")||t4.getText().toString().equals("e")){
            val4=5;
        }else{
            val4=0;
        }

        if (t5.getText().toString().equals("S")||t5.getText().toString().equals("s"))
        {
            val5=10;
        }else if(t5.getText().toString().equals("A")||t5.getText().toString().equals("a")){
            val5=9;
        }else if(t5.getText().toString().equals("B")||t5.getText().toString().equals("b")){
            val5=8;
        }else if(t5.getText().toString().equals("C")||t5.getText().toString().equals("c")){
            val5=7;
        }else if(t5.getText().toString().equals("D")||t5.getText().toString().equals("d")){
            val5=6;
        }else if(t5.getText().toString().equals("E")||t5.getText().toString().equals("e")){
            val5=5;
        }else{
            val5=0;
        }

        if (t6.getText().toString().equals("S")||t6.getText().toString().equals("s"))
        {
            val6=10;
        }else if(t6.getText().toString().equals("A")||t6.getText().toString().equals("a")){
            val6=9;
        }else if(t6.getText().toString().equals("B")||t6.getText().toString().equals("b")){
            val6=8;
        }else if(t6.getText().toString().equals("C")||t6.getText().toString().equals("c")){
            val6=7;
        }else if(t6.getText().toString().equals("D")||t6.getText().toString().equals("d")){
            val6=6;
        }else if(t6.getText().toString().equals("E")||t6.getText().toString().equals("e")){
            val6=5;
        }else{
            val6=0;
        }

        if (t7.getText().toString().equals("S")||t7.getText().toString().equals("s"))
        {
            val7=10;
        }else if(t7.getText().toString().equals("A")||t7.getText().toString().equals("a")){
            val7=9;
        }else if(t7.getText().toString().equals("B")||t7.getText().toString().equals("b")){
            val7=8;
        }else if(t7.getText().toString().equals("C")||t7.getText().toString().equals("c")){
            val7=7;
        }else if(t7.getText().toString().equals("D")||t7.getText().toString().equals("d")){
            val7=6;
        }else if(t7.getText().toString().equals("E")||t7.getText().toString().equals("e")){
            val7=5;
        }else{
            val7=0;
        }

        if (t8.getText().toString().equals("S")||t8.getText().toString().equals("s"))
        {
            val8=10;
        }else if(t8.getText().toString().equals("A")||t8.getText().toString().equals("a")){
            val8=9;
        }else if(t8.getText().toString().equals("B")||t8.getText().toString().equals("b")){
            val8=8;
        }else if(t8.getText().toString().equals("C")||t8.getText().toString().equals("c")){
            val8=7;
        }else if(t8.getText().toString().equals("D")||t8.getText().toString().equals("d")){
            val8=6;
        }else if(t8.getText().toString().equals("E")||t8.getText().toString().equals("e")){
            val8=5;
        }else{
            val8=0;
        }


        if (t9.getText().toString().equals("S")||t9.getText().toString().equals("s"))
        {
            val9=10;
        }else if(t9.getText().toString().equals("A")||t9.getText().toString().equals("a")){
            val9=9;
        }else if(t9.getText().toString().equals("B")||t9.getText().toString().equals("b")){
            val9=8;
        }else if(t9.getText().toString().equals("C")||t9.getText().toString().equals("c")){
            val9=7;
        }else if(t9.getText().toString().equals("D")||t9.getText().toString().equals("d")){
            val9=6;
        }else if(t9.getText().toString().equals("E")||t9.getText().toString().equals("e")){
            val9=5;
        }else{
            val9=0;
        }




        float res = ((float)val1*4+(float)val2*4+(float)val3*4+(float)val4*4+(float)val5*4+(float)val6*4+(float)val7*2+(float)val8*2+(float)val9*1)/29;

        return res;
    }

    private void setupSemInputs() {
        t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t7.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t8.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t9.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public void write(){
        String textToSave = result.getText().toString();

        try{
            FileOutputStream fileOutputStream = openFileOutput("sem6.txt",MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();
            Toast.makeText(EeeSem6List.this,"Added To CGPA ",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
