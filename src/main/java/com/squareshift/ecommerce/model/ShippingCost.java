package com.squareshift.ecommerce.model;

public class ShippingCost {

    /* Find Value for given Weight */
    private int findRow(int weight){
        int row = -1;
        if(weight < 2){
            row = 0;
        }else if(weight > 2.01 && weight < 5){
            row = 1;
        }else if(weight > 5.01 && weight < 20){
            row = 2;
        }else if(weight > 20.01){
            row = 3;
        }
        return row;
    }

    /* Find Value for given Distance */
    private int findColumn(int distance){
        int column = -1;
        if(distance < 5){
            column = 0;
        } else if(distance > 5 && distance < 20){
            column = 1;
        } else if(distance > 20 && distance < 50){
            column = 2;
        } else if(distance > 50 && distance < 500){
            column = 3;
        } else if(distance > 500 && distance < 800){
            column = 4;
        } else if(distance > 800){
            column = 5;
        }
        return column;
    }

    public int getPrice(int weight, int distance){
        int[][] priceArray = new int[4][6];
        priceArray[0][0] = 12;
        priceArray[0][1] = 15;
        priceArray[0][2] = 20;
        priceArray[0][3] = 50;
        priceArray[0][4] = 100;
        priceArray[0][5] = 220;
        priceArray[1][0] = 14;
        priceArray[1][1] = 18;
        priceArray[1][2] = 24;
        priceArray[1][3] = 55;
        priceArray[1][4] = 110;
        priceArray[1][5] = 250;
        priceArray[2][0] = 16;
        priceArray[2][1] = 25;
        priceArray[2][2] = 30;
        priceArray[2][3] = 80;
        priceArray[2][4] = 130;
        priceArray[2][5] = 270;
        priceArray[3][0] = 21;
        priceArray[3][1] = 35;
        priceArray[3][2] = 50;
        priceArray[3][3] = 90;
        priceArray[3][4] = 150;
        priceArray[3][5] = 300;
        int row = findRow(weight);
        int column = findColumn(distance);
        return priceArray[row][column];
    }

}
