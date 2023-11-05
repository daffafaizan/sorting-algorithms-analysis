public class AlgorithmAnalysis {

    public static void analyze(int[] array, SortingAlgorithms sortingAlgorithm) {
        long startTime = System.currentTimeMillis();
        sortingAlgorithm.sort(array);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " ms");
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}
