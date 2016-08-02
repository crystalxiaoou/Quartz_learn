/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.ByteProcessor;
import com.google.common.io.Files;

/**
 * Created by baidu on 16/8/2.
 */
public class FileTest {
    @Test
    public void testFile() {
        try {
//            List<String> lines = Files.readAllLines(
//                    Paths.get("/Users/baidu/Desktop/info_1002_9000_20160427.txt"));
//            lines.remove(0);
//            lines.remove(lines.size() - 1);
//            for (String line : lines) {
//                System.out.println(line.substring(0, 40));
//            }
            File file =
                    new File("/Users/baidu/Desktop/info_1002_9000_20160427.txt");
            List<ProdInfo> prodInfoList =
                    Files.readBytes(file, new ByteProcessor<List<ProdInfo>>() {
                        ArrayList<ProdInfo> prodInfos = new ArrayList<ProdInfo>();
                        @Override
                        public boolean processBytes(byte[] bytes, int start, int end) throws IOException {
                            ProdInfo prodInfo = new ProdInfo();
                            byte[] realBytes = new byte[40];
                            for (int i = start; i < 40 && i < end; i++) {
                                realBytes[i] = bytes[i];
                            }
                            prodInfo.setProductName(new String(realBytes, Charsets.UTF_8));
                            System.out.println(prodInfo.getProductName());
                            int length = realBytes.length;
                            System.out.println(length);
                            realBytes = new byte[32];
                            for (int i = length; i < (length + 32) && i < end; i++) {
                                realBytes[i - length] = bytes[i];
                            }
                            prodInfo.setProductCode(new String(realBytes, Charsets.UTF_8));
                            prodInfos.add(prodInfo);
                            return true;
                        }

                        @Override
                        public List<ProdInfo> getResult() {
                            return prodInfos;
                        }
                    });
            for (ProdInfo prodInfo : prodInfoList) {
                System.out.println(prodInfo.getProductName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
