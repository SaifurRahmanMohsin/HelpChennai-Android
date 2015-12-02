package com.tempestronics.helpchennai;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tempestronics.helpchennai.model.Doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moz on 02/12/15.
 */
public class DoctorList extends Base {

    ListView listView;
    List<Doctor> doctors;

    public static Intent newInstance(Context context) {
        return new Intent(context, DoctorList.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        doctors = new ArrayList<>();

        doctors.add(new Doctor("Athheswar Das", "Alwarpet", "9600014123‬"));
        doctors.add(new Doctor("Velmurugan", "Maduravoyal & Koyambedu", "9840734972"));
        doctors.add(new Doctor("Suman Bohra", "Perambur", "9884358810"));
        doctors.add(new Doctor("Dhanasekar", "Unspecified", "9791171468"));
        doctors.add(new Doctor("Mohan Kumar", "Anna Nagar", "9840666005"));
        doctors.add(new Doctor("Vetri Vendan", "Mylapore", "9884013785"));
        doctors.add(new Doctor("Mathews", "Egmore", "9444126169"));
        doctors.add(new Doctor("R.S.Anbu Selvam", "Thiruvottiyur", "9840193035"));
        doctors.add(new Doctor("Radhika Balasubramanian", "Royapettah", "9840266291"));
        doctors.add(new Doctor("Raghul", "Royapuram", "9944611395"));
        doctors.add(new Doctor("Rahman", "Triplicane", "9840177675"));
        doctors.add(new Doctor("Chandrika", "Nanganallur", "9789330909"));
        doctors.add(new Doctor("Dhinaesh Nayak", "Adyar", "9840642724"));
        doctors.add(new Doctor("Venkat", "Triplicane", "9840032323"));
        doctors.add(new Doctor("Karthik", "Unspecified", "9840106608"));
        doctors.add(new Doctor("Sudipta", "Kilpauk", "9791619530"));
        doctors.add(new Doctor("Talat Salim", "Anna Nagar East", "9840135786"));
        doctors.add(new Doctor("Siddharth Sv", "RK Salai", "9790742708"));
        doctors.add(new Doctor("Balaji", "Choolaimedu", "9487105950"));
        doctors.add(new Doctor("N.Sundar", "Shenoy Nagar", "9840522767"));
        doctors.add(new Doctor("Vidhya Hari", "T Nagar", "9840176088"));
        doctors.add(new Doctor("Malini", "Mylapore", "9884114009"));
        doctors.add(new Doctor("K. Shanmugam", "Koyambedu", "9840139808"));
        doctors.add(new Doctor("ganesh", "Avadi/Ambattur", "9176210077"));
        doctors.add(new Doctor("Karthik Narayan", "Anna Nagar West", "9841279891"));
        doctors.add(new Doctor("Y.D. Meher Prasad", "Kodambakkam", "9840652317"));
        doctors.add(new Doctor("Republica Sridhar", "T.Nagar", "9381016588"));
        doctors.add(new Doctor("Senthil Velan", "Vadapalni", "9566222533"));
        doctors.add(new Doctor("Yeshwanth Venkatraman", "Anna Nagar, Adyar", "9840077000"));
        doctors.add(new Doctor("Balaji", "Moggapair", "9940455839"));
        doctors.add(new Doctor("Bala", "Central", "9894420920"));
        doctors.add(new Doctor("Harish Kumar", "Mylapore", "9841238815"));
        doctors.add(new Doctor("Sindhuja Rajasekaran", "Ekkaduthangal", "9994672189"));
        doctors.add(new Doctor("K. Shanmugam", "Koyambedu", "9840139808"));
        doctors.add(new Doctor("S.Vaiyamalai", "Pattabiram", "9840056964"));
        doctors.add(new Doctor("A. Sethuramashankaran", "Perambur", "9600089360"));
        doctors.add(new Doctor("Harini", "Unspecified", "9445481660"));
        doctors.add(new Doctor("Karthikeyan Vishwanathan", "Thiruvanmiyur", "9940225042"));
        doctors.add(new Doctor("P.Selvakumar", "Aminjikarai", "9444414253"));
        doctors.add(new Doctor("A.K. Geetha Devi", "Purasawakkam", "9940165160"));
        doctors.add(new Doctor("Vivekanantha Raj", "Thiruvottiyur", "9600014740"));
        doctors.add(new Doctor("Rajavel", "Egmore", "9566205225"));

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[doctors.size()];
        for(int i = 0; i < doctors.size(); i++) {
            values[i] = doctors.get(i).getName() + " (" + doctors.get(i).getArea() + ")";
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

                // Show Alert
                AlertDialog.Builder alert = new AlertDialog.Builder(DoctorList.this);
                alert.setTitle("Make a call");
                alert.setMessage("Clicking OK will call " + doctors.get(itemPosition).getName() + " at " + doctors.get(itemPosition).getNumber());
                alert.setPositiveButton("OK", new PhoneOnClickListener(doctors.get(itemPosition).getNumber()));
                alert.setNegativeButton("Cancel", null);
                alert.show();

            }

        });
    }

    public class PhoneOnClickListener implements DialogInterface.OnClickListener
    {

        String phoneNumber;

        public PhoneOnClickListener(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
        }
    };

}
