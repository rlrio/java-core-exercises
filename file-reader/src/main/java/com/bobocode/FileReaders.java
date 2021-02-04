package com.bobocode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {
        Objects.requireNonNull(fileName);
        URL fileURL = FileReaders.class.getClassLoader().getResource(fileName);
        Path filePath;
        try {
            filePath = Paths.get(fileURL.toURI());
            return Files.lines(filePath).collect(joining("\n"));
        } catch (URISyntaxException e) {
            throw new FileReaderException("Invalid file URL.",e);
        } catch (IOException e) {
            throw new FileReaderException("Cannot return string of file lines.",e);
        }
    }
}