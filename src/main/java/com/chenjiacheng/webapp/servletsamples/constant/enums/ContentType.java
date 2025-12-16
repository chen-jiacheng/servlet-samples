package com.chenjiacheng.webapp.servletsamples.constant.enums;

/**
 * Created by chenjiacheng on 2025/2/16 23:39
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public enum ContentType {
    APPLICATION_JSON("application/json"),
    TEXT_HTML("text/html"),
    TEXT_PLAIN("text/plain"),
    APPLICATION_XML("application/xml"),
    TEXT_XML("text/xml"),
    APPLICATION_PDF("application/pdf"),
    APPLICATION_ZIP("application/zip"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG("image/png"),
    IMAGE_GIF("image/gif"),
    IMAGE_SVG_XML("image/svg+xml"),
    TEXT_CSS("text/css"),
    TEXT_JAVASCRIPT("application/javascript"),
    APPLICATION_JAVASCRIPT("application/javascript"),
    OCTET_STREAM("application/octet-stream");

    private final String mimeType;

    ContentType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getValue() {
        return this.mimeType;
    }

    @Override
    public String toString() {
        return this.mimeType;
    }

    // Example usage:
    // To get the MIME type string: ContentType.APPLICATION_JSON.getValue()
    // Output: "application/json"
}