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

import static com.example.android.meetiasiromania.R.drawable.location;
import static com.example.android.meetiasiromania.R.drawable.museum;

public class MuseumActivity extends AppCompatActivity {

    private Uri mAttractionLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array list for the museum class

        final ArrayList<Word> museums = new ArrayList<Word>();

        museums.add(new Word(museum, "Ion Creanga Museum", "Phone: 0747 499 488", "Hours: 10:00 - 17:00", "Simion Barnutiu Street 4", "Ion Creanga Museum Iasi"));
        museums.add(new Word(museum, "Pogor Memorial House", "Phone: 0232 212 830", "Hours: 10:00 - 17:00", "Carol I Boulevard","Pogor Memorial House"));
        museums.add(new Word(museum, "Dosoftei House", "Phone: 0232 261 070", "Hours: 10:00 - 17:00", "Anastasie Panu Street 54","Dosoftei House"));
        museums.add(new Word(museum, "Golia Monastery", "Phone: 0332 408 549", "Cuza Voda Street 51", "Golia Monastery"));
        museums.add(new Word(museum, "Palace of culture", "Phone: 0232 275 979", "Hours: 10:00 - 17:00", "Stefan the Great Square", "Palace of culture"));
        museums.add(new Word(museum, "Otilia Cazimir Museum", "Phone: 0747 499 402", "Hours: 10:00 - 17:00", "Otilia Cazimir street 4", "Otilia Cazimir Museum"));
        museums.add(new Word(museum, "Union Museum", "Phone: 0232 218 383", "Hours: 10:00 - 17:00", "Alexandru Lapusneanu Street 14", "Union Museum"));

        //Match the color of the Activity with the color of the TextView displayed on the main Activity

        WordAdapter adapter = new WordAdapter(this, museums, R.color.category_museum);

        //Create a GridView

        GridView listView = (GridView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Create an onClickListener so it can open the location of each item when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = museums.get(position);

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
