/**
 * A console application that tests the UnzipUtility class
 *
 * @author www.codejava.net
 *
 */
public class UnzipUtilityTest {

	public static void main(String[] args) {
		String zipFilePath = "test1.zip";
		String destDirectory = "test25";
		UnzipUtility unzipper = new UnzipUtility();

		try {
			unzipper.unzip(zipFilePath, destDirectory);
		} catch (Exception ex) {
			// some errors occurred
			ex.printStackTrace();
		}
	}

}
