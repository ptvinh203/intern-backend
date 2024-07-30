package com.ptvinh203.internbackend.util.constant;

public final class ErrorMessageConstant {

    public static final String INTERNAL_SERVER_ERROR_CODE = "ERR_SER0101";
    public static final String BAD_REQUEST_ERROR_CODE = "ERR_SER0102";

    /*
        Common
    */
    public static final String INTERNAL_SERVER_ERROR = "internal_server_error";
    public static final String PAGE_NOT_FOUND = "page_not_found";
    public static final String FORBIDDEN = "forbidden";
    public static final String UNAUTHORIZED = "unauthorized";
    public static final String REQUIRED_BODY_IN_REQUEST = "required_body_in_request";
    public static final String INVALID_UUID = "invalid_uuid";
    public static final String INVALID_ENUM = "invalid_enum";


    /*
        Authentication
    */
    public static final String INVALID_TOKEN = "invalid_token";
    public static final String EXPIRED_TOKEN = "expired_token";
    public static final String REVOKED_TOKEN = "revoked_token";
    public static final String INVALID_REFRESH_TOKEN = "invalid_refresh_token";
    public static final String EXPIRED_REFRESH_TOKEN = "expired_refresh_token";
    public static final String REVOKED_REFRESH_TOKEN = "revoked_refresh_token";
    public static final String REFRESH_TOKEN_NOT_FOUND = "refresh_token_not_found";
    public static final String ACCOUNT_IS_ACTIVE = "account_is_active";
    public static final String ACCOUNT_IS_NOT_ACTIVE = "account_is_not_active";
    public static final String RESET_PASSWORD_CODE_INVALID = "reset_password_code_invalid";
    public static final String RESET_PASSWORD_CODE_EXPIRED = "reset_password_code_expired";

    /*
        Permission
    */
    public static final String PERMISSION_NOT_FOUND = "permission_not_found";
    public static final String PERMISSION_IS_REQUIRE = "permission_is_require";

    /*
        Account
    */
    public static final String ACCOUNT_NOT_FOUND = "account_not_found";
    public static final String INCORRECT_EMAIL_OR_PASSWORD = "incorrect_email_or_password";
    public static final String ACCOUNT_IS_DISABLED = "account_is_disabled";
    public static final String ACCOUNT_ID_IS_REQUIRED = "account_id_is_required";

    private ErrorMessageConstant() {
    }
}
