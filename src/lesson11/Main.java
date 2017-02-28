package lesson11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by artem on 20.02.17.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(getTextFromURL("https://prog.kiev.ua/forum/"));
    }

    public static String getTextFromURL(String url) {
        StringBuilder sb = new StringBuilder();
        try {
            URL urlOne = new URL(url);
            HttpURLConnection httpCon = (HttpURLConnection) urlOne.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            String text = "";
            for(; (text=br.readLine())!=null;) {
                sb.append(text).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
