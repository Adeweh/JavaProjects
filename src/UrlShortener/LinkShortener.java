package UrlShortener;

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

    public String getUrl(int key) {
        return links.get(key);
    }

    public String getConvertedKey(int key) {
        return KeyGenerator.convertKey(key);
    }

    public String getShortURL(String convertedKey) {
        return "https://newURL." + convertedKey;
    }
}
