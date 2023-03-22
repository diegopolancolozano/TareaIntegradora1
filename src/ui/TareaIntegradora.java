package ui;
import java.util.Scanner;

/*
Programa que calcula las raices de una de las tres funciones.
*/
public class TareaIntegradora{ 
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Bienvenido a la calculadora (en radianes) de raices de funciones");
        int election = Menu();
        double a,b;
        switch(election){
        case 1:
            System.out.println("Inserte el limite inferior del intervalo");
            a = reader.nextDouble();
            System.out.println("Inserte el limite superior del intervalo");
            b = reader.nextDouble();
            BisectionMethod1(a, b);
            break;
        case 2:
            System.out.println("Inserte el limite inferior del intervalo");
            a = reader.nextDouble();
            System.out.println("Inserte el limite superior del intervalo");
            b = reader.nextDouble();
            BisectionMethod2(a, b);
            break;
        case 3:
            System.out.println("Inserte el limite inferior del intervalo");
            a = reader.nextDouble();
            System.out.println("Inserte el limite superior del intervalo");
            b = reader.nextDouble();
            BisectionMethod3(a, b);
            break;
        default:
            System.out.println("Opcion equivocada");
            election = Menu();
            }
        reader.close();
    }               //fin del main

    public static int Menu(){
        System.out.println("La función 1 es: 2cos(x^2)");
        System.out.println("La función 2 es: 3x^3 + 7x^2 +5");
        System.out.println("La función 3 es: xcos(x)");
        int election = 0;
        election = reader.nextInt();
        return election;
    }

    public static double Abs(double a){
        if(a<0){
            a=-a;
        }
        return a;
    }

    public static long Factorial(int a){
        long sumOfNumbers = 1l;
        for(int i=2;i<=a; i++){
            sumOfNumbers*=i;
        }
        return sumOfNumbers;    
        }

    public static double Power(double base, double b){
        double c = 1;
        for(int i=0; i<b; i++){
            c*=base;
        }
        return c;
    }

    public static double Cos(double x){
        double PI=3.141592;
        if(x>(2*PI)){           //The cosine of 3 pi equals: 5 pi, 7 pi, 9 pi...
            x=(x%(2*PI));
        }
        double sumOfTheSeries = 0.0;
        double SecuenceSubn = 0.0;
        double precision = 0.005;

        int n = 0;
        do {
            SecuenceSubn = Power(-1, n) / Factorial(2 * n) * Power(x, 2 * n);
            sumOfTheSeries += SecuenceSubn;
            n = n + 1;
        } while (Abs(SecuenceSubn) > precision);

        return sumOfTheSeries;
    }
    public static void BisectionMethod1(double a, double b){
        double c=a+(b-a)/2;
        double epsilon = Abs(a-b);
        boolean foundNegative = false;
        boolean foundPositive = false;
        for(double i=a; (i<b && !(foundNegative && foundPositive)); i+=0.1){
            if(Function1(i)<0){
                foundNegative=true;
            }
            if(Function1(i)>0){
                foundPositive=true;
            }
            c=i;
        }
        a=c-0.1;
        b=c;
        if(!(foundNegative && foundPositive)){
            System.out.println("En ese intervalo no hay raices");
        }
        else{
            do{
                c=a+(b-a)/2;
                if(Function1(a)*Function1(c)<0){
                    b=c;
                }else{
                    a=c;
                }
                epsilon = Abs(a-b);
            }while(epsilon>0.005);
            double aproxRoot=(a+b)/2;
            System.out.println("La raíz está en la posición " + aproxRoot);
        }
    }
    public static void BisectionMethod2(double a, double b){
        double c=a+(b-a)/2;
        double epsilon = Abs(a-b);
        boolean foundNegative = false;
        boolean foundPositive = false;
        for(double i=a; (i<b && !(foundNegative && foundPositive)); i+=0.1){
            if(Function2(i)<0){
                foundNegative=true;
            }
            if(Function2(i)>0){
                foundPositive=true;
            }
            c=i;
        }
        a=c-0.1;
        b=c;
        if(!(foundNegative && foundPositive)){
            System.out.println("En ese intervalo no hay raices");
        }
        else{
            do{
                c=a+(b-a)/2;
                if(Function2(a)*Function2(c)<0){
                    b=c;
                }else{
                    a=c;
                }
                epsilon = Abs(a-b);
            }while(epsilon>0.005);
            double aproxRoot=(a+b)/2;
            System.out.println("La raíz está en la posición " + aproxRoot);
        }
    }
    public static void BisectionMethod3(double a, double b){
        double c=a+(b-a)/2;
        double epsilon = Abs(a-b);
        boolean foundNegative = false;
        boolean foundPositive = false;
        boolean foundZero = false;
        for(double i=a; (i<b && !(foundNegative && foundPositive) && !(foundZero)); i+=0.1){
            if(Function3(i)<0){
                foundNegative=true;
            }
            if(Function3(i)>0){
                foundPositive=true;
            }
            if(Function3(i)==0){
                foundZero=true;
            }
            
            c=i;
        }
        if((!(foundNegative && foundPositive) && !foundZero)){
            System.out.println("En ese intervalo no hay raices");
        }
        else if(foundZero){
            System.out.println("La raiz es 0");
        }
        else{
            a=c-0.1;
            b=c;
            do{
                c=a+(b-a)/2;
                if(Function3(a)*Function3(c)<0){
                    b=c;
                }else{
                    a=c;
                }
                epsilon = Abs(a-b);
            }while(epsilon>0.005);
            double aproxRoot=(a+b)/2;
            System.out.println("La raíz está en la posición " + aproxRoot);
        }
    }
    public static double Function1(double x){
        return Cos(Power(x, 2))*2;
    }
    public static double Function2(double x){
        return 3*Power(x, 3)+7*Power(x, 2) + 5;
    }
    public static double Function3(double x){
        return Cos(x)*x;
    }
}