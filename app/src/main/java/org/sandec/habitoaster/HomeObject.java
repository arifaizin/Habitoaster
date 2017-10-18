package org.sandec.habitoaster;

/**
 * Created by Febriyan A. Fatma on 10/17/2017.
 */

public class HomeObject {
    private String namaHabit;
    private String runningHabit;
    private String persentaseHabit;

    public HomeObject(String namaHabit, String runningHabit, String persentaseHabit) {
        this.namaHabit = namaHabit;
        this.runningHabit = runningHabit;
        this.persentaseHabit = persentaseHabit;
    }

    public String getNamaHabit() {
        return namaHabit;
    }

    public String  getRunningHabit() {
        return runningHabit;
    }

    public String getPersentaseHabit() {
        return persentaseHabit;
    }
}
