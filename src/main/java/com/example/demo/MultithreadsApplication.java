package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultithreadsApplication {

	public static void main(String[] args) throws InterruptedException {
//		SpringApplication.run(MultithreadsApplication.class, args);
//
//		System.out.println("");
//		Multithreads1 m1 = new Multithreads1();
//		m1.one();
	    final int nthreads = 2;
	    final Thread[] workers = new Thread[nthreads];
	    for (int i = 0; i < nthreads; ++i) {
	        workers[i] = new Thread(new PrintingTask(System.out, i + 1, 100, nthreads));
	    }
	    for (final Thread t : workers) {
	        t.start();
	    }
	    for (final Thread t : workers) {
	        t.join();
	    }
	}
}
