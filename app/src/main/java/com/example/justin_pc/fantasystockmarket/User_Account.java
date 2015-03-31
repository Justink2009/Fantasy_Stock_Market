package com.example.justin_pc.fantasystockmarket;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.connector.OracleConnectionManager;


public class User_Account extends ActionBarActivity {

    Button btnChangePassword;
    EditText newPassword;
    EditText currentPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user__account);

        btnChangePassword = (Button) findViewById(R.id.btnChangePassword);
        newPassword = (EditText) findViewById(R.id.newPassword);
        currentPassword = (EditText) findViewById(R.id.currentPassword);


        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            ConnectionManager();

            }
        });
    }

    public void ConnectionManager() {

            String url = "jdbc:oracle:thin:@141.216.24.31:1521:fsdb";
            String driverName = "oracle.jdbc.driver.OracleDriver";
            String username = "fsuser";
            String password = "fsuser";


            try {
                Class.forName(driverName);
                try {
                    DriverManager.getConnection(url, username, password);

                    Statement st = null;
                    ResultSet resultSet = null;

                    assert st != null;
                    resultSet=st.executeQuery("UPDATE userinfo SET password = '"+newPassword+
                            " WHERE PASSWORD ="+currentPassword+"'");


                } catch (SQLException ex) {
                    // log an exception. fro example:
                    System.out.println("Failed to create the database connection.");
                }
            } catch (ClassNotFoundException ex) {
                // log an exception. for example:
                System.out.println("Driver not found.");
            }

        }
    }



















