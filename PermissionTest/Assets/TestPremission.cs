using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TestPremission : MonoBehaviour
{
    public void CallAndroid()
    {
        //获取名为UnityPlayer的类
        AndroidJavaClass jc = new AndroidJavaClass("com.device.Permission.AndroidPermission");

        AndroidJavaClass jc1 = new AndroidJavaClass("com.unity3d.player.UnityPlayer");

        AndroidJavaObject jo = jc1.GetStatic<AndroidJavaObject>("currentActivity");

        jc.CallStatic("requestUserPermissions", jo , new string[] { "android.permission.CAMERA" }, new IPermissionRequestCallbacks());
        ////获取名为UnityPlayer的类

        ////获取当前运行的Activity
        //AndroidJavaObject jo = jc1.GetStatic<AndroidJavaObject>("currentActivity");

        ////调用UnityPlayer类中的函数
        //jc.CallStatic("checkPermission","TestPermission", "CameraPermission");
    }
    

    // Update is called once per frame
    void Update()
    {
        
    }
}

public class IPermissionRequestCallbacks : AndroidJavaProxy
{
    public IPermissionRequestCallbacks() : base("com.device.Permission.IPermissionRequestCallbacks")
    {

    }

    public virtual void onPermissionGranted(string var1) 
    {
        Debug.Log("111111111"+var1);
    }

    public virtual void onPermissionDenied(string var1)
    {
        Debug.Log("22222222222" + var1);
    }

    public virtual void onPermissionDeniedAndDontAskAgain(string var1)
    {
        Debug.Log("333333333333"+var1);
    }
}
