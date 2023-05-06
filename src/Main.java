import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> A = new ArrayList<>();

    public Main() {

    }

    public static int divide(int p, int r) {
        int x = A.get(r);
        int i = p-1;

        for(int j =p; j<=r-1; j++){
            if (A.get(j) <= x) {
                i += 1;
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);
            }

        }

        int temp2 = A.get(i + 1);
        A.set(i + 1, A.get(r));
        A.set(r, temp2);
        return (i+1);
    }

    public static void sort205(int p, int r) {
        if (p < r) {
            int q = divide(p,r);
            sort205(p, q-1);
            sort205(q+1, r);
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the required arguments");
            System.exit(0);
        } else {
            String param = args[0];
            File f  = new File(param);
            try {
                Scanner s = new Scanner(f);
                while(s.hasNextInt()){
                    A.add(s.nextInt());
                }
                s.close();

                sort205(0, A.size() -1);
                for(int i : A){
                    System.out.println(i);
                }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        }


    }



}

