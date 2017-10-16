package org.sandec.habitoaster;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by idn on 10/12/2017.
 */

public class RewardAdapter extends RecyclerView.Adapter<RewardAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<RewardModel> listData;

    //generate constructor
    public RewardAdapter(Context context, ArrayList<RewardModel> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //menghubungkan dengan movie_item
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reward_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //ngapain
        //set data
        holder.tvItemNama.setText(listData.get(position).getNama());
        holder.tvItemPoint.setText(listData.get(position).getPoint());
        Glide.with(context)
                .load(listData.get(position).getGambar())
                .placeholder(R.drawable.gif_loading)
                .error(R.drawable.no_image)
                .into(holder.ivItemGambar);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent pindah = new Intent(context, DetailWisataActivity.class);
//                Bundle data = new Bundle();
//                data.putString(Konstanta.DATA_ID, listData.get(position).getIdWisata());
//                data.putString(Konstanta.DATA_NAMA, listData.get(position).getNamaWisata());
//                data.putString(Konstanta.DATA_GAMBAR, listData.get(position).getGambarWisata());
//                data.putString(Konstanta.DATA_DESKRIPSI, listData.get(position).getDeksripsiWisata());
//                data.putString(Konstanta.DATA_ALAMAT, listData.get(position).getAlamatWisata());
//                data.putString(Konstanta.DATA_LAT, listData.get(position).getLatitudeWisata());
//                data.putString(Konstanta.DATA_LNG, listData.get(position).getLongitudeWisata());
//                pindah.putExtras(data);
//                context.startActivity(pindah);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        //jumlah list
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //menyambungkan dengan komponen yg di dalam item
        ImageView ivItemGambar;
        TextView tvItemNama;
        TextView tvItemPoint;
        Button btnRedeem;
        public MyViewHolder(View itemView) {
            super(itemView);
            ivItemGambar = (ImageView) itemView.findViewById(R.id.iv_item_gambar);
            tvItemNama = (TextView) itemView.findViewById(R.id.tv_item_nama);
            tvItemPoint = (TextView) itemView.findViewById(R.id.tv_item_point);
            btnRedeem = (Button) itemView.findViewById(R.id.btn_redeem);
        }
    }
}
