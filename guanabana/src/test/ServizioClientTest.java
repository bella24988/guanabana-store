/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import client.ServizioClient;

/**
 * Classe di test Junit
 * @author Gabriele
 * @author Veronica
 */
public class ServizioClientTest {

	/**
	 * Test method for {@link client.ServizioClient#conta(java.lang.String)}.
	 */
	@Test
	public void testConta() {
		ServizioClient testContaClient = new ServizioClient("localhost");
		String[] type = {"LAP", "SER", "DES"};
		int componentsForType = 2;
		for (int i = 0; i < type.length; i++) {
			try {
				assertEquals(componentsForType, testContaClient.conta(type[i]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
