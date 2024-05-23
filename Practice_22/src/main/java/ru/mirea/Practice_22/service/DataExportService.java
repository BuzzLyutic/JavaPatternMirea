package ru.mirea.Practice_22.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mirea.Practice_22.model.Student;
import ru.mirea.Practice_22.model.University;

import javax.management.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DataExportService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UniversityService universityService;

    private static final Logger log = LoggerFactory.getLogger(DataExportService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private void makeStudentsBackup() {
        List<Student> items = studentService.getAllStudents();
        Path path = Paths.get("backup/students.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Student item : items) {
                String itemStr = String.format("%d %s %s %s\n",
                        item.getId(),
                        item.getLastName(),
                        item.getFirstName(),
                        item.getMiddleName());
                writer.write(itemStr);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void makeUniversitiesBackup() {
        List<University> universities = universityService.getAllUniversities();
        Path path = Paths.get("backup/universities.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (University university : universities) {
                String orderStr = String.format("%d %s %s\n",
                        university.getId(),
                        university.getName(),
                        university.getCreationDate());
                writer.write(orderStr);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "* */30 * * * *")
    public void makeBackup() {
        makeStudentsBackup();
        makeUniversitiesBackup();
        log.info("Backups are made: {}", dateFormat.format(new Date()));
    }

}
