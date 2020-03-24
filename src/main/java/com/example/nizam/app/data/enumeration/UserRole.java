package com.example.nizam.app.data.enumeration;

public enum UserRole {

    ADMIN("ROLE_ADMINISTRATOR", "Administrator"),
    USER("ROLE_USER", "User");

    private String role;
    private String display;

    UserRole(String role, String display) {
        this.role = role;
        this.display = display;
    }

    public String getRole() {
        return role;
    }

    public String getDisplay() {
        return display;
    }

    public static UserRole roleMatch(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.getRole().equalsIgnoreCase(role)) {
                return userRole;
            }
        }
        return USER;
    }

    public static UserRole displayMatch(String display) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.getDisplay().equalsIgnoreCase(display)) {
                return userRole;
            }
        }
        return USER;
    }

    @Override
    public String toString() {
        return "UserRole values - "
        + ADMIN.getRole() + " "
        + USER.getRole();
    }


}
