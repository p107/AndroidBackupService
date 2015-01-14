package pl.ndl.p107.android_backup_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	    //TODO do something useful
		
		DebugFileSaveHelper deb = new DebugFileSaveHelper();
		deb.SaveTestFile();
		
	    return Service.START_NOT_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
