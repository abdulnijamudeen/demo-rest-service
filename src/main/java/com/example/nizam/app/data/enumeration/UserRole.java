package com.example.nizam.app.data.enumeration;

public enum UserRole {

    ADMIN("Administrator"), USER("User");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static UserRole roleMatch(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.getRole().equalsIgnoreCase(role)) {
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
