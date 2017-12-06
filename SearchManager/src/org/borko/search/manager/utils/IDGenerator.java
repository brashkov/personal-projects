package org.borko.search.manager.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class IDGenerator {

	private static Properties prop = new Properties();
	private static int LAST_ID = 0;

	/**
	 * 
	 * @return inputStream with the properties from the file
	 */
	private static Properties openFile() {
		InputStream input = null;

		try {
			input = new FileInputStream("resources/id_and_constants.properties");
			prop.load(input);

			return prop;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop; // empty prop file !
	}

	/**
	 * 
	 * @return returns the current ID form the prop file
	 * @throws IOException
	 *             if the ID is equal to null
	 */
	public static String getID() throws IOException {
		Properties prop = openFile();
		String ID = prop.getProperty("ID");

		if (ID != null) {
			IdByOne(ID);
			return ID;
		} else {
			reCreateFile();
			return prop.getProperty("ID");
		}
	}

	private static boolean IdByOne(String ID) throws IOException {
		OutputStream output;
		LAST_ID= Integer.valueOf(ID);
		try {
			output = new FileOutputStream("resources/id_and_constants.properties");
			String newID = String.valueOf(LAST_ID+1);
			prop.replace("ID", newID);
			prop.store(output, null);
		} catch (FileNotFoundException e) {
			throw new IOException("Proeprties file not found");
		} catch (IOException e) {
			throw new IOException("Problems with saving the changes");
		} catch (ClassCastException e) {
			e.printStackTrace();
			reCreateFile();
		}
		return true;
	}
	
	/**
	 * If an Exception occurs this will be called so the last known value of the ID will be saved and stored in the prop file
	 * @throws IOException
	 */
	private static void reCreateFile() throws IOException {
		OutputStream out;
		
		try {
			out = new FileOutputStream("resources/id_and_constants.properties");
			prop.setProperty("ID", String.valueOf(LAST_ID));
			prop.store(out, "Recreating file with the last values that were okey");
		}  catch (FileNotFoundException e) {
			throw new IOException("Proeprties file not found");
		} catch (IOException e) {
			throw new IOException("Problems with saving the changes");
		}
	}
}
