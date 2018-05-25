/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author ayenni42
 */
public class Mail {

    Properties props = new Properties();

    public Mail() {

    }

    public void enviarEmail(String personaEnvia, String contraseñaEnvia, String personaRecive, String asunto, String mensaje) {
        //si requiere o no usuario y pasword para conectarse
        props.put("mail.smtp.auth", "true");
        //TLS si esta disponible
        props.put("mail.smtp.starttls.enable", "true");
        //Nombre del host de correo, es smtp.gmail.com
        props.put("mail.smtp.host", "smtp.gmail.com");
        //Puerto de gmail para envio de correos
        props.put("mail.smtp.port", "587");

        //instancia de seccion validar Autenticacion de contraseña
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(personaEnvia, contraseñaEnvia);
            }
        });

        try {
            //Construir mensaje 
            Message EnviarMensaje = new MimeMessage(session);
            //Quien envia el mensaje
            EnviarMensaje.setFrom(new InternetAddress(personaEnvia));
            //A quien va dirigido
            EnviarMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(personaRecive));
            //Asunto
            EnviarMensaje.setSubject(asunto);
            //Mensaje plano
            EnviarMensaje.setText(mensaje);

            //Envio del mensaje 
            Transport t = session.getTransport("smtp");
            t.connect(personaEnvia, contraseñaEnvia);
            t.sendMessage(EnviarMensaje, EnviarMensaje.getAllRecipients());
            t.close();
            JOptionPane.showMessageDialog(null, "Su mensaje ha sido enviado");
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Mail.enviarEmail(): "+e.getMessage());
            }
    }
    
    public void enviarEmail(String personaEnvia, String contraseñaEnvia, String personaRecive, String asunto, String mensaje, File archivo, String nombreArchivo) {
        //si requiere o no usuario y pasword para conectarse
        props.put("mail.smtp.auth", "true");
        //TLS si esta disponible
        props.put("mail.smtp.starttls.enable", "true");
        //Nombre del host de correo, es smtp.gmail.com
        props.put("mail.smtp.host", "smtp.gmail.com");
        //Puerto de gmail para envio de correos
        props.put("mail.smtp.port", "587");

        //instancia de seccion validar Autenticacion de contraseña
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(personaEnvia, contraseñaEnvia);
            }
        });

        try {
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);
            
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
            adjunto.setFileName(nombreArchivo);
            
            MimeMultipart multiparte = new  MimeMultipart();
            multiparte.addBodyPart(texto);
            multiparte.addBodyPart(adjunto);
            
            //Construir mensaje 
            Message EnviarMensaje = new MimeMessage(session);
            //Quien envia el mensaje
            EnviarMensaje.setFrom(new InternetAddress(personaEnvia));
            //A quien va dirigido
            EnviarMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(personaRecive));
            //Asunto
            EnviarMensaje.setSubject(asunto);
            //Mensaje plano
            EnviarMensaje.setContent(multiparte);

            //Envio del mensaje 
            Transport t = session.getTransport("smtp");
            t.connect(personaEnvia, contraseñaEnvia);
            t.sendMessage(EnviarMensaje, EnviarMensaje.getAllRecipients());
            t.close();
            JOptionPane.showMessageDialog(null, "Su mensaje ha sido enviado");
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Mail.enviarEmail(): "+e.getMessage());
            }
    }

    public static void main(String[] args) {
      try {
            File Imagen = new File("C:\\Users\\ayenni42\\Documents\\UNIVERSIDAD\\SEMESTRE 5\\DIU\\proyectoIntegrador (1).pdf");
            Mail mensaje = new Mail();
            mensaje.enviarEmail("bocanegrasantiago18@gmail.com", "santiagobocanegra1998", 
                    "santiago.bocanegra@correounivalle.edu.co", "prueba", "mensaje de prueba 2");
        } catch (Exception e) {
            System.out.println("MODELO.Mail.main(): " + e.getMessage());
        }
    }
}
