package com.example.demo;

public class Multithreads1 implements Runnable {
	public static int count = 1;
	private final int MAX_count = 100;
	private final Object lock = new Object();

	@Override
	public void run() {
		while (count <= MAX_count) {
			System.out.println(Thread.currentThread().getName() + ": " + count);
			synchronized (lock) {
				count++;
			}

		}
	}

	public void one() {
		Multithreads1 printer = new Multithreads1();

		Runnable runnable1 = printer::run;
		Runnable runnable2 = printer::run;

		Thread thread1 = new Thread(runnable1, "Thread1");
		Thread thread2 = new Thread(runnable2, "Thread2");

		thread1.start();
		thread2.start();

	}

}

//Multithreads1 printer = new Multithreads1();
//Runnable[] runnable = new Runnable[10];
//
//for (int i = 0; i < 10; i++) {
//    runnable[i] = printer::run;
//}
//Thread[] threads = new Thread[10];
//for (int i = 0; i < 10; i++) {
//    threads[i] = new Thread(runnable[i], "Thread" + (i + 1));
//    threads[i].start();
//
//}
//
//}
// 
//}