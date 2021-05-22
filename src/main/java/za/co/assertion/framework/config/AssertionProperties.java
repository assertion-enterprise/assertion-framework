package za.co.assertion.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.cors.CorsConfiguration;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Ntsika Mark Mngoma
 * @created at 18:59:50 on 26 Apr 2021
 */

@ConfigurationProperties(prefix = "assertion", ignoreUnknownFields = false)
@PropertySources({@PropertySource(value = "classpath:git.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:META-INF/build-info.properties", ignoreResourceNotFound = true)})
public class AssertionProperties {

    private final Async async = new Async();

    private final Http http = new Http();

    private final Database database = new Database();

    private final Cache cache = new Cache();

    private final Mail mail = new Mail();

    private final Security security = new Security();

    private final ApiDocs apiDocs = new ApiDocs();

    private final Logging logging = new Logging();

    private final CorsConfiguration cors = new CorsConfiguration();

    private final Social social = new Social();

    private final Gateway gateway = new Gateway();

    private final Registry registry = new Registry();

    private final ClientApp clientApp = new ClientApp();

    private final AuditEvents auditEvents = new AuditEvents();

    /**
     * <p>
     * Getter for the field <code>async</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.Async} object.
     */
    public Async getAsync() {
        return async;
    }

    /**
     * <p>
     * Getter for the field <code>http</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.Http} object.
     */
    public Http getHttp() {
        return http;
    }

    /**
     * <p>
     * Getter for the field <code>database</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.Database} object.
     */
    public Database getDatabase() {
        return database;
    }

    /**
     * <p>
     * Getter for the field <code>cache</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.Cache} object.
     */
    public Cache getCache() {
        return cache;
    }

    /**
     * <p>
     * Getter for the field <code>mail</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.Mail} object.
     */
    public Mail getMail() {
        return mail;
    }

    /**
     * <p>
     * Getter for the field <code>registry</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.Registry} object.
     */
    public Registry getRegistry() {
        return registry;
    }

    /**
     * <p>
     * Getter for the field <code>security</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.Security} object.
     */
    public Security getSecurity() {
        return security;
    }

    /**
     * <p>
     * Getter for the field <code>api-docs</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.ApiDocs} object.
     */
    public ApiDocs getApiDocs() {
        return apiDocs;
    }

    /**
     * <p>
     * Getter for the field <code>logging</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.Logging} object.
     */
    public Logging getLogging() {
        return logging;
    }

    /**
     * <p>
     * Getter for the field <code>cors</code>.
     * </p>
     *
     * @return a {@link org.springframework.web.cors.CorsConfiguration} object.
     */
    public CorsConfiguration getCors() {
        return cors;
    }

    /**
     * <p>
     * Getter for the field <code>social</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.Social} object.
     */
    public Social getSocial() {
        return social;
    }

    /**
     * <p>
     * Getter for the field <code>gateway</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.Gateway} object.
     */
    public Gateway getGateway() {
        return gateway;
    }

    /**
     * <p>
     * Getter for the field <code>clientApp</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.ClientApp} object.
     */
    public ClientApp getClientApp() {
        return clientApp;
    }

    /**
     * <p>
     * Getter for the field <code>auditEvents</code>.
     * </p>
     *
     * @return a {@link AssertionProperties.AuditEvents} object.
     */
    public AuditEvents getAuditEvents() {
        return auditEvents;
    }

    public static class Async {

        private int corePoolSize = AssertionDefaults.Async.corePoolSize;

        private int maxPoolSize = AssertionDefaults.Async.maxPoolSize;

        private int queueCapacity = AssertionDefaults.Async.queueCapacity;

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }

    public static class Http {

        private final Cache cache = new Cache();

        public Cache getCache() {
            return cache;
        }

        public static class Cache {

            private int timeToLiveInDays = AssertionDefaults.Http.Cache.timeToLiveInDays;

            public int getTimeToLiveInDays() {
                return timeToLiveInDays;
            }

            public void setTimeToLiveInDays(int timeToLiveInDays) {
                this.timeToLiveInDays = timeToLiveInDays;
            }
        }
    }

    public static class Database {

