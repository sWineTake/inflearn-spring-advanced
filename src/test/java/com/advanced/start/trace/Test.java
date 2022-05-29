package com.advanced.start.trace;


public class Test implements Runnable{
	// 전역 변수 seq 생성
	int seq;

	// 생성자로 seq 변수를 초기화합니다.
	public Test(int seq) {
		this.seq = seq;
	}

	public static void main(String[] args) {
		// Thread를 10번 호출합니다.
		for (int i = 0; i < 10; i++) {
			// Test Class는 Thread를 상속받았으므로 Thread로 캐스팅이 가능합니다.
			Thread t = new Thread(new Test(i));
			// run 메소드를 실행합니다.
			t.start();
		}
		System.out.println("Main Class End");
	}

	@Override
	public void run() {
		System.out.println(this.seq + " : Test Class run Method Start");
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
		}
		System.out.println(this.seq + " : Test Class run Method End");
	}

}
