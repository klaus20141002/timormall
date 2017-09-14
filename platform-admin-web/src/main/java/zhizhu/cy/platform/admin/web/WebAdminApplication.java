package zhizhu.cy.platform.admin.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Web admin application.
 *
 * @author zhangxd
 */
@RestController
@SpringBootApplication
@ImportResource("classpath:dubbo-consumer.xml")
public class WebAdminApplication {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WebAdminApplication.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebAdminApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        LOGGER.info("Web admin started!!!");
    }
}
