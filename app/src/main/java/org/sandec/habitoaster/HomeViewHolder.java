package org.sandec.habitoaster;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class HomeViewHolder extends RecyclerView.ViewHolder{

    public TextView NamaHabit;
    public TextView RunningHabit;
    public TextView PersentaseHabit;

    public HomeViewHolder(View itemView) {
        super(itemView);

        NamaHabit = (TextView)itemView.findViewById(R.id.habit1);
        RunningHabit = (TextView)itemView.findViewById(R.id.running1);
        PersentaseHabit = (TextView) itemView.findViewById(R.id.persentase1);
    }
}
