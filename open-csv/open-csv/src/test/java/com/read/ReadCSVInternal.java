package com.read;

import com.opencsv.CSVReader;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ReadCSVInternal {

    public Map<String, Integer> orgoidCount(List<String> orgoids){
        Map<String, Integer> valuesCount = new HashMap<>();
        for(String orgoid : orgoids){
            if(null == valuesCount.get(orgoid)){
                valuesCount.put(orgoid, 1);
            }else{
                valuesCount.put(orgoid, valuesCount.get(orgoid)+1);
            }

            valuesCount.merge(orgoid, 1, Integer::sum);
        }
        return valuesCount;
    }

    private void printOrgoidsOccuredMoreThanOnce(Map<String, Integer> valuesCount){
        StringBuffer keyValue = new StringBuffer();
        valuesCount.forEach((key,value)->{
            if(value>1){
                log.info("{}-{}", key, value);
                keyValue.append(key).append("-").append(value);
            }
        });
        log.info("keyValue={}", keyValue);
    }

    @SneakyThrows
    @Test
    public void readCsvToList(){
        String[] nextLine;
        final String filePath = "C:\\Work\\email-prod-stats\\13-june-2019\\%s.csv";

        try(CSVReader csvReader = new CSVReader(new FileReader(new File(String.format(filePath, "email-processed-clients"))))){
            List<String> values = new ArrayList<>();
            while (null != (nextLine = csvReader.readNext())){
                values.addAll(Stream.of(nextLine)
                        .filter(line -> StringUtils.isNotBlank(line))
                        .map(value -> value.trim())
                        .collect(Collectors.toList()));
            }

            System.out.println(values.size());
            Map<String, Integer> orgoidCount = orgoidCount(values);
            printOrgoidsOccuredMoreThanOnce(orgoidCount);
        };
    }

    @SneakyThrows
    @Test
    public void readCsvToSet(){
        String[] nextLine;
        final String filePath = "C:\\Work\\email-prod-stats\\13-june-2019\\%s.csv";

        try(CSVReader csvReader = new CSVReader(new FileReader(new File(String.format(filePath, "total-wave-clients"))))){
            Set<String> values = new HashSet<>();
            while (null != (nextLine = csvReader.readNext())){
                 values.addAll(Stream.of(nextLine)
                         .filter(line -> StringUtils.isNotBlank(line))
                         .map(value -> value.trim())
                         .collect(Collectors.toList()));
            }

            System.out.println(values.size());
        };
    }

    @SneakyThrows
    @Test
    public void emailNotProcessedClients(){
        String[] nextLine;
        final String filePath = "C:\\Work\\email-prod-stats\\13-june-2019\\%s.csv";
        Set<String> totalWaveClients = new HashSet<>();
        Set<String> emailProcessedClients = new HashSet<>();
        Set<String> clientsWithoutManagers = new HashSet<>();
        Set<String> emailNotProcessedClients = new HashSet<>();

        // total wave clients
        try(CSVReader csvReader = new CSVReader(new FileReader(new File(String.format(filePath, "total-wave-clients"))))){

            while (null != (nextLine = csvReader.readNext())){
                totalWaveClients.addAll(Stream.of(nextLine)
                        .filter(line -> StringUtils.isNotBlank(line))
                        .map(value -> value.trim())
                        .collect(Collectors.toList()));
            }

            log.info("total-number-of-wave-clients={}",totalWaveClients.size());
        };

        // email processed clients
        try(CSVReader csvReader = new CSVReader(new FileReader(new File(String.format(filePath, "email-processed-clients"))))){

            while (null != (nextLine = csvReader.readNext())){
                emailProcessedClients.addAll(Stream.of(nextLine)
                        .filter(line -> StringUtils.isNotBlank(line))
                        .map(value -> value.trim())
                        .collect(Collectors.toList()));
            }

            log.info("number-of-email-processed-clients={}",emailProcessedClients.size());
        };

        // clients without managers
        try(CSVReader csvReader = new CSVReader(new FileReader(new File(String.format(filePath, "clients-without-managers"))))){

            while (null != (nextLine = csvReader.readNext())){
                clientsWithoutManagers.addAll(Stream.of(nextLine)
                        .filter(line -> StringUtils.isNotBlank(line))
                        .map(value -> value.trim())
                        .collect(Collectors.toList()));
            }

            log.info("clients-without-managers={}",clientsWithoutManagers.size());
        };

        // email not processed clients
        emailNotProcessedClients.addAll(totalWaveClients);
        emailNotProcessedClients.removeAll(emailProcessedClients);
        emailNotProcessedClients.removeAll(clientsWithoutManagers);
        log.info("number-of-email-not-processed-clients={}", emailNotProcessedClients.size());
        emailNotProcessedClients.stream().forEach(System.out::println);
    }

}