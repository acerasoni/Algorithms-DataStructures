public class BinarySearch {
    public static int binarySearch(int[] arr, int key, int low, int high) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String... args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println(binarySearch(arr, 1, 0, 8));
    }
}
