package com.myapplicationdev.android.mydatabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] value;
    ImageView iv;
    TextView tv;

    public CustomAdapter(Context context, int resource,String[] values) {
        super(context, resource, values);
        value = values;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.row, parent, false);

        iv = rowView.findViewById(R.id.iv);
        tv = rowView.findViewById(R.id.tv);
        tv.setText(value[position]);
        String category = value[position];

        if (category.startsWith("Bio")){
            iv.setImageResource(R.drawable.ic_bio_black_24dp);
        } else if (category.startsWith("Anniversary")){
            iv.setImageResource(R.drawable.ic_anniversary_format_black_24dp);
        } else if (category.startsWith("Vaccination")){
            iv.setImageResource(R.drawable.ic_vac_edit_black_24dp);
        } else if(category.startsWith("About Us")) {
            iv.setImageResource(R.drawable.ic_about_border_black_24dp);
        }
        return rowView;
    }
}
