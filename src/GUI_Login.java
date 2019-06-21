
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author antho
 */
public class GUI_Login extends javax.swing.JFrame {

    public static String prinom;
    public static String priapel;
    public static String correo1;
    public static String telefono1;
    public static String idContac1;
    public static String mensaje;

    public static ArrayList<DatosContactos> lista = new ArrayList<DatosContactos>();

    public GUI_Login() {
        initComponents();
        jlbl_Nombre.setText(Registro_Login.nombreUsuario);
        jlblCApi.setText(Registro_Login.claveApi);
        jlblMail.setText(GUI_Chaski_1_1.email_login);
    }

    public static void crearSala() {
        String query_url = "http://35.231.65.179/~ajarab/webservice/salas";
        String json = "{\n"
                + "  \"idUsuario\":" + "\"" + Registro_Login.nombreUsuario + "\",\n"
                + "  \"idContacto\":" + "\"" + idContac1 + "\"\n"
                + "}";
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", Registro_Login.claveApi);
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();

            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            System.out.println("result after Reading JSON Response");
            JSONObject myResponse = new JSONObject(result);

            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);

        }
    }
public static void enviarMensaje() {
        String query_url = "http://35.231.65.179/~ajarab/webservice/chats";
        String json = "{\n"
                + "  \"idContacto\":" + "\"" + idContac1 + "\",\n"
                + "  \"mensaje\":" + "\"" + mensaje + "\"\n"
                + "}";
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", Registro_Login.claveApi);
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();

            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            System.out.println("result after Reading JSON Response");
            JSONObject myResponse = new JSONObject(result);

            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);

        }
    }
    public static void agregarcontacto() {

        String query_url = "http://35.231.65.179/~ajarab/webservice/contactos";
        String json = "{\n"
                + "  \"primerNombre\":" + "\"" + prinom + "\",\n"
                + "  \"primerApellido\":" + "\"" + priapel + "\",\n"
                + "  \"correo\":" + "\"" + correo1 + "\",\n"
                + "  \"telefono\":" + "\"" + telefono1 + "\"\n"
                + "}";
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", Registro_Login.claveApi);
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            System.out.println("result after Reading JSON Response");
            JSONObject myResponse = new JSONObject(result);

            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void editarcontacto() {

        String query_url = "http://35.231.65.179/~ajarab/webservice/contactos/" + idContac1;
        String json = "{\n"
                + "  \"primerNombre\":" + "\"" + prinom + "\",\n"
                + "  \"primerApellido\":" + "\"" + priapel + "\",\n"
                + "  \"correo\":" + "\"" + correo1 + "\",\n"
                + "  \"telefono\":" + "\"" + telefono1 + "\"\n"
                + "}";
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Authorization", Registro_Login.claveApi);
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            System.out.println("result after Reading JSON Response");
            JSONObject myResponse = new JSONObject(result);

            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void eliminarcontacto() {

        String query_url = "http://35.231.65.179/~ajarab/webservice/contactos/" + idContac1;

        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Authorization", Registro_Login.claveApi);
            OutputStream os = conn.getOutputStream();
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            System.out.println("result after Reading JSON Response");
            JSONObject myResponse = new JSONObject(result);

            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void contactos() {
        String query_url = "http://35.231.65.179/~ajarab/webservice/contactos";

        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:27.0) Gecko/20100101 Firefox/27.0.2 Waterfox/27.0");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Authorization", Registro_Login.claveApi);

            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");

            in.close();
            //print result
            JSONObject jn = new JSONObject(result);

            JSONArray jsonarray = jn.getJSONArray("datos");

            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject obj = jsonarray.getJSONObject(i);
                String idContacto = obj.getString("idContacto");
                String pNombre = obj.getString("primerNombre");
                String pApellido = obj.getString("primerApellido");
                String telefono = obj.getString("telefono");
                String correo = obj.getString("correo");
                String idUsuario = obj.getString("idUsuario");
                System.out.println("Id del Contacto: " + idContacto + "\n"
                        + "Primer nombre: " + pNombre + "\n"
                        + "Primer apellido: " + pApellido + "\n"
                        + "Telefono: " + telefono + "\n"
                        + "Correo: " + correo + "\n"
                        + "Id del Usuario: " + idUsuario);
                System.out.println("\n\n");
                DatosContactos persona = new DatosContactos(idContacto, pNombre, pApellido, telefono, correo, idUsuario);
                lista.add(persona);
            }

            /**/
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void mostrar() {
        String matriz[][] = new String[lista.size()][6];
        for (int i = 0; i < lista.size(); i++) {
            matriz[i][0] = lista.get(i).getIdContacto();
            matriz[i][1] = lista.get(i).getpNombre();
            matriz[i][2] = lista.get(i).getpApellido();
            matriz[i][3] = lista.get(i).getTelefono();
            matriz[i][4] = lista.get(i).getCorreo();
            matriz[i][5] = lista.get(i).getIdUsuario();
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "ID del Contacto", "Primer Nombre", "Primer Apellido", "Telefono", "Correo", "ID del Usuario"
                }
        ));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlbl_Nombre = new javax.swing.JLabel();
        jlblMail = new javax.swing.JLabel();
        jlblCApi = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jtxtTelefono = new javax.swing.JTextField();
        jtxtCorreo = new javax.swing.JTextField();
        jtxtPnombre = new javax.swing.JTextField();
        jtxtPapellido = new javax.swing.JTextField();
        jBNuevo = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jtxtPnombre2 = new javax.swing.JTextField();
        jtxtPapellido1 = new javax.swing.JTextField();
        jtxtCorreo1 = new javax.swing.JTextField();
        jtxtTelefono1 = new javax.swing.JTextField();
        jtxtIdContacto = new javax.swing.JTextField();
        jBEditar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jtxtIdContacto1 = new javax.swing.JTextField();
        jBEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtxtMensaje = new javax.swing.JTextField();
        jtxtIdContacto3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(446, 633));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setText("Bienvenido a Chaski 1.1");

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(446, 573));

        jPanel1.setPreferredSize(new java.awt.Dimension(446, 538));

        jLabel2.setText("Nombre:");

        jLabel3.setText("Correo electrónico: ");

        jLabel4.setText("Clave API:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblMail, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblCApi, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jlbl_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlbl_Nombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlblMail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlblCApi))
                .addContainerGap(415, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Info", jPanel1);

        jPanel4.setPreferredSize(new java.awt.Dimension(446, 538));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID del Contacto", "Primer Nombre", "Primer Apellido", "Telefono", "Correo", "ID del Usuario"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setEditingColumn(1);
        jTable1.setEditingRow(1);
        jTable1.setRowHeight(26);
        jScrollPane1.setViewportView(jTable1);

        jtxtTelefono.setForeground(java.awt.Color.gray);
        jtxtTelefono.setText("Teléfono");
        jtxtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtTelefonoFocusLost(evt);
            }
        });

        jtxtCorreo.setForeground(java.awt.Color.gray);
        jtxtCorreo.setText("Correo");
        jtxtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtCorreoFocusLost(evt);
            }
        });

        jtxtPnombre.setForeground(java.awt.Color.gray);
        jtxtPnombre.setText("Primer nombre");
        jtxtPnombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtPnombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtPnombreFocusLost(evt);
            }
        });
        jtxtPnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPnombreActionPerformed(evt);
            }
        });

        jtxtPapellido.setForeground(java.awt.Color.gray);
        jtxtPapellido.setText("Primer apellido");
        jtxtPapellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtPapellidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtPapellidoFocusLost(evt);
            }
        });

        jBNuevo.setText("Nuevo contacto");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtCorreo)
                    .addComponent(jtxtPapellido, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jtxtTelefono)
                    .addComponent(jtxtPnombre))
                .addGap(198, 198, 198))
            .addComponent(jBNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxtPnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtPapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jBNuevo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Nuevo contacto", jPanel6);

        jtxtPnombre2.setForeground(java.awt.Color.gray);
        jtxtPnombre2.setText("Primer nombre");
        jtxtPnombre2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtPnombre2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtPnombre2FocusLost(evt);
            }
        });
        jtxtPnombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPnombre2ActionPerformed(evt);
            }
        });

        jtxtPapellido1.setForeground(java.awt.Color.gray);
        jtxtPapellido1.setText("Primer apellido");
        jtxtPapellido1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtPapellido1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtPapellido1FocusLost(evt);
            }
        });

        jtxtCorreo1.setForeground(java.awt.Color.gray);
        jtxtCorreo1.setText("Correo");
        jtxtCorreo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtCorreo1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtCorreo1FocusLost(evt);
            }
        });

        jtxtTelefono1.setForeground(java.awt.Color.gray);
        jtxtTelefono1.setText("Teléfono");
        jtxtTelefono1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtTelefono1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtTelefono1FocusLost(evt);
            }
        });

        jtxtIdContacto.setForeground(java.awt.Color.gray);
        jtxtIdContacto.setText("ID del Contacto");
        jtxtIdContacto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtIdContactoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtIdContactoFocusLost(evt);
            }
        });
        jtxtIdContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtIdContactoActionPerformed(evt);
            }
        });

        jBEditar.setText("Editar contacto");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtCorreo1)
                    .addComponent(jtxtPapellido1)
                    .addComponent(jtxtTelefono1)
                    .addComponent(jtxtIdContacto, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jtxtPnombre2))
                .addGap(198, 198, 198))
            .addComponent(jBEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxtPnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtPapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtIdContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jBEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Modificar contacto", jPanel7);

        jtxtIdContacto1.setForeground(java.awt.Color.gray);
        jtxtIdContacto1.setText("ID del Contacto");
        jtxtIdContacto1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtIdContacto1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtIdContacto1FocusLost(evt);
            }
        });
        jtxtIdContacto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtIdContacto1ActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar contacto");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jLabel5.setText("Ingrese el Id del contacto que desea eliminar:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtIdContacto1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtIdContacto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jBEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Eliminar contacto", jPanel8);

        jtxtMensaje.setForeground(java.awt.Color.gray);
        jtxtMensaje.setText("Mensaje");
        jtxtMensaje.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtMensajeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtMensajeFocusLost(evt);
            }
        });
        jtxtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMensajeActionPerformed(evt);
            }
        });

        jtxtIdContacto3.setForeground(java.awt.Color.gray);
        jtxtIdContacto3.setText("ID del Contacto");
        jtxtIdContacto3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtIdContacto3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtIdContacto3FocusLost(evt);
            }
        });
        jtxtIdContacto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtIdContacto3ActionPerformed(evt);
            }
        });

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jtxtIdContacto3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtIdContacto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Enviar mensaje", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contactos", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        idContac1 = jtxtIdContacto3.getText();
        mensaje = jtxtMensaje.getText();
        crearSala();
        enviarMensaje();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtxtIdContacto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIdContacto3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtIdContacto3ActionPerformed

    private void jtxtIdContacto3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIdContacto3FocusLost
        // TODO add your handling code here:
        if (jtxtIdContacto3.getText().trim().equals("")) {
            jtxtIdContacto3.setText("ID del Contacto");
            jtxtIdContacto3.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtIdContacto3FocusLost

    private void jtxtIdContacto3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIdContacto3FocusGained
        // TODO add your handling code here:
        if (jtxtIdContacto3.getText().trim().equals("ID del Contacto")) {
            jtxtIdContacto3.setText("");
            jtxtIdContacto3.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtIdContacto3FocusGained

    private void jtxtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtMensajeActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        lista.clear();
        idContac1 = jtxtIdContacto1.getText();

        eliminarcontacto();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "ID del Contacto", "Primer Nombre", "Primer Apellido", "Telefono", "Correo", "ID del Usuario"
                }
        ));
        contactos();
        mostrar();
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jtxtIdContacto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIdContacto1ActionPerformed

    }//GEN-LAST:event_jtxtIdContacto1ActionPerformed

    private void jtxtIdContacto1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIdContacto1FocusLost
        // TODO add your handling code here:
        if (jtxtIdContacto1.getText().trim().equals("")) {
            jtxtIdContacto1.setText("ID del Contacto");
            jtxtIdContacto1.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtIdContacto1FocusLost

    private void jtxtIdContacto1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIdContacto1FocusGained
        // TODO add your handling code here:
        if (jtxtIdContacto1.getText().trim().equals("ID del Contacto")) {
            jtxtIdContacto1.setText("");
            jtxtIdContacto1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtIdContacto1FocusGained

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // TODO add your handling code here:
        lista.clear();
        prinom = jtxtPnombre2.getText();
        priapel = jtxtPapellido1.getText();
        correo1 = jtxtCorreo1.getText();
        telefono1 = jtxtTelefono1.getText();
        idContac1 = jtxtIdContacto.getText();

        editarcontacto();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "ID del Contacto", "Primer Nombre", "Primer Apellido", "Telefono", "Correo", "ID del Usuario"
                }
        ));
        contactos();
        mostrar();
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jtxtIdContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIdContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtIdContactoActionPerformed

    private void jtxtIdContactoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIdContactoFocusLost
        // TODO add your handling code here:
        if (jtxtIdContacto.getText().trim().equals("")) {
            jtxtIdContacto.setText("ID del Contacto");
            jtxtIdContacto.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtIdContactoFocusLost

    private void jtxtIdContactoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIdContactoFocusGained
        // TODO add your handling code here:
        if (jtxtIdContacto.getText().trim().equals("ID del Contacto")) {
            jtxtIdContacto.setText("");
            jtxtIdContacto.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtIdContactoFocusGained

    private void jtxtTelefono1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtTelefono1FocusLost
        // TODO add your handling code here:
        if (jtxtTelefono1.getText().trim().equals("")) {
            jtxtTelefono1.setText("Teléfono");
            jtxtTelefono1.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtTelefono1FocusLost

    private void jtxtTelefono1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtTelefono1FocusGained
        // TODO add your handling code here:
        if (jtxtTelefono1.getText().trim().equals("Teléfono")) {
            jtxtTelefono1.setText("");
            jtxtTelefono1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtTelefono1FocusGained

    private void jtxtCorreo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtCorreo1FocusLost
        // TODO add your handling code here:
        if (jtxtCorreo1.getText().trim().equals("")) {
            jtxtCorreo1.setText("Correo");
            jtxtCorreo1.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtCorreo1FocusLost

    private void jtxtCorreo1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtCorreo1FocusGained
        // TODO add your handling code here:
        if (jtxtCorreo1.getText().trim().equals("Correo")) {
            jtxtCorreo1.setText("");
            jtxtCorreo1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtCorreo1FocusGained

    private void jtxtPapellido1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPapellido1FocusLost
        // TODO add your handling code here:
        if (jtxtPapellido1.getText().trim().equals("")) {
            jtxtPapellido1.setText("Primer apellido");
            jtxtPapellido1.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtPapellido1FocusLost

    private void jtxtPapellido1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPapellido1FocusGained
        // TODO add your handling code here:
        if (jtxtPapellido1.getText().trim().equals("Primer apellido")) {
            jtxtPapellido1.setText("");
            jtxtPapellido1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtPapellido1FocusGained

    private void jtxtPnombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPnombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPnombre2ActionPerformed

    private void jtxtPnombre2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPnombre2FocusLost
        // TODO add your handling code here:
        if (jtxtPnombre2.getText().trim().equals("")) {
            jtxtPnombre2.setText("Primer nombre");
            jtxtPnombre2.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtPnombre2FocusLost

    private void jtxtPnombre2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPnombre2FocusGained
        // TODO add your handling code here:
        if (jtxtPnombre2.getText().trim().equals("Primer nombre")) {
            jtxtPnombre2.setText("");
            jtxtPnombre2.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtPnombre2FocusGained

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        // TODO add your handling code here:
        lista.clear();
        prinom = jtxtPnombre.getText();
        priapel = jtxtPapellido.getText();
        correo1 = jtxtCorreo.getText();
        telefono1 = jtxtTelefono.getText();

        agregarcontacto();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "ID del Contacto", "Primer Nombre", "Primer Apellido", "Telefono", "Correo", "ID del Usuario"
                }
        ));
        contactos();
        mostrar();

    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jtxtPapellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPapellidoFocusLost
        // TODO add your handling code here:
        if (jtxtPapellido.getText().trim().equals("")) {
            jtxtPapellido.setText("Primer apellido");
            jtxtPapellido.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtPapellidoFocusLost

    private void jtxtPapellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPapellidoFocusGained
        // TODO add your handling code here:
        if (jtxtPapellido.getText().trim().equals("Primer apellido")) {
            jtxtPapellido.setText("");
            jtxtPapellido.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtPapellidoFocusGained

    private void jtxtPnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPnombreActionPerformed

    private void jtxtPnombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPnombreFocusLost
        // TODO add your handling code here:
        if (jtxtPnombre.getText().trim().equals("")) {
            jtxtPnombre.setText("Primer nombre");
            jtxtPnombre.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtPnombreFocusLost

    private void jtxtPnombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPnombreFocusGained
        // TODO add your handling code here:
        if (jtxtPnombre.getText().trim().equals("Primer nombre")) {
            jtxtPnombre.setText("");
            jtxtPnombre.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtPnombreFocusGained

    private void jtxtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtCorreoFocusLost
        // TODO add your handling code here:
        if (jtxtCorreo.getText().trim().equals("")) {
            jtxtCorreo.setText("Correo");
            jtxtCorreo.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtCorreoFocusLost

    private void jtxtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtCorreoFocusGained
        // TODO add your handling code here:
        if (jtxtCorreo.getText().trim().equals("Correo")) {
            jtxtCorreo.setText("");
            jtxtCorreo.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtCorreoFocusGained

    private void jtxtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtTelefonoFocusLost
        // TODO add your handling code here:
        if (jtxtTelefono.getText().trim().equals("")) {
            jtxtTelefono.setText("Teléfono");
            jtxtTelefono.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtTelefonoFocusLost

    private void jtxtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtTelefonoFocusGained
        // TODO add your handling code here:
        if (jtxtTelefono.getText().trim().equals("Teléfono")) {
            jtxtTelefono.setText("");
            jtxtTelefono.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtTelefonoFocusGained

    private void jtxtMensajeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtMensajeFocusGained
        // TODO add your handling code here:
        if (jtxtMensaje.getText().trim().equals("Mensaje")) {
            jtxtMensaje.setText("");
            jtxtMensaje.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtxtMensajeFocusGained

    private void jtxtMensajeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtMensajeFocusLost
        // TODO add your handling code here:
        if (jtxtMensaje.getText().trim().equals("")) {
            jtxtMensaje.setText("Mensaje");
            jtxtMensaje.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jtxtMensajeFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTabbedPane jTabbedPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    public static javax.swing.JLabel jlblCApi;
    public static javax.swing.JLabel jlblMail;
    public static javax.swing.JLabel jlbl_Nombre;
    private javax.swing.JTextField jtxtCorreo;
    private javax.swing.JTextField jtxtCorreo1;
    private javax.swing.JTextField jtxtIdContacto;
    private javax.swing.JTextField jtxtIdContacto1;
    private javax.swing.JTextField jtxtIdContacto3;
    private javax.swing.JTextField jtxtMensaje;
    private javax.swing.JTextField jtxtPapellido;
    private javax.swing.JTextField jtxtPapellido1;
    private javax.swing.JTextField jtxtPnombre;
    private javax.swing.JTextField jtxtPnombre2;
    private javax.swing.JTextField jtxtTelefono;
    private javax.swing.JTextField jtxtTelefono1;
    // End of variables declaration//GEN-END:variables
}
