/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import server.DataBase;

/**
 * @author Gab
 *
 */
public class DataBaseTest {

	/**
	 * Test method for {@link server.DataBase#countComponentiModello(java.lang.String)}.
	 */
	@Test
	public void testCountComponentiModello() {
		try {
			DataBase db= new DataBase();
			String[] type = {"lap", "ser", "des"};
			int[] componentsForType = {13, 21, 23};
			for (int i = 0; i < type.length; i++) {
				assertEquals(componentsForType[i], db.countComponentiModello(type[i]));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
