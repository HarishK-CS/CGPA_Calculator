package com.syndicate.cgpacalculator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class CgpaFragment extends Fragment {
    Button submit, clear,addToProfile;
    ImageView del1,del2,del3,del4,del5,del6,del7,del8, copy, copyPerc,delCgpa,delPercent,wr1,tick2,reload;
    TextView result, percent,resultText,resultText1,s1;
    EditText t1, t2, t3, t4, t5, t6, t7, t8;
    float perc;
    public CgpaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        read();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cgpa, container, false);
        t1 = view.findViewById(R.id.txt1);
        t2 = view.findViewById(R.id.txt2);
        t3 = view.findViewById(R.id.txt3);
        t4 = view.findViewById(R.id.txt4);
        t5 = view.findViewById(R.id.txt5);
        t6 = view.findViewById(R.id.txt6);
        t7 = view.findViewById(R.id.txt7);
        t8 = view.findViewById(R.id.txt8);


        del1 = view.findViewById(R.id.del1);
        del2 = view.findViewById(R.id.del2);
        del3 = view.findViewById(R.id.del3);
        del4 = view.findViewById(R.id.del4);
        del5 = view.findViewById(R.id.del5);
        del6 = view.findViewById(R.id.del6);
        del7 = view.findViewById(R.id.del7);
        del8 = view.findViewById(R.id.del8);

//        wr1 = view.findViewById(R.id.wr1);
//
//        s1= view.findViewById(R.id.s1);
//
//        tick2= view.findViewById(R.id.tick2);

        delCgpa = view.findViewById(R.id.delCgpa);
        delPercent = view.findViewById(R.id.delPercent);

        result = view.findViewById(R.id.ResultId);
        resultText = view.findViewById(R.id.ResultTextId);
        resultText1 = view.findViewById(R.id.ResultText1Id);
        percent = view.findViewById(R.id.ResultPercentId);
        submit = view.findViewById(R.id.Btn_Submit);
        addToProfile = view.findViewById(R.id.Btn_AddToProfile);
        clear = view.findViewById(R.id.Btn_Clear);
        copy = view.findViewById(R.id.Btn_Copy);
        copyPerc = view.findViewById(R.id.Btn_CopyPerc);
        reload = view.findViewById(R.id.Btn_Reload);
        read();

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
            addToProfile.setVisibility(View.VISIBLE);
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

//        wr1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                s1.setVisibility(View.INVISIBLE);
//                t1.setVisibility(View.VISIBLE);
//                del1.setVisibility(View.INVISIBLE);
//                tick1.setVisibility(View.VISIBLE);
//            }
//        });
//
//        tick1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                t1.setVisibility(View.INVISIBLE);
//                tick1.setVisibility(View.INVISIBLE);
//                s1.setText(t1.getText().toString());
//                s1.setVisibility(View.VISIBLE);
//                String textToSave = s1.getText().toString();
//                try{
//                    FileOutputStream fileOutputStream = getActivity().openFileOutput("sem1.txt",getActivity().MODE_PRIVATE);
//                    fileOutputStream.write(textToSave.getBytes());
//                    fileOutputStream.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        // setupSemInputs();
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().detach(CgpaFragment.this).attach(CgpaFragment.this).commit();
                read();
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
        }});

        addToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeProfile();
                Toast.makeText(getActivity(), "Added To Profile", Toast.LENGTH_SHORT).show();
            }
        });
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
                    addToProfile.setVisibility(View.VISIBLE);
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
                copy.setVisibility(View.INVISIBLE);
                copyPerc.setVisibility(View.INVISIBLE);
                del1.setVisibility(View.INVISIBLE);
                del2.setVisibility(View.INVISIBLE);
                del3.setVisibility(View.INVISIBLE);
                del4.setVisibility(View.INVISIBLE);
                del5.setVisibility(View.INVISIBLE);
                del6.setVisibility(View.INVISIBLE);
                del7.setVisibility(View.INVISIBLE);
                del8.setVisibility(View.INVISIBLE);
                delCgpa.setVisibility(View.INVISIBLE);
                delPercent.setVisibility(View.INVISIBLE);
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", result.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getActivity(), "CGPA Copied", Toast.LENGTH_SHORT).show();

            }
        });
        copyPerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", percent.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getActivity(), "Percentage Of Marks Copied", Toast.LENGTH_SHORT).show();

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



        return view;
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
//        try {
//            FileInputStream fileInputStream = getActivity().openFileInput("sem1.txt");
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            StringBuffer stringBuffer = new StringBuffer();
//
//            String lines;
//            if(bufferedReader.readLine() != null) {
//                while ((lines = bufferedReader.readLine()) != null) {
//                    stringBuffer.append(lines + "\n");
//                }
//                s1.setVisibility(View.VISIBLE);
//                t1.setText(stringBuffer.toString());
//                s1.setText(t1.getText().toString());
//            }else{
//                del1.setVisibility(View.INVISIBLE);
//                t1.setText("---");
//                s1.setText(t1.getText().toString());
//                s1.setVisibility(View.VISIBLE);
//                tick1.setVisibility(View.INVISIBLE);
//                wr1.setVisibility(View.VISIBLE);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            FileInputStream fileInputStream = getActivity().openFileInput("sem1.txt");
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
            FileInputStream fileInputStream = getActivity().openFileInput("sem2.txt");
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
            FileInputStream fileInputStream = getActivity().openFileInput("sem3.txt");
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
            FileInputStream fileInputStream = getActivity().openFileInput("sem4.txt");
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
            FileInputStream fileInputStream = getActivity().openFileInput("sem5.txt");
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
            FileInputStream fileInputStream = getActivity().openFileInput("sem6.txt");
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
            FileInputStream fileInputStream = getActivity().openFileInput("sem7.txt");
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
            FileInputStream fileInputStream = getActivity().openFileInput("sem8.txt");
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
            FileInputStream fileInputStream = getActivity().openFileInput("cgpa.txt");
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
            FileInputStream fileInputStream = getActivity().openFileInput("percent.txt");
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
        File file = new File(Objects.requireNonNull(getActivity()).getFilesDir(),fileName);
        if (file.exists())
        {
            getActivity().deleteFile(fileName);
        }
    }

    public void write(){
        String textToSave = result.getText().toString();
        String textToSave1 = percent.getText().toString();

        try{
            FileOutputStream fileOutputStream = getActivity().openFileOutput("cgpa.txt",getActivity().MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileOutputStream fileOutputStream = getActivity().openFileOutput("percent.txt",getActivity().MODE_PRIVATE);
            fileOutputStream.write(textToSave1.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeProfile(){
        String textToSave = result.getText().toString();
        String textToSave1 = percent.getText().toString();

        try{
            FileOutputStream fileOutputStream = getActivity().openFileOutput("cgpaProfile.txt",getActivity().MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileOutputStream fileOutputStream = getActivity().openFileOutput("percentProfile.txt",getActivity().MODE_PRIVATE);
            fileOutputStream.write(textToSave1.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


