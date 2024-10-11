//package org.example;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//
//public class FromWeb {
//    private static String a = "aaaa";
//
//    public static String getA() {
//        return a;
//    }
//
//    public static void download() throws IOException {
//        // Make a URL to the web page
//        URL url = new URL("https://lex.uz/uz/docs/5744540");
//
//        // Get the input stream through URL Connection
//        URLConnection con = url.openConnection();
//        InputStream is = con.getInputStream();
//
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
//            String line;
//
//            // read each line and write to System.out
////            while ((line = br.readLine()) != null) {
////                System.out.println(line);
////            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FromWeb {

//    private static List<String[]> resultList = new ArrayList<>();

//    public static List<String[]> getResultList() {
//        return resultList;
//    }

    public List<String[]> download() throws IOException {
        List<String[]> resultList = new ArrayList<>();
        String url = "https://lex.uz/uz/docs/5744540";
        Document doc = Jsoup.connect(url).get();
        Elements divs = doc.select("div.ACT_TEXT.lx_elem_comment");
        int cnt = 0;
        for (Element div : divs) {
            Elements links = div.select("a");
            if (links.size() > 1) {
                Element secondLink = links.get(1);
                String linkText = secondLink.text();

                // Check if the link text starts with a 5-digit number
                Pattern pattern = Pattern.compile("^\\d{5}.*");
                Matcher matcher = pattern.matcher(linkText);
                if (matcher.matches()) {
                    int firstSpaceIndex = linkText.indexOf(' ');
                    if (firstSpaceIndex != -1 && cnt <= 1) {
                        String firstPart = linkText.substring(0, firstSpaceIndex);
                        if (firstPart != null && firstPart.equals("10000")) {
                            cnt++;
                        }
                        String restOfLine = linkText.substring(firstSpaceIndex + 1);
                        if (cnt <= 1) resultList.add(new String[]{firstPart, restOfLine});

                    }

                }
            }
        }
        return resultList;
    }
}
