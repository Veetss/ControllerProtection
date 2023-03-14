package co.develhope.loginDemo.notification.services;

import co.develhope.loginDemo.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendActivationEmail(User user) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(user.getEmail());
        sms.setFrom("vittoria.vassarotti@proton.me");
        sms.setReplyTo("vittoria.vassarotti@proton.me");
        sms.setSubject("You have signed up to the platform!");
        sms.setText("The activation code is: " + user.getActivationCode());
        emailSender.send(sms);
    }

    public void sendPasswordResetMail(User user) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(user.getEmail());
        sms.setFrom("vittoria.vassarotti@proton.me");
        sms.setReplyTo("vittoria.vassarotti@proton.me");
        sms.setSubject("You have signed up to the platform");
        sms.setText("The activation code is: " + user.getPasswordResetCode());
        emailSender.send(sms);
    }

}
