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
public class CalculosSB implements CalculosSBLocal {

    @Override
    public double calculo_conversion(int cantidad_inicial, String divisa_inicio, String divisa_conversion){
        String[][] divisas = new String[5][3];
        divisas[0][0]="USD";
        divisas[0][1]="Dolar";
        divisas[0][2]="624.70";

        divisas[1][0]="EUR";
        divisas[1][1]="Euro";
        divisas[1][2]="725.69";

        divisas[2][0]="CLP";
        divisas[2][1]="Pesos Chilenos";
        divisas[2][2]="1";

        divisas[3][0]="ARS";
        divisas[3][1]="Peso Argentino";
        divisas[3][2]="25.38";

        divisas[4][0]="BTC";
        divisas[4][1]="Bitcoin";
        divisas[4][2]="4545954.01";
        System.out.println(obtener_valor_divisa(divisas,divisa_inicio)*cantidad_inicial);
        System.out.println(obtener_valor_divisa(divisas,divisa_conversion));
        return (obtener_valor_divisa(divisas,divisa_inicio)*cantidad_inicial)/obtener_valor_divisa(divisas,divisa_conversion);
    }
    private double obtener_valor_divisa(String[][] divisas, String id_divisa){
         for (String[] divisa : divisas) {
             if (id_divisa.equals(divisa[0])) {
                 return Double.parseDouble(divisa[2]);
             }
         }
        return 0;
    }
    @Override
    public List<String> ObtenerDivisas()
    {
        List<String> divisas = new ArrayList<>();
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
}
