package com.sirma.itt.javacourse.networkinggui.download.agent.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.sirma.itt.javacourse.networkinggui.download.agent.client.ClientGUI;
import com.sirma.itt.javacourse.networkinggui.download.agent.server.ServerCode;
import com.sirma.itt.javacourse.networkinggui.download.agent.server.ServerGUI;

public class DownloadAgentTests {
	/**
	 * Simulates one download loop.
	 * 
	 * @throws Exception
	 *             - Exception may occur
	 */
	@Test
	public void test() throws Exception {
		ServerGUI server = new ServerGUI(7002);
		equals(7000 <= server.getServerCurrentPort());
		equals(7020 >= server.getServerCurrentPort());

		ClientGUI client = new ClientGUI(server.getServerCurrentPort());
		client.getClient().connectToServer("localhost", server.getServerCurrentPort());
		String url = "http://images.anandtech.com/doci/5434/X79%20Extreme9Box_575px.jpg";
		client.getClient().setDownloadURL(url);
		String directory = "target/";

		ServerCode.download(url, directory);

		File file = new File(directory);
		assertEquals(true, file.isFile());
		// System.exit(0);
	}
}
