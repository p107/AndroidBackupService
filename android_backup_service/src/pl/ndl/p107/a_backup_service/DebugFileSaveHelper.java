package pl.ndl.p107.a_backup_service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;
import android.os.Environment;

public class DebugFileSaveHelper {

	
	@SuppressLint("SimpleDateFormat") public void SaveTestFile() {

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/abs");    
        myDir.mkdirs();
        
        String fname = "abs_4.txt";
        File file = new File (myDir, fname);
        
        
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
     	
        File path1 = Environment.getDataDirectory();
        File path2 = Environment.getExternalStorageDirectory();
        File path3 = new File("/storage");
        
        //  
        //  /storage/extSdCard
        
        FileListHelper filesList = new FileListHelper(true);
        String fileListRaport = filesList.filesList(path3.getPath());
        
        try {
               FileOutputStream out = new FileOutputStream(file);
               OutputStreamWriter osw = new OutputStreamWriter(out);
               osw.write("service - testowa tresc " + reportDate + "\nPATH DATA: " + path1 + "\nEXT: " + path2 + "\nSTORAGE: " + path3 + "\n\n" + fileListRaport /*f.toString()*/ + "\n\n");
               osw.flush();
               osw.close();

        } catch (Exception e) {
               e.printStackTrace();
        }
    }
	
	
}
