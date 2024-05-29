package in.stackroute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.text.TextStringBuilder;

public class QueryExtractor {

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
   

    loadData(null, null);
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
   

    
    
   
  }

  private void printHeaders(String[] columnNames, int[] columnWidths) {

   
  }

  private void printRow(String[] row, int[] columnWidths) {
    
  }

  private void printSeparator(int[] columnWidths, String seperator) {
    
  }

}
