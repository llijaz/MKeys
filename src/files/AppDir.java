package files;

import java.io.File;

public class AppDir {

	private static File APP_DIR = null;

	static File getAppDir(String appName) {
		if(APP_DIR != null) {
			return APP_DIR;
		}

		String os = System.getProperty("os.name").toLowerCase();
		if(os.equals("linux")) {
			APP_DIR = new File(new File(System.getProperty("user.home"), ".config"), appName);
		} else if(os.startsWith("windows")) {
			APP_DIR = new File(System.getenv("APPDATA"), appName);
		} else {
			APP_DIR = new File(System.getProperty("user.dir"), appName);
		}

		if(!APP_DIR.exists()) {
			APP_DIR.mkdir();
		}

		return APP_DIR;
	}

}
