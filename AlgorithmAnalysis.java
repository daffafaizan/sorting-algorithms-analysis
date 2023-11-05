public class AlgorithmAnalysis {

    public static void analyze(int[] array, SortingAlgorithms sortingAlgorithm) {
        System.out.println("Dataset sorted using " + sortingAlgorithm.name());

        System.gc(); 
        long startTime = System.nanoTime();
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        sortingAlgorithm.sort(array);

        long endTime = System.nanoTime();
        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long executionTime = endTime - startTime;
        long memoryUsage = endMemory - startMemory;

        System.out.println("Execution time: " + executionTime / (double) 1000000 + " ms");
        System.out.println("Memory usage: " + memoryUsage / 1024 + " KB");
        isSorted(array);
    }

    public static void isSorted(int[] array) {
        Boolean sorted;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                sorted = false;
        }
        sorted = true;

        if (sorted) {
            System.out.println("The array is sorted.");
        } else {
            System.out.println("The array is not sorted.");
        }
    }
}
