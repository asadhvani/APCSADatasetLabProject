import java.util.ArrayList;

public class ALTools{
    public static ArrayList<String> getIndustryCol(ArrayList<Entry> inpt){
        ArrayList<String> result = new ArrayList<>();
        
        for (int i=0; i<inpt.size(); i++){
            String industry = inpt.get(i).getIndustry();
            result.add(industry);
        }
        return result;
    }
    public static ArrayList<String> removeDuplicates(ArrayList<String> inpt){
        ArrayList<String> seen = new ArrayList<>();
        for (int i=0; i<inpt.size(); i++){
            String item = inpt.get(i);
            
            boolean hasSeen = false;
            for (int j=0; j<seen.size(); j++){
                if (item.equals(seen.get(j))){
                    hasSeen = true;
                }
            }
            
            if (!hasSeen){
                seen.add(item);
            }
        }
        return seen;
    }
}