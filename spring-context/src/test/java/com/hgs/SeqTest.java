package com.hgs;

public class SeqTest {

	private static int count = 0;
	private static String lock = "lock";

	public static void main(String[] args) {
		new Thread(()->{
			while(true && count<30){
				synchronized (lock){
					while (count%3==0 && count<30){
						System.out.print("A");
						count++;
					}
				}
			}
		}).start();
		new Thread(()->{
			while(true && count<30){
				synchronized (lock){
					while (count%3==1 && count<30){
						System.out.print("B");
						count++;
					}
				}
			}
		}).start();
		new Thread(()->{
			while(true && count<30){
				synchronized (lock){
					while (count%3==2){
						System.out.println("C");
						count++;
					}
				}
			}
		}).start();
	}
}
