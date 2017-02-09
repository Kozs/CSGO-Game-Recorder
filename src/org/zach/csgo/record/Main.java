package org.zach.csgo.record;

import java.io.File;

import org.zach.csgo.record.gui.GUI;
import org.zach.csgo.record.util.CreateFile;

public class Main {
	public static void main(String[] args) {
		CreateFile file = new CreateFile();
		UserInput ui = new UserInput();
		GUI g = new GUI();
		boolean make = file.exists();
		if (make) {
			String userHomeFolder = System.getProperty("user.home");
			new File(userHomeFolder, "Desktop\\CSRecords").mkdirs();
			file.createFile();
			g.setVisible(true);
		} else {
			g.setVisible(true);
		}

	}
}
