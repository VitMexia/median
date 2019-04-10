import java.util.Scanner;

public class median2 {



    public static float median;
    public static int myIntList[] = new int[1];
    public static int insertedIntCount = 0;


    public static void main(String[] args){


//        myIntList[0] = 6506;
//        insertedIntCount++;
//        updateSet(9241);
//        updateSet(2567);
//        updateSet(5928);
//        updateSet(5407);
//        updateSet(2650);
//        updateSet(2073);
//        updateSet(3415);
//        updateSet(6842);
//        updateSet(8285);
//        updateSet(8629);
//        updateSet(8605);
//        updateSet(6590);
//        updateSet(682);
//        updateSet(1277);
//        updateSet(978);
//        updateSet(5591);
//        updateSet(7051);
//        updateSet(1698);
//        updateSet(2415);
//        updateSet(7111);
//        updateSet(5331);
//        updateSet(9337);
//        updateSet(771);


        Scanner sc = new Scanner(System.in);

        long startTime = System.currentTimeMillis();

        while(sc.hasNext()) {

            String command = sc.next();

            if(command.equals("e")){
                System.out.println("Exiting... See ya!!");
                break;
            }
            else if(command.equals("updateSet") && sc.hasNextInt()){

                updateSet(sc.nextInt());
                insertedIntCount++;

            }
            else if(command.equals("getMedian")){

                if(insertedIntCount == 0)
                    System.out.println("No Values available! Please add some and try again!");
                else
                    System.out.println("Median: " + median);
            }
            else if(command.equals("listList")){
                listList();
            }
            else{
                System.out.println("Unrecognized command!");
            }

            updateMedian();
        }

        long elapsedTime = System.currentTimeMillis()-startTime;

        System.out.println("time to Process: "+  elapsedTime);
        sc.close();
    }

    private static void increaseMyArraySize() {

        int tempArray[] = new int[myIntList.length*2];
        System.arraycopy(myIntList,0,tempArray,0,insertedIntCount);
        myIntList = tempArray;

    }

    private static void insertIntAt(int index, int newIntToInsert){

        int tempArray[] = new int[myIntList.length];


        if(index>0)
            System.arraycopy(myIntList,0,tempArray,0,index);

        System.arraycopy(myIntList,index,tempArray,index+1,insertedIntCount-index);
        tempArray[index] = newIntToInsert;
        myIntList = tempArray;

    }

    private static void updateSet(int newInt){

        if(insertedIntCount == myIntList.length)
                    increaseMyArraySize();

        if(insertedIntCount == 0){
            myIntList[0] =newInt;
            median = newInt;
            return;
        }


        else {
            addSorted(0, insertedIntCount-1, newInt);
        }

    }


    private static void addSorted(int l, int r, int newInt){

        if(myIntList[r] <= newInt) {
            myIntList[r+1] = newInt;
            return;
        }
        if(myIntList[l] >= newInt) {
            insertIntAt(l, newInt);
            return;
        }



        if(r-l == 1){
            insertIntAt(r, newInt);
            return;
        }

        int mid = l +(r-l)/2;


        if(myIntList[mid] > newInt)
            addSorted(l,mid,newInt);
        else
            addSorted(mid,r,newInt);
    }

    private static void updateMedian(){

        if(insertedIntCount%2 == 0){

            int tmp = insertedIntCount/2;
            int tmp2 = tmp-1;

            median = (myIntList[tmp2] + myIntList[tmp])/2;
        }
        else {
            median = myIntList[insertedIntCount/2];
        }
    }

    private static void listList(){

        for(int i = 0; i < insertedIntCount;i++){
            System.out.println(myIntList[i]);
        }
    }
}
