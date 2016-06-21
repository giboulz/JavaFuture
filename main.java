package com.gbz;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				System.out.println("Début");
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				Thread.sleep(duration);
				
				return duration;
			}
			
		});
		
		executor.shutdown();
		
		try {
			System.out.println("Resultat : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}