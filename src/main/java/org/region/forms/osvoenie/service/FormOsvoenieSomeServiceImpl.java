/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.region.forms.osvoenie.service;

import java.util.*;
import org.apache.commons.math3.analysis.differentiation.*;
import org.apache.commons.math3.fitting.leastsquares.*;
import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.optim.SimpleVectorValueChecker;
import org.apache.commons.math3.random.*;
import org.region.forms.osvoenie.calculations.EqnGenerator;
import org.region.forms.osvoenie.form.data.CalculationsData;
import org.region.forms.osvoenie.form.data.Forma;
import org.springframework.stereotype.Service;

/**
 *
 * @author alex
 */
@Service
public class FormOsvoenieSomeServiceImpl implements FormOsvoenieSomeService {
    
    private static final String LINE = "Старт!<br>====================================================================================================\n <br>";
    public StringBuffer buffer = new StringBuffer(LINE + "\n" );

    @Override
    public void doSmthing(Forma forma, CalculationsData calculationsData) throws Exception {
        System.out.println("Старт");
        //buffer.append("Старт! <br>");
        // double Rho = 1020.0, g = 9.81; /* Плотность воды и ускорение свободного падения*/
        double Lt = 4000.0, ODt = 0.089, IDt = ODt - 2 * 0.0065; /* Длина, внешний и внутренний диаметр НКТ*/

        double St = Math.PI * Math.pow(IDt, 2) / 4.0, Vt = St * Lt; /* Внутренняя площадь и объем НКТ*/

        double ODcas = 0.168, IDcas = ODcas - 2.0 * 0.01; /* Внешний и внутренний диаметр обсадной колоны*/

        double Scas = Math.PI * Math.pow(IDcas, 2) / 4.0, Vcas = Scas * Lt; /* Площадь сечения и объем ОК*/

        double Sann = (Math.PI * (Math.pow(IDcas, 2) - Math.pow(ODt, 2))) / 4.0; /* Площадь затрубного пространства*/

        double Vann = Sann * Lt, Vwell = Vann + Vt; /* Объем затрубного пространства и скважины*/

        double puMin = 100.0e5, puMax = 200.0e5; /* Максимальное и минимальное давление на устье, Па*/

        double Q, QStep, stepDiv = 10;
        double pvStep, vwStep, pzStep;
        double pvStep0 = 0.1e8, vwStep0 = 0.1;
        double pvStepMin = pvStep0 / 1e6, vwStepMin = vwStep0 / 1e5;

        System.out.println("Объявление переменных пачек");
        buffer.append("Объявление переменных пачек <br>");
        double sol[], eqnSol[][], vw[], pv[], pz, pu0, watLevel, sumSqF;
        double xn[], xv[], pg[], pu, pb;
        int out, bot, in, varsNo;
        char outType, botType, inType;
        double[] inGuess;
        double[][] iVGresult;
        boolean puFlag = false, botFlag = false, annFlag = false, noSolFlag = false, notPhysSolFlag = false;

        out = 0;
        bot = 0;
        in = 1;
        outType = 'N';
        botType = 'W';
        inType = 'N';

        watLevel = 1000;
        pz = 1e5;
        pu0 = 1e5;
        pv = new double[]{Sann * watLevel * 10e5, St * watLevel * 10e5};
        vw = new double[]{(St + Sann) * (Lt - watLevel)};

        varsNo = varsCalculator(out, outType, in, inType);
        inGuess = new double[varsNo];
        Arrays.fill(inGuess, 0);

        eqnSol = eqnSolver(out, outType, bot, botType, in, inType, inGuess, vw, pv, pz, forma, calculationsData);
        sol = eqnSol[0];
        sumSqF = eqnSol[1][0];
        System.out.println("Значение суммы квадратов вектор-функции: F =" + sumSqF);
        buffer.append("Значение суммы квадратов вектор-функции: F =").append(sumSqF).append("<br>");
        System.out.println("Правильное решение ЛМ " + Arrays.toString(sol));
        buffer.append("Правильное решение ЛМ ").append(Arrays.toString(sol)).append("<br>");
        pz = 1e5;
        if (inType == 'N') {
            Q = pv[in];
            QStep = pvStep0;
        } else {
            Q = vw[in];
            QStep = vwStep0;
        }

        while (inType == 'N' ? QStep > pvStepMin : QStep > vwStepMin) {
            puFlag = false;
            botFlag = false;
            annFlag = false;
            noSolFlag = false;
            notPhysSolFlag = false;
            do {
                notPhysSolFlag = false;
                Q = Q + QStep;
                if (inType == 'N') {
                    pv[in] = Q;
                } else {
                    vw[in] = Q;
                }
                inGuess = new double[varsNo];
                inGuess = sol;
                System.out.println("inGuess" + Arrays.toString(inGuess) + " pz=" + pz);
                buffer.append("inGuess").append(Arrays.toString(inGuess)).append(pz).append("<br>");
                System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType).append("<br>");
                System.out.println("pv=" + Arrays.toString(pv) + " wv=" + Arrays.toString(vw));
                buffer.append("pv=").append(Arrays.toString(pv)).append(" wv=").append(Arrays.toString(vw)).append("<br>");
                eqnSol = eqnSolver(out, outType, bot, botType, in, inType, inGuess, vw, pv, pz, forma, calculationsData);
                sol = eqnSol[0];
                sumSqF = eqnSol[1][0];

                System.out.println("Значение суммы квадратов вектор-функции: F =" + sumSqF);
                buffer.append("Значение суммы квадратов вектор-функции: F =").append(sumSqF).append("<br>");
                System.out.println("Правильное решение ЛМ " + Arrays.toString(sol));
                buffer.append("Правильное решение ЛМ ").append(Arrays.toString(sol)).append("<br>");
                iVGresult = inverseVarGenerator(out, outType, in, inType, sol);
                xn = iVGresult[0];
                xv = iVGresult[1];
                pg = iVGresult[2];
                pu = iVGresult[3][0];
                pb = iVGresult[4][0];

                System.out.println("xn=" + Arrays.toString(xn) + ", xv=" + Arrays.toString(xv) + ", pg=" + Arrays.toString(pg) + ", pu=" + pu + ", pb=" + pb);
                buffer.append("xn=").append(Arrays.toString(xn)).append(", xv=").append(Arrays.toString(xv)).append(", pg=").append(Arrays.toString(pg)).append(", pu=").append(pu).append(", pb=").append(pb).append("<br>");

                for (int i = 0; i < xn.length; i++) {
                    if ((xn[i] < 0) || (xn[i] > Lt) || (xv[i] < 0) || (xv[i] > Lt) || (pg[i] < 0)) {
                        System.out.println("Нефизичное решение!");
                        buffer.append("Нефизичное решение!").append("<br>");
                        notPhysSolFlag = true;
                    }
                }
                if ((pb < 0) || (pu < 0) || (sumSqF > 10e-10)) {
                    System.out.println("Нефизичное решение!");
                    buffer.append("Нефизичное решение!").append("<br>");
                    notPhysSolFlag = true;
                }
                if ((bot == out && botType == outType) ? (sol[0] < inGuess[0]) : (sol[0] > inGuess[0])) {
                    System.out.println("Нефизичное решение inGuess!");
                    buffer.append("Нефизичное решение inGuess!").append("<br>");
                    notPhysSolFlag = true;
                }

                if (notPhysSolFlag) {
                    Q = Q - QStep;
                    QStep = QStep / stepDiv;
                    sol = inGuess;
                    System.out.println("QStep уменьшено!!!");
                    buffer.append("QStep уменьшено!!!").append("<br>");
                }
                if ((inType == 'N' ? QStep < pvStepMin / 10 : QStep < vwStepMin / 10) && notPhysSolFlag) {
                    notPhysSolFlag = false;
                    noSolFlag = true;
                    System.out.println("Пропало решение!!!В цикле!!!");
                    buffer.append("Пропало решение!!!В цикле!!!").append("<br>");
                }
            } while (notPhysSolFlag);

            notPhysSolFlag = false;

            System.out.println("xn=" + Arrays.toString(xn) + ", xv=" + Arrays.toString(xv) + ", pg=" + Arrays.toString(pg) + ", pu=" + pu + ", pb=" + pb);
            buffer.append("xn=").append(Arrays.toString(xn)).append(", xv=").append(Arrays.toString(xv)).append(", pg=").append(Arrays.toString(pg)).append(", pu=").append(pu).append(", pb=").append(pb).append("<br>");

            if (sumSqF > 10e-10) {
                System.out.println("Пропало решение!");
                buffer.append("Пропало решение!").append("<br>");
                Q = Q - QStep;
                QStep = QStep / stepDiv;
                sol = inGuess;
                noSolFlag = true;
                puFlag = false;
                botFlag = false;
                annFlag = false;
            }

            if (outType == 'N' ? (Math.abs(xv[out] / Lt)) < 0.001 : (Math.abs(xn[out + 1] / Lt)) < 0.001) {
                System.out.println("Планируется смена пачки на выходе!");
                buffer.append("Планируется смена пачки на выходе!").append("<br>");
                noSolFlag = false;
                puFlag = false;
                botFlag = false;
                annFlag = true;
                Q = Q - QStep;
                QStep = QStep / stepDiv;
                sol = inGuess;
            }

            if (inType == 'N' ? pu > puMax : pu < puMin) {
                System.out.println("Планируется смена пачки на устье!");
                buffer.append("Планируется смена пачки на устье!").append("<br>");
                noSolFlag = false;
                puFlag = true;
                botFlag = false;
                annFlag = false;
                Q = Q - QStep;
                QStep = QStep / stepDiv;
                sol = inGuess;
            }

            if (botType == 'N' ? ((Math.abs(xv[bot] - Lt) / Lt) < 0.001) : ((Math.abs(xn[bot + 1] - Lt) / Lt) < 0.001)) {
                System.out.println("Планируется смена пачки на забое!");
                buffer.append("Планируется смена пачки на забое!").append("<br>");
                noSolFlag = false;
                puFlag = false;
                botFlag = true;
                annFlag = false;
                notPhysSolFlag = false;
                Q = Q - QStep;
                QStep = QStep / stepDiv;
                sol = inGuess;
            }

            System.out.println("puFlag=" + puFlag + ", botFlag=" + botFlag + ", annFlag=" + annFlag + ", noSolFlag=" + noSolFlag);
            buffer.append("puFlag=").append(puFlag).append(", botFlag=").append(botFlag).append(", annFlag=").append(annFlag).append(", noSolFlag=").append(noSolFlag).append("<br>");

            if (inType == 'N' ? QStep <= pvStepMin : QStep <= vwStepMin) {
                if (puFlag) {
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    buffer.append("<br><br><br><br>");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("puFlag: Смена пачки на устье!");
                    buffer.append("puFlag: Смена пачки на устье!").append("<br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    if (inType == 'N') {
                        inType = 'W';
                        vw = Arrays.copyOf(vw, vw.length + 1);
                        Q = 0;
                        QStep = vwStep0;
                        xv[in] = 0.0;
                    } else {
                        inType = 'N';
                        in++;
                        pv = Arrays.copyOf(pv, pv.length + 1);
                        Q = 0;
                        QStep = pvStep0;
                        xn = Arrays.copyOf(xn, xn.length + 1);
                        xn[in] = 0.0;
                        pg = Arrays.copyOf(pg, pg.length + 1);
                        pg[in] = pu;
                    }
                    varsNo = varsCalculator(out, outType, in, inType);
                    sol = varGenerator(out, outType, in, inType, xn, xv, pg, pu, pb);
                    puFlag = false;
                } else if (botFlag) {
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("botFlag: Смена пачки на забое!");
                    buffer.append("botFlag: Смена пачки на забое!").append("<br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    if (botType == 'N') {
                        botType = 'W';
                    } else {
                        botType = 'N';
                        bot++;
                    }
                    if (inType == 'N') {
                        QStep = pvStep0;
                    } else {
                        QStep = vwStep0;
                    }
                    varsNo = varsCalculator(out, outType, in, inType);
                    sol = varGenerator(out, outType, in, inType, xn, xv, pg, pu, pb);
                    botFlag = false;
                } else if (annFlag) {
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("annFlag: Смена пачки на выходе!");
                    buffer.append("annFlag: Смена пачки на выходе!").append("<br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    if (outType == 'N') {
                        outType = 'W';
                    } else {
                        outType = 'N';
                        out++;
                    }
                    if ((in == out) && (inType == outType)) {
                        System.out.println("Расчет окончен!");
                        buffer.append("Расчет окончен!").append("<br>");
                        calculationsData.setCalcMess(buffer.toString());
                        break;
                    }
                    if (inType == 'N') {
                        QStep = pvStep0;
                    } else {
                        QStep = vwStep0;
                    }
                    varsNo = varsCalculator(out, outType, in, inType);
                    sol = varGenerator(out, outType, in, inType, xn, xv, pg, pu, pb);
                    annFlag = false;
                } else if (noSolFlag) {
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("noSolFlag: Начало выхода пачки!");
                    buffer.append("noSolFlag: Начало выхода пачки!");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    if (inType == 'N') {
                        pv[in] = Q + pvStepMin;
                    } else {
                        vw[in] = Q + vwStepMin;
                    }

                    double[][] bpzresult = blockpz(out, outType, bot, botType, in, inType, inGuess, vw, pv, pz, forma, calculationsData);
                    xn = bpzresult[0];
                    xv = bpzresult[1];
                    pg = bpzresult[2];
                    pu = bpzresult[3][0];
                    pb = bpzresult[3][1];
                    sumSqF = bpzresult[3][2];
                    vw = bpzresult[4];
                    pv = bpzresult[5];
                    pz = bpzresult[6][0];
                    out = (int) bpzresult[7][0];
                    bot = (int) bpzresult[7][1];
                    in = (int) bpzresult[7][2];
                    if (bpzresult[8][0] == 0) {
                        outType = 'N';
                    } else {
                        outType = 'W';
                    }
                    if (bpzresult[8][1] == 0) {
                        botType = 'N';
                    } else {
                        botType = 'W';
                    }
                    if (bpzresult[8][2] == 0) {
                        inType = 'N';
                    } else {
                        inType = 'W';
                    }

                    if ((in == out) && (inType == outType)) {
                        System.out.println("Расчет окончен!");
                        buffer.append("Расчет окончен!").append("<br>");
                        System.out.println("pv=" + Arrays.toString(pv) + " wv=" + Arrays.toString(vw));
                        buffer.append("pv=").append(Arrays.toString(pv)).append(" wv=").append(Arrays.toString(vw)).append("<br>");
                        calculationsData.setCalcMess(buffer.toString());
                        break;
                    }

                    varsNo = varsCalculator(out, outType, in, inType);
                    sol = varGenerator(out, outType, in, inType, xn, xv, pg, pu, pb);
                    if (inType == 'N') {
                        Q = pv[in];
                        QStep = pvStep0;
                    } else {
                        Q = vw[in];
                        QStep = vwStep0;
                    }
                    noSolFlag = false;
                } else {
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("Проблема: не сработал ни один из флагов!");
                    buffer.append("Проблема: не сработал ни один из флагов!").append("<br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    break;
                }
            }
        }
    }

