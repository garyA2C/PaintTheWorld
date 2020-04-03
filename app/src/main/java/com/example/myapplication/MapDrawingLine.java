package com.example.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.api.IGeoPoint;

import java.util.ArrayList;

public class MapDrawingLine {
    private ArrayList<IGeoPoint> pointList;
    private int color;
    private int thickness;

    public MapDrawingLine(ArrayList<IGeoPoint> pointList, int sRGBColor, int thickness) {
        this.pointList = pointList;
        this.color = sRGBColor & 0x00ffffff;
        this.thickness = thickness;
    }

    public ArrayList<IGeoPoint> getPointList() {
        return pointList;
    }

    public int getColor() {
        return color;
    }

    public int getThickness() {
        return thickness;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        JSONArray pointsArray = new JSONArray();
        try {

            json.put("color", this.color);
            json.put("thickness", this.thickness);
            for (IGeoPoint geoPoint : this.pointList) {
                JSONArray point = new JSONArray();
                point.put(geoPoint.getLatitude());
                point.put(geoPoint.getLongitude());
                pointsArray.put(point);
            }
            json.put("location", pointsArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

}