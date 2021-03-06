package com.example.irmtbletest;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.example.irmtble.*;

public class MainActivity extends Activity {
    public IrmtInt mIrmtInt = new IrmtInt();
    public BLCommService mBLCommService = null;
    private Button mButton = null;
    private Button mButton_disc = null;
    BleComm_UUIDs userUUids = new BleComm_UUIDs(BleComm_UUIDs.UART_UUID_MT,BleComm_UUIDs.UART_UUID_TX_MT,BleComm_UUIDs.UART_UUID_RX_MT);
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v("BLService", "OnCreate");
		mButton = (Button)findViewById(R.id.button1);
		mButton_disc = (Button)findViewById(R.id.button2);
		mBLCommService = new BLCommService(this,mIrmtInt);
		//mBLCommService.userConnect("CC41-A", null, null,userUUids);
		//��ʼ���ӵİ���
		mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	mBLCommService.userConnect("MTSeriBle3E", null, null,userUUids);
            }
        });
		mButton_disc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	mBLCommService.UserDisconn();

            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

