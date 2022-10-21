package task4;
import java.lang.*;
class P1 extends Thread {
    private double i;
    public P1(final double x) {
        this.i=x;
    }
    public void run() {
        System.out.println("THREAD B:: TRIGONOMETRIC OPERATIONS");
        System.out.println("SINUS: "+i+" "+Math.sin(i));
        System.out.println("COSINE: "+i+" "+Math.cos(i));
        System.out.println("TAN: "+i+" "+Math.tan(i));
        System.out.println("SQUARE ROOT OF: "+i+" "+Math.sqrt(i));
        System.out.println("END OF B");
    }
}