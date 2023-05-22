package com.powermock;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@Slf4j
@RunWith(PowerMockRunner.class)
public class PowerMockPractice {

    @Test
    public void helloWorld() {
        ServiceImpl1 serviceImpl1 = PowerMockito.mock(ServiceImpl1.class);
        PowerMockito.when(serviceImpl1.getUser()).thenReturn(User.builder()
                .firstName("jim").lastName("b").address("test method").build());
        Controller1 controller1 = new Controller1(serviceImpl1);
        log.info("user={}", controller1.getUser());
    }

}
