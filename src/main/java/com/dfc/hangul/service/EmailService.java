package com.dfc.hangul.service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${sendgrid.api-key}")
    private String sendGridApiKey;

    public void sendLessonRequestEmail(String studentName, String teacher, String time) {
        try {
            Email from = new Email("ank210005@utdallas.edu");
            String subject = "New Lesson Request - " + studentName;
            Email toAdmin1 = new Email("ank210005@utdallas.edu");
            Email toAdmin2 = new Email("kxg220063@utdallas.edu");

            String bodyText = "📚 New Lesson Request\n\n" +
                    "Student Name: " + studentName + "\n" +
                    "Requested Teacher: " + teacher + "\n" +
                    "Requested Time: " + time + "\n\n" +
                    "Please review this request.";

            Content content = new Content("text/plain", bodyText);

            // Build one email
            Mail mail1 = new Mail(from, subject, toAdmin1, content);
            Mail mail2 = new Mail(from, subject, toAdmin2, content);

            SendGrid sg = new SendGrid(sendGridApiKey);
            Request request = new Request();

            // Send to first recipient
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail1.build());
            Response response1 = sg.api(request);
            System.out.println("Admin 1 send status: " + response1.getStatusCode());
            System.out.println("Loaded SendGrid Key Starts With: " + sendGridApiKey.substring(0,5));


            // Send to second recipient
            request.setBody(mail2.build());
            Response response2 = sg.api(request);
            System.out.println("Admin 2 send status: " + response2.getStatusCode());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
