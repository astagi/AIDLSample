package com.as.serveraidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class RemoteService extends Service {
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// Return the interface
		return mBinder;
	}

	private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
		@Override
		public int calculateArea(Rectangle rect) throws RemoteException {
			int base = rect.right - rect.left;
			int height = rect.bottom - rect.top;
			return base * height;
		}
	};
}
