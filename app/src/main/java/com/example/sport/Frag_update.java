package com.example.sport;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/*
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
*/
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class Frag_update extends Fragment implements View.OnClickListener {
    public Frag_update() {
        super(R.layout.frag_update);
    }
    String url_img ;
    TextView textView;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button button = getView().findViewById(R.id.buttonaddquote);
        button.setOnClickListener(this);
        textView = getView().findViewById(R.id.idquote);
       /* Ion.with(this)
                .load("http://api.quotable.io/random")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        url_img = result.get("content").getAsString();
                        textView.setText(url_img);
                    }
                }); */
    }

    @Override
    public void onClick(View view) {
        textView = getView().findViewById(R.id.idquote);
   /*     Ion.with(this)
                .load("http://api.quotable.io/random")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        url_img = result.get("content").getAsString();
                        textView.setText(url_img);
                    }
                });
*/
    }
}