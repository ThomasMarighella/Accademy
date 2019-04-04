package com.company.utils;

import com.company.Vehicle;

public class VehicleUtils {

    private static int lp=0;
    private static final double HPTOKW=0.7457;
    private static final double KWTOHP=1.34102;
    public static void colorChange(Vehicle v, String c){// da fare la verifica del color
        v.setColor(c);
    }
    public static String getNextPlate(){
        lp++;
        return Integer.toString(lp);
    }
    public static double hp2kw(double hp){// 0.7457
        return hp*HPTOKW;
    }
}
