package com.tar;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;

import java.io.*;
import java.util.Objects;

@Slf4j
public class UnCompress {

    /**
     * Decompress tar file and display files
     * Create tar file using method @see{{@link Compress#compressToTar()}}
     */
    @Test
    public void decompress(){
        String inputTarFilePath = "C:\\Java-Prep\\practice-projects\\third-party-libraries\\commons-compress\\files\\tar-1.tar";
        String outputDirectoryPath = "C:\\Java-Prep\\practice-projects\\third-party-libraries\\commons-compress\\files\\tar-1-decompress";
        File outputDirectory = new File(outputDirectoryPath);

        try(TarArchiveInputStream tarArchiveInputStream = new TarArchiveInputStream(new FileInputStream(inputTarFilePath))){
            TarArchiveEntry tarArchiveEntry;
            while (Objects.nonNull(tarArchiveEntry = tarArchiveInputStream.getNextTarEntry())){
                if(tarArchiveEntry.isDirectory()){
                    continue;
                }

                File currentFile = new File(outputDirectory, tarArchiveEntry.getName());
                File parent = currentFile.getParentFile();
                if(!parent.exists()){
                    parent.mkdir();
                }
                IOUtils.copy(tarArchiveInputStream, new FileOutputStream(currentFile));
            }
        }catch (IOException e){
            log.error("Error while decompressing tar", e);
        }
    }
}
