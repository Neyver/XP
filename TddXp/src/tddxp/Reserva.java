/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tddxp;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Daniel
 */
public class Reserva {

    public boolean userLoginCheck() {
        return Login.getSesion();
    }

    public boolean verificarCupo(Conferencia conf) {
        return conf.MaxCupo > conf.total_inscritos;
    }

    public boolean guardarReserva(int id_participante, int id_conferencia, String fecha, String estado) {
         boolean res = false;
        String sql = "INSERT INTO reserva VALUES(" + id_participante + ", "
                + id_conferencia + ", '" + fecha + "', '" + estado +"');";
        res = PostgresConn.updateDB(sql);
        System.out.println(res);
        return res;
    }

    public String getString() {
        return "Hola";
    }
    
    public String crearEmail(String conf, String fecha, String ciudad, String direcc, double costo) {
    	
    	String data = "*** Sus datos de su Reserva: ***\n\n" +
    	              "CONFERENCIA: " + conf + "\n" +
    	              "FECHA:" + fecha + "\n" +
    	              "CIUDAD:" + ciudad + "\n" +
    	              "DIRECCIÓN:" + direcc + "\n"
                    + "Costo: " + new modelo.funcioncambio().valor(costo, "BRL", "BOB") + " Reales";    	    	    
    	return data;
    }

    public boolean enviarEmail(String sendEmailTo, String subject, String msg) {
        // Sender's email ID needs to be mentioned
        String from = "conferenciasis2@gmail.com";
        String pass = "*ConferenciaSis2";
        // Recipient's email ID needs to be mentioned.
        String to = sendEmailTo;

        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(msg);

            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            return false;
        }

        return true;
    }
    
    public void reservarTeck(int id_conf, int id_participante, String fecha){
        Conferencia conferencia = new Conferencia(id_conf);
        if(userLoginCheck() && verificarCupo(conferencia))
        {
            guardarReserva(id_participante, id_conf, fecha, "Reservado");
            enviarEmail("to.danielrp@gmail.com", "Mail de Confirmacion", crearEmail("Teck-zone", fecha, "Cochabamba", "Av. Melchor Perez 1022", 180));
        }
    }
    
    public void reservarDrupal(int id_conf, int id_participante, String fecha){
        Conferencia conferencia = new Conferencia(id_conf);
        if(userLoginCheck() && verificarCupo(conferencia))
        {
            guardarReserva(id_participante, id_conf, fecha, "Reservado");
            enviarEmail("to.danielrp@gmail.com", "Mail de Confirmacion", crearEmail("Drupal Camp", fecha, "Cochabamba", "Calle La PAz 100", 250));
        }
    }
    
    public void reservarCCbol(int id_conf, int id_participante, String fecha){
        Conferencia conferencia = new Conferencia(id_conf);
        if(userLoginCheck() && verificarCupo(conferencia))
        {
            guardarReserva(id_participante, id_conf, fecha, "Reservado");
            enviarEmail("to.danielrp@gmail.com", "Mail de Confirmacion", crearEmail("CCBOL", fecha, "Cochabamba", "Av. Portales 22", 120));
        }
    }
}
