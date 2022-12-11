package rs.ac.ni.pmf.dialogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
}