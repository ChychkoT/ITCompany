package runner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class FileReadWrite {
	
	private static final Logger LOGGER = Logger.getLogger(FileReadWrite.class);

	public static void main(String[] args) {
		LOGGER.info("-------------File---------------\n");

		File myfile = new File("src/main/resources/javaTestText.txt");
		try {
			String text = FileUtils.readFileToString(myfile, "UTF-8");
			LOGGER.info(text);
			LOGGER.info("\n");

			String t = StringUtils.replaceEach(text, new String[] { ",", "." },
					new String[] { "", "" });
			String arrtext[] = StringUtils.split(t, " ");
			StringBuilder newText = new StringBuilder();
			for (int i = 0; i < arrtext.length; i++) {
				if (!StringUtils.contains(newText, arrtext[i])) {
					int word = StringUtils.countMatches(text, arrtext[i]);
					newText.append(arrtext[i]).append(" - repeat ")
							.append(word).append(" \n");
				}

				File myfile2 = new File("src/main/resources/javaTestText2.txt");
				FileUtils.writeStringToFile(myfile2, newText.toString(),
						"UTF-8");
			}
			LOGGER.info(newText);

		} catch (IOException e1) {
			LOGGER.error("IO exception: " + e1.getMessage());
		}

	}

}
