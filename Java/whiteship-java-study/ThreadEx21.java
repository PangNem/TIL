public class ThreadEx21 {
  public static void main(String[] args) {
    Runnable runnable = new Runnable21();
    new Thread(runnable).start();
    new Thread(runnable).start();
  }
}

class Account {
  private int balance = 1000;

  public int getBalance() {
    return balance;
  }

  public void withdraw(int money) {
    synchronized(this){
      if (balance >= money) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {}
        balance -= money;
      }
    }
  }
}

class Runnable21 implements Runnable {
  Account account = new Account();

  @Override
  public void run() {
    while(account.getBalance() > 0) {
      int money = (int)(Math.random() * 3 + 1) * 100;
      System.out.println("thread: " + Thread.currentThread().getName() + ", money: " + money);
      account.withdraw(money); 
      System.out.println("balance: " + account.getBalance());
    }
  }

  
}