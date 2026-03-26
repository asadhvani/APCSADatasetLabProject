//JavaFX imports 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.awt.Color;

//scanner and I/O imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class AIUsageFX extends Application{
   
   private static String filepath = "ai_adoption_dataset.csv";
   private static ArrayList<Entry> entries;
   
   static
   {
      try
      { 
           entries = AIDataset.fillArray(filepath);
           entries = FilterTools.entryFilter(entries);
      } 
      catch (Exception E){ System.out.println(E);}
   }

   public void start(Stage stage) 
   {
      stage.setTitle("Countries vs Industry vs AI Adoption Rate");
      final CategoryAxis xAxis = new CategoryAxis();
      final NumberAxis yAxis = new NumberAxis();
      final BarChart bc = new 
      BarChart(xAxis,yAxis);
      bc.setTitle("Countries vs Industry vs AI Adoption Rate Graph");
      xAxis.setLabel("Country");       
      yAxis.setLabel("Adoption Rate");
      
      ArrayList<String> industries = ALTools.removeDuplicates(ALTools.getIndustryCol(entries));
      
      //XYChart.Series series1 = new XYChart.Series();
      //series1.setName("Amount of Net Carbs");      
      
      //ArrayList<XYChart.Series<Number, Number>> seriesList = new ArrayList<>();
      
      //There are a total of 8 different industries, make series accordingly
      
      /*
      for (int i=0; i<industries.size(); i++)
      { 
          //Make diff series for each industry
          //Diff data for each country
          XYChart.Series series
          
         //series1.getData().add(new XYChart.Data(c.getName(), findNetCarbs(c)));
      }
      */
      XYChart.Series AIAdoptionTech = new XYChart.Series();
      AIAdoptionTech.setName("Tech");
      XYChart.Series AIAdoptionTrans = new XYChart.Series();
      AIAdoptionTrans.setName("Transportation");
      XYChart.Series AIAdoptionManuf = new XYChart.Series();
      AIAdoptionManuf.setName("Manufacturing");
      XYChart.Series AIAdoptionHealth = new XYChart.Series();
      AIAdoptionHealth.setName("Health");
      XYChart.Series AIAdoptionEduc = new XYChart.Series();
      AIAdoptionEduc.setName("Education");      
      XYChart.Series AIAdoptionFin = new XYChart.Series();
      AIAdoptionFin.setName("Finance");      
      XYChart.Series AIAdoptionAgric = new XYChart.Series();
      AIAdoptionAgric.setName("Agriculture");      
      XYChart.Series AIAdoptionRet = new XYChart.Series();
      AIAdoptionRet.setName("Retail");      
     
      //Try to loop over all rows (in previous tests it took too long)
      
      //Because there are multiple entries, for each country & adoption rate, change alg to place in an arraylist, and get avg
      //Optimize to reduce computational complexity to ensure all rows can be looped through
      for (int i=0; i<2000; i++){
          Entry e = entries.get(i);
          String ind = e.getIndustry();
          if (ind.equals("Technology")){
              AIAdoptionTech.getData().add(new XYChart.Data(e.getCountry(), e.getAdoptionRate()));
          } else if (ind.equals("Transportation")){
              AIAdoptionTrans.getData().add(new XYChart.Data(e.getCountry(), e.getAdoptionRate()));              
          } else if (ind.equals("Manufacturing")){
              AIAdoptionManuf.getData().add(new XYChart.Data(e.getCountry(), e.getAdoptionRate()));              
          } else if (ind.equals("Healthcare")){
              AIAdoptionHealth.getData().add(new XYChart.Data(e.getCountry(), e.getAdoptionRate()));              
          } else if (ind.equals("Education")){
              AIAdoptionEduc.getData().add(new XYChart.Data(e.getCountry(), e.getAdoptionRate()));              
          } else if (ind.equals("Finance")){
              AIAdoptionFin.getData().add(new XYChart.Data(e.getCountry(), e.getAdoptionRate()));              
          } else if (ind.equals("Agriculture")){
              AIAdoptionAgric.getData().add(new XYChart.Data(e.getCountry(), e.getAdoptionRate()));              
          } else {
              AIAdoptionRet.getData().add(new XYChart.Data(e.getCountry(), e.getAdoptionRate()));              
          }
      }
      
      //Industries: [Technology, Transportation, Manufacturing, Healthcare, Education, Finance, Agriculture, Retail]
    
      
      System.out.println(industries.size());
      System.out.println(industries);
      Scene scene  = new Scene(bc,800,600);
      
      bc.getData().addAll(AIAdoptionTech);
      bc.getData().addAll(AIAdoptionTrans);
      bc.getData().addAll(AIAdoptionManuf);
      bc.getData().addAll(AIAdoptionHealth);
      bc.getData().addAll(AIAdoptionEduc);
      bc.getData().addAll(AIAdoptionFin);
      bc.getData().addAll(AIAdoptionAgric);      
      bc.getData().addAll(AIAdoptionRet);
      
      stage.setScene(scene);
      stage.show();
   }
   
   public static void main(String [] args)
   {
      launch(args);
   }
}