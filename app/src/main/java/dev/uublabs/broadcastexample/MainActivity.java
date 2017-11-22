package dev.uublabs.broadcastexample;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import dev.uublabs.broadcastexample.receiver.MyDynamicReceiver;
import dev.uublabs.broadcastexample.util.Constants;

public class MainActivity extends AppCompatActivity
{
    MyDynamicReceiver myDynamicReceiver;
    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = findViewById(R.id.et_input);
        myDynamicReceiver = new MyDynamicReceiver();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Constants.ACTION.ACTION1);
        registerReceiver(myDynamicReceiver, intentFilter);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        unregisterReceiver(myDynamicReceiver);
    }

    public void sendBroadcast(View view)
    {
        String data = etInput.getText().toString();

        Intent intent = new Intent();
        intent.setAction(Constants.ACTION.ACTION1);
        intent.putExtra(Constants.KEYS.DATA_MAIN, data);

        sendBroadcast(intent);
    }
}
