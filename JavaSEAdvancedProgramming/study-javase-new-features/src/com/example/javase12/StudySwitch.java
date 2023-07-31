package com.example.javase12;

public class StudySwitch {
    public static void main(String[] args) {

        int weekDay =3;
        String status;
        switch (weekDay){
            case 1://break unutulursa karşılaştırma yapmadan aşağı kadar hepsini çalıştırır
            case 2:
            case 3:
            case 4:
            case 5: status = "working";
                break;
            case 6:
            case 7: status = "resting";
                break;
            default: status = "unknown";
        }

        switch (weekDay){
            case 1,2,3,4,5:status="working";
            break;
            case 6,7: status="resting";
            break;
            // case 1,2,3,4,5 -> { yield "working"}; -> burada da atama yapar ve break yazmamıza gerek kalmaz.
            // case 6,7-> "resting"; // bölyle olduğunda atama statementa dönüşür
            default:status="unknown";
        }
        System.err.println(status);
    }
}
