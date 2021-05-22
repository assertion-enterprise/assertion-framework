package za.co.assertion.framework.config.apidoc.customizer;

import org.springframework.core.Ordered;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Server;
import springfox.documentation.spring.web.plugins.Docket;
import za.co.assertion.framework.config.AssertionProperties;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Ntsika Mark Mngoma
 * @created at 19:46:16 on 26 Apr 2021
 **/
public class AssertionSpringfoxCustomizer implements SpringfoxCustomizer, Ordered {

    /**
     * The default order for the customizer.
     */
    public static final int DEFAULT_ORDER = 0;

    private int order = DEFAULT_ORDER;

    private final AssertionProperties.ApiDocs properties;

    /**
     * <p>
     * Constructor for AssertionSpringfoxCustomizer.
     * </p>
     *
     * @param properties a {@link AssertionProperties.ApiDocs} object.
     */
    public AssertionSpringfoxCustomizer(AssertionProperties.ApiDocs properties) {
        this.properties = properties;
    }

    /** {@inheritDoc} */
    @Override
    public void customize(Docket docket) {
        Contact contact = new Contact(properties.getContactName(), properties.getContactUrl(), properties.getContactEmail());

        ApiInfo apiInfo = new ApiInfo(properties.getTitle(), properties.getDescription(), properties.getVersion(), properties.getTermsOfServiceUrl(),
                contact, properties.getLicense(), properties.getLicenseUrl(), new ArrayList<>());

        for (AssertionProperties.ApiDocs.Server server : properties.getServers()) {
            docket.servers(new Server(server.getName(), server.getUrl(), server.getDescription(), Collections.emptyList(), Collections.emptyList()));
        }

        docket.host(properties.getHost()).protocols(new HashSet<>(Arrays.asList(properties.getProtocols()))).apiInfo(apiInfo)
                .useDefaultResponseMessages(properties.isUseDefaultResponseMessages()).forCodeGeneration(true)
                .directModelSubstitute(ByteBuffer.class, String.class).genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Pageable.class).ignoredParameterTypes(ServerHttpRequest.class).select()
                .paths(regex(properties.getDefaultIncludePattern())).build();
    }

    /**
     * <p>
     * Setter for the field <code>order</code>.
     * </p>
     *
     * @param order a int.
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /** {@inheritDoc} */
    @Override
    public int getOrder() {
        return order;
    }

}
