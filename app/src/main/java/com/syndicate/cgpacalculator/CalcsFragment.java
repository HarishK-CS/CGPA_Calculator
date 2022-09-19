package com.syndicate.cgpacalculator;

import android.os.Bundle;
import org.mariuszgromada.math.mxparser.*;
import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalcsFragment extends Fragment {
    Button zeroBtn,oneBtn,twoBtn,threeBtn,fourBtn,fiveBtn,sixBtn,sevenBtn,eightBtn,nineBtn,clearBtn,exponentBtn,parentheisBtn,divideBtn,multiplyBtn,addBtn,subBtn,plusMinusBtn,pointBtn,equalsBtn;
    ImageButton backspaceBtn;
    EditText display;
    public CalcsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calcs, container, false);
        zeroBtn = view.findViewById(R.id.zero);
        oneBtn = view.findViewById(R.id.one);
        twoBtn = view.findViewById(R.id.two);
        threeBtn = view.findViewById(R.id.three);
        fourBtn= view.findViewById(R.id.four);
        fiveBtn= view.findViewById(R.id.five);
        sixBtn= view.findViewById(R.id.six);
        sevenBtn= view.findViewById(R.id.seven);
        eightBtn= view.findViewById(R.id.eight);
        nineBtn = view.findViewById(R.id.nine);
        clearBtn= view.findViewById(R.id.clear);
        exponentBtn= view.findViewById(R.id.exponent);
        parentheisBtn= view.findViewById(R.id.parenthesis);
        divideBtn= view.findViewById(R.id.divide);
        multiplyBtn= view.findViewById(R.id.multiply);
        addBtn= view.findViewById(R.id.add);
        subBtn= view.findViewById(R.id.sub);
        plusMinusBtn= view.findViewById(R.id.plusMinus);
        pointBtn= view.findViewById(R.id.point);
        equalsBtn= view.findViewById(R.id.equal);
        backspaceBtn= view.findViewById(R.id.backspace);

        display = view.findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("0");
            }
        });

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("1");
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("2");
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("3");
            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("4");
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("5");
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("6");
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("7");
            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("8");
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("9");
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
            }
        });

        exponentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("^");
            }
        });
        parentheisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cursorPos = display.getSelectionStart();
                int openPar = 0;
                int closePar = 0;
                int textLen = display.getText().length();

                for(int i=0;i<cursorPos;i++){
                    if(display.getText().toString().substring(i,i+1).equals("(")){
                        openPar +=1;
                    }
                    if(display.getText().toString().substring(i,i+1).equals(")")){
                        closePar +=1;
                    }
                }
                if (openPar == closePar || display.getText().toString().substring(textLen-1,textLen).equals("(")){
                    updateText("(");
                }
                else if (closePar < openPar && !display.getText().toString().substring(textLen-1,textLen).equals("(")){
                    updateText(")");
                }
                display.setSelection(cursorPos+1);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("÷");
            }
        });
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("x");
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("+");
            }
        });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("-");
            }
        });

        plusMinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("-");
            }
        });
        pointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(".");
            }
        });

        equalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userExp = display.getText().toString();
                userExp = userExp.replaceAll("÷","/");
                userExp = userExp.replaceAll("x","*");

                Expression exp = new Expression(userExp);
                String result = String.valueOf(exp.calculate());

                display.setText(result);
                display.setSelection(result.length());
            }
        });
        backspaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cursorPos = display.getSelectionStart();
                int textLen = display.getText().length();
                if(cursorPos!=0 && textLen!=0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(cursorPos-1,cursorPos,"");
                    display.setText(selection);
                    display.setSelection(cursorPos-1);
                }
            }
        });






        return view;
    }

    public void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPosition);
        String rightStr = oldStr.substring(cursorPosition);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPosition+1);
        }
        else{
            display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            display.setSelection(cursorPosition+1);
        }

    }


}
