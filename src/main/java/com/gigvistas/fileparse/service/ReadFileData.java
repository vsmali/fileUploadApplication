package com.gigvistas.fileparse.service;

import com.gigvistas.fileparse.exception.MyCustomException;
import com.gigvistas.fileparse.model.EmployeeDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadFileData {

    @Value("${file.upload.location}")
    private String filePath;

    static String currentline;
    public static Logger logger = LogManager.getLogger(ReadFileData.class);

    public List<EmployeeDto> dataReadFile(@RequestParam("file") MultipartFile file) throws IOException {
        Path filename = Paths.get(filePath + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
        Files.copy(file.getInputStream(), filename, StandardCopyOption.REPLACE_EXISTING);
        List<EmployeeDto> user = new ArrayList<>();
        BufferedReader br = null;
        logger.debug("Read the records from the file");
        try {
            br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        } catch (FileNotFoundException e) {
            logger.error("Error: file not found and entered file is " +e.getMessage());
            System.exit(0);
        }
        int count=1;
        while ((currentline = br.readLine()) != null ) {
            String[] column = currentline.split(",");
            if (column[0].equals("usercode")) {
                count++;
                continue;
            }
            try {
                if(column.length < 5 || column[4].isEmpty()) {
                    throw new MyCustomException("Not enough data at " +count+ "rd row & 5th column ");
                }
                else if(column[0].isEmpty()){
                    throw new MyCustomException("Not enough data at " +count+ "rd row & 1th column");
                }
                else if(column[1].isEmpty()){
                    throw new MyCustomException("Not enough data at " +count+ "rd row & 2th column");
                }
                else if(column[2].isEmpty()){
                    throw new MyCustomException("Not enough data at " +count+ "rd row & 3th column");
                }
                else if(column[3].isEmpty()){
                    throw new MyCustomException("Not enough data at " +count+ "rd row & 4th column");
                }
                else {
                    String usercode = column[0];
                    String name = column[1];
                    int jobs_completed = Integer.parseInt(column[2]);
                    String preffered_location = column[3];
                    Boolean inactive = Boolean.parseBoolean(column[4]);
                    user.add(new EmployeeDto(usercode, name, jobs_completed, preffered_location, inactive));
                }
            }
            catch (Exception e){
                logger.error(" Error while reading the file. "+e.getMessage());
            }
            count++;
        }
        System.out.println(user);
        return user;
    }

}
