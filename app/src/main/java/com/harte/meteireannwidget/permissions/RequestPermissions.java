package com.harte.meteireannwidget.permissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class RequestPermissions {
    public static final int COARSE_LOCATION_PERM = 0;

    public static void requestPermissions(Context context, Activity thisActivity) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            int permissionId = 0;
            for (String perm: info.requestedPermissions) {
                requestPermission(context, thisActivity, perm, permissionId);
                permissionId ++;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void requestPermission(Context context, Activity thisActivity, String permission, int permissionId) {
        if (ContextCompat.checkSelfPermission(thisActivity,
                permission)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // No explanation needed; request the permission
            ActivityCompat.requestPermissions(thisActivity,
                    new String[]{permission},
                    permissionId);

            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.

        } else {
            // Permission has already been granted
        }
    }
}
