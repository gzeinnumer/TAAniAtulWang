package com.gzeinnumer.taaniatulwang.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private String PREF_NAME = "SIMPAN";
    private String KEY_USERNAME = "username";
    private String KEY_ID = "id";
    private String KEY_NAME = "name";

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public SessionManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void logout() {
        mEditor = mSharedPreferences.edit();
        mEditor.clear().commit();
    }

    public String getKEY_USERNAME() {
        return mSharedPreferences.getString(KEY_USERNAME, null);
    }

    public void setKEY_USERNAME(String s) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_USERNAME, s).apply();
    }

    public String getKEY_ID() {
        return mSharedPreferences.getString(KEY_ID, null);
    }

    public void setKEY_ID(String s) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_ID, s).apply();
    }

    public String getKEY_NAME() {
        return mSharedPreferences.getString(KEY_NAME, null);

    }

    public void setKEY_NAME(String s) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_NAME, s).apply();
    }
}
