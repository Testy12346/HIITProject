package com.example.hiitproject;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DaDataClass extends Service {
    private final IBinder binder = new LocalBinder();
    static final String ACTION_START = "com.idkwahattoputhere.yummy.ACTION_START";
    ArrayList<String> playinfo = new ArrayList<>();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public ArrayList addInfoForPlay(String name, String desc, String timehr, String timemin, String dayof) {
        ArrayList<String> info = new ArrayList<>();
        info.add(name);
        if (desc == null) ;
        else
            info.add(desc);
        info.add(timehr);
        info.add(timemin);
        info.add(dayof);
        return info;
    }

    public void printPlayListGiven() {
        if (playinfo != null)
            System.out.println(playinfo);
        else
            System.out.println("NoPlayList");
    }

    public class LocalBinder extends Binder {
        DaDataClass getService() {
            return DaDataClass.this;
        }
    }

}

