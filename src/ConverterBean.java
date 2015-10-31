import java.sql.*;

public class ConverterBean
{
    private String result;
    private String conversionSummary;
    private String buttonLabel;
    public String stringfromdb ="uguga";
    public String getStringfromdb()
    {
        return stringfromdb;
    }
    public String setStringfromdb(String stringfromdb)
    {
        this.stringfromdb = stringfromdb;
        return stringfromdb;
    }
    public String getConversionSummary()
    {
        return conversionSummary;
    }
    public void setConversionSummary(String conversionSummary)
    {
        this.conversionSummary = conversionSummary;
    }
    public String getButtonLabel()
    {
        return buttonLabel;
    }
    public void setButtonLabel(String buttonLabel)
    {
        this.buttonLabel = buttonLabel;
    }
    public String getResult()
    {
        return result;
    }
    public void setResult(String result) throws SQLException, ClassNotFoundException
    {
        double conversionFactor = 39.37;
        String support = dbsql();
        setStringfromdb(support);
        try
        {
            double metersToConvert = Double.parseDouble(result);
            double inches = conversionFactor*metersToConvert;
            String inchesString = Double.toString(inches);
            this.result = result + " m = " + inchesString + " inches";
            setConversionSummary("CONVERSION RESULT");
            setButtonLabel("Convert another number");
            setStringfromdb(dbsql());
        }
        catch (NumberFormatException e)
        {
            this.result = "\"" + result + "\" is not a number.";
            if (result.isEmpty()) this.result = "You forgot to specify the number of meters.";
            setConversionSummary("CONVERSION FAILED");
            setButtonLabel("Try once more");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String dbsql() throws SQLException, ClassNotFoundException
    {
        String stringfromdb2 = "";
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/testdb",
                "postgres", "root");
        if (conn == null)
        {
            System.out.println("Нет соединения с БД!");
            System.exit(0);
        }
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM authors");
        int i=0;
        while (rs.next())
        {
            stringfromdb2=rs.getString(1);
            System.out.println(rs.getRow() + ". " + rs.getString("roman_figure")
                    + "\t" + rs.getString("arab_figure"));

        }
        stmt.close();
        return stringfromdb2;
    }






}
