package com.pangpang3.crawler.sina;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

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
            for(String item : list){
                if(StringUtils.isNotBlank(item)){
                    String pre = item.substring(0, 1);
                    if(!NumberUtils.isNumber(pre)){
                        item = item.substring(1);
                    }
                    String firstFlag = "\\(";
                    String[] arr = item.split(firstFlag);

                    String regionflname = "";
                    String regionflno = "";
                    String regionslname = "";
                    String regionslno = "";
                    int index = 0;
                    for(String arrItem : arr){
                        if(index == 0){
                            String[] arr2 = arrItem.split("\\.");
                            regionflno = arr2[0];
                            regionflname = arr2[1];
                        }
                        if(index == 1){
                            arrItem = arrItem.substring(0, arrItem.length() - 2);
                            String[] arr2 = StringUtils.split(arrItem, ",");
                            for(String arr2Item : arr2){
                                int secondFlag = arr2Item.indexOf("=");
                                regionslname = arr2Item.substring(0, secondFlag);
                                regionslno = arr2Item.substring(secondFlag + 1);
                                String sql = String.format("insert into riskcrawlersinaweiboregion(regionflname, regionflno, regionslname, regionslno) values (%s, %s, %s, %s);",
                                        regionflname, regionflno, regionslname, regionslno);
                                System.out.println(sql);
                            }
                        }
                        index++;
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
