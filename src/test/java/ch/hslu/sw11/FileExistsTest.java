package ch.hslu.sw11;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class FileExistsTest {

	@Test
	public void testCheckFileExistance() throws Exception {
		assertEquals(true, FileExists.checkFileExistance("C:\\Users\\Dave\\myCloud\\HSLU\\Module\\OOP\\IO-Files\\netatmo-export-201801-201804.csv"));
	}
	@Test
	public void testCheckFileExistance2() throws Exception {
		assertEquals(false, FileExists.checkFileExistance("C:\\Users\\Dave\\myCloud\\HSLU\\Module\\OOP\\IO-Files\\notExisting.not"));
	}

	

}
