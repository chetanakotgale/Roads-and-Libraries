package Week5;
 
/**
 *  This program is used to estimate the cost for construction of a library and roads.
 *  
 * @author chetana.
 *
 */

import java.util.*;


public class Roads_and_Libraries 
{
    
private static Scanner scan;

public static void main(String[] args) {
       
       scan = new Scanner(System.in);
       
       int q = scan.nextInt();
       
       for (int j=0;j<q;j++){
        
            HashMap<Integer, ArrayList<Integer>> cityMap = new HashMap<>();

            int n = scan.nextInt();
            int m = scan.nextInt();

            int libraryCost = scan.nextInt();
            int roadCost = scan.nextInt();

            for (int i = 1; i <= n; i++)
            {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                cityMap.put(i, list);
            }

            for (int a1 = 0; a1 < m; a1++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                ArrayList<Integer> list1 = cityMap.get(x);
                ArrayList<Integer> list2 = cityMap.get(y);
                if (list1 != list2) {
                    list1.addAll(list2);
                    list2.forEach(i -> cityMap.put(i, list1));
                }
            }

            if (libraryCost < roadCost)
                System.out.println((long) n * libraryCost);
            else {
                long cost = 0;
                for (ArrayList<Integer> list : cityMap.values()) {
                    int size = list.size();
                    if (size > 0) {
                        cost += libraryCost;
                        cost += (size - 1) * roadCost;
                        list.removeIf(i -> true);
                    }
                }
                System.out.println(cost);
            }
        
       }
    }
}