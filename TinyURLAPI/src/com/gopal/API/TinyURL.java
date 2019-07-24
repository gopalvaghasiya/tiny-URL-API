package com.gopal.API;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//Author - Mohamed Shimran
//Blog - http://www.ultimateprogrammingtutorials.info

class TinyURL {
    public static void main(String args[]) {
        String Link;
        try {
            Scanner in = new Scanner(System. in );
            System.out.println("Enter Link to short :");
            Link = in .nextLine();
            URL url = new URL("http://tinyurl.com/api-create.php?url=" + Link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
            String output;
            int cnt=0;
            while ((output = br.readLine()) != null) {
                System.out.println(output + " "+cnt++);
            }
            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}