
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import org.apache.commons.io.IOUtils;

import org.json.JSONObject;

public class Registro_Login {

    public static String query_url;
    public static String json, result, nombreUsuario, claveApi;

    public static void Registro() {
        query_url = "http://35.231.65.179/~ajarab/webservice/usuarios/registro";
        json = "{\n"
                + "  \"nombre\":" + "\"" + GUI_Chaski_1_1.name_register + "\",\n"
                + "  \"contrasena\":" + "\"" + GUI_Chaski_1_1.psswd_register + "\",\n"
                + "  \"correo\":" + "\"" + GUI_Chaski_1_1.email_register + "\"\n"
                + "}";
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            System.out.println("result after Reading JSON Response");
            JSONObject myResponse = new JSONObject(result);
            nombreUsuario = myResponse.getString("mensaje");
            if (nombreUsuario.equals("Registrado correctamente!")) {
                JOptionPane.showMessageDialog(null, nombreUsuario);
            }

            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error!!!");
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void Login() {
        query_url = "http://35.231.65.179/~ajarab/webservice/usuarios/login";
        json = "{\n"
                + "  \"correo\":" + "\"" + GUI_Chaski_1_1.email_login + "\",\n"
                + "  \"contrasena\":" + "\"" + GUI_Chaski_1_1.psswd_login + "\"\n"
                + "}";
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            result = IOUtils.toString(in, "UTF-8");
            JSONObject myResponse = new JSONObject(result);
            nombreUsuario = myResponse.getJSONObject("usuario").getString("nombre");
            claveApi = myResponse.getJSONObject("usuario").getString("claveApi");
            JOptionPane.showMessageDialog(null, "Nombre: " + nombreUsuario + "\nClave API: " + claveApi);
            GUI_Chaski_1_1.correct=true;
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Revise sus datos e intente de nuevo!!!");
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
