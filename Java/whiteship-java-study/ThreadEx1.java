class ThreadEx1 {
  public static void main (String args[]) {
    Thread1Ex_1 thread1 = new Thread1Ex_1();
    Thread thread2 = new Thread(new Thread1Ex_2());

    thread1.start();
    thread2.start();
  }
}

class Thread1Ex_1 extends Thread {
  public void run() {
    for (int i=0; i<5; i++) {
      System.out.println(getName());
    }
  }
} 

class Thread1Ex_2 implements Runnable {
  public void run() {
    for (int i=0; i<5; i++) {
      System.out.println(Thread.currentThread().getName());
    }
  }
}