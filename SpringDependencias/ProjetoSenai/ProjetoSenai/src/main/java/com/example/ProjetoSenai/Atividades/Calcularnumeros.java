package com.example.ProjetoSenai.Atividades;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calcularnumeros {
    @GetMapping("/somar")
    public int somar(int num1, int num2) {
        return num1 + num2;
    }
    @GetMapping("/subtrair")
    public int subtrair(int num1, int num2) {
        return num1 - num2;
    }
    @GetMapping("/multiplicar")
    public int multiplicar(int num1, int num2) {
        return num1 * num2;
    }
    @GetMapping("/dividir")
    public int dividir(int num1, int num2) throws IllegalAccessException {
        if (num2 == 0){
            throw new IllegalAccessException("Não divide por zero!");
        }
        return num1 / num2;
    }

    //Verificar se o numero é par ou impar
    //Calcular o Fatorial de um Número
    //Converter Celsius para fahrenheit
    //Reverter uma String
    //verificar se o numero é primo
    //calcular a media de um numero

    @GetMapping("/ParImpar")
    public String ParImpar(@RequestParam int numb){
        if (numb % 2 == 0 ){
            return "O número " + numb + " é par.";
        } else {
            return "O número " + numb + " é ímpar.";
        }
    }

    @GetMapping("/reverter")
    public static String reverter(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    @GetMapping("/fatorial")
    public static long fatorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    @GetMapping("/celsius")
    public static double celsius(@RequestParam double celsius) {
        return (celsius * 9 / 5) + 32;
    }



    @GetMapping("/primo")
    public static boolean primo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @GetMapping("/media")
    public static int media(int a, int b, int c){
        int somarElementos = a + b + c;
        int mediaElementos = somarElementos / 3;
        return mediaElementos;
    }

}
