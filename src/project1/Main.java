package project1;

import project1.generator.Dictionary;
import project1.generator.PermGenerator;
import project1.writer.SequenceWriter;
import project1.writer.SkipWriter;

/**
 * Created by zhang tingjian on 2021/10/6.
 */
public class Main {

    private static long test(PermGenerator generator, SequenceWriter writer) {
        long tic = System.currentTimeMillis();
        generator.generate(writer);
        long toc = System.currentTimeMillis();
        return toc - tic;
    }

    public static void main(String[] args) {
        int len = 11;
        SequenceWriter writer = new SkipWriter();
        PermGenerator generator = new Dictionary(len);
        long sum = 0;
        int testTime = 10;
        for (int i = 0; i < testTime; i++) {
            //sum += test(generator, writer);
            long tt = test(generator, writer);
            sum += tt;
            System.out.println(tt);
            generator.reset();
        }
        System.out.println(sum / testTime);
    }

}
