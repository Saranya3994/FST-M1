package Activity13;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomScannerActivity {
    public static void main(String arg[]){
        Scanner scan=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<Integer>();
        Random index=new Random();
        System.out.println("Enter numbers");
        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }
//        System.out.println("Entered integers are:"+list);
//        Integer nums[] = list.toArray(new Integer[0]);
        Integer nums[]=list.toArray(new Integer[0]);
        int indexGen=index.nextInt(nums.length);
        System.out.println("indexGen:"+indexGen);
        System.out.println("nums[indexGen]:"+nums[indexGen]);
    }
}
