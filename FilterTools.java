import java.util.ArrayList;

public class FilterTools{
    public static AIDataset filter(AIDataset dataset){
        for (int i=0; i<dataset.getLength(); i++){
            Entry e = dataset.getEntry(i);
            String tool = e.getTool();
            if (!(tool.equals("ChatGPT") || tool.equals("Bard"))){
                dataset.remove(i);
                i--;
            }
        }
        return dataset;
    }
    public static ArrayList<Entry> entryFilter(ArrayList<Entry> arr){
        for (int i=0; i<arr.size(); i++){
            Entry e = arr.get(i);
            String tool = e.getTool();
            if (!(tool.equals("ChatGPT") || tool.equals("Bard"))){
                arr.remove(i);
                i--;
            }
        }
        return arr;        
    }
}