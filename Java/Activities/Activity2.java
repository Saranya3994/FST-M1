package activities;

public class Activity2 {
    public static void main(String arg[]) {
        int numArr[] = {10, 77, 10, 54, -11, 10};
int j=0;
        for (int i = 0; i <numArr.length; i++) {
if(numArr[i]==10){
    j=j+numArr[i];
}
        }
        System.out.println("j:"+j);
        if(j==30){
            System.out.println("equals to 30");
        }
        else {
            System.out.println("not equals to 30");
        }
    }
}