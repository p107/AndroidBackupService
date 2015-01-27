package pl.ndl.p107.a_backup_service;

import java.io.File;
import java.io.IOException;

public class CopyTest {

	private String path1 = "/storage/sdcard0/DCIM";
	private String path2 = "/storage/extSdCard/abs_backup/DCIM";
	//private String path2 = "/storage/sdcard/abs_backup/DCIM";
	
	public CopyTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void Test1() {
		
		dirCopy(new File(path1));
		
	}
	
	private void dirCopy(File p) {
		File files[] = p.listFiles();
        //StringBuilder f = new StringBuilder();
        for (int i=0; i < files.length; i++) {
        	
        	String p1 = files[i].getAbsolutePath();
    		String p2 = p1.replace(path1, path2);
    		
        	if (files[i].isDirectory()) {
        		//f.append("<dir> " + files[i].getAbsolutePath() + "\n");
        		if (files[i].canRead()) {
        			File myDir = new File(p2);    
        	        myDir.mkdirs();
        	        
        			dirCopy(files[i]);
        		}
        	}
        	else {
        		//f.append(files[i].getName());
        		try {
					FileCopyHelper.copy(new File(p1), new File(p2));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        	}
        	//f.append("\n");
        }
		//return f.toString();
	}
	
	
}
