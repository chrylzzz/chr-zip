package com.chryl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;

/**
 * Created by Chr.yl on 2020/8/30.
 *
 * @author Chr.yl
 */
public class GzTest {
    public static void main(String[] args) {
        String filePath = "/Users/chryl/Desktop/切换硬盘格式22.tar.gz";
        String outputFile = filePath.substring(0, filePath.lastIndexOf("."));

        try (
                //建立gz压缩文件流
                FileInputStream fileInputStream = new FileInputStream(filePath);
                //建立gz解压流
                GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
                //
                FileOutputStream fileOutputStream = new FileOutputStream(outputFile)
        ) {
            int num;
            byte[] data = new byte[1024];
            while ((num = gzipInputStream.read(data, 0, data.length)) != -1) {
                fileOutputStream.write(data, 0, num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
