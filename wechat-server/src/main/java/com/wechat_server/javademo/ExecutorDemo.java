package com.wechat_server.javademo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import rx.internal.schedulers.CachedThreadScheduler;


public class ExecutorDemo {
	public static void main(String[] args) {
		//定长线程池单参数
		ExecutorService pool=Executors.newFixedThreadPool(10);
		ExecutorDemo tExecutorDemo=new ExecutorDemo();
		MyThreadFactory tMyThreadFactory=tExecutorDemo.new MyThreadFactory();
		//定长线程池多参数
		ExecutorService poolSecond=Executors.newFixedThreadPool(10, new ExecutorDemo().new MyThreadFactory());

	}
	public class MyThreadFactory implements ThreadFactory{

		@Override
		public Thread newThread(Runnable r) {

                Thread tThread=new Thread();
			return tThread;
		}
		
	}
	public void test(String...strings) {
		
	}

}
