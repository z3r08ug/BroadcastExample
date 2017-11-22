package dev.uublabs.broadcastexample.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Admin on 11/21/2017.
 */

public class MyStaticReceiver extends BroadcastReceiver
{
    private static final String TAG = MyStaticReceiver.class.getSimpleName() + "_TAG";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onReceive: Airplane Mode Changed");
    }
}
