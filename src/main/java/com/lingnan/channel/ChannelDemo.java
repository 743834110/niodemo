package com.lingnan.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelDemo {

    public static void main(String args[]) throws IOException {
        String relativelyPath = System.getProperty("user.dir");
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\work\\point_temp.txt");
        ByteChannel readChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\work\\result.txt");
        ByteChannel writeChannel = outputStream.getChannel();
        copyData(readChannel, writeChannel);
        readChannel.close();
        writeChannel.close();
    }

    private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException {

        // 系统级内存分配
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10 * 1024);
        // JVM内的内存开销
        byteBuffer = ByteBuffer.allocate(10 * 1024);

        while (src.read(byteBuffer) != -1) {

            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {

                dest.write(byteBuffer);

            }
            byteBuffer.clear();
        }
    }
}
