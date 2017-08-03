package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Files {
	
	private static BufferedWriter writer;
	private static BufferedReader reader;
	private static File configFile;
	
	private static String totalConfigContent;
	
	private static String[] keys;
	private static String[] content;
	
	public static ArrayList<String> paths;
	
	public static void init() {
		configFile = new File(AppDir.getAppDir("MKeys"), "mkeys.config");
		
		try {
			writer = new BufferedWriter(new FileWriter(configFile, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (!configFile.exists()) {
			WriteFile("");
		}
		
		try {
			reader = new BufferedReader(new FileReader(configFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ReadAll();
		
		ReadContent();
	}
	
	public static void ReadContent() {
		String[] lines = totalConfigContent.split(System.lineSeparator());
		
		keys = new String[lines.length];
		content = new String[lines.length];
		
		paths = new ArrayList<>();
		
		for (int i = 0; i < lines.length; i++) {
			String[] split = lines[i].split("=", 2);
			
			keys[i] = split[0];
			
			try {
				content[i] = split[1];
			} catch (ArrayIndexOutOfBoundsException e) {
				content[i] = "";
			}
			
			if (keys[i].equalsIgnoreCase("path")) {
				paths.add(content[i]);
			}
		}
	}
	
	public static void ReadAll() {
		totalConfigContent = "";
		
		try {
			String line;
			while((line = reader.readLine()) != null) {
				totalConfigContent += line + System.lineSeparator();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void WriteFile(String s) {
		try {
			writer.write(s);
			writer.close();
			
			totalConfigContent = s;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void WriteLine(String s) {
		String newConfigContent = totalConfigContent;
		
		if (!newConfigContent.endsWith(System.lineSeparator())) {
			newConfigContent += System.lineSeparator();
		}
		
		newConfigContent += s;
		
		try {
			writer.write(newConfigContent);
			writer.close();
			
			totalConfigContent = newConfigContent;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getContent(String key) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].equalsIgnoreCase(key)) {
				return content[i];
			}
		}
		
		return null;
	}
	
	public static String getKey(String cont) {
		for (int i = 0; i < keys.length; i++) {
			if (content[i].equalsIgnoreCase(cont)) {
				return keys[i];
			}
		}
		
		return null;
	}
	
}
