package pl.ndl.p107.android_backup_service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;

public class MyService extends Service {

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	    
		DebugFileSaveHelper deb = new DebugFileSaveHelper();
		deb.SaveTestFile();
		
		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		//v.vibrate(500);
		long[] pattern = {0, 100, 1000, 300, 200, 100, 500, 200, 100};
		v.vibrate(pattern, -1);
		
	    return Service.START_NOT_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
