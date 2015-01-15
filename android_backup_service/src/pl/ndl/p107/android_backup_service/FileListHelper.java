package pl.ndl.p107.android_backup_service;

import java.io.File;

import android.util.Log;

public class FileListHelper {
	
	final private String suff = "  ";
	private boolean recursive = false; 
	
	public FileListHelper(boolean recursiv) {
		this.recursive = recursiv;
	}
	
	public String filesList(String path) {
		File p = new File(path);
		return dirList(p, "");
	}
		
	private String dirList(File p, String suffix) {
		File files[] = p.listFiles();
        StringBuilder f = new StringBuilder();
        for (int i=0; i < files.length; i++) {
        	f.append(suffix);
        	if (files[i].isDirectory()) {
        		f.append("<dir> " + files[i].getName() + "\n");
        		if (recursive && files[i].canRead()) {
        			f.append(dirList(files[i], suff + suffix));
        			//Log.d("my", files[i].getAbsolutePath());
        		}
        	}
        	else {
        		f.append(files[i].getName());
        	}
        	f.append("\n");
        }
		return f.toString();
	}
	
}