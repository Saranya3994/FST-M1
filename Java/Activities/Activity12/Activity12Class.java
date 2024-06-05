package Activity12;

public class Activity12Class {
    public static void main(String arg[]){
//        int ad1,ad2;
        Addable ad1=(a,b)-> (a + b);
        System.out.println(ad1.add(10,20));
        Addable ad2=(int a,int b)->{
            return (a+b);
        };
        System.out.println(ad2.add(100,200));
    }
}
