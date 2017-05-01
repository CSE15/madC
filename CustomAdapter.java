package com.example.android.justjava;

/**
 * Created by Faria huq on 30-Apr-17.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String>{
    public CustomAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_row ,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.custom_row, parent, false);
        // get references.
        String singleFoodItem = getItem(position);
        TextView itemText = (TextView) customView.findViewById(R.id.BuckysText);
        ImageView buckysImage = (ImageView) customView.findViewById(R.id.imageView);

        // dynamically update the text from the array
        itemText.setText(singleFoodItem);
        // using the same image every time
        Context context = buckysImage.getContext();
        int id = context.getResources().getIdentifier(singleFoodItem, "drawable", context.getPackageName());
        buckysImage.setImageResource(id);
        //buckysImage.setImageResource(R.drawable.singleFoodItem);
        // Now we can finally return our custom View or custom item
        return customView;
    }
}

