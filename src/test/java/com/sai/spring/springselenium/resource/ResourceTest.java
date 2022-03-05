package com.sai.spring.springselenium.resource;

import com.sai.spring.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ResourceTest extends SpringBaseTestNGTest {


    //@Value("file:C:\\Users\\sai93\\Downloads\\Spring_Boot\\spring-selenium\\src\\test\\resources\\data\\testdata.csv")
    @Value("classpath:data/testdata.csv")
    private Resource resource;

    @Value("https://www.google.com/")
    private Resource resource1;

    @Value("https://www.w3.org/TR/PNG/iso_8859-1.txt")
    private Resource resource2;

    @Value("${file.path}/sample.txt")
    private Path path;

    @Value("${file.path}")
    private Path path1;

    @Autowired
    private ResourceLoader resourceLoader;
    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(resource.getFile().toPath())
                .stream()
                .map(s-> s.split(","))
                .toArray(Object[][]::new);

    }
    @Test(dataProvider = "getData")
    public void resourceTest(String url,String saveAs) throws IOException, URISyntaxException {
        Files.readAllLines(resource.getFile().toPath())
                .forEach(System.out::println);


        try(Reader reader = new InputStreamReader(resource1.getInputStream(), StandardCharsets.UTF_8))
        {
            System.out.println(FileCopyUtils.copyToString(reader));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try(Reader reader1 = new InputStreamReader(resource2.getInputStream(), StandardCharsets.UTF_8))
        {
            System.out.println(FileCopyUtils.copyToString(reader1));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        try
        {
          FileCopyUtils.copy(resource2.getInputStream(),Files.newOutputStream(path));
          FileCopyUtils.copy(resourceLoader.getResource(url).getInputStream(),Files.newOutputStream(path1.resolve(saveAs)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }






    }

}
