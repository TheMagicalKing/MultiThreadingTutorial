public class PrintChar implements Runnable {
    private char charToPrint; // The character to print
    private int times; // The times to repeat


    /** Construct a task with specified character and number of
     *  times to print the character
     */
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override /** Override the run() method to tell the system
     *  what the task to perform
     */
    public void run() {
        for (int i = 0; i < times; i++) {
            if (i%10 == 0){
                System.out.println();
            }
            System.out.print(charToPrint+" ");
        }
    }
}

// The task class for printing number from 1 to n for a given n
class PrintNum implements Runnable {
    private int lastNum;

    /** Construct a task for printing 1, 2, ... i */
    public PrintNum(int n) {
        lastNum = n;
    }

    @Override /** Tell the thread how to run */
    public void run() {

        for (int i = 1; i <= lastNum; i++) {
            if (i%10 == 0){
                System.out.println();
            }
            System.out.print(" " + i);
        }
    }
}