    private double[][] blockpz(int out, char outType, int bot, char botType, int in, char inType, double[] inGuess, double[] vw, double[] pv, double pz, Forma forma, CalculationsData calculationsData) {
        double[][] iVGresult, eqnSol;
        double[][] result = new double[9][];
        double sol[], sumSqF = 0, varsNo;
        double pz0 = 1e5, pzStep0 = 1e5, pzStepMin = pzStep0 / 1e5, stepDiv = 10;
        double Lt = 4000.0;
        double puMin = 100.0e5, puMax = 200.0e5; /* Максимальное и минимальное давление на устье, Па*/

        double pzStep = pzStep0;
        double[] mean, standardDeviation;
        double xn[] = new double[in + 1];
        double xv[] = new double[in + 1];
        double pg[] = new double[in + 1];
        double pu = 0, pb = 0;

        int count = 0, starts = 10;

        boolean noSolFlag, puFlag, botFlag, annFlag, notPhysSolFlag, inFlag;

        while (Math.abs(pzStep) > pzStepMin) {
            noSolFlag = false;
            puFlag = false;
            botFlag = false;
            annFlag = false;
            inFlag = false;
            System.out.println("pz=" + pz);
            buffer.append("pz=").append(pz).append("<br>");
//            mean=inGuess;
//            standardDeviation = new double[inGuess.length];
//            RandomGenerator rg = new JDKRandomGenerator();
//            rg.setSeed(17399225432l);
//            GaussianRandomGenerator rGenerator = new GaussianRandomGenerator(rg);

//            for (int i=0;i<inGuess.length;i++){
//                standardDeviation[i] = inGuess[i]/100;
//           }
            // UncorrelatedRandomVectorGenerator generator =
            //    new UncorrelatedRandomVectorGenerator(mean, standardDeviation, rGenerator);
            System.out.println("inGuess= " + Arrays.toString(inGuess));
            buffer.append("inGuess= ").append(Arrays.toString(inGuess)).append("<br>");
            do {
                notPhysSolFlag = false;
                count++;
                pz = pz + pzStep;
                System.out.println("pzStep=" + pzStep + " pz=" + pz);
                buffer.append("pzStep=").append(pzStep).append(" pz=").append(pz).append("<br>");
                while (pz < pz0) {
                    if (pz < pz0) {
                        pz = pz - pzStep;
                        pzStep = pzStep / stepDiv;
                        pz = pz + pzStep;
                    }
                }

                //double[] randomGuess = generator.nextVector();
                //System.out.println("randomGuess= "+Arrays.toString(randomGuess));
                System.out.println("inGuess" + Arrays.toString(inGuess) + " pz=" + pz);
                buffer.append("inGuess").append(Arrays.toString(inGuess)).append(" pz=").append(pz).append("<br>");
                System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType).append("<br>");
                System.out.println("pv=" + Arrays.toString(pv) + " wv=" + Arrays.toString(vw));
                buffer.append("pv=").append(Arrays.toString(pv)).append(" wv=").append(Arrays.toString(vw));
                eqnSol = eqnSolver(out, outType, bot, botType, in, inType, inGuess, vw, pv, pz, forma, calculationsData);
                sol = eqnSol[0];
                sumSqF = eqnSol[1][0];
                System.out.println("Цикл!");
                buffer.append("Цикл!").append("<br>");

                System.out.println("Значение суммы квадратов вектор-функции: F =" + sumSqF + " pz=" + pz);
                buffer.append("Значение суммы квадратов вектор-функции: F =").append(sumSqF).append(" pz=").append(pz).append("<br>");
                System.out.println("Правильное решение ЛМ " + Arrays.toString(sol));
                buffer.append("Правильное решение ЛМ ").append(Arrays.toString(sol)).append("<br>");

                iVGresult = inverseVarGenerator(out, outType, in, inType, sol);
                xn = iVGresult[0];
                xv = iVGresult[1];
                pg = iVGresult[2];
                pu = iVGresult[3][0];
                pb = iVGresult[4][0];

                for (int i = 0; i < xn.length; i++) {
                    if ((xn[i] < 0) || (xn[i] > Lt) || (xv[i] < 0) || (xv[i] > Lt) || (pg[i] < 0)) {
                        System.out.println("Нефизичное решение!");
                        buffer.append("Нефизичное решение!").append("<br>");
                        notPhysSolFlag = true;
                    }
                }
                if ((pb < 0) || (pu < 0) || (sumSqF > 10e-10) || (sol[0] > inGuess[0])) {
                    System.out.println("Нефизичное решение!");
                    buffer.append("Нефизичное решение!").append("<br>");
                    notPhysSolFlag = true;
                }
                if (notPhysSolFlag) {
                    pz = pz - pzStep;
                    pzStep = pzStep / stepDiv;
                    System.out.println("pzStep уменьшено!!!");
                    buffer.append("pzStep уменьшено!!!").append("<br>");
                }
                if ((Math.abs(pzStep) < pzStepMin) && notPhysSolFlag && (pz > pz0)) {
                    pzStep = Math.signum(-pzStep) * Math.abs(pzStep0);
                    System.out.println("pzStep поменял знак!!!");
                    buffer.append("pzStep поменял знак!!!").append("<br>");
                }
            } while (notPhysSolFlag);

            notPhysSolFlag = false;

            System.out.println("xn=" + Arrays.toString(xn) + ", xv=" + Arrays.toString(xv) + ", pg=" + Arrays.toString(pg) + ", pu=" + pu + ", pb=" + pb);
            buffer.append("xn=").append(Arrays.toString(xn)).append(", xv=").append(Arrays.toString(xv)).append(", pg=").append(Arrays.toString(pg)).append(", pu=").append(pu).append(", pb=").append(pb).append("<br>");

            if (sumSqF > 10e-10) {
                System.out.println("Пропало решение!");
                buffer.append("Пропало решение!").append("<br>");
                pz = pz - pzStep;
                pzStep = pzStep / stepDiv;
                sol = inGuess;
                noSolFlag = true;
                puFlag = false;
                botFlag = false;
                annFlag = false;
                inFlag = false;
            }

            if (outType == 'N' ? (Math.abs(xv[out] / Lt)) < 0.001 : (Math.abs(xn[out + 1] / Lt)) < 0.001) {
                System.out.println("Планируется смена пачки на выходе!");
                buffer.append("Планируется смена пачки на выходе!").append("<br>");
                noSolFlag = false;
                puFlag = false;
                botFlag = false;
                annFlag = true;
                inFlag = false;
                pz = pz - pzStep;
                pzStep = pzStep / stepDiv;
                sol = inGuess;
            }

            if (inType == 'N' ? pu > puMax : pu < puMin) {
                System.out.println("Планируется смена пачки на устье!");
                buffer.append("Планируется смена пачки на устье!").append("<br>");
                noSolFlag = false;
                puFlag = true;
                botFlag = false;
                annFlag = false;
                inFlag = false;
                pz = pz - pzStep;
                pzStep = pzStep / stepDiv;
                sol = inGuess;
            }
            //System.out.println("botType="+botType+" pzStep="+pzStep+"Abs="+Math.abs(xv[bot]-Lt)+"Bool");
            if (botType == 'N' ? ((Math.abs(xv[bot] - Lt) / Lt) < 0.001) : ((Math.abs(xn[bot + 1] - Lt) / Lt) < 0.001)) {
                System.out.println("Планируется смена пачки на забое!");
                buffer.append("Планируется смена пачки на забое!").append("<br>");
                noSolFlag = false;
                puFlag = false;
                botFlag = true;
                annFlag = false;
                inFlag = false;
                pz = pz - pzStep;
                pzStep = pzStep / stepDiv;
                sol = inGuess;
            }

            if ((pzStep < 0) && ((Math.abs(pz - pz0) / pz0) < 0.001)) {
                System.out.println("Планируется продолжение закачки!");
                buffer.append("Планируется продолжение закачки!").append("<br>");
                noSolFlag = false;
                puFlag = false;
                botFlag = false;
                annFlag = false;
                inFlag = true;
                pzStep = pzStepMin / stepDiv;
                pz = pz0;

            }

            System.out.println("puFlag=" + puFlag + ", botFlag=" + botFlag + ", annFlag=" + annFlag + ", noSolFlag=" + noSolFlag + ", inFlag=" + inFlag);
            buffer.append("puFlag=").append(puFlag).append(", botFlag=").append(botFlag).append(", annFlag=").append(annFlag).append(", noSolFlag=").append(noSolFlag).append(", inFlag=").append(inFlag).append("<br>");

            inGuess = sol;

            if (Math.abs(pzStep) <= pzStepMin) {
                if (puFlag) {
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("puFlag: Смена пачки на устье!");
                    buffer.append("puFlag: Смена пачки на устье!").append("<br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    if (inType == 'N') {
                        inType = 'W';
                        vw = Arrays.copyOf(vw, vw.length + 1);
                        vw[vw.length - 1] = 0;
                        xv[in] = 0.0;
                    } else {
                        inType = 'N';
                        in++;
                        pv = Arrays.copyOf(pv, pv.length + 1);
                        pv[pv.length - 1] = 0;
                        xn = Arrays.copyOf(xn, xn.length + 1);
                        xn[in] = 0.0;
                        pg = Arrays.copyOf(pg, pg.length + 1);
                        pg[in] = pu;
                    }
                    varsNo = varsCalculator(out, outType, in, inType);
                    sol = varGenerator(out, outType, in, inType, xn, xv, pg, pu, pb);
                    pzStep = pzStep0;
                    inGuess = sol;
                    puFlag = false;
                } else if (botFlag) {
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("botFlag: Смена пачки на забое!");
                    buffer.append("botFlag: Смена пачки на забое!").append("<br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    if (botType == 'N') {
                        botType = 'W';
                    } else {
                        botType = 'N';
                        bot++;
                    }
                    varsNo = varsCalculator(out, outType, in, inType);
                    sol = varGenerator(out, outType, in, inType, xn, xv, pg, pu, pb);
                    pzStep = pzStep0;
                    inGuess = sol;
                    botFlag = false;
                } else if (annFlag) {
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("annFlag: Смена пачки на выходе!");
                    buffer.append("annFlag: Смена пачки на выходе!").append("<br>");
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    if (outType == 'N') {
                        outType = 'W';
                    } else {
                        outType = 'N';
                        out++;
                    }
                    if ((in == out) && (inType == outType)) {
                        System.out.println("Расчет окончен!");
                        buffer.append("Расчет окончен!").append("<br>");
                        calculationsData.setCalcMess(buffer.toString());
                        break;
                    }
                    varsNo = varsCalculator(out, outType, in, inType);
                    sol = varGenerator(out, outType, in, inType, xn, xv, pg, pu, pb);
                    pzStep = pzStep0;
                    inGuess = sol;
                    annFlag = false;
                } else if (inFlag) {
                    System.out.println();
                    System.out.println();
                    buffer.append("<br><br>");
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    System.out.println();buffer.append("<br><br>");
                    System.out.println();buffer.append("<br><br>");
                    System.out.println();
                    System.out.println();
                    System.out.println("inFlag: Продолжение закачки!");
                    buffer.append("inFlag: Продолжение закачки!").append("<br>");
                    System.out.println();buffer.append("<br><br>");
                    System.out.println();
                    //varsNo=varsCalculator(out, outType, in, inType);
                    //sol = varGenerator(out, outType, in, inType, xn, xv, pg, pu, pb);
                    inGuess = sol;
                    inFlag = false;
                } else if (noSolFlag) {
                    System.out.println();
                    System.out.println();buffer.append("<br><br>");
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    System.out.println();buffer.append("<br><br>");
                    System.out.println();buffer.append("<br><br>");
                    System.out.println();
                    System.out.println();
                    System.out.println("noSolFlag.Out: Пока нет реализации!");
                    buffer.append("noSolFlag.Out: Пока нет реализации!").append("<br>");
                    System.out.println();buffer.append("<br><br>");
                    System.out.println();
                    inGuess = sol;
                    break;
                } else {
                    System.out.println();buffer.append("<br><br>");
                    System.out.println();
                    System.out.println("in=" + in + inType + ", bot=" + bot + botType + ", out=" + out + outType);
                    buffer.append("in=").append(in).append(inType).append(", bot=").append(bot).append(botType).append(", out=").append(out).append(outType);
                    System.out.println();buffer.append("<br><br>");
                    System.out.println();buffer.append("<br><br>");
                    System.out.println();
                    System.out.println();
                    System.out.println("Проблема: не сработал ни один из флагов!");
                    buffer.append("Проблема: не сработал ни один из флагов!").append("<br>");
                    System.out.println();
                    System.out.println();
                    break;
                }
            }
            if (inFlag) {
                break;
            }
        }

