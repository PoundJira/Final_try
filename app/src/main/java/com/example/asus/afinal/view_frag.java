package com.example.asus.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class view_frag extends Fragment {
    private SQLiteDatabase database;
    ArrayList<weight> view_list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Button back = getView().findViewById(R.id.view_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view,new page2_frag()).addToBackStack(null).commit();
            }
        });
        super.onActivityCreated(savedInstanceState);
        final viewAdapter viewAdapter = new viewAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1, view_list
        );
        viewAdapter.clear();
        database = getActivity().openOrCreateDatabase("nate.final", Context.MODE_PRIVATE,null);
        database.execSQL(
                "CREATE TABLE IF NOT EXISTS db (id INTEGER PRIMARY KEY AUTOINCREMENT, date VARCHAR(5),weight VARCHAR(3)) "
        );
        Cursor db_query = database.rawQuery("SELECT date,weight FROM db",null);
        String date,weight;
        while (db_query.moveToNext()){
            date = db_query.getString(0);
            weight = db_query.getString(1);
            view_list.add(new weight(date,weight));
            Log.d("VF",date);
        }

        ListView menuList = getView().findViewById(R.id.view_list);;
        menuList.setAdapter(viewAdapter);
        viewAdapter.notifyDataSetChanged();

    }
}
