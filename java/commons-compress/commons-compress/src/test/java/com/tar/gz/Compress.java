package com.tar.gz;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class Compress {

    /**
     * Create tar file named tar-1.tar with files 1.txt, 1.docx, 1.xlsx
     */
    @Test
    public void compressToTar(){
        try{
            String tarFileName = "C:\\Java-Prep\\practice-projects\\third-party-libraries\\commons-compress\\files\\tar-1.tar.gz";

            // create TarArchiveOutputStream
            TarArchiveOutputStream tarArchiveOutputStream = new TarArchiveOutputStream(new GzipCompressorOutputStream(new FileOutputStream(tarFileName)));

            // TAR has an 8 gig file limit by default, this gets around that
            tarArchiveOutputStream.setBigNumberMode(TarArchiveOutputStream.BIGNUMBER_STAR);

            // TAR originally didn't support long file names, so enable the support for it
            tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
            tarArchiveOutputStream.setAddPaxHeadersForNonAsciiNames(true);

            List<String> filePaths = new ArrayList<>();
            filePaths.add("C:\\Java-Prep\\practice-projects\\third-party-libraries\\commons-compress\\files\\1.txt");
            filePaths.add("C:\\Java-Prep\\practice-projects\\third-party-libraries\\commons-compress\\files\\1.docx");
            filePaths.add("C:\\Java-Prep\\practice-projects\\third-party-libraries\\commons-compress\\files\\1.xlsx");
            String dir = ".";

            for(String filePath : filePaths){
                File file = new File(filePath);
                addFilesToTar(tarArchiveOutputStream, file, dir);
            }
        }catch(Exception e){
            log.error("Error while prepare tar file", e);
        }
    }

    private void addFilesToTar(TarArchiveOutputStream tarArchiveOutputStream, File file, String dir){
        String entry = dir + File.separator + file.getName();
        try{
            if(file.isFile()){
                tarArchiveOutputStream.putArchiveEntry(new TarArchiveEntry(file, entry));
                try(FileInputStream fis = new FileInputStream(file)){
                    IOUtils.copy(fis, tarArchiveOutputStream);
                }
            }else if(file.isDirectory()){
                File[] children = file.listFiles();
                if(Objects.nonNull(children)){
                    for(File child: children){
                        addFilesToTar(tarArchiveOutputStream, child, dir);
                    }
                }
            }else{
                log.error("{} file name is not supported", file.getName());
            }
        }catch (IOException e){
            log.error("Exception while adding file to tar", e);
        }
    }

}
