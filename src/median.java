import java.util.ArrayList;

import java.util.Scanner;

public class median {

    public static void main(String[] args) {

        ArrayList myIntList = new ArrayList<>();
        int tesst [] = {23,56 ,25 ,258, 254, 56,8, 54, 2, 552, 885, 49, 64, 31, 818 ,15, 9, 1, 987, 1 };
        Scanner sc = new Scanner(System.in);

       // if(myIntList.size()==0)myIntList.add(tesst[0]);
        if(myIntList.size()==0 && sc.hasNext())myIntList.add(sc.nextInt());

        while(sc.hasNext()) {

            int temp = sc.nextInt();

            if((int)myIntList.get(myIntList.size()-1) <= temp)
                myIntList.add(temp);
            else
            {
                int tmp = 0;
                for(int j = myIntList.size()-1; j>-1; j-- ) {

                    if ((int) myIntList.get(j) > temp) {
                        tmp = j;
                    } else {
                        myIntList.add(tmp, temp);
                        break;
                    }

                }
            }
        }

//            for(int i = 1; i<tesst.length;i++){
//
//                if((int)myIntList.get(myIntList.size()-1) <= tesst[i])
//                    myIntList.add(tesst[i]);
//                else
//                {
//                    int tmp = 0;
//                    for(int j = myIntList.size()-1; j>-1; j-- ) {
//
//                        if ((int) myIntList.get(j) > tesst[i]) {
//                            tmp = j;
//                        } else {
//                            myIntList.add(tmp, tesst[i]);
//                            break;
//                        }
//
//                    }
//                }
//            }

           // myIntList.add(sc.next());

//        }

        for(int i =0 ; i< myIntList.size(); i++){
            System.out.println(myIntList.get(i));
        }

//        while(true){
//            sc = new Scanner (System.in);
//
//            if(sc.nextLine().equals("e")){
//                System.out.println("O K, I'll Leave!!");
//                break;
//            }else{
//                System.out.println("no leaving!!");
//            }
//        }
    }


    private void updateset(int i){

    }

    private int getMedian(){

        return -1;
    }


}


