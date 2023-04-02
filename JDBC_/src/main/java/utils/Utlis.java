package utils;
public class Utlis {
    public static java.sql.Date getSQLDate(java.util.Date utliDate){
        return new java.sql.Date(utliDate.getTime());
    }
}
