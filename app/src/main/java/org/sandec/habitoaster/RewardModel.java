package org.sandec.habitoaster;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by idn on 10/12/2017.
 */

public class RewardModel {
    @SerializedName("idReward")
    @Expose
    private String id;
    @SerializedName("namaReward")
    @Expose
    private String nama;
    @SerializedName("gambarReward")
    @Expose
    private String gambar;
    @SerializedName("pointReward")
    @Expose
    private String point;

    public RewardModel() {
    }

    public RewardModel(String id, String nama, String gambar, String point) {
        this.id = id;
        this.nama = nama;
        this.gambar = gambar;
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}

