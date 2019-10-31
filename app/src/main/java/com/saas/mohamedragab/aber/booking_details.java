package com.saas.mohamedragab.aber;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class booking_details extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior1;
    ListView listView;
    public int images[]={R.drawable.ic_arrow_forward_black_24dp,R.drawable.ic_arrow_upward_black_24dp,R.drawable.ic_arrow_forward_black_24dp,R.drawable.ic_arrow_upward_black_24dp,R.drawable.ic_arrow_upward_black_24dp};
    public String miles[]={"18 miles","19 miles","25 miles","30 miles","17 miles"};
    public String[] orders={"Head southwest on Madison St","Turn left onto  4th Ave","Turn right at 105th N Link Rd","Turn right at 105 William St, Chicago, US","Continue straight to stay on Vancouver"};
    public String descriptions[] ={"Pass by Executive Hotel Pacific (on the left)","7958 Swift Village","Entering California","Entering California","Entering California"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        View bottomSheet = findViewById(R.id.bottom_sheet1);
        mBottomSheetBehavior1 = BottomSheetBehavior.from(bottomSheet);

        listView = (ListView) findViewById(R.id.list);
        MyAdapter5 adapter = new MyAdapter5(this, images, miles,orders,descriptions);
        listView.setAdapter(adapter);
    }

    public void view_sheet(View view) {
        if(mBottomSheetBehavior1.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
        else {
            mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

    }
    }
class MyAdapter5 extends ArrayAdapter {
    public int images[];
    public String miles[];
    public String[] orders;
    public String descriptions[] ;

    public MyAdapter5(Context context,int image[], String mile[], String order[], String description[]) {
        super(context, R.layout.pick_up_info, R.id.title, order);

        this.miles = mile;
        this.orders = order;
        this.images = image;
        this.descriptions = description;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.pick_up_info, parent, false);

        CircleImageView imageView = (CircleImageView) row.findViewById(R.id.image);
        TextView mile = (TextView) row.findViewById(R.id.mile);
        TextView order = (TextView) row.findViewById(R.id.title);
        TextView description = (TextView) row.findViewById(R.id.description);


        imageView.setImageResource(images[position]);
        mile.setText(miles[position]);
        order.setText( orders[position]);
        description.setText(descriptions[position]);

        return row;
    }
}