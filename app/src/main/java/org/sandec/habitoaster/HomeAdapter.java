package org.sandec.habitoaster;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder>{

    private static final String TAG = HomeAdapter.class.getSimpleName();

    private Context context;
    private List<HomeObject> target;

    public HomeAdapter(Context context, List<HomeObject> target) {
        this.context = context;
        this.target = target;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        HomeObject daftarObject = target.get(position);
        holder.NamaHabit.setText(daftarObject.getNamaHabit());
        holder.RunningHabit.setText(daftarObject.getRunningHabit());

    }

    @Override
    public int getItemCount() {
        return target.size();
    }
}
