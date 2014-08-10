package com.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

/** 
 * TCP/IP的NIO非阻塞方式
 * 服务器端
 * */

public class Server implements Runnable{

	//第一个端口
	private Integer port1 = 8099;
	private ServerSocketChannel serverChannel ;
	//缓冲区
	private ByteBuffer buf = ByteBuffer.allocate(512);

      public Server(){
		init();
	}
	
	//选择器，主要用来监控各个通道的事件
	private Selector selector ;
	
	/**
	 * 这个method的作用1：是初始化选择器
	 * 2：打开两个通道
	 * 3：给通道上绑定一个socket
	 * 4：将选择器注册到通道上
	 * */
	public  void init(){
		try{
			//创建选择器
			this.selector = SelectorProvider.provider().openSelector();
			//打开第一个服务器通道
			this.serverChannel = ServerSocketChannel.open();
			//告诉程序现在不是阻塞方式的
			this.serverChannel.configureBlocking(false);
			//获取现在与该通道关联的套接字
			this.serverChannel.socket().bind(new InetSocketAddress("localhost",this.port1));
			//将选择器注册到通道上，返回一个选择键
			//OP_ACCEPT用于套接字接受操作的操作集位
			this.serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 这个方法是连接
	 * 客户端连接服务器
	 * @throws IOException 
	 * */
	public void accept(SelectionKey key) throws IOException{
		ServerSocketChannel server = (ServerSocketChannel) key.channel(); 	
		
		SocketChannel	clientChannel = server.accept();
			clientChannel.configureBlocking(false);
			clientChannel.register(this.selector, SelectionKey.OP_READ);
		
	}
	
	/**
	 * 从通道中读取数据
	 * @throws IOException 
	 * */
	public void read(SelectionKey key) throws IOException{
			
			this.buf.clear();
			//通过选择键来找到之前注册的通道
			//但是这里注册的是ServerSocketChannel为什么会返回一个SocketChannel？？
			SocketChannel channel = (SocketChannel) key.channel();
			//从通道里面读取数据到缓冲区并返回读取字节数
			int count = channel.read( this.buf);
			
			if(count == -1){
				//取消这个通道的注册
	            key.channel().close();
	            key.cancel();
	            return;
			}
			
			//将数据从缓冲区中拿出来
			String input = new String(this.buf.array()).trim();
				System.out.println("欢迎您使用服务");
				System.out.println("您的输入为："+input);
		
	}
	
	@Override
	public void run() {
		while(true){
			try{
				//选择一组键，其相应的通道已为 I/O 操作准备就绪。
				this.selector.select();
				
				//返回此选择器的已选择键集
				//public abstract Set<SelectionKey> selectedKeys()
				Iterator selectorKeys = this.selector.selectedKeys().iterator();
				while(selectorKeys.hasNext()){
					//这里找到当前的选择键
					SelectionKey key = (SelectionKey) selectorKeys.next();
					//然后将它从返回键队列中删除
					selectorKeys.remove();
					if(!key.isValid()){
						continue;
					}
					if(key.isAcceptable()){
						//如果遇到请求那么就响应
						this.accept(key);
					}else if(key.isReadable()){
						//读取客户端的数据
						this.read(key);
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	public static void main(String[] args) {
		Server server = new Server();
		Thread thread = new Thread(server);
		thread.start();
	}
}
