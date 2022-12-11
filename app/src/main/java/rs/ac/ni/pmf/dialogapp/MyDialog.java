package rs.ac.ni.pmf.dialogapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Naslov dialoga")
                .setMessage("Poruka dialoga")
                .setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Kliknuo DA", Toast.LENGTH_SHORT).show();
                        Log.i("DIALOGAPPTAG", "KLIKNUO DA");
                    }
                })
        .setNegativeButton("Ne", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "Klinuo NE", Toast.LENGTH_SHORT).show();
                Log.i("DIALOGAPPTAG", "KLIKNUO NE");
            }
        });
        //return super.onCreateDialog(savedInstanceState);
        return builder.create();
    }
}
