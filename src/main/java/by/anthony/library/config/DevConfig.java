package by.anthony.library.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.h2.tools.Server;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Profile({"dev", "group_dev"})
@Configuration
@Slf4j
public class DevConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        log.info("Start H2 TCP Server");
        return Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }

}
