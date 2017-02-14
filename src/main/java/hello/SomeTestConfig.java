package hello;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SomeTestConfig {

    private String value;

    private String other;
}
