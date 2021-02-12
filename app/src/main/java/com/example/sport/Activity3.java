package com.example.sport;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        Bundle b=this.getIntent().getExtras();
        Frag_display frag_display = new Frag_display();
        frag_display.setArguments(b);
        getSupportFragmentManager().beginTransaction()
                //replace in activity_main.xml the view with id frag_menu with the fragment fragMenu passing a null bundle (bundle is used to pass data to your fragment)
                .add(R.id.framlayout2, frag_display, null)
                //commit to update
                .commit();

    }

    @Override
    public void onClick(View view) {

    }
}
