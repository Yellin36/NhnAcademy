package com.nhnacademy.springboot.department.runner;

import com.nhnacademy.springboot.department.service.DBSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbSettingRunner implements ApplicationRunner {
    private final DBSettingService settingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String fileName = System.getProperty("init.file.name");

        settingService.dbSetting(fileName);
    }
}
