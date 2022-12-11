package rs.ac.ni.pmf.dialogapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {

    public interface MyDialogListener{
        void onYes();
        void onNo();
    }

    private MyDialogListener _listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        _listener = (MyDialogListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Naslov dialoga")
                .setMessage("Poruka dialoga")
                .setPositiveButton("Da", ((dialogInterface, i) -> _listener.onYes()))
                .setNegativeButton("Ne", ((dialogInterface, i) -> _listener.onNo()));
        //return super.onCreateDialog(savedInstanceState);
        return builder.create();
    }
}
