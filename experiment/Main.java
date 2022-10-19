import java.util.Scanner;

/**
 * @author 86134
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = giveNumber(n);
        int num = input.nextInt();
        int[] mover = new int[num];
        int[] index = new int[num];
        for (int i = 0; i < num; i++) {
            mover[i] = input.nextInt();
            index[i] = input.nextInt();
        }
        move(arr, num,mover,index);
    }

    /**
     * 给出学生个数，生成数组记录学号
     */
    public static int[] giveNumber(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        return a;
    }

    /**
     * 移动队列
     */
    public static void move(int[] a, int num, int[] mover, int[] index) {
        for (int i = 0; i < num; i++) {
            int indexMover = getIndex(a, mover[i]);
            if (index[i] >= 0) {
                for (int j = indexMover; j < indexMover + index[i]; j++) {
                    a[j] = a[j + 1];
                }
            } else {
                for (int j = indexMover; j > indexMover + index[i]; j--) {
                    a[j] = a[j - 1];
                }
            }
            a[indexMover + index[i]] = mover[i];
        }
        for (int k : a) {
            System.out.print(k + " ");
        }
    }

    /**
     * 获得对应学号的数组下标
     */
    public static int getIndex(int[] arr, int value) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }
}
