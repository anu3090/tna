package com.tedwon.scribe.client;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Scribe Client in Java Class.
 * <p/>
 * <p/>This class read a line from a local file and
 * <p/>send the line message to the Scribe central server.
 *
 * @author <a href=mailto:tedd824@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class ScribeClient {

    private static Logger logger = LoggerFactory.getLogger(ScribeClient.class);

    public static void main(String[] args) throws Exception {

        // Read a file from local file system

        String filePath = "/tmp/test.dat";
        File inputFile = FileUtils.getFile(filePath);
        InputStream input = FileUtils.openInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(input, "UTF-8");
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = reader.readLine();

        while(line != null) {

            System.out.println(line);

            line = reader.readLine();
        }
    }
}
