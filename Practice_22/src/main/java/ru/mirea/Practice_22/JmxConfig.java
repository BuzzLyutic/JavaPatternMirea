package ru.mirea.Practice_22;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import ru.mirea.Practice_22.service.DataExportService;

import java.util.Map;

@Configuration
public class JmxConfig {

    @Bean
    public AnnotationMBeanExporter mbeanExporter() {
        AnnotationMBeanExporter exporter = new AnnotationMBeanExporter();
        exporter.setBeans(Map.of("dataExportService", new DataExportService()));
        return exporter;
    }
}