        System.out.println("Выход из выхода пачек!");
        buffer.append("Выход из выхода пачек!").append("<br>");

        result[0] = xn;
        result[1] = xv;
        result[2] = pg;
        result[3] = new double[]{pu, pb, sumSqF};
        result[4] = vw;
        result[5] = pv;
        result[6] = new double[]{pz};
        result[7] = new double[]{out, bot, in};
        result[8] = new double[]{((outType == 'N') ? 0 : 1), ((botType == 'N') ? 0 : 1), ((inType == 'N') ? 0 : 1)};
        return result;

    }

    private double[][] eqnSolver(int out, char outType, int bot, char botType, int in, char inType, double[] inGuess, double[] vw, double[] pv, double pz, Forma forma, CalculationsData calculationsData) {
        //System.out.println("Инициализация переменных");
        int varsNo = inGuess.length;
        //System.out.println("varsNo="+varsNo);
        double[][] result = new double[2][];
        double[] observedF = new double[varsNo];
        double[] wMatrix = new double[varsNo];

        RealMatrix weight;
        Arrays.fill(observedF, 0);
        Arrays.fill(wMatrix, 1);
        weight = new DiagonalMatrix(wMatrix);

        //System.out.println("Инициализация SimpleVectorValueChecker");
        //SimpleVectorValueChecker(double relativeThreshold, double absoluteThreshold, int maxIter)
        SimpleVectorValueChecker MyChecker = new SimpleVectorValueChecker(1e-20, 1e-20, Integer.MAX_VALUE);
        EqnGenerator myFunc = new EqnGenerator(out, outType, bot, botType, in, inType, vw, pv, pz, forma, calculationsData);
        JacobianFunction myJacob = new JacobianFunction(myFunc);
        LevenbergMarquardtOptimizer optimizer = new LevenbergMarquardtOptimizer();

        RealVector optimalValues = new ArrayRealVector();
        LeastSquaresOptimizer.Optimum optimum;
        LeastSquaresProblem problem;

        //System.out.println("inGuess= "+Arrays.toString(inGuess));
        problem = LeastSquaresFactory.create(myFunc, // MultivariateVectorFunction model
                myJacob, // MultivariateMatrixFunction jacobian
                observedF, // double[] observed
                inGuess, // double[] start
                weight, // RealMatrix weight
                LeastSquaresFactory.evaluationChecker(MyChecker), // ConvergenceChecker<LeastSquaresProblem.Evaluation> checker
                Integer.MAX_VALUE, // int maxEvaluations Integer.MAX_VALUE
                Integer.MAX_VALUE);                               // int maxIterations Integer.MAX_VALUE

        optimum = optimizer.optimize(problem);
        optimalValues = optimum.getPoint();

        //System.out.println("Решение: " + optimalValues);
        //System.out.println("Правильное решение ЛМ "+Arrays.toString(optimalValues.toArray()));
        //System.out.println("Значение функции: F ="+Arrays.toString(myFunc.value(optimalValues.toArray())));
        double sum = 0;
        for (int i = 0; i < varsNo; i++) {
            sum = sum + Math.pow(myFunc.value(optimalValues.toArray())[i], 2);
        }

        result[0] = optimalValues.toArray();
        result[1] = new double[]{sum};
        return result;
    }

    private int varsCalculator(int out, char outType, int in, char inType) {
        int varsNo;
        if (outType == 'N' && inType == 'N') {
            varsNo = 3 * (in - out) + 3;
        } else if (outType == 'N' && inType == 'W') {
            varsNo = 3 * (in - out) + 4;
        } else if (outType == 'W' && inType == 'N') {
            varsNo = 3 * (in - out) + 1;
        } else if (outType == 'W' && inType == 'W') {
            varsNo = 3 * (in - out) + 2;
        } else {
            System.out.println("Неопределенная комбинация в varGenerator");
            buffer.append("Неопределенная комбинация в varGenerator").append("<br>");
            varsNo = 0;
        }
        return varsNo;
    }

    private double[][] inverseVarGenerator(int out, char outType, int in, char inType, double[] vars) {

        double xn[] = new double[in + 1];
        double xv[] = new double[in + 1];
        double pg[] = new double[in + 1];
        double pu, pb;
        double[][] result = new double[5][];
        int varsNo = vars.length;

        if (outType == 'N' && inType == 'N') {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // xv[i] | xn[i+1] xv[i+1] ... xn[k-1]         xv[k-1]     | xn[k]      Pu       Pb         | Pg[i]      ... Pg[k]         //
            // 0     | 1       2       ... 2(in-out-1)-1   2(in-out-1) | 2in-2out-1 2in-2out 2in-2out+1 | 2in-2out+2 ... 3(in-out)+2   //
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //varsNo=3*(in-out)+3;
            xv[out] = vars[0];
            for (int i = 1; i <= (in - out - 1); i++) {
                xn[i + out] = vars[2 * i - 1];
                xv[i + out] = vars[2 * i];
            }
            xn[in] = vars[2 * in - 2 * out - 1];
            pu = vars[2 * in - 2 * out];
            pb = vars[2 * in - 2 * out + 1];
            for (int i = 2 * in - 2 * out + 2; i < varsNo; i++) {
                pg[i - (2 * in - 3 * out + 2)] = vars[i];
            }
        } else if (outType == 'N' && inType == 'W') {
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // xv[i] | xn[i+1] xv[i+1] ... xn[k]         xv[k]     | Pu         Pb         | Pg[i]      ... Pg[k]           //
            // 0     | 1       2       ... 2(in-out)-1   2(in-out) | 2in-2out+1 2in-2out+2 | 2in-2out+3 ... 3(in-out+1)     //
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //varsNo=3*(in-out)+4;
            xv[out] = vars[0];
            for (int i = 1; i <= (in - out); i++) {
                xn[i + out] = vars[2 * i - 1];
                xv[i + out] = vars[2 * i];
            }
            pu = vars[2 * in - 2 * out + 1];
            pb = vars[2 * in - 2 * out + 2];
            for (int i = 2 * in - 2 * out + 3; i < varsNo; i++) {
                pg[i - (2 * in - 3 * out + 3)] = vars[i];
            }
        } else if (outType == 'W' && inType == 'N') {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // xn[i+1] xv[i+1] ... xn[k-1]         xv[k-1]       | xn[k]      Pu         Pb       | Pg[i+1]    ... Pg[k]         //
            // 0       1       ... 2(in-out-2)     2(in-out-1)-1 | 2in-2out-2 2in-2out-1 2in-2out | 2in-2out+1 ... 3(in-out)     //
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //varsNo=3*(in-out)+1;
            for (int i = 0; i <= (in - out - 2); i++) {
                xn[i + out + 1] = vars[2 * i];
                xv[i + out + 1] = vars[2 * i + 1];
            }
            xn[in] = vars[2 * in - 2 * out - 2];
            pu = vars[2 * in - 2 * out - 1];
            pb = vars[2 * in - 2 * out];
            for (int i = 2 * in - 2 * out + 1; i < varsNo; i++) {
                pg[i - (2 * in - 3 * out)] = vars[i];
            }
        } else if (outType == 'W' && inType == 'W') {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
            // xn[i+1] xv[i+1] ... xn[k]         xv[k]       | Pu       Pb         | Pg[i+1]    ... Pg[k]         //
            // 0       1       ... 2(in-out-1)   2(in-out)-1 | 2in-2out 2in-2out+1 | 2in-2out+2 ... 3(in-out)+1   //
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            //varsNo=3*(in-out)+2;
            for (int i = 0; i <= (in - out - 1); i++) {
                xn[i + out + 1] = vars[2 * i];
                xv[i + out + 1] = vars[2 * i + 1];
            }
            pu = vars[2 * in - 2 * out];
            pb = vars[2 * in - 2 * out + 1];
            for (int i = 2 * in - 2 * out + 2; i < varsNo; i++) {
                pg[i - (2 * in - 3 * out + 1)] = vars[i];
            }
        } else {
            System.out.println("Неопределенная комбинация в varGenerator");
            buffer.append("Неопределенная комбинация в varGenerator").append("<br>");
            xn = new double[]{0};
            xv = new double[]{0};
            pg = new double[]{0};
            pu = 0;
            pb = 0;
        }
        result[0] = xn;
        result[1] = xv;
        result[2] = pg;
        result[3] = new double[]{pu};
        result[4] = new double[]{pb};
        return result;
    }

    private double[] varGenerator(int out, char outType, int in, char inType, double[] xn, double[] xv, double[] pg, double pu, double pb) {
        int varsNo;
        double[] vars;
        if (outType == 'N' && inType == 'N') {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // xv[i] | xn[i+1] xv[i+1] ... xn[k-1]         xv[k-1]     | xn[k]      Pu       Pb         | Pg[i]      ... Pg[k]         //
            // 0     | 1       2       ... 2(in-out-1)-1   2(in-out-1) | 2in-2out-1 2in-2out 2in-2out+1 | 2in-2out+2 ... 3(in-out)+2   //
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            varsNo = 3 * (in - out) + 3;
            vars = new double[varsNo];
            vars[0] = xv[out];
            for (int i = 1; i <= (in - out - 1); i++) {
                vars[2 * i - 1] = xn[i + out];
                vars[2 * i] = xv[i + out];
            }
            vars[2 * in - 2 * out - 1] = xn[in];
            vars[2 * in - 2 * out] = pu;
            vars[2 * in - 2 * out + 1] = pb;
            for (int i = 2 * in - 2 * out + 2; i < varsNo; i++) {
                vars[i] = pg[i - (2 * in - 3 * out + 2)];
            }
        } else if (outType == 'N' && inType == 'W') {
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // xv[i] | xn[i+1] xv[i+1] ... xn[k]         xv[k]     | Pu         Pb         | Pg[i]      ... Pg[k]           //
            // 0     | 1       2       ... 2(in-out)-1   2(in-out) | 2in-2out+1 2in-2out+2 | 2in-2out+3 ... 3(in-out+1)     //
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            varsNo = 3 * (in - out) + 4;
            vars = new double[varsNo];
            vars[0] = xv[out];
            for (int i = 1; i <= (in - out); i++) {
                vars[2 * i - 1] = xn[i + out];
                vars[2 * i] = xv[i + out];
            }
            vars[2 * in - 2 * out + 1] = pu;
            vars[2 * in - 2 * out + 2] = pb;
            for (int i = 2 * in - 2 * out + 3; i < varsNo; i++) {
                vars[i] = pg[i - (2 * in - 3 * out + 3)];
            }
        } else if (outType == 'W' && inType == 'N') {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // xn[i+1] xv[i+1] ... xn[k-1]         xv[k-1]       | xn[k]      Pu         Pb       | Pg[i+1]    ... Pg[k]         //
            // 0       1       ... 2(in-out-2)     2(in-out-1)-1 | 2in-2out-2 2in-2out-1 2in-2out | 2in-2out+1 ... 3(in-out)     //
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            varsNo = 3 * (in - out) + 1;
            vars = new double[varsNo];
            for (int i = 0; i <= (in - out - 2); i++) {
                vars[2 * i] = xn[i + out + 1];
                vars[2 * i + 1] = xv[i + out + 1];
            }
            vars[2 * in - 2 * out - 2] = xn[in];
            vars[2 * in - 2 * out - 1] = pu;
            vars[2 * in - 2 * out] = pb;
            for (int i = 2 * in - 2 * out + 1; i < varsNo; i++) {
                vars[i] = pg[i - (2 * in - 3 * out)];
            }
        } else if (outType == 'W' && inType == 'W') {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
            // xn[i+1] xv[i+1] ... xn[k]         xv[k]       | Pu       Pb         | Pg[i+1]    ... Pg[k]         //
            // 0       1       ... 2(in-out-1)   2(in-out)-1 | 2in-2out 2in-2out+1 | 2in-2out+2 ... 3(in-out)+1   //
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            varsNo = 3 * (in - out) + 2;
            vars = new double[varsNo];
            for (int i = 0; i <= (in - out - 1); i++) {   //Изменено in-out->in-out-1
                vars[2 * i] = xn[i + out + 1];
                vars[2 * i + 1] = xv[i + out + 1];
            }
            vars[2 * in - 2 * out] = pu;
            vars[2 * in - 2 * out + 1] = pb;
            for (int i = 2 * in - 2 * out + 2; i < varsNo; i++) {
                vars[i] = pg[i - (2 * in - 3 * out + 1)];      //Изменено 2*in-out+1->2*in-3*out+1
            }
        } else {
            System.out.println("Неопределенная комбинация в varGenerator");
            buffer.append("Неопределенная комбинация в varGenerator").append("<br>");
            vars = new double[1];
        }
        return vars;
    }

    @Override
    public void solver_for_avarageDiams(Forma forma) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
}
