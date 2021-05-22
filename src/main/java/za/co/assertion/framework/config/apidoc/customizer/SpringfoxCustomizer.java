package za.co.assertion.framework.config.apidoc.customizer;

import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Ntsika Mark Mngoma
 * @created at 19:45:28 on 26 Apr 2021
 **/

/**
 * Callback interface that can be implemented by beans wishing to further customize the
 * {@link springfox.documentation.spring.web.plugins.Docket} in Springfox.
 */
@FunctionalInterface
public interface SpringfoxCustomizer {

    void customize(Docket docket);
}
