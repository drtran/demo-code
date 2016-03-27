package com.bemach.aep.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

public class PingingPies {
	@Test
	public void allPiesShouldRespond() {
		String[] hosts = {
				"pidev0",
				"pidev1",
				"pidev2",
				"pidev3",
				"pidev4",
				"pidev5",
				"pidev6",
				"pidev7",
				"pidev8",
				"pidev9",
				"pidev10",
				"pialarm01",
				"pi3mate"
		};
		for (String host: hosts) {
			runSystemCommand("ping " + host);
		}
	}
	
	public static void runSystemCommand(String command) {

		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(p.getInputStream()));

			String s = "";
			// reading output stream of the command
			while ((s = inputStream.readLine()) != null) {
				System.out.println(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
