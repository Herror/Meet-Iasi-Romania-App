package com.example.android.meetiasiromania;

import android.net.Uri;

import static android.R.attr.name;
import static com.example.android.meetiasiromania.R.drawable.location;

/**
 * Created by enach on 9/6/2017.
 */

public class Word {

    private int mPhotoResource;
    private String mAttractionName;
    private String mAttractionPhone;
    private String mAttractionHours;
    private String mAttractionLocation;
    private String mLocation;


    public Word (int photoResource, String attractionName, String attractionPhone,
                 String attractionHours, String attractionLocation,String locationOnMap){
        mPhotoResource = photoResource;
        mAttractionName = attractionName;
        mAttractionPhone = attractionPhone;
        mAttractionHours = attractionHours;
        mAttractionLocation = attractionLocation;
        mLocation = locationOnMap;
    }

    public Word (int photoResource, String attractionName,
                 String attractionHours, String attractionLocation, String locationOnMap){
        mPhotoResource = photoResource;
        mAttractionName = attractionName;
        mAttractionHours = attractionHours;
        mAttractionLocation = attractionLocation;
        mLocation = locationOnMap;
    }

    public Word (int photoResource, String attractionName, String attractionLocation, String locationOnMap){
        mPhotoResource = photoResource;
        mAttractionName = attractionName;
        mAttractionLocation = attractionLocation;
        mLocation = locationOnMap;
    }

    public int getPhotoResource() {
        return mPhotoResource;
    }

    public String getAttractionName() {
        return mAttractionName;
    }

    public String getAttractionPhone(){
        return mAttractionPhone;
    }

    public String getAttractionHours(){
        return mAttractionHours;
    }

    public String getAttractionLocation(){
        return mAttractionLocation;
    }

    public String getLocation(){
        return mLocation;
    }

}
