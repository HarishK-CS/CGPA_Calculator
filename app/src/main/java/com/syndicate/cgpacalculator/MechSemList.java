package com.syndicate.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MechSemList extends AppCompatActivity {
    Button sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech_sem_list);

        sem1 = findViewById(R.id.sem1Id);
        sem2 = findViewById(R.id.sem2Id);
        sem3 = findViewById(R.id.sem3Id);
        sem4 = findViewById(R.id.sem4Id);
        sem5 = findViewById(R.id.sem5Id);
        sem6 = findViewById(R.id.sem6Id);
        sem7 = findViewById(R.id.sem7Id);
        sem8 = findViewById(R.id.sem8Id);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MechSemList.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        sem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MechSemList.this,CseSem1List.class);
                startActivity(intent);
            }
        });

        sem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MechSemList.this,CseSem2List.class);
                startActivity(intent);
            }
        });

        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MechSemList.this,MechSem3List.class);
                startActivity(intent);
            }
        });

        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MechSemList.this,MechSem4List.class);
                startActivity(intent);
            }
        });

        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MechSemList.this,MechSem5List.class);
                startActivity(intent);
            }
        });

        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MechSemList.this,MechSem6List.class);
                startActivity(intent);
            }
        });
        sem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MechSemList.this,MechSem7List.class);
                startActivity(intent);
            }
        });

        sem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MechSemList.this,MechSem8List.class);
                startActivity(intent);
            }
        });


    }


}
