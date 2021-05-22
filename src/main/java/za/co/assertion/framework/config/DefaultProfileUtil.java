package za.co.assertion.framework.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;

/**
 * @author Ntsika Mark Mngoma
 * @created at 18:51:16 on 26 Apr 2021
 */
public final class DefaultProfileUtil {

    private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";

    private DefaultProfileUtil() {}

    public static void addDefaultProfile(SpringApplication application) {
        Map<String, Object> defineProperties = new HashMap<>();
        defineProperties.put(SPRING_PROFILE_DEFAULT, AssertionConstants.SPRING_PROFILE_DEV);
        application.setDefaultProperties(defineProperties);
    }
}
