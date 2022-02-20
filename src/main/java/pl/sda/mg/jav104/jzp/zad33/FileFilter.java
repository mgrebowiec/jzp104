package pl.sda.mg.jav104.jzp.zad33;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileFilter {
    public static void main(String[] args) {
        Path directory = Paths.get("C:\\SDA\\workspace\\java-zaawansowana-programowanie\\10_10_2021");
        PrintFilesWithExtensions printFilesWithExtensions = new PrintFilesWithExtensions("txt", "java");

        try {
            Files.walkFileTree(directory, printFilesWithExtensions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class PrintFilesWithExtensions extends SimpleFileVisitor<Path> {
        List<String> extensions;

        public PrintFilesWithExtensions(String... extensions) {
            if (extensions == null) {
                this.extensions = Collections.emptyList();
            } else {
                this.extensions = Stream.of(extensions)
                        .map(extension -> "." + extension)
                        .collect(Collectors.toList());
            }
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (extensions.stream().anyMatch(extension -> file.getFileName().toString().endsWith(extension))) {
                System.out.println(file.toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
