package my.linkshortapp;

import java.util.HashMap;
import java.util.Map;

public class LinkShortHelper {
    private static final Map<String, String> db = new HashMap<>();
    private static final String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String shortenLink(String link) {
        String shortLink = "http://foo.bar/" + generateLink(db.size() + 1);

        db.put(shortLink, link);

        return shortLink;
    }

    public static String generateLink(int position) {
        int rem = position;
        StringBuilder result = new StringBuilder();
        while (rem != 0) {
            result.insert(0, base.charAt(rem % base.length()));
            rem /= base.length();
        }
        return result.toString();
    }

    public static String getFullLink(String link) {
        return db.getOrDefault(link, "unknown link");
    }
}
