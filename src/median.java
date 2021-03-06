
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class median {


    public static float median;

    public static ArrayList<Integer> myIntList = new ArrayList<Integer>();


    public static void main(String[] args){


//        myIntList.add(6506);
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
            }
            else if(command.equals("getMedian")){
                if(myIntList.size() == 0)
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


    private static void updateSet(int newInt){

        if(myIntList.size()==0){
            myIntList.add(newInt);
            median = newInt;
            return;
        }

            addSorted(0, myIntList.size()-1, newInt);
    }


    private static void addSorted(int l, int r, int newInt){

        if(myIntList.get(r) <= newInt){
            myIntList.add(newInt);
            return;
        }
        if(myIntList.get(l) >= newInt){
            myIntList.add(l,newInt);
            return;
        }

        if(r-l == 1){
            myIntList.add(r,newInt);
            return;
        }

        int mid = l +(r-l)/2;

        if(myIntList.get(mid)> newInt)
            addSorted(l,mid,newInt);
        else
            addSorted(mid,r,newInt);
    }

    private static void updateMedian(){

        if(myIntList.size()%2 == 0){

            int tmp = myIntList.size()/2;
            int tmp2 = tmp-1;

            median = (myIntList.get(tmp2)+ myIntList.get(tmp))/2;
        }
        else {
            median = myIntList.get(myIntList.size()/2);

        }
    }

    private static void listList(){

        for(int i = 0; i < myIntList.size();i++){
            System.out.println(myIntList.get(i));
        }
    }



}


