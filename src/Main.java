import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Boolean done = false;
        while(done == false){
            System.out.println("\u001B[34mWhat is URL of the site?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if(netIsAvailable(formatURL(input))){
                System.out.println("\u001B[32mThis site is reachable!");
            }else{
                System.out.println("\u001B[31mThis site is unreachable or doesn't exist.");
            }
            System.out.println("\u001B[34mDo you want to search for new site? (Yes/No)");
            String yesno = scanner.next();
            if(yesno.equals("No")){
                done=true;
            }
        }
    }
    private static boolean netIsAvailable(String string) {
        try {
            final URL url = new URL(string);
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }
    public static String formatURL(String originalURL){
        String newURL = originalURL;
        if (!originalURL.contains("http://") || !originalURL.contains("https://")){
            newURL = "http://" + originalURL;
        }
        return newURL;
    }
}
