
package project.theory;


public class AdminVerification {
    public static boolean verifyAdminID(int adminID) {
        return String.valueOf(adminID).matches("\\d{8}");
    }
}
