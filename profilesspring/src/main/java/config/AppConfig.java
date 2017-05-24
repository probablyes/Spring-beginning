package config;

import configprofiles.DevProfile;
import configprofiles.ProdProfile;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HP on 21.04.2017.
 */
public class AppConfig{

    @Bean
    @DevProfile
    public DatabaseDatasource getH2Database(){
        return (() -> Arrays.asList("KasiaTest", "BartekTest", "AniaTest", "KrzychuTest"));
    }

    @Bean
    @ProdProfile
    public DatabaseDatasource getMySQLDatabase(){
        return new DatabaseDatasource() {
            @Override
            public List<String> getDatabase() {
                try {
                    Path filePath = new File(getClass().getResource("/data.txt").toURI()).toPath();
                    List<String> allLines = Files.readAllLines(filePath);
                    return allLines;
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
                return new ArrayList<>();
            }
            };

        }
}
