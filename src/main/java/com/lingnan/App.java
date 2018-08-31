package com.lingnan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        System.out.println( "Hello World!" );
        SocketChannel channel = SocketChannel.open(new InetSocketAddress(3306));
        channel.close();
    }
}
