import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Sorting Algorithm Initialization
        SortingAlgorithms maxHeapSort = new MaxHeapSort();
        SortingAlgorithms randomizedShellSort = new RandomizedShellSort();

        // Dataset Preparation
        final String folderPath = "Datasets/";
        String[] types = { "sorted_dataset_", "reverseSorted_dataset_", "random_dataset_" };
        int[] sizes = { (int) Math.pow(2, 9), (int) Math.pow(2, 13), (int) Math.pow(2, 16) };

        for (String type : types) {
            for (int size : sizes) {
                String filename = type + size + ".txt";
                System.out.println("Processing file: " + filename);

                try {
                    int[] array = DatasetReader.read(folderPath + filename);

                    // Dataset Analysis
                    System.out.println("Analyzing: " + filename);
                    System.out.println("---------------------------------------");
                    AlgorithmAnalysis.analyze(array.clone(), maxHeapSort);
                    System.out.println(" ");
                    AlgorithmAnalysis.analyze(array.clone(), randomizedShellSort);
                    System.out.println("---------------------------------------");

                } catch (IOException e) {
                    System.err.println("Error: Unable to access file: " + filename);
                }

                System.out.println(" ");
                System.out.println(" ");
            }
        }

    }
}
