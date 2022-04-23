import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("\u001B[34m What is URL of the site?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if(netIsAvailable(input)){
            System.out.println("\u001B[32m This site is reachable!");
        }else{
            System.out.println("\u001B[31m This site is unreachable or doesn't exist.");
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
}
