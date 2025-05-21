class SharedResult {
    int sum;
    int product;
}

class SumThread extends Thread {
    private final int a, b;
    private final SharedResult result;

    public SumThread(int a, int b, SharedResult result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    public void run() {
        result.sum = a + b;
        System.out.println("Sum computed: " + result.sum);
    }
}

class ProductThread extends Thread {
    private final int a, b;
    private final SharedResult result;

    public ProductThread(int a, int b, SharedResult result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    public void run() {
        result.product = a * b;
        System.out.println("Product computed: " + result.product);
    }
}

public class MultiThreadSumProduct {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        SharedResult result = new SharedResult();

        SumThread sumThread = new SumThread(a, b, result);
        ProductThread productThread = new ProductThread(a, b, result);

        sumThread.start();
        productThread.start();

        try {
            sumThread.join();
            productThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("\nFinal Results:");
        System.out.println("Sum = " + result.sum);
        System.out.println("Product = " + result.product);
    }
}
