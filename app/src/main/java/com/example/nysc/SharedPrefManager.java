package com.example.nysc;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mcontext;
    private static final String Shared_Pref_Name = "NYSCUser";
    private static final String KEY_EMAIL = "email";

    private SharedPrefManager(Context context) {
        mcontext = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }
    public  boolean userLogin(String email){
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_EMAIL, email);
        editor.apply();

        return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_EMAIL, null) != null){
            return true;
        }
        return false;
    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}