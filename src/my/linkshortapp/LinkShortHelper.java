package my.linkshortapp;

import java.util.HashMap;
import java.util.Map;

public class LinkShortHelper {
    private static final Map<String, String> db = new HashMap<>();
    private static final String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public void shortenLink(String link) {
        String shortLink = "http://foo.bar/" + generateHash(db.size() + 1);

        db.put(shortLink, link);
        System.out.println(shortLink);
    }

    public static String generateHash(int position) {
        // строка на искомой позиции
        // длина строки на искомой позиции
        int len = 1;
        // количество перебранных перестановок до текущей длины
        int totalCount = 0;

        while (true) {
            int lenPermutationsCount = (int) Math.pow(base.length(), len);
            if (totalCount + lenPermutationsCount >= position) {
                break;
            }
            totalCount += lenPermutationsCount;
            len++;
        }

        char[] current = new char[len];
        for (int i = 0; i < len; i++) {
            current[i] = base.charAt(0);
            for (int j = 0; j < base.length(); j++) {
                // количество перестановок, начинающеся на данный символ, через которые цикл перескочет
                int permutationsCount = (int) Math.pow(base.length(), len - (i + 1));
                current[i] = base.charAt(j);
                if (totalCount + permutationsCount >= position) {
                    break;
                }
                totalCount += permutationsCount;
            }
        }

        return String.valueOf(current);
    }

    public void getFullLink(String link) {
        System.out.println(db.getOrDefault(link, "unknown link"));
    }
}
