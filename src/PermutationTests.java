import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sergiu on 2/28/2017.
 */
class PermutationTests {
    private void testFor1And2(ArrayList<ArrayList<Integer>> permutationsList){
        for(ArrayList<Integer> arr : permutationsList){
            for(Integer i=0;i<arr.size();i++){
                if(arr.get(i).equals(1)){
                    assertTrue(i<3);
                }
                if(arr.get(i).equals(2)){
                    assertTrue(i>=arr.size()-2);
                }
            }
        }
    }

    @org.junit.jupiter.api.Test
    void getCustomPermutation() {
        Permutation perm = new Permutation();
        ArrayList<ArrayList<Integer>> permutationsList = perm.getCustomPermutation(7);
        assertEquals(720,permutationsList.size());
        for(Integer i=0;i< permutationsList.size() - 1;i++)
            for(Integer j = i + 1;j<permutationsList.size();j++)
                assertNotEquals(permutationsList.get(i),permutationsList.get(j));
        assertTrue(permutationsList.contains(Arrays.asList(1,3,4,5,6,7,2)));
        assertTrue(permutationsList.contains(Arrays.asList(1,3,4,5,6,7,2)));
        assertFalse(permutationsList.contains(Arrays.asList(1,2,5,6,7,3)));
        assertFalse(permutationsList.contains(Arrays.asList(7,3,4,5,6,1,2)));
        testFor1And2(permutationsList);


        permutationsList = perm.getCustomPermutation(3);
        assertEquals(4,permutationsList.size());
        for(Integer i=0;i< permutationsList.size() - 1;i++)
            for(Integer j = i + 1;j<permutationsList.size();j++)
                assertNotEquals(permutationsList.get(i),permutationsList.get(j));
        assertTrue(permutationsList.contains(Arrays.asList(1,3,2)));
        assertTrue(permutationsList.contains(Arrays.asList(1,2,3)));
        assertTrue(permutationsList.contains(Arrays.asList(3,1,2)));
        assertTrue(permutationsList.contains(Arrays.asList(3,2,1)));
        testFor1And2(permutationsList);
    }

}
