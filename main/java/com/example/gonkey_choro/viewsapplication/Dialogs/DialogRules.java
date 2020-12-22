package com.example.gonkey_choro.viewsapplication.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;

public class DialogRules extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Правила игры")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Я пока не придумал правила, но врятли они будут слишком большими.")
                .setPositiveButton("Ок", null)
                .create();
    }
}
