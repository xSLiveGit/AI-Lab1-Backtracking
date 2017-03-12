import java.util.Scanner;

/**
 * Created by Sergiu on 2/28/2017.
 */
public class CLI {
    public static void run(){
        String nr = "";
        Scanner sc = new Scanner(System.in);
        Permutation permutation = new Permutation();
        while(true){
            System.out.println("Introdu valoare 0 pentru n daca doriti sa iesiti!");
            System.out.println("n: ");
            nr = sc.nextLine();
            if(nr.equals("0"))
                break;
            else{
                try{
                    Integer a = Integer.parseInt(nr);
                    if(a < 0) throw  new NumberFormatException();
                    permutation.getCustomPermutation(a).forEach(System.out::println);
                    System.out.println();
                }catch (NumberFormatException none){
                    System.out.print("Introdu un intreg nenegativ.");
                }
            }
        }
        System.out.print("La revedere!");
    }
}
