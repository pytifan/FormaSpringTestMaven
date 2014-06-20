/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.region.forms.osvoenie.service;

import java.util.*;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.region.forms.osvoenie.form.data.Forma;
import org.springframework.stereotype.Service;

/**
 *
 * @author alex
 */
@Service
public class FormOsvoenieSomeServiceImpl implements FormOsvoenieSomeService {
    private String FieldName, WellName;
    private double internalDiamCasing1, internalDiamCasing2, internalDiamCasing3, internalDiamCasing4, internalDiamCasing5;
    
    @Override
    public void doSmthing(Forma forma) throws Exception {
        FieldName = forma.getFieldName();
        WellName = forma.getWellName();
        forma.setComments(FieldName.concat(WellName));
        
       int Rho = 1020; /* плотность воды*/
       int Pmax = 200 * 100000; /* Максимальное давление на устье, Па*/
       int Pmin = 100 * 100000; /* Минимальное давление на устье, Па*/

       double g = 9.81; /* ускорение свободного падения*/
       int L = 4000; /* глубина скважины*/
       double OD = 0.089; /* Внешний диаметр НКТ*/
       double ID = OD - 2*0.0065; /* Внутренний диаметр НКТ = 0.076 м*/
       double St = Math.PI * Math.pow(ID, 2)/4; /* внутренняя площадь НКТ = 0.004536 м2*/
       double Vt = St * L; /* Объем НКТ*/
       double ODcol = 0.168; /* Внешний диаметр обсадной колоны*/
       double IDcol = ODcol - 2 * 0.01; /* Внутренния диаметр обсадной колоны = 0.148 м*/
       double Scol = Math.PI * Math.pow(IDcol, 2)/4; /* Площадь сечения с колонны= 0.0172 м2*/
       double Vcol = Scol * L; /* Объем обсадной колонны*/
       double Sout = (Math.PI * (Math.pow(IDcol, 2) - Math.pow(OD, 2))) / 4; /* Площадь затрубного пространства= 0.010982 м2*/
       double Vout = Sout * L; /* Объем затрубного пространства*/
       double V = Vout + Vt; /* эффективный объем скважины*/
       double PV4 = 10 * Math.pow(10, 5);
       double PV3 = 36 * Math.pow(10, 7);
       double VW2 = 8.67;
       double VW3 = 6.7525;
       double pz = 71 * Math.pow(10, 5);
       double pn2 = pz;
        
        /*Система уравнений,
		PV2 == Sout pn2 (hw2- hn2),
		VW2 == Sout (hn3-hw2),
		PV3 == pn3 St (L-hw3) + pn3 Sout (L-hn3),
		VW3 == St hw3,
		pn2 == Rho g hn2,
		pn3 == pn2 + Rho g (hn3-hw2)            */
        /* Вектор ответов при таких параметрах */
//        Map solution = new HashMap();
       /*список переменных*/
        double pn3 = 0.0, pn4 = 0.0, hw2 = 0.0, hn3 = 0.0, hw3 = 0.0, hn4 = 0.0;
//        solution.put(pn3, Math.pow(1.4999471518774671, 7));
//        solution.put(pn4, 105287.81579648993);
//        solution.put(hw2, 1197.7182646306726);
//        solution.put(hn3, 1987.175952741511); 
//        solution.put(hw3, 3582.149052653622);
//        solution.put(hn4, 2093.653549567717);
        
        double [] Vars = new double [6];
        /*вектор фуккций*/
        List FuncsList = new ArrayList();
        FuncsList.add((VW2 - Sout*(hn3 - hw2))/VW2);
        FuncsList.add((PV3 - pn3 * St * (L - hw3) - pn3 * Sout * (L - hn3))/PV3);
        FuncsList.add((VW3 - St * (hw3 - hn4))/VW3);
        FuncsList.add((PV4 - pn4 * hn4 * St)/PV4);
        FuncsList.add((pn3 - pn2 - Rho * g * (hn3 - hw2)) / pn3);
        FuncsList.add((pn3 - pn4 - Rho * g * (hw3 - hn4)) / pn3);
        // F = Math.pow(FuncsList, 2);
        /*функция для оптимизации*/
        double F = Math.pow((VW2 - Sout*(hn3 - hw2))/VW2, 2) 
                + Math.pow((PV3 - pn3 * St * (L - hw3) - pn3 * Sout * (L - hn3))/PV3, 2)
                + Math.pow((VW3 - St * (hw3 - hn4))/VW3, 2)
                + Math.pow((PV4 - pn4 * hn4 * St)/PV4, 2)
                + Math.pow((pn3 - pn2 - Rho * g * (hn3 - hw2)) / pn3, 2)
                + Math.pow((pn3 - pn4 - Rho * g * (hw3 - hn4)) / pn3, 2);
        /* допустимая погрешность в расчетах -1 атмосфера и 10 метров, для начала*/
        double [] InGuess = {1.6 * Math.pow(10, 7), Math.pow(10, 5), 2000, 1900, 1300, 3200};
        double [] min = {10000, 10000, 0.1, 0.1, 0.1, 0.1};
        /*Матрица Якоби*/
        for(int i=1; i<Vars.length; i++) {
                for (int j=1; j<Vars.length; j++) {
            int params = 6;
            int order = 1;
            double xRealValue = 0;
            DerivativeStructure x = new DerivativeStructure(params, order, 0, xRealValue);
            DerivativeStructure y = x.pow(2);
                    FuncsList.get(i);
                }
                }
  }
    
//    public DerivativeStructure f(DerivativeStructure x,
//            DerivativeStructure y) {
//        return x.multiply(x).add(y.multiply(y)).add(l * l);
//    }

    @Override
    public void CasingAvarageDiamCalculations(Forma forma) throws Exception {
//        double a1 = forma.getInternalDiamCasing1();
//        double b1 = forma.getInternalDiamCasing2();
//        forma.setAvdiamcas((a1 + b1) / 2);
        /* Вычисление среднего внутреннего диаметра для освоения пачками *//*
         Sum [i = 1, Ncas] (Van[i])== (Pi*(IDcasav^2 - ODtav^2))/4*Ltub,
         Sum [i = 1, Ntub] (Pi*(ODt[i])^2/4*Lt[i]) == (Pi*ODtav^2)/4*Ltub,
         Sum [i = 1, Ntub] (Vt[i]) == (Pi*IDtav^2)/4*Ltub, IDtav > 0, ODtav > 0, IDcasav > 0}, {IDtav, ODtav, IDcasav}]*/
       // double coefficients[] = {-2.0, 4.0};
        System.out.println("result111:   ");
       // PolynomialFunction function = new PolynomialFunction(coefficients);
        System.out.println("result222:   ");
      //  LaguerreSolver solver = new LaguerreSolver();
        System.out.println("result333:   ");
     //   double result = solver.solve(1000, function, 0.0, 1000.0);
        System.out.println("result444:   ");
      //  System.out.println("result: " + result);      
    
        final double relativeAccuracy = 1.0e-12;
        final double absoluteAccuracy = 1.0e-8;
        final int maxOrder = 5;

        double Vani[] = new double[4];
        double Result[] = new double[Vani.length];
        for (int i = 1; i <= 5; i++) {
            double ODtav = 0.0;
            double IDcasav = 0.0;
            double Ltub = 0.0;
            Vani[i] = ((Math.PI * (IDcasav * IDcasav - ODtav * ODtav)) / 4) * Ltub;
            Result[i] = Result[i - 1] + Vani[i];
        }
        System.out.println("Result[i]: " + Result.toString());
    }

    @Override
    public void solver_for_avarageDiams(Forma forma) throws Exception {  
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
