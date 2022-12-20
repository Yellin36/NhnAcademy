package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.config.MainConfig;
import com.nhnacademy.edu.springframework.config.ServiceConfig;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.Service;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class, MainConfig.class })
public class AnnotationMockTest {
    User user = new User("32@sdf.com", "324-2342");
    String message = "wsdfs";

    @InjectMocks
    @Autowired
    private Service annotationService;

    @Mock
    private MessageSender messageSender;

    @Test
    public void test() {
        annotationService.send(user, message);
    }

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        when(messageSender.sendMessage(user, message)).thenReturn(message);
    }
    @Test
    void testService() {
        String actual = annotationService.send(user, message);
        assertThat(actual).isEqualTo(message);
    }
}
