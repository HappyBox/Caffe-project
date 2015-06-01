package GUI;
 
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import Model.Customer;
import Model.Dish;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
/**
 * Email with PDF.
 */
public class Driver {

	private static String address;
	private Customer cus;

	/**
     * Sends an email with a PDF attachment.
	 * @param address 
     */
	public Driver(Customer cus) {
		this.cus= cus;
	}
	public String getContent(ArrayList<Dish> orders){
		String content= "";
		for (Dish dish:orders){
			content = content + dish.getName() +" " + dish.getPrice() + " \n" ; 
		}
		return content;
	}
    public void email() {
        String smtpHost = "smtp.gmail.com"; //replace this with a valid host
        final String username = "pizza4driver@gmail.com";
        final String password = "pizzalounge";
        int smtpPort = 25; //replace this with a valid port
                 
        String sender = "pizza4driver@gmail.com";  //replace this with a valid sender email address
        String receiver = "pizza4driver@gmail.com";//replace this with a valid recipient email address

        String subject = "Order"; //this will be the subject of the email
        
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        ByteArrayOutputStream outputStream = null;
         
        try {           
            //construct the text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Address: " + cus.getAddress() +"\n"+ getContent(cus.getOrders()) );
            //now write the PDF content to the output stream
            outputStream = new ByteArrayOutputStream();
            writePdf(outputStream);
            byte[] bytes = outputStream.toByteArray();
             
            //construct the pdf body part
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("order.pdf");
                         
            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);
             
            //create the sender/recipient addresses
            InternetAddress iaSender = new InternetAddress(sender);
            InternetAddress iaRecipient = new InternetAddress(receiver);
             
            //construct the mime message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSender(iaSender);
            mimeMessage.setSubject(subject);
            mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
            mimeMessage.setContent(mimeMultipart);
             
            //send off the email
            Transport.send(mimeMessage);
             
            System.out.println("Sent from " + sender + 
                    ", to " + receiver);
                   // + "; server = " + smtpHost + ", port = " + smtpPort);         
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            //clean off
            if(null != outputStream) {
                try { outputStream.close(); outputStream = null; }
                catch(Exception ex) { }
            }
        }
    }
     
    /**
     * Writes the content of a PDF file (using iText API)
     * to the {@link OutputStream}.
     * @param outputStream {@link OutputStream}.
     * @throws Exception
     */
    public void writePdf(OutputStream outputStream) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
         
        document.open();
         
        document.addTitle("Order");
        document.addSubject("New Order");
        document.addKeywords("Order");
        document.addAuthor("PizzaLounge");
        document.addCreator("PizzaLounge");
         
        Paragraph paragraph = new Paragraph();
       
        paragraph.add(new Chunk("Address: " + cus.getAddress() +"\n"+ getContent(cus.getOrders())));
        document.add(paragraph);
        
        document.close();
    }
     
}