package M9_UF3_Act08;

    import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author maria
 */
public class Activitat8 {

    private final String USER_AGENT = "Mozilla/5.0";
    private final static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        Activitat8 http = new Activitat8();
        int opcio = 0;
                        
        System.out.println("Indica 1 - GET / 2 - POST");
        opcio = scan.nextInt();
        
        if (opcio == 1) {
            System.out.println("Testing 1 - Send Http GET request");
            http.sendGet();
        } else {
            System.out.println("\nTesting 2 - Send Http POST request");
            http.sendPost();
        }            
    }

    // HTTP GET request
    private void sendGet() throws Exception {
        String url = "";

        System.out.println("Indica la URL a cercar: ");
        url = scan.next();
        
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
    }

    // HTTP POST request
    private void sendPost() throws Exception {
        String url = "";

        System.out.println("Introdueix la URL a cercar: ");
        url = scan.next();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "ca-es");

        //Query string
        String urlParameters = "";//categoryid=7
        System.out.println("Introdueix els parametres de la URL a cercar: ");
        urlParameters = scan.next();
        
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}