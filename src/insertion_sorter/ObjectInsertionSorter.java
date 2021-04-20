



package insertion_sorter;

import java.util.ArrayList;


public class ObjectInsertionSorter {
//                                            INSERTION SORT METHOD
    public ArrayList<String> insertionSort(ArrayList<String> str_array){
        String unsorted_value;
        int scan;
        
        for (int index=1; index<str_array.size(); index++){
            unsorted_value=str_array.get(index);
            scan=index;
            
            while (scan>0 && str_array.get(scan-1).compareTo(unsorted_value)>0){
                str_array.set(scan,str_array.get(scan-1));
                scan--;
            }
            
            str_array.set(scan, unsorted_value);
        }
        System.out.println(str_array);
        
        return str_array;
    }
    
//                                    PRINT ARRAY LIST METHOD
    public String printArrayList(ArrayList<String> list){
        String str="";
        for (int index=0; index<list.size(); index++){
            if (index==list.size()-1){
                str=str+list.get(index);
            }
            else if (index==0){
                str=list.get(0)+", ";
            }
            else{
                str=str+list.get(index)+", ";
            }
        }
        return str;
    }

}


