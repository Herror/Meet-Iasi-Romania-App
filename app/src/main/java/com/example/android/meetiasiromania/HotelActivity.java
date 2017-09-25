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

public class HotelActivity extends AppCompatActivity {

    private Uri mAttractionLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> hotels = new ArrayList<Word>();

        hotels.add(new Word(R.drawable.traian,"Traian","Phone: 0232 266 666","Union Square 1", "Traian Hotel Iasi"));
        hotels.add(new Word(R.drawable.international,"International","Phone: 0332 110 060","Palat Street 5A", "International Hotel Iasi"));
        hotels.add(new Word(R.drawable.hotel,"Moldova","Phone: 0232 260 240", "Anastasie Panu Street 31", "Moldova Hotel Iasi"));
        hotels.add(new Word(R.drawable.ramada,"Ramada","Phone: 0232 256 070","27 Grigore Ureche 170044", "Ramada Hotel Iasi"));
        hotels.add(new Word(R.drawable.unirea,"Unirea","Phone: 0232 205 000","Union Square 5", "Unirea Hotel Iasi"));
        hotels.add(new Word(R.drawable.bellaria,"Bellaria","Phone: 0232 233 870","Bucium Street", "Bellaria Hotel Iasi"));
        hotels.add(new Word(R.drawable.hotel,"Select","Phone: 0232 210 715","14th December Street 1989 2", "Select Hotel Iasi"));
        hotels.add(new Word(R.drawable.hotel,"Astoria","Phone: 0232 233 888","Alexandru Lapusneanu Street 1", "Astoria Hotel Iasi"));

        //Match the color of the Activity with the color of the TextView displayed on the main Activity

        WordAdapter itemsAdapter = new WordAdapter(this, hotels, R.color.category_hotel );

        //Create a GridView

        GridView listView = (GridView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        //Create an onClickListener so it can open the location of each item when clicked

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = hotels.get(position);

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
