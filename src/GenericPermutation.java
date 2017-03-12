import java.util.ArrayList;

/**
 * Created by Sergiu on 2/28/2017.
 */
public abstract class GenericPermutation {
    protected abstract boolean isValid(ArrayList<Integer> list, Integer index, Integer maxValue);
    private Integer initValue = 0;
    private boolean isFinal(Integer index,Integer maxIndex){
        return maxIndex.equals(index);
    }

    private  void processLocalSolution(ArrayList<ArrayList<Integer>> allLocalSolutions,ArrayList<Integer> localSolution){
        ArrayList<Integer> lista = new ArrayList<>(localSolution);
        allLocalSolutions.add(lista);
    }

    public void setInitValue(Integer initValue){
        this.initValue = initValue;
    }

    public  ArrayList<ArrayList<Integer>> getClassicalPermutation(int n){
        ArrayList<ArrayList<Integer>> permutationsCollection = new ArrayList<>();
        ArrayList<Integer> thisPermutation = new ArrayList<>(n);

        for(Integer i=0;i<n;i++)
            thisPermutation.add(initValue);

        int index = 0;
        boolean ok ;
        while(index >= 0){
            ok = false;
            do {
                thisPermutation.set(index, thisPermutation.get(index) + 1);
                ok = isValid(thisPermutation, index,n+initValue);
            } while (index < n && !ok && thisPermutation.get(index) <= n+initValue);

            if(ok){
                if (!isFinal(index,n-1)) {
                    index++;
                    thisPermutation.set(index,initValue);
                }
                else {
                    processLocalSolution(permutationsCollection, thisPermutation);
                    index--;

                }
            }else {
                index--;
            }
        }
        return permutationsCollection;
    }
}
