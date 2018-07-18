package common;

import java.io.File;
import java.io.IOException;

public class TempFileFactory {
	public static File getTempFile(String suffix) throws IOException {
		File f = File.createTempFile("tmp", suffix);
		return f;
	}
}
