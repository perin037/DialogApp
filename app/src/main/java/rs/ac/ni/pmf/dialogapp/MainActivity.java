package rs.ac.ni.pmf.dialogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialog.MyDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {
        final MyDialog mydialog = new MyDialog();
        mydialog.show(getSupportFragmentManager(), "DIALOGAPPTAG");
    }

    @Override
    public void onYes() {
        Toast.makeText(this, "Kliknuo DA", Toast.LENGTH_SHORT).show();
        Log.i("DIALOGAPPTAG", "KLIKNUO DA");
    }

    @Override
    public void onNo() {
        Toast.makeText(this, "Klinuo NE", Toast.LENGTH_SHORT).show();
        Log.i("DIALOGAPPTAG", "KLIKNUO NE");
    }

    public void showListDialog(View view) {
        final MultiChoiceDialog mydialog = new MultiChoiceDialog();
        mydialog.show(getSupportFragmentManager(), "DIALOGAPPTAG");
    }
    public void showTimeDialog(View view) {
        final TimePickerDialog mydialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourofday, int minute) {
                Log.i("DIALOGAPPTAG", "Time picked:" + hourofday + " : " + minute);
            }
        }, 0, 0, true);
        mydialog.show();
    }

    public void showDateDialog(View view){
        final DatePickerDialog mydialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                Log.i("DIALOGAPPTAG", "DATE picked: " + date + "/" + (1+month) + "/" + year);
            }
        }, 2022, 11, 11);
        mydialog.show();
    }
}