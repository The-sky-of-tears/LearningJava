package com.codegym.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Decrease").start();
        new Thread(new CountUpRunnable(), "Increase").start();
    }

    public static class CountdownRunnable implements Runnable {
        private int countdownIndex = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countdownIndex -= 1;
                    if (countdownIndex == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countdownIndex;
        }
    }

    public static class CountUpRunnable implements Runnable {
        private int countUpIndex = 1;

        @Override
        public void run() {
            try {
                for (; countUpIndex <= number; countUpIndex++) {
                    System.out.println(Thread.currentThread().getName() + ": " + countUpIndex);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }
    }
}
