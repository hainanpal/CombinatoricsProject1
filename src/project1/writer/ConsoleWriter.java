package project1.writer;

/**
 * Created by zhang tingjian on 2021/10/20
 */
public class ConsoleWriter implements SequenceWriter{
    @Override
    public void write(int[] sequence) {
        for (int i : sequence) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
