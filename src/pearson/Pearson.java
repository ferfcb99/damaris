/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pearson;

/**
 *
 * @author Fernando
 */
public class Pearson {
    public double[] arrX = {20,40,65,98,76};
    public double[] arrY = {1,1,1,2,7};
    
    
    public double media(double[] array){
        int cantidadElementos = array.length;
        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma = suma + array[i];
        }
        double promedio = (suma / cantidadElementos);
        return promedio;
    }
    
    public double mediaXY(double[] muestrasX, double[] muestrasY){
        double mediaX = media(arrX);
        double mediaY = media(arrY);
        double promedio = (mediaX + mediaY)/2;
        return promedio;
    }
    
    public double calculaNumeradorPearson(double[] muestrasX, double[] muestrasY){
        int n = muestrasX.length;
        double mediaXY = mediaXY(muestrasX, muestrasY);
        double sumaNumerador = 0;
        for (int i = 0; i < muestrasX.length; i++) {
            double x = muestrasX[i];
            double y = muestrasY[i];
            sumaNumerador = sumaNumerador + ((x*y) - (n*mediaXY));   
        }
        return sumaNumerador;
    }
    
    public double calculaDenominadorX(double[] muestrasX){
        double suma = 0; 
        int n = muestrasX.length;
        double media = media(muestrasX) * media(muestrasX);
        for (int i = 0; i <muestrasX.length; i++) {
            double cuadrados = muestrasX[i] * muestrasX[i];
            suma = suma + (cuadrados - (n*media));
        }
        suma = Math.sqrt(suma);
        return suma;
    }
    
    public double calculaDenominadorY(double[] muestrasY){
        double suma = 0;
        int n = muestrasY.length;
        double media = media(muestrasY) * media(muestrasY);
        for (int i = 0; i < muestrasY.length; i++) {
            double cuadradosY = muestrasY[i] * muestrasY[i];
            suma = suma + (cuadradosY - n*media);
        }
        System.out.println("LA suma desde la funcion: " + suma);
        suma = Math.sqrt(suma);
        return suma;
    }
    
    public double  resultadoDivision(double[] muestrasX, double[] muestrasY){
        double resultado = 0;
        double numerador = calculaNumeradorPearson(muestrasX, muestrasY);
        double denominadorX = calculaDenominadorX(muestrasX);
        double denominadorY = calculaDenominadorY(muestrasY);
        
         resultado = resultado + (numerador / (denominadorX * denominadorY));
         return resultado;
    }
    
    public static void main(String[] args) {
        Pearson p = new Pearson();
        // System.out.println(p.media(p.arrX));
        //System.out.println(p.mediaXY(p.arrX, p.arrY));
        //System.out.println(p.calculaNumeradorPearson(p.arrX,p.arrY));
       // System.out.println(p.calculaDenominadorX(p.arrX));
        System.out.println(p.calculaDenominadorY(p.arrY));
        p.resultadoDivision(p.arrX,p.arrY);
    }
    
    
    
    
    
}
