package com.example.JavaPatternsTask14.config;

import com.example.JavaPatternsTask14.services.SchedulerBackupService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.RegistrationPolicy;

import java.util.Collections;

@Configuration
public class JmxConfig {

    @Bean
    public MBeanExporter exporter(SchedulerBackupService backupService) {
        MBeanExporter exporter = new MBeanExporter();
        exporter.setBeans(Collections.singletonMap("bean:name=backupService", backupService));
        exporter.setRegistrationPolicy(RegistrationPolicy.REPLACE_EXISTING);
        return exporter;
    }
}
