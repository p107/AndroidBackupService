package pl.ndl.p107.android_backup_service;

import java.io.File;

public class FileListHelper {
	
	final private String suff = "  ";
	
	//TODO: recursive jako pole ustawiane w konstruktorze
	
	public FileListHelper() {
		// TODO Auto-generated constructor stub
	}

	public String filesList(String path, boolean recursive) {
		File p = new File(path);
		return dirList(p, recursive, suff);
	}
	
	public String filesList(String path) {
		return filesList(path, false);
	}
	
	private String dirList(File p, boolean recursive, String suffix) {
		File files[] = p.listFiles();
        StringBuilder f = new StringBuilder();
        for (int i=0; i < files.length; i++) {
        	f.append(suffix);
        	if (files[i].isDirectory()) {
        		f.append("<dir> " + files[i].getName() + "\n");
        		if (recursive) {
        			dirList(files[i], recursive, suff + suffix);
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