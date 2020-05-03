package bookClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that handles the connection with the database
 */
public class DatabaseManager {
   ////////////// fields ////////////////////////////

   private final String driverName;
   private final String urlStr;

   ////////////   constructors /////////////////////

   /**
    * Constructor that takes the driver name and url
    *
    * @param driver the class that communicates with the
    *               database
    * @param url    the url of the database as a string
    */
   public DatabaseManager(String driver, String url) {
      this.driverName = driver;
      this.urlStr = url;

      // try the following
      try {

         // load the driver class
         Class.forName(driver);

      }
      catch (ClassNotFoundException ex) {
         SimpleOutput.showError("Can't find the driver class " + driver + ", check the classpath");
      }
   }

   /////////////// methods //////////////////////////

   /* main for testing */
   public static void main(String[] args) {
      // create the database manager for an Access database
      DatabaseManager dbManager = new DatabaseManager("sun.jdbc.odbc.JdbcOdbcDriver", "jdbc:odbc:person");

      // create the database manager for a MySQL database
      // new DatabaseManager("com.mysql.jdbc.Driver",
      //                     "jdbc:mysql://localhost:3306/person");

      // test a query
      dbManager.testQuery(
              "Select per.FirstName, " + "pict.FileName From " + "Picture as pict, Person as per, " + "PicturePerson as pictPer " +
              "Where per.FirstName = 'Jennifer' And " + "pictPer.PersonID = per.PersonID And " + "pict.PictureID = pictPer.PictureID", 2);
   }

   /**
    * Method for testing the connection
    */
   public void testConnection() {
      // try the following
      try {

         // open the connection to the database
         Connection connection = DriverManager.getConnection(this.urlStr);

         // tell the user the connection was opened
         System.out.println("Connection established");

         // close the connection
         connection.close();

         // tell the user the connection was closed
         System.out.println("The connection was closed");

      }
      catch (SQLException ex) {
         SimpleOutput.showError("Trouble with the " + "database connection");
         ex.printStackTrace();
      }
   }

   /**
    * Method to test a query and print the results
    *
    * @param query   the query to execute
    * @param numCols the number of columns in the result
    */
   public void testQuery(String query, int numCols) {

      // try the following
      try {

         // open the connection to the database
         Connection connection = DriverManager.getConnection(this.urlStr);

         // create a statement
         Statement statement = connection.createStatement();

         // execute the query
         ResultSet rs = statement.executeQuery(query);

         // print out the results
         while (rs.next()) {
            for (int i = 1; i <= numCols; i++) {
               System.out.print(rs.getString(i) + ", ");
            }
            System.out.println();
         }

         // close everything
         rs.close();
         statement.close();
         connection.close();

      }
      catch (SQLException ex) {
         SimpleOutput.showError("Trouble with the database " + urlStr);
         ex.printStackTrace();
      }
   }

   /**
    * Method to execute a query and return a string of the
    * first result
    *
    * @param query the query to execute
    * @return the first result of the query, or null if none
    */
   public String getStringForQuery(String query) {
      String result = null;

      // try the following
      try {

         // open the connection to the database
         Connection connection = DriverManager.getConnection(this.urlStr);

         // create a statement
         Statement statement = connection.createStatement();

         // execute the query
         ResultSet rs = statement.executeQuery(query);

         // print out the results
         if (rs.next()) {
            result = rs.getString(1);
         }

         // close everything
         rs.close();
         statement.close();
         connection.close();

      }
      catch (SQLException ex) {
         SimpleOutput.showError("Trouble with the database " + urlStr);
         ex.printStackTrace();
      }

      return result;
   }

   /**
    * Method to execute a query and return a list of strings
    * for the first returned row
    *
    * @param query the query to execute
    * @return list of strings for the data in the first
    * returned row, the list may be empty
    */
   public List getListForQuery(String query) {
      List<String> resultList = new ArrayList<String>();

      // try the following
      try {

         // open the connection to the database
         Connection connection = DriverManager.getConnection(this.urlStr);

         // create a statement
         Statement statement = connection.createStatement();

         // execute the query
         ResultSet rs = statement.executeQuery(query);

         // find out how many columns are in the result
         ResultSetMetaData rsmd    = rs.getMetaData();
         int               numCols = rsmd.getColumnCount();

         // print out the results
         if (rs.next()) {
            for (int i = 1; i <= numCols; i++) {
               resultList.add(rs.getString(i));
            }
         }

         // close everything
         rs.close();
         statement.close();
         connection.close();

      }
      catch (SQLException ex) {
         SimpleOutput.showError("Trouble with the database " + urlStr);
         ex.printStackTrace();
      }

      return resultList;
   }

}
