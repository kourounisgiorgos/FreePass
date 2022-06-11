package gr.hua.freepass.models;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.*;



public final class EmailController {

    public static void sendEmail(String to, String subject, String text) throws MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mailserver");
        mailSender.setProtocol("smtp");
        mailSender.setPort(1025);
        mailSender.setPassword("");
        mailSender.setUsername("");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("applications@freepass.gr");
        mimeMessageHelper.setText(text);
        mimeMessageHelper.setTo(InternetAddress.parse(to));
        mimeMessageHelper.setSubject(subject);

        mailSender.send(mimeMessage);

    }

}
