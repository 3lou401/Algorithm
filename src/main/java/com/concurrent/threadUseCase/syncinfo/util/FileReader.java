package com.concurrent.threadUseCase.syncinfo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/20 14:32
 * @Desc:
 */
@Slf4j(topic = "C.FileReader")
public class FileReader {
    public static byte[] read(){
        long beginMillis = System.currentTimeMillis();
        log.error("start thread ");
        byte[] res = new byte[1024];
        try(FileInputStream fis = new FileInputStream(new File("C:\\Users\\leaderHoo\\Documents\\测试文件\\data.json"));
            FileChannel fileChannel = fis.getChannel();
        ){
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
            res =   byteBuffer.array();
        }catch (Exception e){
            e.printStackTrace();
        }
        long endMillis = System.currentTimeMillis();
        log.error("end 共耗时 "+ (endMillis-beginMillis) +" 毫秒");
        return res;
    }

    public static void main(String[] args) {
       byte[] s =  read();
    }


}
