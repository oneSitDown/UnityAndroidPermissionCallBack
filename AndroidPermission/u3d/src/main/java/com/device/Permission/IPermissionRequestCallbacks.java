package com.device.Permission;

public interface IPermissionRequestCallbacks {

    void onPermissionGranted(String var1);

    void onPermissionDenied(String var1);

    void onPermissionDeniedAndDontAskAgain(String var1);
}
