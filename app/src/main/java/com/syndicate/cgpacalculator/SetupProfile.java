package com.syndicate.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SetupProfile extends AppCompatActivity {

    EditText name;
    Button setUpSubmit;
    String res_dept,res_year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_profile);

        name = findViewById(R.id.txt_name);
        setUpSubmit = findViewById(R.id.Btn_setupProfile);

        Spinner dept = findViewById(R.id.spinner_dept);
        Spinner year = findViewById(R.id.spinner_year);


        final ArrayAdapter<CharSequence> adapterDept = ArrayAdapter.createFromResource(this,R.array.dept,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterYear = ArrayAdapter.createFromResource(this,R.array.year,android.R.layout.simple_spinner_item);

        adapterDept.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dept.setAdapter(adapterDept);
        year.setAdapter(adapterYear);

        dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                res_dept = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                res_year = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        setUpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (res_dept.equals("----"))
                {
                    Toast.makeText(SetupProfile.this,"Please Select a Valid Dept!",Toast.LENGTH_SHORT).show();
                }
                if(res_year.equals("----")){
                    Toast.makeText(SetupProfile.this,"Please Select a Year Year!",Toast.LENGTH_SHORT).show();
                }
                if(name.getText().toString().equals(""))
                {
                    Toast.makeText(SetupProfile.this,"Type A Valid Name !",Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        FileOutputStream fileOutputStream = openFileOutput("name.txt",MODE_PRIVATE);
                        fileOutputStream.write(name.getText().toString().getBytes());
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try{
                        FileOutputStream fileOutputStream = openFileOutput("dept.txt",MODE_PRIVATE);
                        fileOutputStream.write(res_dept.getBytes());
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try{
                        FileOutputStream fileOutputStream = openFileOutput("year.txt",MODE_PRIVATE);
                        fileOutputStream.write(res_year.getBytes());
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try{
                        String log = "1";
                        FileOutputStream fileOutputStream = openFileOutput("logged.txt",MODE_PRIVATE);
                        fileOutputStream.write(log.getBytes());
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(SetupProfile.this,"Informations Are Updated Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SetupProfile.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }
}
