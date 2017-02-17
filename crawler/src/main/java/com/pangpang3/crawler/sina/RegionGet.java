package com.pangpang3.crawler.sina;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by jiangjg on 2017/2/17.
 */
public class RegionGet {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "\\doc\\crawler\\region.txt";

        try {
            List<String> list = FileUtils.readLines(new File(path), Charset.forName("utf-8"));
            System.out.println(list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
