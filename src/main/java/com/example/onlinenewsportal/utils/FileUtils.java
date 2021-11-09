package com.example.onlinenewsportal.utils;

import com.example.onlinenewsportal.entity.Article;
import com.example.onlinenewsportal.exception.InputFileHandlingException;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Enumeration;
import java.util.Objects;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FileUtils {

    private static final String FILE_NAME = "article.txt";
    private static final String INCORRECT_ZIP_CONTENT_MESSAGE = "Sorry, the zip doesn't contain only one txt file 'article.txt'";
    private static final String INCORRECT_TXT_CONTENT_MESSAGE = "Sorry, the txt file doesn't contain the article content";

    public static String getContentFromFile(InputStream inputStream) throws IOException {

        String result;

        ZipFile zipFile = getZipFile(inputStream);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        ZipEntry zipEntry = entries.nextElement();
        if (!Objects.isNull(zipEntry)
                && !zipEntry.isDirectory()
                && !entries.hasMoreElements()
                && FILE_NAME.equals(zipEntry.getName())) {
            InputStream stream = zipFile.getInputStream(zipEntry);
            result = IOUtils.toString(stream, Charset.defaultCharset());
            stream.close();
        } else {
            throw new InputFileHandlingException(INCORRECT_ZIP_CONTENT_MESSAGE);
        }
        zipFile.close();

        return result;
    }

    public static Article getArticleFromContent(String content) {
        String[] split = content.split(System.lineSeparator());
        if (split.length < 2) {
            throw new InputFileHandlingException(INCORRECT_TXT_CONTENT_MESSAGE);
        }
        // all without the first line is article's content
        String replace = content.replace(split[0] + System.lineSeparator(), "");
        return new Article(split[0], split[1], replace, new Date());
    }

    private static ZipFile getZipFile(InputStream inputStream) throws IOException {
        File temp = File.createTempFile(UUID.randomUUID().toString(), "temp");
        org.apache.commons.io.FileUtils.copyInputStreamToFile(inputStream, temp);
        return new ZipFile(temp);
    }
}
