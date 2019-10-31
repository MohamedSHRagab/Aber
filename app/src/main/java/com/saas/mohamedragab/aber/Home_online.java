package com.saas.mohamedragab.aber;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home_online extends AppCompatActivity {
    ListView listView;
    public int images[]={R.drawable.phone,R.drawable.earn,R.drawable.phone,R.drawable.phone,R.drawable.phone};
    public String salarys[]={"25$","13$","25$","13$","25$"};
    public String[] names={"Mohamed Ragab","Mohamed Hamdy","Mohamed Ragab","Mohamed Hamdy","Mohamed Ragab"};
    public String pickUp[] ={"7958 Swift Village","7958 Swift Village","7958 Swift Village","7958 Swift Village","7958 Swift Village"};
    public String dropOff[] ={"105 William St, Chicago, US","105 William St, Chicago, US","105 William St, Chicago, US","105 William St, Chicago, US","105 William St, Chicago, US"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_online);

        listView = (ListView) findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(this, names, salarys, images, pickUp,dropOff);
        listView.setAdapter(adapter);
    }

    public void go_home_page2(View view) {
        startActivity(new Intent(this,Home_online2.class));
    }

    public void go_navigation(View view) {
        Toast.makeText(this, "still programming :)", Toast.LENGTH_SHORT).show();
    }
}
class MyAdapter extends ArrayAdapter {
    public int images[];
    public String salarys[];
    public String[] names;
    public String pickUp[];
    public String dropOff[];

    public MyAdapter(Context context, String[] name, String[] salary, int[] image, String[] pickUp, String[] dropOff) {
        super(context, R.layout.passenger_info, R.id.name, name);

        this.names = name;
        this.salarys = salary;
        this.images = image;
        this.pickUp = pickUp;
        this.dropOff = dropOff;



    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.passenger_info, parent, false);

        CircleImageView imageView = (CircleImageView) row.findViewById(R.id.image);
        TextView name = (TextView) row.findViewById(R.id.name);
        TextView pickup = (TextView) row.findViewById(R.id.pickup);
        TextView salary = (TextView) row.findViewById(R.id.salary);
        TextView dropoff = (TextView) row.findViewById(R.id.dropoff);


        imageView.setImageResource(images[position]);
        name.setText(names[position]);
        salary.setText( salarys[position]);
        pickup.setText(pickUp[position]);
        dropoff.setText(dropOff[position]);

        return row;
    }
}