package org.sandec.habitoaster;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RewardFragment extends Fragment {

    private RecyclerView recycler;
    ArrayList<RewardModel> listData;
    private static final String TAG = "HomeFragment";

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

        //dataset
        listData = new ArrayList<>();

        //data dummy
        for (int i = 0; i < 10; i++) {
            RewardModel data1 = new RewardModel();
            data1.setNama("Free T-Shirt by Sandec");
            data1.setPoint("400 pts");
            data1.setGambar("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/22365636_1713758052002495_4209369711106473550_n.jpg?oh=a0bd2ee542fb998b59af80eae26dfe20&oe=5A75B2FE");
            listData.add(data1);
        }

        //data online
//        ambilDataOnline();

        //setup recyclerview
        recycler = (RecyclerView) view.findViewById(R.id.recycler_view);
        recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recycler.setAdapter(new RewardAdapter(getActivity(), listData));
    }

}
