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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cgpa extends AppCompatActivity {

    Button submit, clear;
    ImageView del1,del2,del3,del4,del5,del6,del7,del8, copy, copyPerc,delCgpa,delPercent,back;
    TextView result, percent,resultText,resultText1;
    EditText t1, t2, t3, t4, t5, t6, t7, t8;
    float perc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);

        t1 = findViewById(R.id.txt1);
        t2 = findViewById(R.id.txt2);
        t3 = findViewById(R.id.txt3);
        t4 = findViewById(R.id.txt4);
        t5 = findViewById(R.id.txt5);
        t6 = findViewById(R.id.txt6);
        t7 = findViewById(R.id.txt7);
        t8 = findViewById(R.id.txt8);

        back = findViewById(R.id.back);

        del1 = findViewById(R.id.del1);
        del2 = findViewById(R.id.del2);
        del3 = findViewById(R.id.del3);
        del4 = findViewById(R.id.del4);
        del5 = findViewById(R.id.del5);
        del6 = findViewById(R.id.del6);
        del7 = findViewById(R.id.del7);
        del8 = findViewById(R.id.del8);
        delCgpa = findViewById(R.id.delCgpa);
        delPercent = findViewById(R.id.delPercent);

        result = findViewById(R.id.ResultId);
        resultText = findViewById(R.id.ResultTextId);
        resultText1 = findViewById(R.id.ResultText1Id);
        percent = findViewById(R.id.ResultPercentId);
        submit = findViewById(R.id.Btn_Submit);
        clear = findViewById(R.id.Btn_Clear);
        copy = findViewById(R.id.Btn_Copy);
        copyPerc = findViewById(R.id.Btn_CopyPerc);
        read();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cgpa.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if (!t1.getText().toString().equals(""))
        {
            del1.setVisibility(View.VISIBLE);
        }
        if (!t2.getText().toString().equals(""))
        {
            del2.setVisibility(View.VISIBLE);
        }
        if (!t3.getText().toString().equals(""))
        {
            del3.setVisibility(View.VISIBLE);
        }
        if (!t4.getText().toString().equals(""))
        {
            del4.setVisibility(View.VISIBLE);
        }
        if (!t5.getText().toString().equals(""))
        {
            del5.setVisibility(View.VISIBLE);
        }
        if (!t6.getText().toString().equals(""))
        {
            del6.setVisibility(View.VISIBLE);
        }
        if (!t7.getText().toString().equals(""))
        {
            del7.setVisibility(View.VISIBLE);
        }
        if (!t8.getText().toString().equals(""))
        {
            del8.setVisibility(View.VISIBLE);
        }

        if (!result.getText().toString().equals(""))
        {
            result.setVisibility(View.VISIBLE);
            resultText.setVisibility(View.VISIBLE);
            copy.setVisibility(View.VISIBLE);
            delCgpa.setVisibility(View.VISIBLE);
        }
        if (!percent.getText().toString().equals(""))
        {
            percent.setVisibility(View.VISIBLE);
            resultText1.setVisibility(View.VISIBLE);
            copyPerc.setVisibility(View.VISIBLE);
            delPercent.setVisibility(View.VISIBLE);
        }
        // setupSemInputs();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float res = calculate();
                result.setText("" + res);
                percent.setText("" + perc);
                result.setVisibility(View.VISIBLE);
                resultText.setVisibility(View.VISIBLE);
                resultText1.setVisibility(View.VISIBLE);
                percent.setVisibility(View.VISIBLE);
                copy.setVisibility(View.VISIBLE);
                copyPerc.setVisibility(View.VISIBLE);
                write();
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
                result.setVisibility(View.INVISIBLE);
                resultText.setVisibility(View.INVISIBLE);
                resultText1.setVisibility(View.INVISIBLE);
                percent.setVisibility(View.INVISIBLE);

            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", result.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(Cgpa.this, "CGPA Copied", Toast.LENGTH_SHORT).show();

            }
        });
        copyPerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", percent.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(Cgpa.this, "Percentage Of Marks Copied", Toast.LENGTH_SHORT).show();

            }
        });

        del1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete("sem1.txt");
                del1.setVisibility(View.INVISIBLE);
                t1.setText("");
            }
        });
        del2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete("sem2.txt");
                del2.setVisibility(View.INVISIBLE);
                t2.setText("");
            }
        });

        del3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete("sem3.txt");
                del3.setVisibility(View.INVISIBLE);
                t3.setText("");
            }
        });
        del4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete("sem4.txt");
                del4.setVisibility(View.INVISIBLE);
                t4.setText("");
            }
        });
        del5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete("sem5.txt");
                del5.setVisibility(View.INVISIBLE);
                t5.setText("");
            }
        });
        del6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete("sem6.txt");
                del6.setVisibility(View.INVISIBLE);
                t6.setText("");
            }
        });
        del7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete("sem7.txt");
                del7.setVisibility(View.INVISIBLE);
                t7.setText("");
            }
        });
        del8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete("sem8.txt");
                del8.setVisibility(View.INVISIBLE);
                t8.setText("");
            }
        });

        delCgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete("cgpa.txt");
                result.setVisibility(View.INVISIBLE);
                resultText.setVisibility(View.INVISIBLE);
                copy.setVisibility(View.INVISIBLE);
                delCgpa.setVisibility(View.INVISIBLE);
            }
        });
        delPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete("percent.txt");
                percent.setVisibility(View.INVISIBLE);
                resultText1.setVisibility(View.INVISIBLE);
                copyPerc.setVisibility(View.INVISIBLE);
                delPercent.setVisibility(View.INVISIBLE);
            }
        });


    }

    public float calculate() {
        int count = 0;
        float val1 = 0, val2 = 0, val3 = 0, val4 = 0, val5 = 0, val6 = 0, val7 = 0, val8 = 0;
        float tot = 0, res = 0;

        if (!t1.getText().toString().equals("")) {
            val1 = Float.valueOf(t1.getText().toString());
            count++;
        }
        if (!t2.getText().toString().equals("")) {
            val2 = Float.valueOf(t2.getText().toString());
            count++;
        }
        if (!t3.getText().toString().equals("")) {
            val3 = Float.valueOf(t3.getText().toString());
            count++;
        }
        if (!t4.getText().toString().equals("")) {
            val4 = Float.valueOf(t4.getText().toString());
            count++;
        }
        if (!t5.getText().toString().equals("")) {
            val5 = Float.valueOf(t5.getText().toString());
            count++;
        }
        if (!t6.getText().toString().equals("")) {
            val6 = Float.valueOf(t6.getText().toString());
            count++;
        }
        if (!t7.getText().toString().equals("")) {
            val7 = Float.valueOf(t7.getText().toString());
            count++;
        }
        if (!t8.getText().toString().equals("")) {
            val8 = Float.valueOf(t8.getText().toString());
            count++;
        }

        res = ((val1 + val2 + val3 + val4 + val5 + val6 + val7 + val8) / (float) count);
        perc = (res - 0.5F) * 10;

        return res;
    }

    public void read() {
        try {
            FileInputStream fileInputStream = openFileInput("sem1.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            t1.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = openFileInput("sem2.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            t2.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = openFileInput("sem3.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            t3.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = openFileInput("sem4.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            t4.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = openFileInput("sem5.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            t5.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = openFileInput("sem6.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            t6.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = openFileInput("sem7.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            t7.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = openFileInput("sem8.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            t8.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = openFileInput("cgpa.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            result.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = openFileInput("percent.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            percent.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(String fileName){
        File file = new File(getFilesDir(),fileName);
        if (file.exists())
        {
            deleteFile(fileName);
        }
    }

    public void write(){
        String textToSave = result.getText().toString();
        String textToSave1 = percent.getText().toString();

        try{
            FileOutputStream fileOutputStream = openFileOutput("cgpa.txt",MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileOutputStream fileOutputStream = openFileOutput("percent.txt",MODE_PRIVATE);
            fileOutputStream.write(textToSave1.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}