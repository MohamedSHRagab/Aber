package com.saas.mohamedragab.aber;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class PageFragment   extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    ListView listView;
    public int images[]={R.drawable.phone,R.drawable.earn,R.drawable.phone,R.drawable.phone,R.drawable.phone};
    public String salarys[]={"25$","13$","25$","13$","25$"};
    public String[] names={"Mohamed Ragab","Mohamed Hamdy","Mohamed Ragab","Mohamed Hamdy","Mohamed Ragab"};
    public String pickUp[] ={"7958 Swift Village","7958 Swift Village","7958 Swift Village","7958 Swift Village","7958 Swift Village"};
    public String dropOff[] ={"105 William St, Chicago, US","105 William St, Chicago, US","105 William St, Chicago, US","105 William St, Chicago, US","105 William St, Chicago, US"};

    private int mPage;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        MyAdapter3 adapter = new MyAdapter3(getActivity(), names, salarys, images, pickUp,dropOff);
        listView.setAdapter(adapter);
        return view;
    }



}

