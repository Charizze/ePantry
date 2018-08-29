package com.example.epantry;

/*
 * The Database class contains methods to establish a database
 * connection, read and store highscore details into a database.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database extends SQLiteAssetHelper {

    Connection conn = null;
    String url = "jdbc:derby:Database;create=true";
    String username = "name";
    String password = "pass";
    Statement statement;
    ResultSet rs;

    public Database(Context context, String name, String storageDirectory, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, storageDirectory, factory, version);
    }

    /*
     * Establishes as connection to a database
     */
    public void connectDB() {
        try
        {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(url + " connected...");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Takes in a username and score argument to
     * insert row into the database
     */
    public void insertDetails(String username, String password) {
        try {
            Statement statement = conn.createStatement();
            String insertQuery = "INSERT INTO USERS VALUES ('" + username + "', " + password + ")";
            statement.executeUpdate(insertQuery);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Creates a table for scores using default values,
     * and handles SQL errors if one is encountered
     */
    public void createDB() {

        try {
            Statement statement = conn.createStatement();

            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "USER", null);

            if (!rs.next()) {
                String sqlCreateDBTable = "CREATE TABLE USERS(USERNAME VARCHAR(50),PASSWORD VARCHAR(50))";
                statement.executeUpdate(sqlCreateDBTable);

                String insertQuery = "INSERT INTO USERS VALUES ('RandomUser', 'password123'), "
                        + "('AnotherUser', aPassword)";
                statement.executeUpdate(insertQuery);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Retrieves the username and scores from a database file and
     * stores each value into a ResultSet. Handles Input/Output
     * errors when they occur
     */
    public ResultSet getScores() throws SQLException {

        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT USERNAME, PASSWORD "
                    + "FROM USERS";

            rs = statement.executeQuery(sqlQuery);

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

        return rs;
    }
}

