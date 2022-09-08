package UrlShortener;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class LinkShortener {

    private final Map<Integer, String> links = new HashMap<>();

    public void addURL(Integer key, String link) {
        links.put(key, link);

    }


    public int size() {
        return links.size();
    }

    public String getUrl(String shortURL) {
        int key = getKey(shortURL);
        return links.get(key);
    }

    public String getConvertedKey(int key) {
        return KeyGenerator.convertKey(key);
    }

    public String getShortURL(String link) {
        SecureRandom random = new SecureRandom();
        int key = random.nextInt(22_000_000);
        addURL(key, link);
        
        String convertedKey = getConvertedKey(key);
        
        return "https://newURL.com/" + convertedKey;
    }

    public int getKey(String shortURl) {
        String[] keyArray = shortURl.split("/");

        return KeyGenerator.getKey(keyArray[keyArray.length-1]);




    }
}
