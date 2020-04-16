import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /* Inicia o tamanho do vetor */
        int size = 10000;
        /* Inicia a quantidade de threads baseada na raiz do tamanho maximo do vetor */
        int qThreads = (int) Math.sqrt(size);

        int[] numbers = new int[size];
        int[] greaters = new int[qThreads];

        for (int i = 0; i < size; i++) {
            /* gera numeros de 1 a 1 milhão */
            numbers[i] = new Random().nextInt(10000000);
        }

        /* Para contabilizar o tempo de execução */
        long startTime = System.currentTimeMillis();

        int step = size / qThreads;

        Greater[] threads = new Greater[qThreads];

        for (int i = 0; i < qThreads; i++) {
            if (i != qThreads - 1)
                threads[i] = new Greater(i, step * i, step * (i + 1), numbers);
            else
                threads[i] = new Greater(i, step * i, numbers.length, numbers);

        }

        for (int i = 0; i < qThreads; i++)
            threads[i].start();

        for (int i = 0; i < qThreads; i++)
            threads[i].join();

        for (int i = 0; i < qThreads; i++)
            greaters[i] = threads[i].getGreater();

        /*
         * Depois de calculado, junto tods os maiores numeros de cada parte em um unico
         * vetor para a thread prinicpal calcular o maior dos maiores
         */

        Greater result = new Greater(qThreads, 0, qThreads, greaters);
        result.start();
        result.join();
        int greater = result.getGreater();

        System.out.println("\nMaior número encontrado: " + greater);

        long endTime = System.currentTimeMillis();

        System.out.println("\nTempo gasto para execução: "
                + new SimpleDateFormat("mm:ss.SSS").format(new Date(endTime - startTime)));

    }
}