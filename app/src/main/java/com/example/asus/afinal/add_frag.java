package com.example.asus.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class add_frag extends Fragment {
    private SQLiteDatabase database;
    private ContentValues con_value;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button back = getView().findViewById(R.id.add_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view,new page2_frag()).addToBackStack(null).commit();
            }
        });
        Button save = getView().findViewById(R.id.add_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText date = getView().findViewById(R.id.add_date);
                EditText weight = getView().findViewById(R.id.add_weight);
                String date_str = date.getText().toString();
                String weight_str = weight.getText().toString();
                System.out.println(date_str);

                database = getActivity().openOrCreateDatabase("nate.final", Context.MODE_PRIVATE,null);
                database.execSQL(
                        "CREATE TABLE IF NOT EXISTS db (id INTEGER PRIMARY KEY AUTOINCREMENT, date VARCHAR(5),weight VARCHAR(3)) "
                );
                weight weight_add = new weight();
                weight_add.setConvalue(date_str,weight_str);
                con_value = weight_add.getConvalue();

                database.insert("db",null,con_value);
            }
        });
    }
}
