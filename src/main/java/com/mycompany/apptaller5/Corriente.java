/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apptaller5;

/**
 *
 * @author Veronica
 */
public class Corriente {
    public static double calcular_corriente(double voltaje, double resistencia){
        double corriente;
        corriente= voltaje / resistencia;
        return corriente;
    }
}
