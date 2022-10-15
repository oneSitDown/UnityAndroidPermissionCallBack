package com.device.Permission;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class AndroidPermission {

    public static void requestUserPermissions(Activity var0, String[] var1, com.device.Permission.IPermissionRequestCallbacks var2) {

        if (var0 != null && var1 != null) {
            FragmentManager var3 = var0.getFragmentManager();
            String var4 = "96489";
            if (var3.findFragmentByTag(var4) == null) {
                com.device.Permission.g var5 = new com.device.Permission.g(var0, var2);
                Bundle var7;
                (var7 = new Bundle()).putStringArray("PermissionNames", var1);
                var5.setArguments(var7);
                FragmentTransaction var6;
                (var6 = var3.beginTransaction()).add(0, var5, var4);
                var6.commit();
            }

        }
    }
}
