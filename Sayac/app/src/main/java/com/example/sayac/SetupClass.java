package com.example.sayac;

import android.content.Context;
import android.content.SharedPreferences;

public class SetupClass {
    int upperLimit;
    int lowerLimit;
    int currentValue;

    boolean upperVib;
    boolean upperSound;
    boolean lowerVib;
    boolean lowerSound;

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    static SetupClass setupClass = null;

    private SetupClass(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("setup", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SetupClass getInstance(Context context) {
        if(setupClass == null){
            setupClass = new SetupClass(context);
        }
        return setupClass;
    }

    public void SetValues(int upperLimit, int lowerLimit, int currentValue,
                          boolean upperVib,boolean upperSound,
                          boolean lowerVib, boolean lowerSound){
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
        this.currentValue = currentValue;
        this.upperVib = upperVib;
        this.upperSound= upperSound;
        this.lowerVib = lowerVib;
        this.lowerSound= lowerSound;
    }

    public void saveValues(){
        editor.putInt("upperLimit", upperLimit);
        editor.putInt("lowerLimit", lowerLimit);
        editor.putInt("currentValue", currentValue);
        editor.putBoolean("upperVib", upperVib);
        editor.putBoolean("upperSound", upperSound);
        editor.putBoolean("lowerVib", lowerVib);
        editor.putBoolean("lowerSound", lowerSound);
        editor.commit();
    }

    public void loadValues(){
        upperLimit = sharedPreferences.getInt("upperLimit", 10);
        lowerLimit = sharedPreferences.getInt("lowerLimit", 0);
        currentValue = sharedPreferences.getInt("currentValue",0);
        upperVib = sharedPreferences.getBoolean("upperVib", true);
        upperSound = sharedPreferences.getBoolean("upperSound", true);
        lowerVib = sharedPreferences.getBoolean("lowerVib", true);
        lowerSound = sharedPreferences.getBoolean("lowerSound", true);
    }
}
