
package taller1.merge.sort;

/**
 *
 * @author Sebastian Baldion
 */
public class Taller1MergeSort {

    private int[] Array;
    private int[] tempMergeSort;
    private int length;
    
    public static void main(String[] args) {
        
        int[] array = {63, 33, 18, 97, 71, 101, 10, 41, 1, 84, 14};
        System.out.println("Datos:");
        
        Taller1MergeSort obj = new Taller1MergeSort();
        obj.sort(array);
        
        for(int i : array){
            System.out.print(i);
            System.out.print(" ");
        }
    }
    
    public void sort(int array[]) {
        this.Array = array;
        this.length = array.length;
        this.tempMergeSort = new int[length];
        doMergeSort(0, length - 1);
    }
    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergeSort[i] = Array[i];
        }
        
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while(i <= middle && j <= higherIndex) {
            if(tempMergeSort[i] <= tempMergeSort[j]) {
                Array[k] = tempMergeSort[i];
                i++;
            }else{
                Array [k] = tempMergeSort[j];
                j++;
            }
            k++;
        }
        while(i <= middle){
            Array[k] = tempMergeSort[i];
            k++;
            i++;
        }
    }
}
