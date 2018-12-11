package com.example.asus.afinal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class page2_frag extends Fragment {
    ArrayList<String> menu = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page2,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menu.add("ADD");
        menu.add("VIEW");
        menu.add("THEME");
        menu.add("PIC");
        final ArrayAdapter<String> _menuAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1, menu
        );

        ListView menuList = getView().findViewById(R.id.list);;
        menuList.setAdapter(_menuAdapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("MENU", "Click on menu = " + menu.get(i));
                if (i == 0) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view,new add_frag()).addToBackStack(null).commit();
                }else if(i==1){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view,new view_frag()).addToBackStack(null).commit();
                }else if(i==3){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view,new Image()).addToBackStack(null).commit();
                }
            }
        });
    }
    }
