package com.example.asus.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

public class Image extends Fragment {
    private SQLiteDatabase database;
    private ContentValues conValue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView imageView = getView().findViewById(R.id.image_view);

        String url = "https://www.what-dog.net/Images/faces2/scroll001.jpg";

        try{
            String filename = “test.txt”;
            FileOutputStream fos = openFileOutput(filename, MODE_PRIVATE);
            fos.write("data in ".getBytes());
            fos.close();
            FileInputStream fis = openFileInput(filename);
            IOUtils.readInputStreamFully(fis).toString();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        Picasso.with(getActivity()).load(url).into(imageView);
    }
}
