import java.util.Scanner;

public class median2 {



    public static float median;

    public static int minHeapArray[] = new int[100];
    public static int maxHeapArray[] = new int[100];

    public static int insertedMinHeapCount;
    public static int insertedMaxHeapCount;
    public static int maxInt = Integer.MAX_VALUE;
    public static int minInt = Integer.MIN_VALUE;

    public static void main(String[] args){


        updateSet(6506);
        updateSet(9241);
        updateSet(2567);
        updateSet(5928);
        updateSet(5407);
        updateSet(2650);
        updateSet(2073);
        updateSet(3415);
        updateSet(6842);
        updateSet(8285);
        updateSet(8629);
        updateSet(8605);
        updateSet(6590);
        updateSet(682);
        updateSet(1277);
        updateSet(978);
        updateSet(5591);
        updateSet(7051);
        updateSet(1698);
        updateSet(2415);
        updateSet(7111);
        updateSet(5331);
        updateSet(9337);
        updateSet(771);


//        Scanner sc = new Scanner(System.in);
//
//        long startTime = System.currentTimeMillis();
//
//        while(sc.hasNext()) {
//
//            String command = sc.next();
//
//            if(command.equals("e")){
//                System.out.println("Exiting... See ya!!");
//                break;
//            }
//            else if(command.equals("updateSet") && sc.hasNextInt()){
//                updateSet(sc.nextInt());
//
//
//            }
//            else if(command.equals("getMedian")){
//
//                if(insertedMinHeapCount == 0)
//                    System.out.println("No Values available! Please add some and try again!");
//                else
//                    System.out.println("Median: " + median);
//            }
//            else{
//                System.out.println("Unrecognized command!");
//            }
//
//            updateMedian();
//        }
//
//        long elapsedTime = System.currentTimeMillis()-startTime;
//
//        System.out.println("time to Process: "+  elapsedTime);
//        sc.close();
    }

    private static void increaseMyArraysSize() {


        int newSize = minHeapArray.length*2;
        int tempArray[] = new int[newSize];
        System.arraycopy(minHeapArray,0,tempArray,0,insertedMinHeapCount);
        minHeapArray = tempArray;

        int temp2Array[] = new int[newSize];
        System.arraycopy(maxHeapArray,0,tempArray,0,insertedMaxHeapCount);
        maxHeapArray = temp2Array;

    }



    private static void updateSet(int newInt){

        if(insertedMinHeapCount == minHeapArray.length || insertedMaxHeapCount == maxHeapArray.length)
            increaseMyArraysSize();

        if(insertedMinHeapCount == 0){
            minHeapArray[insertedMinHeapCount++] = newInt;
            median = newInt;
            return;
        }
        else if(newInt > median){
            minHeapArray[insertedMinHeapCount++] = newInt;
            minHeapify(insertedMinHeapCount, insertedMinHeapCount-1);

        }else{
            maxHeapArray[insertedMaxHeapCount++] = newInt;
            maxHeapify(insertedMaxHeapCount, insertedMaxHeapCount-1);
        }

        if(Math.abs(insertedMinHeapCount - insertedMaxHeapCount) > 1){
            balanceTrees();
        }
        updateMedian();
    }

    private static void balanceTrees(){

        if(insertedMinHeapCount > insertedMaxHeapCount){
            maxHeapArray[insertedMaxHeapCount++] = minHeapArray[0];
            minHeapArray[0] = maxInt;
            minHeapify(insertedMinHeapCount,insertedMinHeapCount -1);
            maxHeapify(insertedMaxHeapCount, insertedMaxHeapCount-1);
            insertedMinHeapCount--;
        }
        else
        {
            minHeapArray[insertedMinHeapCount++] = maxHeapArray[0];
            maxHeapArray[0] = minInt;
            maxHeapify(insertedMaxHeapCount, insertedMaxHeapCount -1);
            minHeapify(insertedMinHeapCount, insertedMinHeapCount-1);
            insertedMaxHeapCount--;
        }
    }


    private static void updateMedian(){

        if(insertedMinHeapCount == insertedMaxHeapCount){

            median = (minHeapArray[0] + maxHeapArray[0])/2;
        }
        else if (insertedMinHeapCount > insertedMaxHeapCount) {
            median = minHeapArray[0];
        }else{
            median = maxHeapArray[0];
        }
    }



    public static void minHeapify(int heapSize, int insertedPos){

        int smaller = insertedPos;
        int left = left(insertedPos);
        int right = right(insertedPos);

        if(left < heapSize && minHeapArray[smaller] > minHeapArray[left])
            smaller = left;

        if(right < heapSize && minHeapArray[smaller] > minHeapArray[right])
            smaller = right;

        if(smaller != insertedPos){
            minHeapArray = exchPos(minHeapArray, insertedPos, smaller);
            minHeapify(heapSize,smaller);
        }
    }

    public static void maxHeapify( int heapSize, int insertedPos){

        int greater = insertedPos;
        int left = left(insertedPos);
        int right = right(insertedPos);

        if(left < heapSize && maxHeapArray[greater] < maxHeapArray[left])
            greater = left;

        if(right < heapSize && maxHeapArray[greater] < maxHeapArray[right])
            greater = right;

        if(greater != insertedPos){
            exchPos(maxHeapArray, insertedPos, greater);
            maxHeapify(heapSize,greater);
        }
    }

    private static int[] exchPos(int[] array, int k, int j) {
        int temp = array[k];
        array[k] = array[j];
        array[j] = temp;
        return array;
    }

    public static int left(int i){
        return 2*i +1;
    }

    public static int right(int i){
        return 2*i +2;
    }
}