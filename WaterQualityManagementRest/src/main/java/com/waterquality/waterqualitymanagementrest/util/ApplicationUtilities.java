package com.waterquality.waterqualitymanagementrest.util;

public class ApplicationUtilities {
    public static boolean performEvaluation(String parameter, Double value) {

        if(parameter.equals("pH")) { //: 6.5 < value < 8.5
            if(value >= 6.5 && value <= 8.5) {
                return true;
            } else {
                return false;
            }
        }
        else if(parameter.equals("Ba")) { //value < 2.0 mh/L
            if(value <= 2.0) {
                return true;
            } else {
                return false;
            }
        }
        else if(parameter.equals("Cu")) { //value < 1.3 mg/
            if(value <= 1.3) {
                return true;
            } else {
                return false;
            }
        }
        else if(parameter.equals("Virus")) { //0 : true 1: false
            return value == 0 ? true : false;
        }
        else if(parameter.equals("Fe")) { //: value < 0.3 mg/L
            if(value <= 0.3) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}