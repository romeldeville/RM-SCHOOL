package rmschoolapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "file:../../RM-ENV/rm-school-api.env", ignoreResourceNotFound = false)
public class EnvironmentConfig {
}
