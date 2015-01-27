package pl.ndl.p107.a_backup_service;

import android.os.Vibrator;

public class MyServiceThread extends Thread {
	
	private Vibrator v;
	
	public void setVibrator(Vibrator v) {
		this.v = v;
	}
	
	@Override
	public void run() {
		
//		//opoznienie na zamontowanie sd
//		try {
//			sleep(60 * 1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		v.vibrate(500);
		
		DebugFileSaveHelper deb = new DebugFileSaveHelper();
		deb.SaveTestFile(); 
		
		v.vibrate(1000);
		
		//kopiowanie 
		CopyTest ct = new CopyTest();
		ct.Test1();
		
		
		//v.vibrate(500);
		long[] pattern = {0, 100, 1000, 300, 200, 100, 500, 200, 100};
		v.vibrate(pattern, -1);
		//
		
	}

}
