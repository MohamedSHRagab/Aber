package com.saas.mohamedragab.aber;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Context;
import android.widget.Toast;


public class History extends AppCompatActivity {
    ListView listView;
    public int images[] = {R.drawable.phone, R.drawable.earn, R.drawable.phone, R.drawable.phone, R.drawable.phone};
    public String salarys[] = {"25$", "13$", "25$", "13$", "25$"};
    public String[] names = {"Mohamed Ragab", "Mohamed Hamdy", "Mohamed Ragab", "Mohamed Hamdy", "Mohamed Ragab"};
    public String pickUp[] = {"7958 Swift Village", "7958 Swift Village", "7958 Swift Village", "7958 Swift Village", "7958 Swift Village"};
    public String dropOff[] = {"105 William St, Chicago, US", "105 William St, Chicago, US", "105 William St, Chicago, US", "105 William St, Chicago, US", "105 William St, Chicago, US"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SampleFragmentPagerAdapter pagerAdapter =
                new SampleFragmentPagerAdapter(getSupportFragmentManager(), History.this);
        viewPager.setAdapter(pagerAdapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }

        listView = (ListView) findViewById(R.id.listview);
        MyAdapter3 adapter = new MyAdapter3(this, names, salarys, images, pickUp, dropOff);
        listView.setAdapter(adapter);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView view = (NavigationView) findViewById(R.id.nav_view);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.home) {
                    gohome();
                } else if (id == R.id.wallet) {
                    Toast.makeText(History.this, "wallet", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.history) {
                    gohistory();

                } else if (id == R.id.notifications) {
                    gonotification();
                } else if (id == R.id.invite) {
                    goinvite();
                } else if (id == R.id.setting) {
                    Toast.makeText(History.this, "setting", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.logout) {
                    Toast.makeText(History.this, "Logout", Toast.LENGTH_SHORT).show();
                }


                return false;
            }
        });

    }

    private void gohome() {
        startActivity(new Intent(this, Home_online.class));
    }

    private void gohistory() {
        startActivity(new Intent(this, History.class));
    }

    private void gonotification() {
        startActivity(new Intent(this, Notifications.class));
    }

    private void goinvite() {
        startActivity(new Intent(this, invite_friends.class));
    }


    /*public View getTabView() {
        View v = LayoutInflater.from(this).inflate(R.layout.date_info, null);
        TextView day = (TextView) v.findViewById(R.id.day);
        TextView number = (TextView) v.findViewById(R.id.number);

        day.setTextColor(Color.YELLOW);
        number.setTextColor(Color.YELLOW);

        return v;
    }
*/

}

class MyAdapter3 extends ArrayAdapter {
    public int images[];
    public String salarys[];
    public String[] names;
    public String pickUp[];
    public String dropOff[];
    private Fragment pageFragment;

    public MyAdapter3(Context context, String[] name, String[] salary, int[] image, String[] pickUp, String[] dropOff) {
        super(context, R.layout.passenger_info2, R.id.name, name);

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
        View row = inflater.inflate(R.layout.passenger_info2, parent, false);

        CircleImageView imageView = (CircleImageView) row.findViewById(R.id.image);
        TextView name = (TextView) row.findViewById(R.id.name);
        TextView pickup = (TextView) row.findViewById(R.id.pickup);
        TextView salary = (TextView) row.findViewById(R.id.salary);
        TextView dropoff = (TextView) row.findViewById(R.id.dropoff);


        imageView.setImageResource(images[position]);
        name.setText(names[position]);
        salary.setText(salarys[position]);
        pickup.setText(pickUp[position]);
        dropoff.setText(dropOff[position]);

        return row;
    }
}
