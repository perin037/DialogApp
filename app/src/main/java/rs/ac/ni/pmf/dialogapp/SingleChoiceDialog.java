package rs.ac.ni.pmf.dialogapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class SingleChoiceDialog extends DialogFragment {
    private int _selected = -1;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String[] values = {"Jedan", "dva", "tri"};
        return builder.setTitle("Naslov dialoga")
                .setSingleChoiceItems(values, _selected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        _selected = i;
                        Log.i("DIALOGAPPTAG", "Selected item: " + values[i]);
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("DIALOGAPPTAG", "Final selected item: " + values[_selected]);
                    }
                })
                .create();

    }
}
