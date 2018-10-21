public class TestTwo extends Thread{
    static final int size = 10000000;
    static final int h = size / 2;
    float[] a1 = new float[h];
    float[] a2 = new float[h];

    @Override
    public void run() {

        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;

        }
        long a = System.currentTimeMillis();
        System.out.println("а: " + a);

System.arraycopy(arr, 0 ,a1,0, h);
System.arraycopy(arr, h ,a2,0, h);

Thread mass1 = new Thread(){
    @Override
    public void run(){
        for (int i = 0; i < h; i++) {
            a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long a = System.currentTimeMillis();
        System.out.println("первая половина массива " + a);
    }

};

        Thread mass2 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < h; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                long a = System.currentTimeMillis();
                System.out.println("вторая половина массива " + a);
            }
        };

mass1.start();
mass2.start();

        try {
            mass1.join();
            mass2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h);
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());
        System.out.println("Тут есть разделенние " + (System.currentTimeMillis() - a));
    }





}
