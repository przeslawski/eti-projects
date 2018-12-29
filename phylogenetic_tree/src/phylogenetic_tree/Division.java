/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phylogenetic_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kuba
 */
public class Division {
    public final String[] A, B;

    public Division(String[] A, String[] B) {
        this.A = A;
        this.B = B;
        Arrays.sort(this.A);
        Arrays.sort(this.B);
    }

    public static boolean equals(Division first, Division second) {
        return Arrays.equals(first.A, second.A) && Arrays.equals(first.B, second.B);
    }
    
    public static boolean validate(Division first, Division second) {
        int cnt = 0;
        List<String> A = new ArrayList<>(Arrays.asList(first.A));
        List<String> B = new ArrayList<>(Arrays.asList(first.B));
        List<String> C = new ArrayList<>(Arrays.asList(second.A));
        List<String> D = new ArrayList<>(Arrays.asList(second.B));
        
        A.retainAll(C);
        cnt += A.isEmpty() ? 1 : 0;
        B.retainAll(D);
        cnt += B.isEmpty() ? 1 : 0;

        A = new ArrayList<>(Arrays.asList(first.A));
        B = new ArrayList<>(Arrays.asList(first.B));
        A.retainAll(D);
        cnt += A.isEmpty() ? 1 : 0;
        B.retainAll(C);
        cnt += B.isEmpty() ? 1 : 0;
        
        // debug only
        if (!(cnt == 1)) {
            System.err.println("A: " + Arrays.asList(first.A) + 
                    " B: " + Arrays.asList(first.B) + 
                    " C: " + Arrays.asList(second.A) + 
                    " D: " + Arrays.asList(second.B));
        }
        
        return cnt == 1;
    }
    
    public static boolean validateDivisionSet(List<Division> list) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = i+1; j < list.size(); j++) {
                if (!Division.validate(list.get(i), list.get(j)))
                    return false;
            }
        }
        return true;
    }

}
    