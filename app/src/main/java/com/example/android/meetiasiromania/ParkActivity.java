package com.example.android.meetiasiromania;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class ParkActivity extends AppCompatActivity {

    private Uri mAttractionLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> parks = new ArrayList<Word>();

        parks.add(new Word(R.drawable.park,"Palas Park", "Palas Street 7A", "47.1566525, 27.587093299999992"));
        parks.add(new Word(R.drawable.park,"Copou Park", "Carol I Boulevard 31", "Copou Park Iasi"));
        parks.add(new Word(R.drawable.park,"Exposition Park", "Grigore Ghica Voda Alley", "Parcul Expozitiei Iasi"));
        parks.add(new Word(R.drawable.park,"Botanic Garden","Phone: 0232 201 373","Hours: 09:00 - 20:00", "Red Grove Street 7-9", "Botanic Garden Iasi"));

        //Match the color of the Activity with the color of the TextView displayed on the main Activity
        WordAdapter adapter = new WordAdapter(this, parks, R.color.category_park );

        //Create a GridView
        GridView listView = (GridView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Create an onClickListener so it can open the location of each item when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = parks.get(position);

                mAttractionLocation = Uri.parse("geo:0,0?q=" + word.getLocation());
                Intent intent = new Intent(Intent.ACTION_VIEW, mAttractionLocation);

                //Check to see if there is an app that can handle this intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
