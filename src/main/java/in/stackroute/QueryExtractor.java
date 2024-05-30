package in.stackroute;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.text.TextStringBuilder;

public class QueryExtractor {

    List<String> head;
    int[] coulmnWidth = {5,7,8,8,3,3,3,9,9};
    int[] coulmnWidthForHead = {2,17,17,1,3,3,3,9,9};

  public void extractQuery(String queryString) throws IOException {

    // Step 1: Verify that teh queryString contains both select and from clauses.
    // If the queryString does not contain select and from clauses, throw a runtime
    // exception with the message "Query must start with SELECT and contain FROM
    // clause".

 

    // Step 2: Extract the name of the data source from the query. The name of the
    // data source can be found after the FROM keyword in the query. For example, in
    // the query "SELECT * FROM users", the data source name is users.
    

    // Step 3: Extract the column names from the select clause in the query. The
    // column names can be found after the SELECT keyword in the query. For example,
    // in the query "SELECT id, name, email FROM users", the column names are id,
    // name, and email. The column names should be separated by a comma and a space.

    

    // remove the white spaces

    if(!queryString.toLowerCase().contains("select")|| !queryString.toLowerCase().contains("from"))
    {
      throw new RuntimeException("Query must start with SELECT and contain FROM clause");
    }
    String [] query = queryString.split(" ");
//      System.out.println(Arrays.toString(query)+"query");
    StringBuilder answer = new StringBuilder();
    int N = query.length;
    String [] fields = new String[N-3];
      for (int i = 0; i <N-3 ; i++) {
          fields[i]=query[i+1].replaceAll("[^a-zA-z0-9*]","");
//          System.out.println(fields[i]);

      }
      for (String a :fields)
      {
        answer.append(a).append(",");
      }
    String fileName = query[N-1];
//      System.out.println(fileName);


      System.out.println("===========================================================================");
      System.out.print("|| ");
      printHeaders(fields,coulmnWidth);

    loadData(fileName, answer.toString());

  }

  public void loadData(String dataSource, String selectedOptions) throws IOException {
    // Load data from the data source

    // The data source is a .csv file, so first load the data from the csv file
    // and then filter the data based on the selected options

;

    // Extract the headers from the data
 
    // if selectOptions is not equal to '*' then extract the column names from the
    // selectOptions


    // Extract the row based on the selected options
    // Load the selected data from the data source
//      System.out.println(selectedOptions+"selected op");
     String [] atr = selectedOptions.split(",");

      for (int i = 0; i < atr.length; i++) {

          atr[i]=atr[i].replaceAll("[^a-zA-z0-9*]","");
//          System.out.println(atr[i]+"Inside for loop of atr");

      }
      List<String> strs = Arrays.stream(atr).toList();

      File file = new File(dataSource);
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
      String line ="";

      head= Arrays.stream(bufferedReader.readLine().split(",")).toList();
//      System.out.println(Arrays.toString(atr));

      String ref;
      int a=0;
      while ((ref=bufferedReader.readLine())!=null)
      {
          if(atr.length==1 && atr[0].equalsIgnoreCase("*"))
          {
              System.out.println(ref);
          }
          String[] value=ref.split(",");
//          System.out.println(Arrays.toString(value));
          int x=0;
          String space =" ";
          for(int i=0;i<head.size();i++)
          {
              if(x<atr.length&& head.get(i).equalsIgnoreCase(atr[x])) {
                  System.out.print("||  "+value[i]+space.repeat(coulmnWidth[i]));
                  x++;
              }
          }
          System.out.println();

      }

//   while ((line=bufferedReader.readLine())!=null)
//   {
//
//       String[] data = line.split(",");
//       if(atr.length==1 && atr[0].equalsIgnoreCase("*"))
//       {
//           System.out.println(line);
//       }
//       if(atr.length>1  && atr[0].equalsIgnoreCase("matchid"))
//       {
//           System.out.print(data[0]+" ");
//       }
//       if(atr.length>2 && atr[1].equalsIgnoreCase("team1"))
//       {
//           System.out.print(data[2]+" ");
//       }
//       if((2< atr.length)&& atr[2].equalsIgnoreCase("team2") )
//       {
//           System.out.print(data[3]+" ");
//       }
//       if((3< atr.length)&& atr[3].equalsIgnoreCase("team1score") )
//       {
//           System.out.print(data[5]+" ");
//       }
//       System.out.println();
//
//   }

    
    
   
  }

  private void printHeaders(String[] columnNames, int[] columnWidths) throws IOException {

      File file = new File("ipl.csv");
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
      String line ="";


      List<String> header = Arrays.stream(bufferedReader.readLine().split(",")).toList();
//      System.out.println(header);
//      System.out.println(header.contains("MatchID"));
      String space = " ";
      for(int i=0;i<columnNames.length;i++)
      {
//          System.out.print(columnNames[i]+"  ");
          if(header.contains(columnNames[i]))
          {
              System.out.print(columnNames[i]+space.repeat(coulmnWidthForHead[i])+"||");
          }
      }
      System.out.println();

   
  }

  private void printRow(String[] row, int[] columnWidths) {
    
  }

  private void printSeparator(int[] columnWidths, String separator) {
    
  }

}
