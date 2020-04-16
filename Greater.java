public class Greater extends Thread {
    private int id, startIndex, endIndex;
    private int[] numbers;
    private int greater;

    public Greater(int id, int startIndex, int endIndex, int[] numbers) {
        this.id = id;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.numbers = numbers;
        this.greater = numbers[startIndex];

    }

    public void run() {
        System.out.println("Thread " + id + " iniciada!");
        this.greater = numbers[startIndex];
        for (int i = startIndex; i < endIndex; i++)
            if (this.greater < numbers[i])
                this.greater = numbers[i];
    }

    public int getGreater() {
        System.out.println("Selecionando o maior numero da Thread " + id);
        return this.greater;
    }
}