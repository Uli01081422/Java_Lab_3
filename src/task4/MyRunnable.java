package task4;

public class MyRunnable implements Runnable {
    private int i = 1,j  = 1;
    private double k = 1.1;

    public MyRunnable(final int i, final int j) {
        this.i = i;
        this.j = j;
    }

    public MyRunnable(final double x) {
        k=x;
    }
    @Override
    public void run() {
        System.out.println(" RUNNABLE:: ARITHMETIC OPERATIONS ");
        System.out.println("SUM = "+(i+j));
        System.out.println("SUBTRACTION = "+(i-j));
        System.out.println("MULTIPLICATION = "+(i*j));
        System.out.println("DIVISION = "+(i/j));
        System.out.println("POWER = "+Math.pow(i,j));
        System.out.println("-----");

        System.out.println("RUNNABLE:: TRIGONOMETRIC OPERATIONS");
        System.out.println("SINUS: "+k+" "+Math.sin(k));
        System.out.println("COSINE: "+k+" "+Math.cos(k));
        System.out.println("TAN: "+k+" "+Math.tan(k));
        System.out.println("SQUARE ROOT OF: "+k+" "+Math.sqrt(k));
        System.out.println("------");
    }
}

