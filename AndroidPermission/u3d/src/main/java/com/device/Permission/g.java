package com.device.Permission;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;


public final class g extends Fragment {

    private final IPermissionRequestCallbacks a;
    private final Activity b;
    private final Looper c;

    public g() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public g(Activity var1, IPermissionRequestCallbacks var2) {
        this.a = var2;
        this.b = var1;
        this.c = Looper.myLooper();
    }

    public final void onCreate(Bundle var1) {
        super.onCreate(var1);
        String[] var2 = this.getArguments().getStringArray("PermissionNames");
        this.requestPermissions(var2, 96489);
    }

    public final void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
        if (var1 == 96489) {
            if (var2.length == 0) {
                String[] var6 = this.getArguments().getStringArray("PermissionNames");
                this.requestPermissions(var6, 96489);
            } else {
                for(var1 = 0; var1 < var2.length && var1 < var3.length; ++var1) {
                    if (this.a != null && this.b != null && this.c != null) {
                        String var4 = var2[var1] == null ? "<null>" : var2[var1];
                        (new Handler(this.c)).post(new com.device.Permission.g.a(this.a, var4, var3[var1], this.b.shouldShowRequestPermissionRationale(var4)));
                    }
                }

                FragmentTransaction var5;
                (var5 = this.getActivity().getFragmentManager().beginTransaction()).remove(this);
                var5.commit();
            }
        }
    }

    class a implements Runnable {
        private IPermissionRequestCallbacks b;
        private String c;
        private int d;
        private boolean e;

        a(IPermissionRequestCallbacks var2, String var3, int var4, boolean var5) {
            this.b = var2;
            this.c = var3;
            this.d = var4;
            this.e = var5;
        }

        public final void run() {
            if (this.d == -1) {
                if (this.e) {
                    this.b.onPermissionDenied(this.c);
                } else {
                    this.b.onPermissionDeniedAndDontAskAgain(this.c);
                }
            } else {
                if (this.d == 0) {
                    this.b.onPermissionGranted(this.c);
                }

            }
        }
    }
}

