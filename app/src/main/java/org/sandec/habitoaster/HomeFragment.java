package org.sandec.habitoaster;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment(){

    }
    SwipeRefreshLayout swLayout;
    LinearLayout llayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        swLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefresh);

        llayout = (LinearLayout) v.findViewById(R.id.detail_content);

        swLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // Handler untuk menjalankan jeda selama 5 detik
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {

                        // Berhenti berputar/refreshing
                        swLayout.setRefreshing(false);

                        // fungsi-fungsi lain yang dijalankan saat refresh berhenti
                        return;
                    }
                }, 5000);
            }
        });

//        CollapsingToolbarLayout collapsingToolbar =
//                (CollapsingToolbarLayout) v.findViewById(R.id.collapsing_toolbar);
//// Set title of Detail page
//        collapsingToolbar.setTitle(getString(R.string.item_title));
        RecyclerView targetRecyclerView = (RecyclerView)v.findViewById(R.id.daftar_menu);
        GridLayoutManager gridLayout = new GridLayoutManager(getActivity(), 1);
        targetRecyclerView.setLayoutManager(gridLayout);
        targetRecyclerView.setHasFixedSize(true);

        HomeAdapter mAdapter = new HomeAdapter(getActivity(), getTestData());
        targetRecyclerView.setAdapter(mAdapter);
        // Inflate the layout for this fragment

        return v;
    }
    public List<HomeObject> getTestData() {
        List<HomeObject> infomenu = new ArrayList<HomeObject>();
        infomenu.add(new HomeObject("Puasa Senin Kamis", "Berjalan 7 Hari", "50%"));
        infomenu.add(new HomeObject("Joging sore", "Berjalan 3 Hari", "20%"));
        infomenu.add(new HomeObject("Sarapan Sebelum Jam 9", "Berjalan 9 Hari", "45%"));
        infomenu.add(new HomeObject("Sholat Tahajud", "Berjalan 6 Hari", "30"));
        return infomenu;
    }

}


