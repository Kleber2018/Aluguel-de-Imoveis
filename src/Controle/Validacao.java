/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Cliente;
import javax.swing.JTextField;

/**
 *
 * @author klebe
 */
public class Validacao {
    
    //Metodo para verificar se os campos estão vazio
    public boolean estaVazio(JTextField campo) {
    return campo.getText() != null && !campo.getText().trim().isEmpty();
}
}
