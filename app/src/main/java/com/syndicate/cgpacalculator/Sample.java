package com.syndicate.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Sample extends AppCompatActivity {

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, PackageManager.PERMISSION_GRANTED);
        t1 = findViewById(R.id.t1);
        read();
        printPdf();

    }
    public void read() {
        String[] sub = {"M I","Physics","chemistry","BEEE","TD","CP","CP  Lab","EG","BEE  Lab"};
        try {
            FileInputStream fileInputStream = openFileInput("sem1Gpa.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines= bufferedReader.readLine();
//            while ((lines = bufferedReader.readLine()) != null) {
//                if (lines == " ") {
//                    arrayList.add(stringBuffer);
//                    stringBuffer = new StringBuffer();
//                }
//                stringBuffer.append(lines + "\n");
//
//            }
            String a  = lines.trim().replaceAll(" ","");
            String  temp  ="";
            int j = 0;
            char[] ch=a.toCharArray();
            for(int  i=0;i<9;i++)
            {
                temp = temp + "\n"+sub[j]+" : "+ch[i];
                j++;
            }
//            for(char i: ch){
//                temp = temp + "\n"+sub[j]+" : "+i;
//                j++;
//            }
            t1.setText(temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printPdf(){
        PdfDocument myPdfDocument = new PdfDocument();
        Paint myPaint =new Paint();

        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(1000,1500,1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);
        Canvas canvas = myPage.getCanvas();

        myPaint.setTextSize(80);
        canvas.drawText("CGPA Calculator",30,80,myPaint);

//        myPaint.setTextSize(50);
//        canvas.drawText("Name :",30,80,myPaint);
//        canvas.drawText("Register No :",30,80,myPaint);
//        canvas.drawText("Dept :",30,80,myPaint);
//        canvas.drawText("Year :",30,80,myPaint);
//
//        myPaint.setTextAlign(Paint.Align.RIGHT);
//        canvas.drawText("DateTime ",canvas.getWidth()-40,40,myPaint);
//
//        myPaint.setColor(Color.rgb(150,150,150));
//        canvas.drawRect(30,150,canvas.getWidth()-30,160,myPaint);

        myPdfDocument.finishPage(myPage);
//        File file = new File(Environment.getExternalStorageDirectory(null),"/cgpa.pdf");
        File file = new File(getExternalFilesDir(null),"cgpa.pdf");
        try{
            myPdfDocument.writeTo(new FileOutputStream(file));
        }catch (IOException e) {
            e.printStackTrace();
        }

        myPdfDocument.close();
        Toast.makeText(Sample.this,"printed ",Toast.LENGTH_SHORT).show();


    }

}
