package com.example.JavaPatternsTask14.services;

import com.example.JavaPatternsTask14.repositories.ManufactureRepo;
import com.example.JavaPatternsTask14.repositories.PhoneRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@EnableScheduling
@Slf4j
@Transactional
public class SchedulerBackupService {
    private final PhoneRepo phoneRepository;
    private final ManufactureRepo manufactureRepository;
    String backupPath = "src/main/resources/database/backups/";

    @Scheduled(cron = "0 */30 * * * *")
    public void backupData() {
        log.info("Backup database");
        clearDirectory(backupPath);

        try {
            File file = new File(backupPath + "phones.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(phoneRepository.getAllBy().orElseThrow().toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File(backupPath + "manufactures.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(manufactureRepository.getAllBy().orElseThrow().toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
    }

    // Метод для вызова через JMX (для управления через JConsole или подобные инструменты)
    public void performBackup() {
        backupData();
    }
}

