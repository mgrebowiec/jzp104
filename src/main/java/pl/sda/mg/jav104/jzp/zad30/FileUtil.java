package pl.sda.mg.jav104.jzp.zad30;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtil {
    public static void main(String[] args) {
        String filePath = "C:\\SDA\\workspace\\java-zaawansowana-programowanie\\jzp-104\\resources\\sample.txt";
        File fileToRead = new File(filePath);
        File fileToWrite = getFileToWrite(fileToRead);
        try {
            String content = Files.readString(fileToRead.toPath());
            String reverseContent = reverse(content);
//            reverseContent = reverseContent.replace("\n", ""); // to na potrzeby odwróconego CRLF
            Files.writeString(fileToWrite.toPath(), reverseContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getFileToWrite(File fileToRead) {
        String fileName = reverse(getFileNameWithoutExtension(fileToRead));
        String path =  fileToRead.getParent() + File.separator + fileName + getFileExtension(fileToRead);
        return new File(path);
    }

    private static String getFileNameWithoutExtension(File file) {
        return file.getName().substring(0, file.getName().indexOf("."));
    }

    private static String getFileExtension(File file) {
        return file.getName().substring(file.getName().indexOf("."));
    }

    private static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
