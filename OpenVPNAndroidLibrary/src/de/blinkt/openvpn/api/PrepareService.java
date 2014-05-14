package de.blinkt.openvpn.api;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import de.blinkt.openvpn.LaunchVPN;
import de.blinkt.openvpn.activities.ConfigConverter;
import de.blinkt.openvpn.activities.DisconnectVPN;

public class PrepareService {
	private FileUtilities fl;
	private Intent startImport;
	private File f;
	private String mConfig;
	private static final int IMPORT_PROFILE = 231;
	private Activity activi;
	private File dir;
	private String mudf;

	private Intent intent;

	public PrepareService(Activity activity, String config, String udf) {
		activi = activity;
		mConfig = config;
		mudf = udf;
		fl = new FileUtilities(activi);
		startImport = new Intent(activi, ConfigConverter.class);
		fl.write("conf.ovpn", mConfig);
		f = new File(Environment.getExternalStorageDirectory() + fl.mFile);
		startImport.setAction(ConfigConverter.IMPORT_PROFILE);
		startImport.setData(Uri.fromFile(f));
		dir = new File(Environment.getExternalStorageDirectory() + fl.mDir);
		activi.startActivityForResult(startImport, IMPORT_PROFILE);
	}

	public void startService() {
		intent = new Intent(activi, LaunchVPN.class);
		intent.setAction(Intent.ACTION_MAIN);
		intent.putExtra(LaunchVPN.EXTRA_KEY, mudf);
		activi.startActivity(intent);
		if (f.exists() && dir.exists()) {
			f.delete();
			fl.recursiveDelete(dir);
		}
	}

	public void desconnectService() {
		Intent intent = new Intent(activi, DisconnectVPN.class);
		activi.startActivity(intent);
	}
}
