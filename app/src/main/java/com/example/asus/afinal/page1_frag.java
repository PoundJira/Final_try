package com.example.asus.afinal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class page1_frag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page1,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button go = getView().findViewById(R.id.gogo);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = getView().findViewById(R.id.input_text);
                String input_str = input.getText().toString();
                String test = input_str.toUpperCase();
                if(input_str.charAt(0)==(test.charAt(0)) && input_str.length() >= 3){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view,new page2_frag()).addToBackStack(null).commit();
                    Log.d("P1",input_str);
                    SharedPreferences.Editor name = getContext().getSharedPreferences("name", Context.MODE_PRIVATE).edit();
                    name.putString("name",input_str).apply();
                    name.commit();
                }


            }
        });
    }
}
