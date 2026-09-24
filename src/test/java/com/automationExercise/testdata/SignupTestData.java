package com.automationExercise.testdata;

public final class SignupTestData {

    private SignupTestData() {
        // Prevent object creation
    }

    // ============================================================
    // Name Validation
    // ============================================================

    public static final String BLANK_NAME =
            "";

    public static final String NAME_REQUIRED_ERROR_MESSAGE =
            "Please fill in this field.";

    // ============================================================
    // Email Validation
    // ============================================================

    public static final String BLANK_EMAIL =
            "";

    public static final String EMAIL_REQUIRED_ERROR_MESSAGE =
            "Please fill in this field.";

    public static final String INVALID_EMAIL_ERROR_MESSAGE =
            "Please include an '@' in the email address.";

    // ============================================================
    // Existing Email Validation
    // ============================================================

    public static final String EXISTING_EMAIL_ERROR_MESSAGE =
            "Email Address already exist!";
}