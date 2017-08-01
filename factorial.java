/**
    This is a Java program to calculate
    factorial of really big numbers as 
    well as small small numbers too.

    important ==>

    1.funcion 'fact1' can only handle max input=23
    2.variable 'a_limit'= i*(no. of digits in i) is sufficient
    3.Tested on 64-bit Windows OS machine

    File info  ==>

    Author      :       Ankur Parihar
    Date        :       26 June 2017
    Time        :       21:07:00
    Version     :       1.0.0.0
      
    facebook    :       https://fb.com/ankur.parihar.773

    See this program in action ==>
    Youtube     :       https://youtu.be/aXc5QUjlGO8

    Copyright @ Ankur Parihar 2017
*/

import java.util.Scanner;

class factorial{

    static long factorial23 = fact1(23);
    public static void main(String []args){

        //Max limit fact1 is 23
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number :");

        //taking user input

        int i = s.nextInt();
        int z = zeros(i);

        //zeros will be printed separately

        System.out.print("factorial is :");

        if(i<24) System.out.print(fact1(i));
        else fact2(i);

        //printing zeros
        while(z-->0) System.out.print(0);
        System.out.println();
    }

    static long fact1(int i){
        if(i<0) return 0;
        else if(i<2) return 1;
        long p = i*fact1(i-1);
        return (p%10 == 0)?p/10:p;
    }

    static void fact2(int i){
        int p=0,c=0,u=0,l=0 ;
        /*
            p --> pointer
            c --> carry
            u --> upper limit
            l --> lower limit
        */
        int a_limit = i*count_dig(i);   //                       --> You can change array length here by changing 'a_limit' variable <--
        int a[] = new int[a_limit];

        long fact23 = factorial23;
        //now writing fact23 into the array
        while(fact23>0){
            a[p] = (int)(fact23%10);
            p++;
            fact23 /= 10;
        }
        u = --p;  //pointer to upper limit

        //now main task of multiplying each digit
        
        for(int j=24; j<=i; j++){
            //multiplying until upper limit
            for(p=0; p<=u; p++){
                c += a[p]*j;
                a[p] = c%10;
                c /= 10;
            }
            //adding remaining carry and increasing upper limit
            while(c>0){
                u++;
                a[u] = c%10;
                c /= 10;
            }
            //process to remove zeros in order to increase program range
            if(a[0]==0){
                p=1;
                while(a[p]==0){p++;}
                shift(a,p,u);
                u -= p;
            }
        }
        
        //now printing final array result
        for(;u>=0;u--){
            System.out.print(a[u]);
        }
    }

    static int zeros(int i){
        if(i/5==0) return 0;
        return i/5 + zeros(i/5);
    }

    // counting digits of i
    static int count_dig(long n){
        int dig=0;
        while(n>0){
            n /= 10;
            dig++;
        }
        return dig;
    }

    //void for shifting the array
    static void shift(int a[],int l, int u){
        for(int i=l; i<=u; i++){
            a[i-l]=a[i];
        }
    }
}