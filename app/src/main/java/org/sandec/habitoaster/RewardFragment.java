package org.sandec.habitoaster;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RewardFragment extends Fragment {

    private RecyclerView recycler;
    ArrayList<RewardModel> listData;
    private static final String TAG = "HomeFragment";
    private TextView tvRewardNama;
    private TextView tvRewardEmail;
    private TextView tvRewardPoint;

    public RewardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reward, container, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        //dataset
        listData = new ArrayList<>();

        //data dummy
        for (int i = 0; i < 10; i++) {
            RewardModel data1 = new RewardModel();
            data1.setNama("Free T-Shirt by Sandec");
            data1.setPoint("400 pts");
            data1.setGambar("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/22365636_1713758052002495_4209369711106473550_n.jpg?oh=a0bd2ee542fb998b59af80eae26dfe20&oe=5A75B2FE");
            listData.add(data1);

            RewardModel data2 = new RewardModel();
            data2.setNama("Free Cloud Credit");
            data2.setPoint("800 pts");
            data2.setGambar("https://venturebeat.com/wp-content/uploads/2016/11/Google-Firebase-logo-e1494819679178.png?fit=1600%2C800&strip=all");
            listData.add(data2);
            
            RewardModel data3 = new RewardModel();
            data3.setNama("Free Chromecast");
            data3.setPoint("1000 pts");
            data3.setGambar("https://assets.pcmag.com/media/images/480434-old-chromecast-vs-new-chromecast.jpg?thumb=y&width=810&height=456");
            listData.add(data3);

            listData.add(new RewardModel("Free Google Wifi", "3000 pts", "https://cnet3.cbsistatic.com/img/5k2m3nsVmGIR0_vzoUdqEjoZyjY=/770x433/2016/12/06/ae71a163-6ce2-4597-9fc0-107ad0ae573f/flgooglewifisystem.jpg"));
            listData.add(new RewardModel("Free Google Home", "5000 pts", "https://cnet2.cbsistatic.com/img/d4UzB6o3QwUC6WDouFbXYuW__po=/770x433/2016/11/02/d405a6ab-5f2b-4dec-a1f8-67cccaca77d3/google-home-product-photos-20.jpg"));
        }

        //data online
//        ambilDataOnline();

        //setup recyclerview
        recycler = (RecyclerView) view.findViewById(R.id.recycler_view);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(new RewardAdapter(getActivity(), listData));
    }

    private void initView(View view) {
        tvRewardNama = (TextView) view.findViewById(R.id.tv_reward_nama);
        tvRewardEmail = (TextView) view.findViewById(R.id.tv_reward_email);
        tvRewardPoint = (TextView) view.findViewById(R.id.tv_reward__point);
    }
}
