package project1;

import project1.generator.*;
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
        SequenceWriter writer = new SkipWriter();
        for (int i = 2; i < 12; i++) {
            (new NeighbourSwap(i)).generate(writer);
        }
    }

}
