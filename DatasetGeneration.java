import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DatasetGeneration {
    static Random random = new Random();
    static final String folderPath = "Datasets/";

    public static int[] sorted(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] reverseSorted(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i - 1;
        }
        return array;
    }

    public static int[] random(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    public static int[] inversionInSorted(int size) {
        int[] array = new int[size];
        int[] sortedPart = new int[size];
        
        for (int i = 0; i < size; i++) {
            sortedPart[i] = i;
        }
        
        int index = random.nextInt(size);
        
        for (int i = 0; i < size; i++) {
            if (i < index) {
                array[i] = sortedPart[i];
            } else {
                array[i] = sortedPart[size - i - 1];
            }
        }
        return array;
    }

    public static void save(String filename, int[] array) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(folderPath + filename))) {
            for (int i = 0; i < array.length; i++) {
                writer.println(array[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] sizes = { (int) Math.pow(2, 9), (int) Math.pow(2, 13), (int) Math.pow(2, 16) };

        for (int size : sizes) {
            int[] sorted = sorted(size);
            int[] reverseSorted = reverseSorted(size);
            int[] random = random(size);

            save("sorted_dataset_" + size + ".txt", sorted);
            save("reverseSorted_dataset_" + size + ".txt", reverseSorted);
            save("random_dataset_" + size + ".txt", random);
        }
    }

}
