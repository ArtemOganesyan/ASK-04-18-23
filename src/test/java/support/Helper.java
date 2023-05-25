/*
 * Created by Artem Oganesyan on 10.01.2023
 */

package support;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

public class Helper {
    static final String DB_URL = "jdbc:mysql://44.205.92.189:3307/application?autoReconnect=true&useSSL=false";
    static final String USER = "testuser";
    static final String PASS = "password";
    public static String getAccessToken(String userEmail) throws SQLException {
        String result = "No data";
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        try(PreparedStatement pstmt = con.prepareStatement("SELECT id, activationCode FROM users WHERE email = ?");) {
            pstmt.setString(1, userEmail);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result = rs.getString("id") + ";" + rs.getString("activationCode");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void activateUser(int userId, String activationCode) throws IOException {
        URL url = new URL("http://ask-stage.portnov.com/api/v1/activate/" + userId + "/" + activationCode);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "USER_AGENT");
        int responseCode = con.getResponseCode();
        System.out.println("Activation request response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response);
        } else {
            System.out.println("Error occurred while trying to send get request");
        }
    }
}