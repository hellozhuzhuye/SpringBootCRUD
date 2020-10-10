package top.smartsoftware.springbootcrud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.smartsoftware.springbootcrud.mapper")
public class SpringbootcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootcrudApplication.class, args);
    }

}
