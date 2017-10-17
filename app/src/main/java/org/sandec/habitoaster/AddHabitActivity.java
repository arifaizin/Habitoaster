package org.sandec.habitoaster;

import android.app.TimePickerDialog;
import android.graphics.Typeface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.shawnlin.numberpicker.NumberPicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddHabitActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_habit_name)
    TextView tvHabitName;
    @BindView(R.id.et_habit_name)
    EditText etHabitName;
    @BindView(R.id.tv_number_of_days)
    TextView tvNumberOfDays;
    @BindView(R.id.number_picker_days)
    NumberPicker numberPickerDays;
    @BindView(R.id.tv_notifications)
    TextView tvNotifications;
    @BindView(R.id.toggle_notifications)
    ToggleButton toggleNotifications;
    @BindView(R.id.btn_notifications_time)
    Button btnNotificationsTime;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    String finalHabitName;
    int finalNumberOfDays;
    boolean finalNotifications;
    String finalNotificationsTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupDurationDaysPicker();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_habit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_sign_in_using_google:

                return true;
            case R.id.action_sign_out:

                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void setupDurationDaysPicker() {
        numberPickerDays.setOrientation(LinearLayout.HORIZONTAL);

        // set divider color
        numberPickerDays.setDividerColor(ContextCompat.getColor(this, R.color.colorAccent));
        numberPickerDays.setDividerColorResource(R.color.colorAccent);

        // set formatter
        numberPickerDays.setFormatter(getString(R.string.number_picker_formatter));
        numberPickerDays.setFormatter(R.string.number_picker_formatter);

        // set selected text color
        numberPickerDays.setSelectedTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        numberPickerDays.setSelectedTextColorResource(R.color.colorAccent);

        // set text color
        numberPickerDays.setTextColor(ContextCompat.getColor(this, R.color.dark_grey));
        numberPickerDays.setTextColorResource(R.color.dark_grey);

        // set text size
        numberPickerDays.setTextSize(getResources().getDimension(R.dimen.text_size));
        numberPickerDays.setTextSize(R.dimen.text_size);

        // set selected text size
        numberPickerDays.setSelectedTextSize(getResources().getDimension(R.dimen.selected_text_size));
        numberPickerDays.setSelectedTextSize(R.dimen.selected_text_size);

        // set typeface
        numberPickerDays.setTypeface(Typeface.create(getString(R.string.roboto_light), Typeface.NORMAL));
        numberPickerDays.setTypeface(getString(R.string.roboto_light), Typeface.NORMAL);
        numberPickerDays.setTypeface(getString(R.string.roboto_light));
        numberPickerDays.setTypeface(R.string.roboto_light, Typeface.NORMAL);
        numberPickerDays.setTypeface(R.string.roboto_light);
    }

    private void collectHabitData() {
        finalHabitName = etHabitName.getText().toString();
        finalNumberOfDays = numberPickerDays.getValue();
        finalNotifications = toggleNotifications.isChecked();
        finalNotificationsTime = btnNotificationsTime.getText().toString();
    }

    private void uploadHabitDataToServer() {

    }

    @OnClick({R.id.toggle_notifications, R.id.btn_notifications_time, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toggle_notifications:
                if (toggleNotifications.isChecked()) {
                    btnNotificationsTime.setEnabled(true);
                } else {
                    btnNotificationsTime.setEnabled(false);
                }
                break;
            case R.id.btn_notifications_time:
                TimePickerDialog timePickerDialog;
                // Get Current Time
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    final Calendar c = Calendar.getInstance();
                    int mHour = c.get(Calendar.HOUR_OF_DAY);
                    int mMinute = c.get(Calendar.MINUTE);
                    timePickerDialog = new TimePickerDialog(this,
                            new TimePickerDialog.OnTimeSetListener() {

                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay,
                                                      int minute) {
                                    String pickedHour;
                                    String pickedMinute;
                                    if (hourOfDay < 10) {
                                        pickedHour = "0" + hourOfDay;
                                    } else {
                                        pickedHour = String.valueOf(hourOfDay);
                                    }
                                    if (minute < 10) {
                                        pickedMinute = "0" + minute;
                                    } else {
                                        pickedMinute = String.valueOf(minute);
                                    }
                                    btnNotificationsTime.setText(pickedHour + ":" + pickedMinute);
                                }
                            }, mHour, mMinute, false);
                } else {
                    timePickerDialog = new TimePickerDialog(this,
                            new TimePickerDialog.OnTimeSetListener() {

                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay,
                                                      int minute) {
                                    String pickedHour;
                                    String pickedMinute;
                                    if (hourOfDay < 10) {
                                        pickedHour = "0" + hourOfDay;
                                    } else {
                                        pickedHour = String.valueOf(hourOfDay);
                                    }
                                    if (minute < 10) {
                                        pickedMinute = "0" + minute;
                                    } else {
                                        pickedMinute = String.valueOf(minute);
                                    }
                                    btnNotificationsTime.setText(pickedHour + ":" + pickedMinute);
                                }
                            }, 6, 0, false);
                }
                timePickerDialog.show();
                break;
            case R.id.fab:
                collectHabitData();
                uploadHabitDataToServer();
                break;
        }
    }
}
