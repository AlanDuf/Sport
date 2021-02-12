package com.example.sport;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class Frag_main extends Fragment implements View.OnClickListener {

    public Frag_main() {
        super(R.layout.frag_main);
    }
    AppCompatActivity activity;
    String nameEx, TypeEx,poids,nbrep;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = getView().findViewById(R.id.btn);
        Button button1 = getView().findViewById(R.id.btn2);
        String name = this.getArguments().getString("name");
        String type= this.getArguments().getString("type");
        System.out.println(name);
        TextView tv = getView().findViewById(R.id.textView);
        TextView tv2= getView().findViewById(R.id.textView2);
        poids = this.getArguments().getString("poids");
        nbrep = this.getArguments().getString("rep");
        tv.setText(name);
        nameEx= name;
        TypeEx = type;
        tv2.setText(type);
        Button btn = getView().findViewById(R.id.btnseance);
        btn.setOnClickListener(this);
        Button btnSwitch = getView().findViewById(R.id.btnswitch);
        btnSwitch.setOnClickListener(this);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);

    }
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        this.activity = (AppCompatActivity) context;
    }
    @Override
    public void onClick(View v) {
        Frag_addExercice fragmentAddExercice = new Frag_addExercice();
        Frag_modif fragmentModifyExo = new Frag_modif();
        Bundle b = new Bundle();
        b.putString("name", nameEx );
        b.putString("type", TypeEx );
        b.putString("rep", nbrep);
        b.putString("poids", poids);
        switch (v.getId()) {
            case R.id.btn:
                System.out.println(nameEx+" "+TypeEx);
                fragmentAddExercice.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentAddExercice).commit();
                break;
            case R.id.btn2:
                fragmentModifyExo.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentModifyExo).commit();
                break;
            case R.id.btnseance:
                ((Activity2)getActivity()).launchAct3();
                break;
            case R.id.btnswitch:
                ((Activity2)getActivity()).switchEx();
        }
    }
}