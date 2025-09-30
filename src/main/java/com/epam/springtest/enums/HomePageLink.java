package com.epam.springtest.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HomePageLink {
    AB_TESTING("/abtest", "A/B Testing"),
    ADD_REMOVE_ELEMENTS("/add_remove_elements/", "Add/Remove Elements"),
    BASIC_AUTH("/basic_auth", "Basic Auth"),
    BROKEN_IMAGES("/broken_images", "Broken Images"),
    CHALLENGING_DOM("/challenging_dom", "Challenging DOM"),
    CHECKBOXES("/checkboxes", "Checkboxes"),
    CONTEXT_MENU("/context_menu", "Context Menu"),
    DIGEST_AUTH("/digest_auth", "Digest Authentication"),
    DISAPPEARING_ELEMENTS("/disappearing_elements", "Disappearing Elements"),
    DRAG_AND_DROP("/drag_and_drop", "Drag and Drop"),
    DROPDOWN("/dropdown", "Dropdown"),
    DYNAMIC_CONTENT("/dynamic_content", "Dynamic Content"),
    DYNAMIC_CONTROLS("/dynamic_controls", "Dynamic Controls"),
    DYNAMIC_LOADING("/dynamic_loading", "Dynamic Loading"),
    ENTRY_AD("/entry_ad", "Entry Ad"),
    EXIT_INTENT("/exit_intent", "Exit Intent"),
    FILE_DOWNLOAD("/download", "File Download"),
    FILE_UPLOAD("/upload", "File Upload"),
    FLOATING_MENU("/floating_menu", "Floating Menu"),
    FORGOT_PASSWORD("/forgot_password", "Forgot Password"),
    FORM_AUTHENTICATION("/login", "Form Authentication"),
    FRAMES("/frames", "Frames"),
    GEOLOCATION("/geolocation", "Geolocation"),
    HORIZONTAL_SLIDER("/horizontal_slider", "Horizontal Slider"),
    HOVERS("/hovers", "Hovers"),
    INFINITE_SCROLL("/infinite_scroll", "Infinite Scroll"),
    INPUTS("/inputs", "Inputs"),
    JQUERY_UI_MENUS("/jqueryui/menu", "JQuery UI Menus"),
    JAVASCRIPT_ALERTS("/javascript_alerts", "JavaScript Alerts"),
    JAVASCRIPT_ERROR("/javascript_error", "JavaScript onload event error"),
    KEY_PRESSES("/key_presses", "Key Presses"),
    LARGE_DEEP_DOM("/large", "Large & Deep DOM"),
    MULTIPLE_WINDOWS("/windows", "Multiple Windows"),
    NESTED_FRAMES("/nested_frames", "Nested Frames"),
    NOTIFICATION_MESSAGES("/notification_message", "Notification Messages"),
    REDIRECT_LINK("/redirector", "Redirect Link"),
    SECURE_FILE_DOWNLOAD("/download_secure", "Secure File Download"),
    SHADOW_DOM("/shadowdom", "Shadow DOM"),
    SHIFTING_CONTENT("/shifting_content", "Shifting Content"),
    SLOW_RESOURCES("/slow", "Slow Resources"),
    SORTABLE_DATA_TABLES("/tables", "Sortable Data Tables"),
    STATUS_CODES("/status_codes", "Status Codes"),
    TYPOS("/typos", "Typos"),
    WYSIWYG_EDITOR("/tinymce", "WYSIWYG Editor");

    private final String path;
    private final String altText;
}
