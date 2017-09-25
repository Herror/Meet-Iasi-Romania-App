package com.example.android.meetiasiromania;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.resource;


public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;


    public WordAdapter(Activity context, ArrayList<Word> word, int colorResourceId) {
        super(context, 0, word);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_items, parent, false);
        }

        Word currentWordAdapter = getItem(position);

        //Create the object for the image in the GridView

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.attraction_photo);

        imageView.setImageResource(currentWordAdapter.getPhotoResource());

        //Create the object for the name of the attraction

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.attraction_name);

        nameTextView.setText(currentWordAdapter.getAttractionName());

        //Create the object for the phone of the attraction

        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.attraction_phone);

        phoneTextView.setText(currentWordAdapter.getAttractionPhone());

        //Create the object for the hours that the attraction is operating

        TextView hoursTextView = (TextView) listItemView.findViewById(R.id.attraction_hours);

        hoursTextView.setText(currentWordAdapter.getAttractionHours());

        //Create the object for the location of the attraction

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.attraction_location);

        locationTextView.setText(currentWordAdapter.getAttractionLocation());

        //Set the color of each activity to match the one from the main activity

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);

        return listItemView;

    }
}
