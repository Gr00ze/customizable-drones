package com.grooze.drone.util;

public class MyMathHelper {

    /**The player head yaw range is different from Client and Server
     * On Server is limited from -180 to 180
     * On Client is unlimited
     * So this method is useful to have the same variable on both C & S
     **/
    public static double normalizeCSPlayerHeadYawDegrees(double degrees){
        return (degrees + 180) % 360 - 180;
    }
}
