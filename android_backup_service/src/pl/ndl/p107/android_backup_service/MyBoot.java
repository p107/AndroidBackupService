package pl.ndl.p107.android_backup_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class MyBoot extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
	 
        Intent serviceIntent = new Intent(context, MyService.class);       
        context.startService(serviceIntent);  
		
		
	}

}