        private final Couchbase couchbase = new Couchbase();

        public Couchbase getCouchbase() {
            return couchbase;
        }

        public static class Couchbase {

            private String bucketName;

            public String getBucketName() {
                return bucketName;
            }

            public Couchbase setBucketName(String bucketName) {
                this.bucketName = bucketName;
                return this;
            }
        }
    }

    public static class Cache {

        private final Hazelcast hazelcast = new Hazelcast();

        private final Redis redis = new Redis();

        public Hazelcast getHazelcast() {
            return hazelcast;
        }

        public Redis getRedis() {
            return redis;
        }

        public static class Hazelcast {

            private int timeToLiveSeconds = AssertionDefaults.Cache.Hazelcast.timeToLiveSeconds;

            private int backupCount = AssertionDefaults.Cache.Hazelcast.backupCount;

            public int getTimeToLiveSeconds() {
                return timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public int getBackupCount() {
                return backupCount;
            }

            public void setBackupCount(int backupCount) {
                this.backupCount = backupCount;
            }
        }

        public static class Redis {

            private String[] server = AssertionDefaults.Cache.Redis.server;
            private int expiration = AssertionDefaults.Cache.Redis.expiration;
            private boolean cluster = AssertionDefaults.Cache.Redis.cluster;
            private int connectionPoolSize = AssertionDefaults.Cache.Redis.connectionPoolSize;
            private int connectionMinimumIdleSize = AssertionDefaults.Cache.Redis.connectionMinimumIdleSize;
            private int subscriptionConnectionPoolSize = AssertionDefaults.Cache.Redis.subscriptionConnectionPoolSize;
            private int subscriptionConnectionMinimumIdleSize = AssertionDefaults.Cache.Redis.subscriptionConnectionMinimumIdleSize;

            public String[] getServer() {
                return server;
            }

            public void setServer(String[] server) {
                this.server = server;
            }

            public int getExpiration() {
                return expiration;
            }

            public void setExpiration(int expiration) {
                this.expiration = expiration;
            }

            public boolean isCluster() {
                return cluster;
            }

            public void setCluster(boolean cluster) {
                this.cluster = cluster;
            }

            public int getConnectionPoolSize() {
                return connectionPoolSize;
            }

            public Redis setConnectionPoolSize(int connectionPoolSize) {
                this.connectionPoolSize = connectionPoolSize;
                return this;
            }

            public int getConnectionMinimumIdleSize() {
                return connectionMinimumIdleSize;
            }

            public Redis setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
                this.connectionMinimumIdleSize = connectionMinimumIdleSize;
                return this;
            }

            public int getSubscriptionConnectionPoolSize() {
                return subscriptionConnectionPoolSize;
            }

            public Redis setSubscriptionConnectionPoolSize(int subscriptionConnectionPoolSize) {
                this.subscriptionConnectionPoolSize = subscriptionConnectionPoolSize;
                return this;
            }

            public int getSubscriptionConnectionMinimumIdleSize() {
                return subscriptionConnectionMinimumIdleSize;
            }

            public Redis setSubscriptionConnectionMinimumIdleSize(int subscriptionConnectionMinimumIdleSize) {
                this.subscriptionConnectionMinimumIdleSize = subscriptionConnectionMinimumIdleSize;
                return this;
            }
        }
    }

    public static class Mail {

        private boolean enabled = AssertionDefaults.Mail.enabled;

        private String from = AssertionDefaults.Mail.from;

        private String baseUrl = AssertionDefaults.Mail.baseUrl;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }

    public static class Security {

        private String contentSecurityPolicy = AssertionDefaults.Security.contentSecurityPolicy;

        private final ClientAuthorization clientAuthorization = new ClientAuthorization();

        private final Authentication authentication = new Authentication();

        private final RememberMe rememberMe = new RememberMe();

        private final OAuth2 oauth2 = new OAuth2();

        public ClientAuthorization getClientAuthorization() {
            return clientAuthorization;
        }

        public Authentication getAuthentication() {
            return authentication;
        }

        public RememberMe getRememberMe() {
            return rememberMe;
        }

        public OAuth2 getOauth2() {
            return oauth2;
        }

