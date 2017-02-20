package com.pangpang3.utils.unzip;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by jiangjg on 2017/2/20.
 */
public class GzipUtils {
    public static void main(String[] args) throws IOException {

    }
    public static String compressToBase64Data(String data) throws IOException {
        byte[] binaryData = compress(data);
        return Base64.encodeBase64String(binaryData);
    }

    public static String decompressFromBase64Data(String compressedBase64Data) throws IOException {
        byte[] binaryData = Base64.decodeBase64(compressedBase64Data);
        return decompress(binaryData);
    }

    public static byte[] compress(String data) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length());
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(data.getBytes("UTF-8"));
        gzip.close();
        byte[] compressed = bos.toByteArray();
        bos.close();
        return compressed;
    }

    public static String decompress(byte[] compressed) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(compressed);
        GZIPInputStream gis = new GZIPInputStream(bis);
        BufferedReader br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        gis.close();
        bis.close();
        return sb.toString();
    }
}
