import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaUtility {

	public String readDataFromProperty(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream("./src/test/resources/Thunai_Test_Data.Properties"));
		String value = p.getProperty(key);
		return value;
	}
}
