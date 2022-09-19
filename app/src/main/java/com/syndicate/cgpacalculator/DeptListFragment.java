package com.syndicate.cgpacalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeptListFragment extends Fragment {
    Button btnCSE,btnIT,btnECE,btnEEE,btnMech,btnCivil;
    GridView gridView;
    public DeptListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dept_list, container, false);

        gridView = view.findViewById(R.id.gridview);
        gridView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        ImageAdapter imageAdapter = new ImageAdapter(view.getContext());
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    Intent intent = new Intent(getActivity(), CseSemList.class);
                    startActivity(intent);
                }else if(i==1) {
                    Intent intent = new Intent(getActivity(), EceSemList.class);
                    startActivity(intent);
                }else if(i==2) {
                    Intent intent = new Intent(getActivity(), EeeSemList.class);
                    startActivity(intent);
                }else if(i==3) {
                    Intent intent = new Intent(getActivity(), MechSemList.class);
                    startActivity(intent);
                }else if(i==4) {
                    Intent intent = new Intent(getActivity(), CivilSemList.class);
                    startActivity(intent);
                }else if(i==5) {
                    Intent intent = new Intent(getActivity(), ItSemList.class);
                    startActivity(intent);
                }
            }
        });
                return view;
    }

}



//        btnCSE = view.findViewById(R.id.btnCse);
//        btnIT = view.findViewById(R.id.btnIt);
//        btnECE = view.findViewById(R.id.btnECE);
//        btnEEE = view.findViewById(R.id.btnEEE);
//        btnMech = view.findViewById(R.id.btnMech);
//        btnCivil = view.findViewById(R.id.btnCivil);
//
//        btnCSE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),CseSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnIT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),ItSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnECE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),EceSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnEEE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),EeeSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnMech.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),MechSemList.class);
//                startActivity(intent);
//            }
//        });
//
//        btnCivil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),CivilSemList.class);
//                startActivity(intent);
//            }
//        });

