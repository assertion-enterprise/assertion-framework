package za.co.assertion.framework.web.util;

import java.text.MessageFormat;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Ntsika Mark Mngoma
 * @created at 13:14:03 on 27 Apr 2021
 */
public final class PaginationUtil {

    private static final String HEADER_X_TOTAL_COUNT = "X-Total-Count";
    private static final String HEADER_LINK_FORMAT = "<{0}>; rel=\"{1}\"";

    private PaginationUtil() {}

    /**
     * Generate pagination headers Spring Data {@link Page}
     * @param uriComponentsBuilder The URI builder.
     * @param page The page.
     * @param <T> The type of object.
     * @return {@link HttpHeaders}
     */
    public static <T> HttpHeaders generatePaginationHttpHeaders(UriComponentsBuilder uriComponentsBuilder, Page<T> page) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_X_TOTAL_COUNT, Long.toString(page.getTotalElements()));
        int pageNumber = page.getNumber();
        int pageSize = page.getSize();
        StringBuilder link = new StringBuilder();
        if (pageNumber < page.getTotalPages() - 1) {
            link.append(prepareLink(uriComponentsBuilder, pageNumber + 1, pageSize, "next")).append(",");
        }
        if (pageNumber > 0) {
            link.append(prepareLink(uriComponentsBuilder, pageNumber - 1, pageSize, "prev")).append(",");
        }
        link.append(prepareLink(uriComponentsBuilder, page.getTotalPages() - 1, pageSize, "last")).append(",")
                .append(prepareLink(uriComponentsBuilder, 0, pageSize, "first"));
        headers.add(HttpHeaders.LINK, link.toString());
        return headers;
    }

    private static String prepareLink(UriComponentsBuilder uriBuilder, int pageNumber, int pageSize, String relType) {
        return MessageFormat.format(HEADER_LINK_FORMAT, preparePageUri(uriBuilder, pageNumber, pageSize), relType);
    }

    private static String preparePageUri(UriComponentsBuilder uriBuilder, int pageNumber, int pageSize) {
        return uriBuilder.replaceQueryParam("page", Integer.toString(pageNumber)).replaceQueryParam("size", Integer.toString(pageNumber))
                .toUriString().replace(",", "%2C").replace(";", "%3B");
    }
}
