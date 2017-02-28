package lesson10;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;

/**
 * Created by artem on 15.02.17.
 */

public class MorzeConverter {
    private String morzeFile = "./src/lesson10/morze";
    Map<Character, String> hashMap = new HashMap<Character, String>();
    private String text;

    public MorzeConverter(String text) {
        this.text = text.toUpperCase();
    }

    public void getMorze() {
        try(BufferedReader f1 = new BufferedReader(new FileReader(morzeFile))) {
            String line;
            String[] words;
            for(;(line=f1.readLine())!=null;) {
                String[] keyValue = line.split("   ");
                Character key = keyValue[0].charAt(0);
                hashMap.put(key, keyValue[1]);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public void convertText() {
        String convString = "";
        for (int i = 0; i < this.text.length(); i++){
            char c = this.text.charAt(i);
            convString += hashMap.get(c);
        }
        System.out.println(convString);
    }
}
