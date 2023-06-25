package com.sugiartha.juniorandroid;

public class HitungBMI {

    public double hitungBMI(double beratBadan, double tinggiBadan){
        double tinggim = tinggiBadan*0.01;
        return beratBadan/(tinggim*tinggim);
    }
    public String statusBMI(double beratBadan, double tinggiBadan){
        String statusBadan;
        double BMI = hitungBMI(beratBadan, tinggiBadan);
        if(BMI<18.5){
            statusBadan = "Anda kekurangan berat badan";
        } else if(BMI>=18.5 && BMI<=22.9){
            statusBadan = "Berat badan anda normal (ideal)";
        } else if(BMI>=23 && BMI<=24.9){
            statusBadan = "Anda beresiko kelebihan berat badan";
        } else if(BMI>=25 && BMI<=29.9){
            statusBadan = "Anda kelebihan berat badan";
        }else {
            statusBadan = "Anda kegemukan (obesitas)";
        }
        return statusBadan;
    }


}
