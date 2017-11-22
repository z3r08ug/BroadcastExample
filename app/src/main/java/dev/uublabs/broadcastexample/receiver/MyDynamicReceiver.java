package dev.uublabs.broadcastexample.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import dev.uublabs.broadcastexample.util.Constants;

/**
 * Created by Admin on 11/21/2017.
 */

public class MyDynamicReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();

        switch (action)
        {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
            {
                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
                if (isAirplaneModeOn)
                {
                    Toast.makeText(context, "Airplane Mode is on", Toast.LENGTH_LONG).show();
                } else
                {
                    Toast.makeText(context, "Airplane Mode is off", Toast.LENGTH_LONG).show();
                }
                break;
            }
            case Constants.ACTION.ACTION1:
            {
                String data = intent.getStringExtra(Constants.KEYS.DATA_MAIN);
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
