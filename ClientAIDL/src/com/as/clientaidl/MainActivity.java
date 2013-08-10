package com.as.clientaidl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;
import android.widget.Toast;

import com.as.serveraidl.IRemoteService;
import com.as.serveraidl.Rectangle;

public class MainActivity extends Activity {

	/**
	 * Class for interacting with the main interface of the service.
	 */
	private ServiceConnection mConnection = new ServiceConnection() {
		private IRemoteService mService;

		public void onServiceConnected(ComponentName className, IBinder service) {
			mService = IRemoteService.Stub.asInterface(service);

			try {
				int area = mService.calculateArea(new Rectangle(0, 0, 10, 10));
				Toast.makeText(MainActivity.this, "Area: " + area, Toast.LENGTH_LONG).show();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		public void onServiceDisconnected(ComponentName className) {

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent i = new Intent();
		i.setClassName("com.as.serveraidl", "com.as.serveraidl.RemoteService");
		bindService(i, mConnection, Context.BIND_AUTO_CREATE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
