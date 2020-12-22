package com.example.gonkey_choro.viewsapplication.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.gonkey_choro.viewsapplication.BuildingClasses.BuildingOptions;
import com.example.gonkey_choro.viewsapplication.NeuralClasses.NeuralOptions;
import com.example.gonkey_choro.viewsapplication.ProfileOptions;
import com.example.gonkey_choro.viewsapplication.InGameActivity;
import com.example.gonkey_choro.viewsapplication.ShopClasses.ShopOptions;

public class DialogOnStartNewGame extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Внимание")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Начать новую игру?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ProfileOptions.removeAllPreferences(getContext());
                        BuildingOptions.removeAllPreferences(getContext());
                        NeuralOptions.removeAllPreferences(getContext());
                        ShopOptions.removeAllPreferences(getContext());
                        Intent intent = new Intent(getContext(), InGameActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Нет", null).create();
    }
}
