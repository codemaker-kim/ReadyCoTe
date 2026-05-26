package sw_expert;

public class BinarySearch {

    // 이진 탐색 - 원소들이 정렬되어있다는 가정하에 진행.
    private int binarySearch(int[] arr, int num, int key) {
        int down = 0;
        int up = num - 1;
        int mid;

        while (true) {
            mid = (up + down) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] > key) {
                up = mid - 1;
            } else {
                down = mid + 1;
            }

            // 찾는 값이 존재하지 않을 때
            if (up < down)
                return -1;
        }
    }
}
