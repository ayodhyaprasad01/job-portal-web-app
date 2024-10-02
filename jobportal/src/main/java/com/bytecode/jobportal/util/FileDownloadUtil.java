package com.bytecode.jobportal.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.UrlResource;

import io.github.classgraph.Resource;

public class FileDownloadUtil {

    private Path foundfile;

    public UrlResource getFileAsResourse(String downloadDir, String fileName) throws IOException {

        Path path = Paths.get(downloadDir);
        Files.list(path).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileName)) {
                foundfile = file;
            }
        });

        if (foundfile != null) {
            return new UrlResource(foundfile.toUri());
        }
        return null;
    }
}
