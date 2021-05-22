package za.co.assertion.framework.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

/**
 * @author Ntsika Mark Mngoma
 * @created at 13:14:03 on 27 Apr 2021
 */
public final class HeaderUtil {


    private static final Logger log = LoggerFactory.getLogger(HeaderUtil.class);

    private HeaderUtil() {}

    /**
     * @param applicationName {@link String}
     * @param message {@link String}
     * @param param {@link String}
     * @return {@link HttpHeaders}
     */
    public static HttpHeaders createAlert(String applicationName, String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-" + applicationName + "-alert", message);
        try {
            headers.add("X-" + applicationName + "-params", URLEncoder.encode(param, StandardCharsets.UTF_8.toString()));
        } catch (UnsupportedEncodingException e) {
            // StandardCharsets are supported by every Java implementation so this exception will never happen.
        }
        return headers;
    }

    /**
     * @param applicationName {@link String}
     * @param enableTranslation {@link Boolean}
     * @param entityName {@link String}
     * @param param {@link String} object.
     * @return a {@link HttpHeaders} object.
     */
    public static HttpHeaders createEntityCreationAlert(String applicationName, boolean enableTranslation, String entityName, String param) {
        String message =
                enableTranslation ? applicationName + "." + entityName + ".created" : "A new" + entityName + "is created with identifier " + param;
        return createAlert(applicationName, message, param);
    }

    /**
     * @param applicationName {@link String}
     * @param enableTranslation a {@link boolean}
     * @param entityName {@link String}
     * @param param {@link String}
     * @return a {@link HttpHeaders} object.
     */
    public static HttpHeaders createEntityUpdateAlert(String applicationName, boolean enableTranslation, String entityName, String param) {
        String message =
                enableTranslation ? applicationName + "." + entityName + ".updated" : "A " + entityName + "is updated with identifier " + param;
        return createAlert(applicationName, message, param);
    }


    /**
     * @param applicationName {@link String}
     * @param enableTranslation {@link Boolean}
     * @param entityName {@link String}
     * @param param {@link String}
     * @return a {@link HttpHeaders } object
     */
    public static HttpHeaders createEntityDeletionAlert(String applicationName, boolean enableTranslation, String entityName, String param) {
        String message =
                enableTranslation ? applicationName + "." + entityName + ".deleted" : "A " + entityName + "is deleted with identifier " + param;
        return createAlert(applicationName, message, param);
    }

    /**
     * @param applicationName {@link String}
     * @param enableTranslation {@link Boolean}
     * @param entityName {@link String}
     * @param errorKey {@link String}
     * @param defaultMessage {@link String}
     * @return {@link HttpHeaders} object.
     */
    public static HttpHeaders createFailureAlert(String applicationName, boolean enableTranslation, String entityName, String errorKey,
            String defaultMessage) {
        log.error("Entity processing failed, {}", defaultMessage);

        String message = enableTranslation ? "error." + errorKey : defaultMessage;

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-" + applicationName + "-error", message);
        headers.add("X-" + applicationName + "-params", entityName);
        return headers;
    }

}
