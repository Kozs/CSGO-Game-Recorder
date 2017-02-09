package org.zach.csgo.record.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.zach.csgo.record.UserInput;

public class CreateFile {
	String userHomeFolder = System.getProperty("user.home");
	File textFile = new File(userHomeFolder, "Desktop\\CSRecords\\CSGO.txt");
	public boolean exists() {
		if (textFile.exists()) {
			return false;
		}
		return true;
	}
	public void createFile() {
		try {
			textFile.createNewFile();
			System.out.println("File Made at: " + textFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeInfo() {
		Date d = new Date();
		String result = "";
		if (!UserInput.won) {
			result = "Loss";
		} else {
			result = "Win!";
		}
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(textFile, true)))) {
			out.println("Date: "+ d);
			out.println("\tScore (You/Them): " +UserInput.score);
			out.println("\tResult: "+result);
			out.println("\tCurrent Rank: "+UserInput.rank);
			out.println("\tKills: "+UserInput.kills);
			out.println("\tDeaths: "+UserInput.deaths);
			out.println("\tSmurfs on your Team: "+UserInput.smurfOnTeam);
			out.println("\tSmurfs on opposite Team: "+UserInput.smurfOther);
			out.println("\tExtra Information: " + UserInput.extraInfo);
			out.println("");
			out.flush();
			out.close();
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
		}
	}
}