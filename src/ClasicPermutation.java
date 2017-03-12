import java.util.ArrayList;

/**
 * Created by Sergiu on 2/28/2017.
 */
public class ClasicPermutation extends GenericPermutation {
    protected boolean isValid(ArrayList<Integer> list, Integer index, Integer maxValue){
        if(list.get(index) > maxValue)
            return false;
        for(Integer i=0;i<index;i++)
            if(list.get(i).equals(list.get(index))){
                return false;
            }
        return true;
    }
}
