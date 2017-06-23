package com.github.cekmorse.api.util;

/**
 * Created by keith on 6/22/17.
 */
public interface HttpConstants
{
    String ACCEPT = "Accept";
    String CONTENT_TYPE = "Content-Type";
    String IF_DELETED_SINCE = "If-Deleted-Since";
    String IF_MODIFIED_SINCE = "If-Modified-Since";
    String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
    String LOCATION = "Location";
    String LAST_MODIFIED = "Last-Modified";

    String HEADER_DATE_FORMAT = "E, dd MMM yyyy HH:mm:ss z";
    String HEADER_DATE_FORMAT_TIMEZONE = "GMT";
    String HEADER_AUTHORIZATION = "Authorization";
}
