public class Entry{
    
    private String country;
    private String industry;
    private String tool;
    private double adoptionRate;
    private int dailyUsers;
    private int year;
    private String feedback;
    private double avgAge;
    private String companySize;
    
    public Entry(String country, String industry, String tool, double adoptionRate, int dailyUsers, int year, String feedback, String ageRange, String companySize){
        this.country = country;
        this.industry = industry;
        this.tool = tool;
        this.adoptionRate = adoptionRate;
        this.dailyUsers = dailyUsers;
        this.year = year;
        this.feedback = feedback;
        
        if (!(ageRange.equals("55+"))){
            String[] splAge = ageRange.split("-");
            int lower = Integer.parseInt(splAge[0]);
            int upper = Integer.parseInt(splAge[1]);
            double avg = (lower+upper)/2.0;
            this.avgAge = avg;
        } else {
            avgAge = 55;
        }
        this.companySize = companySize;
    }
    
    public String getCountry(){
        return this.country;
    }
    
    public String getIndustry(){
        return this.industry;
    }
    
    public double getAdoptionRate(){
        return this.adoptionRate;
    }
    
    public String getTool(){
        return this.tool;
    }
    
    public String toString(){
        String p1 = "Country: "+this.country+" ";
        String p2 = "Adoption Rate: "+this.adoptionRate+" ";
        String p3 = "Tool: "+this.tool+" ";
        String p4 = "Industry"+this.industry+".";
        return p1+p2+p3+p4;
    }
}