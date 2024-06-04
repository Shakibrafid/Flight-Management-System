/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.theory;

/**
 *
 * @author Dell
 */
public class UserVerification {
    public static boolean verifyUserID(int userID) {
        return String.valueOf(userID).matches("\\d{8}");
    }
}
