package com.saas.mohamedragab.aber;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Notifications extends AppCompatActivity {
    ListView listView;
    public int images[]={R.drawable.phone,R.drawable.earn,R.drawable.phone,R.drawable.phone,R.drawable.phone};
    public String titles[]={"System","Promotion","System","System","Promotion"};
    public String[] descriptions={"Booking #1234 has been success...","Invite friends - Get 3 coupons each!","Booking #1205 has been cancelled","Booking #1205 has been cancelled","Invite friends - Get 3 coupons each!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        listView = (ListView) findViewById(R.id.listview);
        MyAdapter2 adapter = new MyAdapter2(this, images, titles, descriptions);
        listView.setAdapter(adapter);
    }
}
class MyAdapter2 extends ArrayAdapter {
    public int images[];
    public String titles[];
    public String[] descriptions;


    public MyAdapter2(Context context, int[] image, String[] title, String[] description) {
        super(context, R.layout.passenger_info, R.id.title, title);


        this.titles = title;
        this.images = image;
        this.descriptions = description;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.notification_info, parent, false);

        CircleImageView imageView = (CircleImageView) row.findViewById(R.id.image);
        TextView title = (TextView) row.findViewById(R.id.title);
        TextView description = (TextView) row.findViewById(R.id.description);


        imageView.setImageResource(images[position]);
        title.setText(titles[position]);
        description.setText( descriptions[position]);

        return row;
    }
}
