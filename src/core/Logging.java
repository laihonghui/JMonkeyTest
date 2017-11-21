package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
/**
 * 
 * @author Mathias Thejsen - Thejsen@live.dk - s175192
 *
 */
public class Logging {
	static BufferedWriter writer;
	protected static void writeLog(String name, String string) {
		try {
			writer = new BufferedWriter(new FileWriter(name+".txt", true));
			writer.append(string);
			writer.newLine();
			writer.close();

		} catch (IOException e) {
			MonkeyBase.logger.log(Level.WARNING, "Something went wrong trying to write to the log with following name and string: "+name+" | "+string);
			e.printStackTrace();
		}
	

	}
	protected static void clearLog(String name) {
		try {
			writer = new BufferedWriter(new FileWriter(name+".txt",false));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			MonkeyBase.logger.log(Level.WARNING, "Something went wrong trying to clear log with filename: "+name+".txt");
			e.printStackTrace();
		}
	}
	protected static void closeLog() {
		try {
			writer.close();
		} catch (IOException e) {
			MonkeyBase.logger.log(Level.WARNING, "Something went wrong trying to close the log");
			e.printStackTrace();
		}
	}
}
