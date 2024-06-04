/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.theory;

/**
 *
 * @author Dell
 */
public class AdminVerification {
    public static boolean verifyAdminID(int adminID) {
        return String.valueOf(adminID).matches("\\d{8}");
    }
}
