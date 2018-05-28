/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Divisas.SessionBeans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author crist
 */
@Stateless
public class DivisasSB implements DivisasSBLocal {
    public List<String> ObtenerDivisas()
    {
        List<String> divisas = new ArrayList<String>();
        divisas.add("USD - Dolar");//624,70 CLP
        divisas.add("EUR - Euro");//725,69 CLP
        divisas.add("CLP - Pesos Chilenos");//1 CLP
        divisas.add("ARS - Peso Argentino");//25,38 CLP
        divisas.add("BTC - Bitcoin");//4545954,01 CLP
        System.out.println("For a list divisas");
        for (int i = 0; i < divisas.size(); i++) {
                System.out.println(divisas.get(i));
        }
        return divisas;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