        public String getContentSecurityPolicy() {
            return contentSecurityPolicy;
        }

        public void setContentSecurityPolicy(String contentSecurityPolicy) {
            this.contentSecurityPolicy = contentSecurityPolicy;
        }

        public static class ClientAuthorization {

            private String accessTokenUri = AssertionDefaults.Security.ClientAuthorization.accessTokenUri;

            private String tokenServiceId = AssertionDefaults.Security.ClientAuthorization.tokenServiceId;

            private String clientId = AssertionDefaults.Security.ClientAuthorization.clientId;

            private String clientSecret = AssertionDefaults.Security.ClientAuthorization.clientSecret;

            public String getAccessTokenUri() {
                return accessTokenUri;
            }

            public void setAccessTokenUri(String accessTokenUri) {
                this.accessTokenUri = accessTokenUri;
            }

            public String getTokenServiceId() {
                return tokenServiceId;
            }

            public void setTokenServiceId(String tokenServiceId) {
                this.tokenServiceId = tokenServiceId;
            }

            public String getClientId() {
                return clientId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public String getClientSecret() {
                return clientSecret;
            }

            public void setClientSecret(String clientSecret) {
                this.clientSecret = clientSecret;
            }
        }

        public static class Authentication {

            private final Jwt jwt = new Jwt();

            public Jwt getJwt() {
                return jwt;
            }

            public static class Jwt {

                private String secret = AssertionDefaults.Security.Authentication.Jwt.secret;

                private String base64Secret = AssertionDefaults.Security.Authentication.Jwt.base64Secret;

                private long tokenValidityInSeconds = AssertionDefaults.Security.Authentication.Jwt.tokenValidityInSeconds;

                private long tokenValidityInSecondsForRememberMe = AssertionDefaults.Security.Authentication.Jwt.tokenValidityInSecondsForRememberMe;

                public String getSecret() {
                    return secret;
                }

                public void setSecret(String secret) {
                    this.secret = secret;
                }

                public String getBase64Secret() {
                    return base64Secret;
                }

                public void setBase64Secret(String base64Secret) {
                    this.base64Secret = base64Secret;
                }

                public long getTokenValidityInSeconds() {
                    return tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                public long getTokenValidityInSecondsForRememberMe() {
                    return tokenValidityInSecondsForRememberMe;
                }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }

        public static class RememberMe {

            @NotNull
            private String key = AssertionDefaults.Security.RememberMe.key;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }

        public static class OAuth2 {

            private List<String> audience = new ArrayList<>();

            public List<String> getAudience() {
                return Collections.unmodifiableList(audience);
            }

            public void setAudience(@NotNull List<String> audience) {
                this.audience.addAll(audience);
            }
        }
    }

    public static class ApiDocs {

        private String title = AssertionDefaults.ApiDocs.title;

        private String description = AssertionDefaults.ApiDocs.description;

        private String version = AssertionDefaults.ApiDocs.version;

        private String termsOfServiceUrl = AssertionDefaults.ApiDocs.termsOfServiceUrl;

        private String contactName = AssertionDefaults.ApiDocs.contactName;

        private String contactUrl = AssertionDefaults.ApiDocs.contactUrl;

        private String contactEmail = AssertionDefaults.ApiDocs.contactEmail;

        private String license = AssertionDefaults.ApiDocs.license;

        private String licenseUrl = AssertionDefaults.ApiDocs.licenseUrl;

        private String defaultIncludePattern = AssertionDefaults.ApiDocs.defaultIncludePattern;

        private String managementIncludePattern = AssertionDefaults.ApiDocs.managementIncludePattern;

        private String host = AssertionDefaults.ApiDocs.host;

        private String[] protocols = AssertionDefaults.ApiDocs.protocols;

        private Server[] servers = {};

        private boolean useDefaultResponseMessages = AssertionDefaults.ApiDocs.useDefaultResponseMessages;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactUrl() {
            return contactUrl;
        }

        public void setContactUrl(String contactUrl) {
            this.contactUrl = contactUrl;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }

        public String getDefaultIncludePattern() {
            return defaultIncludePattern;
        }

