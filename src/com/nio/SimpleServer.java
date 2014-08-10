package com.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SimpleServer {

	public static void main(String[] args) throws Exception {
		
		ServerSocketChannel ssc = ServerSocketChannel.open();
		
		
		ssc.configureBlocking(false);
		
		SocketChannel sc = ssc.accept();
		
		sc.configureBlocking(false);
		
		
		
		Selector selector = Selector.open();
		
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		
		
		
		
		SelectionKey key = sc.register(selector, SelectionKey.OP_WRITE);
		
		
		
		
		
		
		
		
		
	}
	
	
}
