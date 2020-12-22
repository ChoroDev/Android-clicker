package com.example.gonkey_choro.viewsapplication;

import android.content.Context;
import static android.content.Context.MODE_PRIVATE;

public class ShC {
    private Context context;
    private String fileName;

    public ShC(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    public float getFloat(String key) {
        return context.getSharedPreferences(fileName, MODE_PRIVATE).getFloat(key, 0f);
    }

    public void setFloat(String key, float value) {
        context.getSharedPreferences(fileName, MODE_PRIVATE).edit().putFloat(key, value).apply();
    }

    public int getInt(String key) {
        return context.getSharedPreferences(fileName, MODE_PRIVATE).getInt(key, 0);
    }

    public void setInt(String key, int value) {
        context.getSharedPreferences(fileName, MODE_PRIVATE).edit().putInt(key, value).apply();
    }

    public String getString(String key) {
        return context.getSharedPreferences(fileName, MODE_PRIVATE).getString(key, "");
    }

    public void setString(String key, String value) {
        context.getSharedPreferences(fileName, MODE_PRIVATE).edit().putString(key, value).apply();
    }

    public boolean getBool(String key) {
        return context.getSharedPreferences(fileName, MODE_PRIVATE).getBoolean(key, false);
    }

    public void setBool(String key, boolean value) {
        context.getSharedPreferences(fileName, MODE_PRIVATE).edit().putBoolean(key, value).apply();
    }
}
