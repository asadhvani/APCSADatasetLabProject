import java.util.ArrayList;

public class AdoptionRate {

    private static ArrayList<AdoptionRate> adoptionRates = new ArrayList<>();

    private ArrayList<Double> vals;
    private String country;
    private String industry;

    public AdoptionRate(String country, String industry){
        this.country = country;
        this.industry = industry;
        this.vals = new ArrayList<>();
        adoptionRates.add(this);
    }

    public AdoptionRate(String country, String industry, double initVal){
        this.country = country;
        this.industry = industry;
        this.vals = new ArrayList<>();
        this.vals.add(initVal);
        adoptionRates.add(this);
    }

    public String getCountry(){
        return this.country;
    }

    public String getIndustry(){
        return this.industry;
    }

    public ArrayList<Double> getAdoptionRates(){
        return this.vals;
    }

    public void iAddAdoptionRate(double adoptionRate){
        vals.add(adoptionRate);
    }

    public double iGetAvg(){
        Double sum1 = 0.0;
        for (Double d : vals){
            sum1=sum1+d;
        }
        int len = vals.size();
        double avg = sum1/len;
        return avg;
    }

    public static double getAvg(String countryInpt, String industryInpt){
        for (AdoptionRate ar : adoptionRates){
            if (ar.getCountry().equals(countryInpt) && ar.getIndustry().equals(industryInpt)){
                double avg = ar.iGetAvg();
                return avg;
            }
        }
        System.out.println("Tried to get avg of nonexistent country, industry combo");
        return -1;
    }

    public static boolean sAddAdoptionRate(String countryI, String industryI, double adoptionRate){
        if (checkIfExist(countryI, industryI)){
            for (AdoptionRate ar : adoptionRates){
                if (ar.getCountry().equals(countryI) && ar.getIndustry().equals(industryI)){
                    ar.iAddAdoptionRate(adoptionRate);
                    return true;
                }
            }
        }
        return false;
    }

    public static void addAdoptionRate(String countryInpt, String industryInpt, double adoptionRateInpt){
        boolean r1 = sAddAdoptionRate(countryInpt, industryInpt, adoptionRateInpt);
        if (!r1){
            AdoptionRate a = new AdoptionRate(countryInpt, industryInpt, adoptionRateInpt);
        }
    }

    public static boolean checkIfExist(String countryIn, String industryIn){
        for (AdoptionRate ar : adoptionRates){
            if (ar.getCountry().equals(countryIn) && ar.getIndustry().equals(industryIn)){
                return true;
            }
        }
        return false;
    }

}
