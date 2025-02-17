package my.linkshortapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LinkShortHelper {
    private static final Map<String, String> shortLinkMap = new HashMap<>();
    private static final Map<String, String> fullLinkMap = new HashMap<>();
    private static final String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String shortenLink(String link) throws Exception {

        if (fullLinkMap.containsKey(link)) {
            return fullLinkMap.get(link);
        }

        if (!checkLink(link)) {
            throw new IOException("URL is invalid");
        }

        String shortLink = "http://foo.bar/" + generateLink(shortLinkMap.size() + 1);

        shortLinkMap.put(shortLink, link);
        fullLinkMap.put(link, shortLink);

        return shortLink;
    }

    private String generateLink(int position) {
        StringBuilder result = new StringBuilder();
        while (position != 0) {
            result.append(base.charAt(position % base.length()));
            position /= base.length();
        }
        return result.reverse().toString();
    }

    public String getFullLink(String link) {
        return shortLinkMap.getOrDefault(link, "unknown link");
    }

    private boolean checkLink(String link) {
        try {
            URL u = new URL(link);
            u.toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
        return true;
    }
}
