/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculations;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class AutomatedMathematica {
    
    double Pumin = 100 * 10E5;
    double Pumax = 200 * 10E5;
    double StepDiv = 10;
    double PVStep0 = 0.1 * 10E8;
    double VwStep0 = 0.1;
    double PzStep0 = 1 * 10E5;
    double PVStepMin = PVStep0 / 1000000;
    double VwStepMin = VwStep0 / 100000;
    double PzStepMin = PzStep0 / 100000;
    double Pu0 = 0;
    double Pz = 0;
    double Pb = 0;
    double Pu;
    int dim = 100;
    int ro = 1040;
    int L = 4604;
    double g = 9.8;
    double xn[] = new double[dim];
    double xv[] = new double[dim];
    double Pg[] = new double[dim];
    double Hw[] = new double[dim];
    double PV[] = new double[dim];
    double Vw[] = new double[dim];
    double OD = 0.073;
    double IDcas = 0.146;
    double San = (Math.PI * (Math.pow(IDcas, 2) - Math.pow(OD, 2))) / 4;
    double St = (Math.PI * Math.pow(IDcas, 2)) / 4;

    int Qaz = 30;
    double ID = 0.062;
    double Vt = St * L;
    double ODcas = 0.1683;
    double Scas = (Math.PI * Math.pow(IDcas, 2)) / 4;
    double Vcas = Scas * L;
    double Van = San * L;
    double Vwell = Van + Vt;
    int WatLevel = 1;
    double Vwat = (St + San) * (L - WatLevel);

    public void WhichEquations(int i, String itype, int j, String jtype, int k, String ktype) { // out, outtype, bottom, bottomtype, in, intype    
        if ("N".equals(ktype)) {
            double Q = PV[k];
        } else {
            double Q = Vw[k];
        }
        if ("N".equals(itype) && "N".equals(jtype) && "N".equals(ktype)) {
            for (int l = i; l <= k; l++) {
                if (l == i && l != j) {
                    Pg[l] = Pz;
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                }
                if (l == i && l == j && l != k) {
                    Pg[l] = Pz;
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    Pb = Pg[l];
                }
                if (i < l && l < j) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                }
                if (l == j && l != k && l != i) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * (San * (L - xn[l]) + St * (L - xv[l]));
                    Pb = Pg[l];
                }
                if (j < l && l < k) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l != j) {
                    Pg[l] = Pu;
                    PV[l] = Pg[l] * St * xn[l];
                }
                if (l == k && l == j && j != i) {
                    Pg[l] = Pu;
                    PV[l] = Pg[l] * (San * (L - xn[l]) + St * L);
                    Pb = Pg[l];
                }
            }
        }
        if ("N".equals(itype) && "N".equals(jtype) && "W".equals(ktype)) {
            for (int l = i; l <= k; l++) {
                if (l == i && l != j) {
                    Pg[l] = Pz;
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                }
                if (l == i && l == j && l != k) {
                    Pg[l] = Pz;
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    Pb = Pg[l];
                }
                if (i < l && l < j) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                }
                if (l == j && l != k && l != i) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * (San * (L - xn[l]) + St * (L - xv[l]));
                    Pb = Pg[l];
                }
                if (j < l && l < k) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l != j) {
                    Pg[l] = Pu + ro * g * xv[l];
                    Vw[l] = St * xv[l];
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l == j && j != i) {
                    Pg[l] = Pu + ro * g * xv[l];
                    Vw[l] = St * xv[l];
                    PV[l] = Pg[l] * (San * (L - xn[l]) + St * (L - xv[l]));
                    Pb = Pg[l];
                }
            }
        }
        if ("N".equals(itype) && "W".equals(jtype) && "N".equals(ktype)) {
            for (int l = i; l <= k; l++) {
                if (l == i && l != j) {
                    Pg[l] = Pz;
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                }
                if (l == i && l == j && l != k) {
                    Pg[l] = Pz;
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (L - xv[l]) + St * (L - xn[l + 1]);
                    Pb = Pg[l] + ro * g * (L - xv[l]);
                }
                if (i < l && l < j) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                }
                if (l == j && l != k && l != i) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (L - xv[l]) + St * (L - xn[l + 1]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                    Pb = Pg[l] + ro * g * (L - xv[l]);
                }
                if (j < l && l < k) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l != j) {
                    Pg[l] = Pu;
                    PV[l] = Pg[l] * St * xn[l];
                }
                if (l == k && l == j && j != i) {
//NOP
                }
            }
        }
        if ("N".equals(itype) && "W".equals(jtype) && "W".equals(ktype)) {
            for (int l = i; l <= k; l++) {
                if (l == i && l != j) {
                    Pg[l] = Pz;
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                }
                if (l == i && l == j && l != k) {
                    Pg[l] = Pz;
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (L - xv[l]) + St * (L - xn[l + 1]);
                    Pb = Pg[l] + ro * g * (L - xv[l]);
                }
                if (i < l && l < j) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                }
                if (l == j && l != k && l != i) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (L - xv[l]) + St * (L - xn[l + 1]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                    Pb = Pg[l] + ro * g * (L - xv[l]);
                }
                if (j < l && l < k) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l != j) {
                    Pg[l] = Pu + ro * g * xv[l];
                    Vw[l] = St * xv[l];
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l == j && j != i) {
                    Pg[l] = Pu + ro * g * xv[l];
                    Vw[l] = San * (L - xv[l]) + St * L;
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                    Pb = Pu + ro * g * L;
                }
            }
        }
        if ("W".equals(itype) && "N".equals(jtype) && "N".equals(ktype)) {
            for (int l = i; l <= k; l++) {
                if (l == i && l != j) {
                    Pg[l + 1] = Pz + ro * g * xn[l + 1];
                }
                if (l == i && l == j && l != k) {
                    //NOP
                }
                if (i < l && l < j) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                }
                if (l == j && l != k && l != i) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * (San * (L - xn[l]) + St * (L - xv[l]));
                    Pb = Pg[l];
                }
                if (j < l && l < k) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l != j) {
                    Pg[l] = Pu;
                    PV[l] = Pg[l] * St * xn[l];
                }
                if (l == k && l == j && l != i) {
                    Pg[l] = Pu;
                    PV[l] = Pg[l] * (San * (L - xn[l]) + St * L);
                    Pb = Pg[l];
                }
            }
        }
        if ("W".equals(itype) && "N".equals(jtype) && "W".equals(ktype)) {
            for (int l = i; l <= k; l++) {
                if (l == i && l != j) {
                    Pg[l + 1] = Pz + ro * g * xn[l + 1];
                }
                if (l == i && l == j && l != k) {
                    //NOP
                }
                if (i < l && l < j) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                }
                if (l == j && l != k && l != i) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * (San * (L - xn[l]) + St * (L - xv[l]));
                    Pb = Pg[l];
                }
                if (j < l && l < k) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l != j) {
                    Pg[l] = Pu + ro * g * xv[l];
                    Vw[l] = St * xv[l];
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l == j && l != i) {
                    Pg[l] = Pu + ro * g * xv[l];
                    Vw[l] = St * xv[l];
                    PV[l] = Pg[l] * (San * (L - xn[l]) + St * (L - xv[l]));
                    Pb = Pg[l];
                }
            }
        }
        if ("W".equals(itype) && "W".equals(jtype) && "N".equals(ktype)) {
            for (int l = i; l <= k; l++) {
                if (l == i && l != j) {
                    Pg[l + 1] = Pz + ro * g * xn[l + 1];
                }
                if (l == i && l == j && l != k) {
                    Pg[l + 1] = Pz + ro * g * xn[l + 1];
                    Pb = Pz + ro * g * L;
                }
                if (i < l && l < j) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                }
                if (l == j && l != k && l != i) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (L - xv[l]) + St * (L - xn[l + 1]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                    Pb = Pg[l] + ro * g * (L - xv[l]);
                }
                if (j < l && l < k) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l != j) {
                    Pg[l] = Pu;
                    PV[l] = Pg[l] * St * xn[l];
                }
                if (l == k && l == j && l != i) {
//NOP
                }
            }
        }
        if ("W".equals(itype) && "W".equals(jtype) && "W".equals(ktype)) {
            for (int l = i; l <= k; l++) {
                if (l == i && l != j) {
                    Pg[l + 1] = Pz + ro * g * xn[l + 1];
                }
                if (l == i && l == j && l != k) {
                    Pg[l + 1] = Pz + ro * g * xn[l + 1];
                    Pb = Pz + ro * g * L;
                }
                if (i < l && l < j) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (xn[l + 1] - xv[l]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                }
                if (l == j && l != k && l != i) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = San * (L - xv[l]) + St * (L - xn[l + 1]);
                    PV[l] = Pg[l] * San * (xv[l] - xn[l]);
                    Pb = Pg[l] + ro * g * (L - xv[l]);
                }
                if (j < l && l < k) {
                    Pg[l] = Pg[l + 1] + ro * g * (xv[l] - xn[l + 1]);
                    Vw[l] = St * (xv[l] - xn[l + 1]);
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l != j) {
                    Pg[l] = Pu + ro * g * xv[l];
                    Vw[l] = St * xv[l];
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                }
                if (l == k && l == j && l != i) {
                    Pg[l] = Pu + ro * g * xv[l];
                    Vw[l] = San * (L - xv[l]) + St * L;
                    PV[l] = Pg[l] * St * (xn[l] - xv[l]);
                    Pb = Pu + ro * g * L;
                }
            }
        }
    }

    public ArrayList VarGenerator(int i, String itype, int k, String ktype) {
        ArrayList join = new ArrayList(100);
        if ("N".equals(itype) && "N".equals(ktype)) {
            join.add(xv[i]);
            for (int l = i + 1; l <= k - 1; l++) {
                join.add(xn[l]);
                join.add(xv[l]);
            }
            join.add(xn[k]);
            join.add(Pu);
            join.add(Pb);
            for (int l = i; l <= k; l++) {
                join.add(Pg[l]);
            }
        }
        if ("N".equals(itype) && "W".equals(ktype)) {
            join.add(xv[i]);
            for (int l = i + 1; l <= k; l++) {
                join.add(xn[l]);
                join.add(xv[l]);
            }
            join.add(Pu);
            join.add(Pb);
            for (int l = i; l <= k; l++) {
                join.add(Pg[l]);
            }
        }
        if ("W".equals(itype) && "N".equals(ktype)) {
            for (int l = i + 1; l <= k - 1; l++) {
                join.add(xn[l]);
                join.add(xv[l]);
            }
            join.add(xn[k]);
            join.add(Pu);
            join.add(Pb);
            for (int l = i + 1; l <= k; l++) {
                join.add(Pg[l]);
            }
        }
        if ("W".equals(itype) && "W".equals(ktype)) {
            for (int l = i + 1; l <= k; l++) {
                join.add(xn[l]);
                join.add(xv[l]);
            }
            join.add(Pu);
            join.add(Pb);
            for (int l = i + 1; l <= k; l++) {
                join.add(Pg[l]);
            }
        }
        return join;
    }
}
