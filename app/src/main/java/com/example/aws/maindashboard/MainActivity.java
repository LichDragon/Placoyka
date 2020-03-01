package com.example.aws.maindashboard;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("RedundantCast")
public class MainActivity extends AppCompatActivity  {

    private Button button0;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction ;
    RecyclerView recyclerView ;
    List<item> mData;
    MenuAdapter adapter;

    // fragment codes
    public static final int DASHBOARD_CODE = 0 ;
    public static final int SETTINGS_CODE = 1 ;
    public static final int SCHOOL_CODE = 2;
    public static final int MAP_CODE = 3 ;
    public static final int FIT_CODE = 4 ;
    public static final int SEARCH_CODE = 5 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        //activity_main меню

        recyclerView = findViewById(R.id.rv_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mData = new ArrayList<>();
        mData.add(new item(R.drawable.ic_dashboard_black_24dp,DASHBOARD_CODE,"Dashboard Fragment"));
        mData.add(new item(R.drawable.ic_map_black_24dp,MAP_CODE,"Dashboard Fragment"));
        mData.add(new item(R.drawable.ic_search_black_24dp,SEARCH_CODE,"Dashboard Fragment"));
        mData.add(new item(R.drawable.ic_fitness_center_black_24dp,FIT_CODE,"Dashboard Fragment"));
        mData.add(new item(R.drawable.ic_school_black_24dp,SCHOOL_CODE,"Dashboard Fragment"));
        mData.add(new item(R.drawable.ic_settings_black_24dp,SETTINGS_CODE,"Dashboard Fragment"));

        adapter = new MenuAdapter(this,mData);
        recyclerView.setAdapter(adapter);



        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        // Dashboard instantiate
        DashboardFrag dashboardFrag = new DashboardFrag();

        fragmentTransaction.replace(R.id.container,dashboardFrag);
        fragmentTransaction.commit();

        setContentView(R.layout.fragment_dashboard);

        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button0 = (Button) findViewById(R.id.button0);
                button0.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   openHardAtletic();
                                               }
                                           }

                );

            }
        });

    }


    public void openHardAtletic(){
        Intent intent = new Intent(this, HardAtletic.class);
        startActivity(intent);
    }



}
