/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Divisas.SessionBeans;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author crist
 */
@Local
public interface EjbDivisasLocal {
    public double calculo_conversion(int cantidad_inicial, String divisa_de, String divisa_a);
    public List<String> ObtenerDivisas();
}
