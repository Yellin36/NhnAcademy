package com.nhnacademy.edu.springframework.messagesender;

public class Main {
    public static void main(String[] args) {
        User user = new User("yerin@gmail.com", "010-1234-1234");
        String message = "hello";

        //다형성 실습1 : 특정 메소드 호출
        sendSmsMessage(user, message);
        
        //다형성 실습2
        new Service(new EmailMessageSender()).send(user, message);
        new Service(new SmsMessageSender()).send(user, message);
    }
    private static void sendSmsMessage(User user, String message) {
        System.out.printf("SMS Message Sent to %s : %s\n", user.getPhoneNumber(), message);
    }
    private static void sendEmailMessage(User user, String message) {
        System.out.printf( "Email Message Sent %s : %s\n", user.getEmail(), message);
    }
}
