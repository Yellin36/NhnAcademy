package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.Service;
import com.nhnacademy.edu.springframework.messagesender.SmsMessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.aspectj.bridge.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {
    Service service = new Service();
    User user = new User("32@sdf.com", "324-2342");
    String message = "wsdfs";

    @Test
    void testService() {
    //        ReflectionTestUtils.setField(service, "messageSender", new SmsMessageSender());
    //        boolean actual = service.send(user, message);

    }
    @Test
    public void testSmsMessageSender() {
        MessageSender messageSender = mock(MessageSender.class);
        service = new Service(messageSender);

        when(messageSender.sendMessage(user, message)).thenReturn(message);

        String actual = service.send(user, message);
        Assertions.assertThat(actual).isEqualTo(message);
    }
    @Test
    public void test() {
        MessageSender mockSender = Mockito.mock(MessageSender.class);
        String name = "yerin";
        Service service1 = new Service(mockSender);

        service1.send(user, message);

        Mockito.verify(mockSender, Mockito.times(2))
                .sendMessage(any(User.class), any(String.class));
    }


}
