class ThreadEx9 {
  public static void main (String args[]) {
    ThreadGroup main = Thread.currentThread().getThreadGroup();
    ThreadGroup group1 = new ThreadGroup("Group1");
    ThreadGroup group2 = new ThreadGroup("Group2");

    ThreadGroup subGroup1 = new ThreadGroup(group1, "SubGroup1");

    group1.setMaxPriority(3);

    Runnable runnable = new Runnable(){
      @Override
      public void run (){
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {}
      }
    };

    new Thread(group1, runnable, "thread1").start();
    new Thread(subGroup1, runnable, "thread2").start();
    new Thread(group2, runnable, "thread3").start();

    System.out.println(">>List of ThreadGroup :" + main.getName()
    + ", Active ThreadGroup : " + main.activeGroupCount()
    + ", Active Thread : " + main.activeCount()
    );

    main.list();
    // group1.list();
    // group2.list();
    // subGroup1.list();
  }
}