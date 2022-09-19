package com.syndicate.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EceSem4List extends AppCompatActivity {
    Button submit,clear,copy;
    TextView result,resultText;
    ImageView cpyIcon,back;
    EditText t1,t2,t3,t4,t5,t6,t7,t8,t9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_sem4_list);

        t1 = findViewById(R.id.txt1);
        t2 = findViewById(R.id.txt2);
        t3 = findViewById(R.id.txt3);
        t4 = findViewById(R.id.txt4);
        t5 = findViewById(R.id.txt5);
        t6 = findViewById(R.id.txt6);
        t7 = findViewById(R.id.txt7);
        t8 = findViewById(R.id.txt8);
        t9 = findViewById(R.id.txt9);



        result = findViewById(R.id.ResultId);
        resultText = findViewById(R.id.ResultTextId);
        submit = findViewById(R.id.Btn_Submit);
        clear = findViewById(R.id.Btn_Clear);
        copy = findViewById(R.id.Btn_Copy);
        cpyIcon = findViewById(R.id.copy);
        back = findViewById(R.id.back);
        setupSemInputs();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EceSem4List.this,EceSemList.class);
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
                Toast.makeText(EceSem4List.this,"GPA Copied",Toast.LENGTH_SHORT).show();
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

        float res = ((float)val1*4+(float)val2*4+(float)val3*4+(float)val4*4+(float)val5*4+(float)val6*4+(float)val7*2+(float)val8*2+(float)val9*2)/30;

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
        t9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    t1.requestFocus();
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
            FileOutputStream fileOutputStream = openFileOutput("sem4.txt",MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();
            Toast.makeText(EceSem4List.this,"Added To CGPA ",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
