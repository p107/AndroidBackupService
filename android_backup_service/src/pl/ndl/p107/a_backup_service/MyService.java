package pl.ndl.p107.a_backup_service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;

public class MyService extends Service {

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	    
		
		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		MyServiceThread thread = new MyServiceThread();
		thread.setVibrator(v);
		thread.start();
		
	    return Service.START_NOT_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
