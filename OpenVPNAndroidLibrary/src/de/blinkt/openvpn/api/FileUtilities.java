package de.blinkt.openvpn.api;

/**
 * Created by FL on 06.05.14.
 */
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileUtilities {
    private Writer writer;
    private String absolutePath;
    private final Context context;
    public String mFile = "/temp_ovp/conf.ovpn";
    public String mDir = "/temp_ovp";
    public FileUtilities(Context context) {
        super();
        this.context = context;
    }

    public void write(String fileName, String data) {
        File root = Environment.getExternalStorageDirectory();
        File outDir = new File(root.getAbsolutePath() + File.separator + "temp_ovp");
        if (!outDir.isDirectory()) {
            outDir.mkdir();
        }
        try {
            if (!outDir.isDirectory()) {
                throw new IOException(
                        "Unable to create directory EZ_time_tracker. Maybe the SD card is mounted?");
            }
            File outputFile = new File(outDir, fileName);
            writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(data);

            writer.close();
        } catch (IOException e) {
            Log.w("eztt", e.getMessage(), e);

        }

    }

    public Writer getWriter() {
        return writer;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }
    public void recursiveDelete(File fileOrDirectory) {
		if (fileOrDirectory.isDirectory())
			for (File child : fileOrDirectory.listFiles())
				recursiveDelete(child);

		fileOrDirectory.delete();
	}
	

}



