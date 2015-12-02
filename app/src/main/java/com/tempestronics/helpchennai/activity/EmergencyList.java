package com.tempestronics.helpchennai.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tempestronics.helpchennai.R;
import com.tempestronics.helpchennai.model.Emergency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moz on 02/12/15.
 */
public class EmergencyList extends Base {

    ListView listView;
    List<Emergency> emergencyList;

    public static Intent newInstance(Context context) {
        return new Intent(context, EmergencyList.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        emergencyList = new ArrayList<>();
        emergencyList.add(new Emergency("Food Distribution (Karthick)", "+919840315393"));
        emergencyList.add(new Emergency("Accomodation Hall (Nungampakkam)", "1913"));
        emergencyList.add(new Emergency("Accomodation Hall (Sowcarpet)", "+918056169969"));
        emergencyList.add(new Emergency("Boat & Jeep #1 (ShowKat)", "+919940488880"));
        emergencyList.add(new Emergency("Boat & Jeep #2 (Shyam)", "+919841816271"));
        emergencyList.add(new Emergency("Medical Help (KK Nagar, T Nagar)", "+919790801234"));
        emergencyList.add(new Emergency("Oxygen Cylinder / Generator", "+919840997657"));
        emergencyList.add(new Emergency("Boat Rescue Service", "30003000"));
        emergencyList.add(new Emergency("Boat in Mission (Mudichur)", "+919500002000"));
        emergencyList.add(new Emergency("Free Topup (ANY NETWORK)", "18001030033"));
        emergencyList.add(new Emergency("Ambulance (George Town, Tondeyarpet)", "+919500000310"));
        emergencyList.add(new Emergency("Ambulance (Triplicane)", "+919500000389"));
        emergencyList.add(new Emergency("Ambulance (Royapuram)", "+919380796329"));
        emergencyList.add(new Emergency("Helicopter on Mission", "+919547159884"));
        emergencyList.add(new Emergency("National Disaster Relief Force", "1078"));
        emergencyList.add(new Emergency("Tree Fall, Water Logging", "1913"));
        emergencyList.add(new Emergency("Sewage Overflow #1", "45674567"));
        emergencyList.add(new Emergency("Sewage Overflow #2", "22200335"));
        emergencyList.add(new Emergency("State Emergency", "1070"));
        emergencyList.add(new Emergency("District Emergency", "1077"));
        emergencyList.add(new Emergency("Electricity", "1912"));
        emergencyList.add(new Emergency("Fire & Rescue", "101"));

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[emergencyList.size()];
        for(int i = 0; i < emergencyList.size(); i++) {
            values[i] = emergencyList.get(i).getName();
        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String  itemValue = (String) listView.getItemAtPosition(position);

                // Dial Number
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + emergencyList.get(itemPosition).getNumber()));
                startActivity(intent);

            }

        });
    }

}