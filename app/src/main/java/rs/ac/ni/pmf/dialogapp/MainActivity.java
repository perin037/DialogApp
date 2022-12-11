package rs.ac.ni.pmf.dialogapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialog.MyDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button showDialogButton = findViewById(R.id.dlgbutton);
        showDialogButton.setOnClickListener(this::showListDialog);

        registerForContextMenu(showDialogButton);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.button_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.context_menu_button_disable:
                Toast.makeText(this, "Ugasio sam dugme", Toast.LENGTH_SHORT).show();
                break;
            default:
                return true;
        }
        return super.onContextItemSelected(item);
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

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
            getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_game:
                Toast.makeText(this, "Selected new game", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quit_game:
                Toast.makeText(this, "QUIT GAME", Toast.LENGTH_SHORT).show(); break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}