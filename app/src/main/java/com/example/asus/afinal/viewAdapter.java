package com.example.asus.afinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class viewAdapter extends ArrayAdapter<weight>{
    private List<weight> weights;
    private Context context;

    private LayoutInflater mLayoutInflater;//ใช้สร้าview

    public viewAdapter(Context context, int resource, List<weight> object) {
        super(context, resource, object);
        this.weights = object;
        this.context = context;

        mLayoutInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {

        View _weightItem;

        if (convertView == null) {
            _weightItem = mLayoutInflater.inflate(R.layout.view_item, parent, false);
        } else {
            _weightItem = convertView;
        }

        TextView _date = _weightItem.findViewById(R.id.item_date);
        TextView _weight = _weightItem.findViewById(R.id.item_weight);


        weight _row = weights.get(position);
        _date.setText(_row.getDate());
        _weight.setText(_row.getWeight());
        Log.d("VA",_row.getDate());
        return _weightItem;
    }
}


