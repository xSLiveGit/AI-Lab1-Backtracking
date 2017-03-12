import java.util.ArrayList;

/**
 * Created by Sergiu on 2/28/2017.
 */
public class Permutation {

    public ArrayList<ArrayList<Integer>> getCustomPermutation(int n){
        ArrayList<ArrayList<Integer>> permutationsCollection;
        if(n <= 6){
            CustomPermutation perm = new CustomPermutation();
            permutationsCollection = perm.getClassicalPermutation(n);

        }
        else{
            ClasicPermutation perm = new ClasicPermutation();
            perm.setInitValue(2);
            permutationsCollection = perm.getClassicalPermutation(n-2);
//            permutationsCollection.forEach(el->{
//                for(Integer i=0;i<el.size();i++)
//                    el.set(i,el.get(i) + 2);
//            });
            populateWith1(permutationsCollection);
            populateWith2(permutationsCollection);
        }
        return  permutationsCollection;
    }



    private void populateWith1(ArrayList<ArrayList<Integer>> list){
        Integer initSize = list.size();
        for(Integer i=0;i<initSize;i++){
            ArrayList<Integer> localList= new ArrayList<>(list.get(i));
            ArrayList<Integer> localList2= new ArrayList<>(list.get(i));
            localList.add(0,1);
            localList2.add(1,1);
            list.get(i).add(2,1);
            list.add(localList);
            list.add(localList2);
        }
    }

    private  void  populateWith2(ArrayList<ArrayList<Integer>> list){
        Integer initSize = list.size();
        for(Integer i=0;i<initSize;i++){
            ArrayList<Integer> localList= new ArrayList<>(list.get(i));
            localList.add(2);
            list.get(i).add(list.get(i).size()-1,2);
            list.add(localList);
        }
    }
}
