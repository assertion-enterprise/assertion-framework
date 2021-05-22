package za.co.assertion.framework.web.filter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import za.co.assertion.framework.config.AssertionProperties;

/**
 * @author Ntsika Mark Mngoma
 * @created at 13:14:03 on 27 Apr 2021
 */
public class CachingHttpHeadersFilter implements Filter {

    public static final int DEFAULT_DAYS_TO_LIVE = 1461; // 4 YEARS
    public static final long DEFAULT_SECONDS_TO_LIVE = TimeUnit.DAYS.toMillis(DEFAULT_DAYS_TO_LIVE);
    private long cacheTimeToLive = DEFAULT_SECONDS_TO_LIVE;
    private AssertionProperties assertionProperties;


    public CachingHttpHeadersFilter(AssertionProperties assertionProperties) {
        this.assertionProperties = assertionProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        cacheTimeToLive = TimeUnit.DAYS.toMillis(assertionProperties.getHttp().getCache().getTimeToLiveInDays());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
        // Nothing to destroy
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setHeader("Cache-Control", "max-age=" + cacheTimeToLive + ", public");
        httpResponse.setHeader("Pragma", "cache");

        // Setting expires header for proxy caching
        httpResponse.setDateHeader("Expires", cacheTimeToLive + System.currentTimeMillis());
        chain.doFilter(request, response);
    }

}
