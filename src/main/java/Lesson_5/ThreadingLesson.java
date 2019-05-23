package Lesson_5;

class CalculatingThread extends Thread {

    CalculatingThread(float[] arr, int offset, int size, int threadNo) {
        m_threadNo = threadNo;
        m_offset = offset;
        m_size = size;
        m_arr = arr;
    }
    @Override
    public void run() {
        System.out.println("Starting thread #"+m_threadNo+" in range of ["+m_offset+", "+(m_offset+m_size)+")");

        for (int i=m_offset;i<m_offset+m_size;++i) {
            m_arr[i] = (float)(m_arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private int m_threadNo;
    private int m_offset;
    private int m_size;
    private float m_arr[];
}

interface Benchmarkable {
    void benchmark();
}

class Benchmark {
    Benchmark( Benchmarkable b ) {
        long start = System.currentTimeMillis();
        b.benchmark();
        long end = System.currentTimeMillis();

        System.out.println("Benchmark result: "+(end-start)+" ms");
    }
}

public class ThreadingLesson {

    public static void fillArray(float[] ar) {
        for (int idx=0;idx<ar.length;++idx)
            ar[idx] = idx;
    }

    public static boolean compareArrays(float[] a, float[] b) {
        for (int idx=0;idx<a.length;++idx) {
            if (idx>=b.length)
                return false;
            if (a[idx]!=b[idx])
                return false;
        }
        return true;
    }

    public static void calculate(float[] arr, int threadNumber) throws InterruptedException {
        if (threadNumber==0)
            throw new RuntimeException("threadNumber must be > 0");

        double len = arr.length;
        len = len /threadNumber;
        int rangeSize = (int)Math.ceil(len);

        if (rangeSize==0)
            throw new RuntimeException("too much threads or too litle array");

        CalculatingThread[] thread = new CalculatingThread[threadNumber];

        for (int i=0, thridx=0;i<arr.length;thridx++) {
            if (i+rangeSize>arr.length)
                rangeSize=arr.length-i;
            thread[thridx] = new CalculatingThread(arr, i, rangeSize, thridx);
            i+=rangeSize;
        }

        if (threadNumber==1)
            thread[0].run();
        else {
            for (int thridx=0;thridx<threadNumber;++thridx) {
                thread[thridx].start();
            }
            for (int thridx=0;thridx<threadNumber;++thridx) {
                thread[thridx].join();
            }
        }
    }

    public static void main(String[] args) {

        final int array_len = 1000000;
        float[] ar_1_thread = new float[array_len];
        float[] ar_2_thread = new float[array_len];
        float[] ar_4_thread = new float[array_len];
        float[] ar_10_thread = new float[array_len];

        fillArray(ar_1_thread);
        fillArray(ar_2_thread);
        fillArray(ar_4_thread);
        fillArray(ar_10_thread);

        new Benchmark(new Benchmarkable() {
            @Override
            public void benchmark() {
                try {
                    calculate(ar_1_thread, 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        new Benchmark(new Benchmarkable() {
            @Override
            public void benchmark() {
                try {
                    calculate(ar_2_thread, 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        new Benchmark(new Benchmarkable() {
            @Override
            public void benchmark() {
                try {
                    calculate(ar_4_thread, 4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        new Benchmark(new Benchmarkable() {
            @Override
            public void benchmark() {
                try {
                    calculate(ar_10_thread, 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        if (!compareArrays(ar_1_thread, ar_2_thread))
            throw new RuntimeException("arrays not equal");

        if (!compareArrays(ar_1_thread, ar_4_thread))
            throw new RuntimeException("arrays not equal");

        if (!compareArrays(ar_1_thread, ar_10_thread))
            throw new RuntimeException("arrays not equal");
    }

}
