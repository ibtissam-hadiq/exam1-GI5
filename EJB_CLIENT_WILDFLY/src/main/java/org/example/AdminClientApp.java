package org.example;
import org.example.Entities.CD;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import java.util.Properties;
public class AdminClientApp {
    private AdminServiceRemote adminService;

    public AdminClientApp() {
        try {
            Properties jndiProps = new Properties();
            jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            Context context = new InitialContext(jndiProps);

            // Obtenir la référence du service distant via JNDI
            adminService = (AdminServiceRemote) context.lookup("java:global/cinetheque-backend/AdminService!com.example.AdminServiceRemote");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void showAdminPanel() {
        JFrame frame = new JFrame("Admin Panel");
        JButton addCDButton = new JButton("Ajouter CD");

        addCDButton.addActionListener(e -> {
            CD cd = new CD();
            cd.setTitre("Nouveau CD");
            cd.setArtiste("Artiste Exemple");
            adminService.ajouterCD(cd);  // Appel de la méthode distante
            JOptionPane.showMessageDialog(frame, "CD ajouté !");
        });

        frame.add(addCDButton);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AdminClientApp app = new AdminClientApp();
        app.showAdminPanel();
    }
}
