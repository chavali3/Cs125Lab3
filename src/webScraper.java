import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class webScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urltoString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String[] args) {
        System.out.println("Paste URL here");
        Scanner theurl = new Scanner(System.in);
        String webaddress = theurl.next();
        String web = urltoString(webaddress);
        String[] webwords = web.split("\\s");
        //count words
        int count = 0;
        for (int i = 0; i < webwords.length; i++) {
            if (!(webwords[i].contains("\\s")) && !(webwords[i].contains("\\n")) && (webwords[i].length() > 0)) {
                count++;

            }

        }
        System.out.println("The total word count is " + count);
        //find word
        System.out.println("Search for a word on website by typing it in.");
        Scanner findword = new Scanner(System.in);
        String foundword = findword.next();
        boolean found = false;
        for (int i = 0; i < webwords.length; i++) {
            if ((webwords[i].contains(foundword))) {
                found = true;

            }
        }
        System.out.println(found);
        //find unique word count
        System.out.println("Hit enter to see unique word count");
        int newcount = 0;
        for (int i = 0; i < webwords.length; i++) {
            if ((webwords[i].length() > 0)) {
                String[] solution = new String[count];
                for (int j = 0; j < solution.length; j++){
                    if (!(solution[j].contains(webwords[i]))) {
                        solution[newcount++] =webwords[i];
                    }
                }

            }

        }
        System.out.println("Number of Unique words is " + newcount);

    }

}