        public void setDefaultIncludePattern(String defaultIncludePattern) {
            this.defaultIncludePattern = defaultIncludePattern;
        }

        public String getManagementIncludePattern() {
            return managementIncludePattern;
        }

        public void setManagementIncludePattern(String managementIncludePattern) {
            this.managementIncludePattern = managementIncludePattern;
        }

        public String getHost() {
            return host;
        }

        public void setHost(final String host) {
            this.host = host;
        }

        public String[] getProtocols() {
            return protocols;
        }

        public void setProtocols(final String[] protocols) {
            this.protocols = protocols;
        }

        public Server[] getServers() {
            return servers;
        }

        public void setServers(final Server[] servers) {
            this.servers = servers;
        }

        public boolean isUseDefaultResponseMessages() {
            return useDefaultResponseMessages;
        }

        public void setUseDefaultResponseMessages(final boolean useDefaultResponseMessages) {
            this.useDefaultResponseMessages = useDefaultResponseMessages;
        }

        public static class Server {

            private String name;
            private String url;
            private String description;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }

    public static class Logging {

        private boolean useJsonFormat = AssertionDefaults.Logging.useJsonFormat;

        private final Logstash logstash = new Logstash();

        public boolean isUseJsonFormat() {
            return useJsonFormat;
        }

        public void setUseJsonFormat(boolean useJsonFormat) {
            this.useJsonFormat = useJsonFormat;
        }

        public Logstash getLogstash() {
            return logstash;
        }

        public static class Logstash {

            private boolean enabled = AssertionDefaults.Logging.Logstash.enabled;

            private String host = AssertionDefaults.Logging.Logstash.host;

            private int port = AssertionDefaults.Logging.Logstash.port;

            private int queueSize = AssertionDefaults.Logging.Logstash.queueSize;

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public int getPort() {
                return port;
            }

            public void setPort(int port) {
                this.port = port;
            }

            public int getQueueSize() {
                return queueSize;
            }

            public void setQueueSize(int queueSize) {
                this.queueSize = queueSize;
            }
        }
    }

    public static class Social {

        private String redirectAfterSignIn = AssertionDefaults.Social.redirectAfterSignIn;

        public String getRedirectAfterSignIn() {
            return redirectAfterSignIn;
        }

        public void setRedirectAfterSignIn(String redirectAfterSignIn) {
            this.redirectAfterSignIn = redirectAfterSignIn;
        }
    }

    public static class Gateway {

        private final RateLimiting rateLimiting = new RateLimiting();

        public RateLimiting getRateLimiting() {
            return rateLimiting;
        }

        private Map<String, List<String>> authorizedMicroservicesEndpoints = AssertionDefaults.Gateway.authorizedMicroservicesEndpoints;

        public Map<String, List<String>> getAuthorizedMicroservicesEndpoints() {
            return authorizedMicroservicesEndpoints;
        }

        public void setAuthorizedMicroservicesEndpoints(Map<String, List<String>> authorizedMicroservicesEndpoints) {
            this.authorizedMicroservicesEndpoints = authorizedMicroservicesEndpoints;
        }

        public static class RateLimiting {

            private boolean enabled = AssertionDefaults.Gateway.RateLimiting.enabled;

            private long limit = AssertionDefaults.Gateway.RateLimiting.limit;

            private int durationInSeconds = AssertionDefaults.Gateway.RateLimiting.durationInSeconds;

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public long getLimit() {
                return this.limit;
            }

            public void setLimit(long limit) {
                this.limit = limit;
            }

            public int getDurationInSeconds() {
                return durationInSeconds;
            }

            public void setDurationInSeconds(int durationInSeconds) {
                this.durationInSeconds = durationInSeconds;
            }
        }
    }

    public static class Registry {

        private String password = AssertionDefaults.Registry.password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class ClientApp {

        private String name = AssertionDefaults.ClientApp.name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class AuditEvents {

        private int retentionPeriod = AssertionDefaults.AuditEvents.retentionPeriod;

        public int getRetentionPeriod() {
            return retentionPeriod;
        }

        public void setRetentionPeriod(int retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
        }
    }
}

