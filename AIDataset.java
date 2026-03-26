import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException; 
import java.io.FileReader;

public class AIDataset{
    
    private ArrayList<Entry> entries;
    private String filepath;
    private File f;
    
    public AIDataset(String filepath){
        this.filepath = filepath;
        this.entries = new ArrayList<Entry>();
    }
    
    public static ArrayList<Entry> fillArray(String filepath) throws FileNotFoundException{
        File f = new File(filepath);
        Scanner scan = new Scanner(f);
        ArrayList<Entry> entries = new ArrayList<>();
        scan.nextLine(); //Get rid of labels row
        while (scan.hasNext()){
            String inpt = scan.nextLine();
            String[] spl = inpt.split(",");
            
            String country = spl[0];
            String industry = spl[1];
            String tool = spl[2];
            double adoptionRate = Double.parseDouble(spl[3]);
            int dailyUsers = Integer.parseInt(spl[4]);
            int year = Integer.parseInt(spl[5]);
            String feedback = spl[6];
            String ageRange = spl[7];
            String companySize = spl[8];
            
            Entry e = new Entry(country, industry, tool, adoptionRate, dailyUsers, year, feedback, ageRange, companySize);
            entries.add(e);
        }
        return entries;
    }
    
    public Entry getEntry(int index){
        return entries.get(index);
    }
    
    public void remove(int index){
        entries.remove(index);
    }
    
    public int getLength(){
        return entries.size();
    }
}