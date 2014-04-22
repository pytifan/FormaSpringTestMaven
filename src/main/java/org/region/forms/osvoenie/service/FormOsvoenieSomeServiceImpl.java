/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.region.forms.osvoenie.service;

import calculations.MyFunction;
import jy.py.thon_calc.BuildingFactory;
import jy.py.thon_calc.BuildingType;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.linear.*;
import org.region.forms.osvoenie.spring.controller.Forma;
import org.springframework.stereotype.Service;

/**
 *
 * @author alex
 */
@Service
public class FormOsvoenieSomeServiceImpl implements FormOsvoenieSomeService {
    private String FieldName, WellName;
    private double internalDiamCasing1, internalDiamCasing2, internalDiamCasing3, internalDiamCasing4, internalDiamCasing5;
    private BuildingType building;
    
    @Override
    public void doSmthing(Forma forma) throws Exception {
        //  MyRecipient recipient = new MyRecipient();
        FieldName = forma.getFieldName();
        WellName = forma.getWellName();
        forma.setComments(FieldName.concat(WellName));
        
       // nl_solver_test();
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
        MultivariateMatrixFunction f = new MyFunction();
//        double result = (1000, f, 0.0, 5.0);
//        forma.setRig(String.valueOf(result));        
//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");
//        engine.eval("import sys");
//        engine.eval("print sys");
//        engine.put("a", 47);
//        engine.eval("print a");
//        engine.eval("x = 2 + 2");
//        Object a = engine.get("a"); //        System.out.println("a: " + a);
//        forma.setRig(a.toString());
//        engine.eval("from __future__ import division");
//        engine.eval("from sympy import *");
//        engine.eval("x, y, z, t = symbols('x y z t')");
//        engine.eval("k, m, n = symbols('k m n', integer=True)");
//        engine.eval("f, g, h = symbols('f g h', cls=Function)");
//        System.setProperty("LD_LIBRARY_PATH","/usr/local/MATLAB/MATLAB_Compiler_Runtime/v81/runtime/glnxa64");
//        System.load("/usr/local/MATLAB/MATLAB_Compiler_Runtime/v81/runtime/glnxa64/libmwmclmcrrt.so.8.1");
//        System.load("libmwmclmcrrt.so.8.1");
//        Field fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
//        fieldSysPath.setAccessible( true );
//        fieldSysPath.set( null, null );
        
//        QuadraticProblem problem = new QuadraticProblem();
//        problem.addPoint(1, 34.234064369);
//        problem.addPoint(2, 68.2681162306);
//        problem.addPoint(3, 118.6158990846);
//        problem.addPoint(4, 184.1381972386);
//        problem.addPoint(5, 266.5998779163);
//        problem.addPoint(6, 364.1477352516);
//        problem.addPoint(7, 478.0192260919);
//        problem.addPoint(8, 608.1409492707);
//        problem.addPoint(9, 754.5988686671);
//        problem.addPoint(10, 916.1288180859);
//        LevenbergMarquardtOptimizer optimizer = new LevenbergMarquardtOptimizer();
//        final double[] weights = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        final double[] initialSolution = {1, 1, 1};
//        PointVectorValuePair optimum = optimizer.optimize(100, problem, problem.calculateTarget(), weights, initialSolution);
//        final double[] optimalValues = optimum.getPoint();
//        System.out.println("A: " + optimalValues[0]);
//        System.out.println("B: " + optimalValues[1]);
//        System.out.println("C: " + optimalValues[2]);
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
    
    
    
//    public void nl_solver_test() {
//                
//    int nitr = 7;
//    double A[][] = {{1.0, 2.0, 3.0}, {2.0, 1.0, 1.0}, {3.0, 1.0, 4.0}};
//    double Xt[] = new double[3]; // X terms, A * Xt = Y 
//                                 // with X being nonlinear terms 
//    double Y[] = new double[3];  // RHS of equations 
//    double D[] = new double[3];  // derivative of X terms 
//    double Ja[][] = new double[3][3]; // Jacobian to be inverted 
//    double JI[][] = new double[3][3]; // Jacobian  inverted 
//    double F[] = new double[3];  // A*X-Y error to be multiplied by J inverse 
//    double x1, x2, x3; // initial guess and solution 
//    double fctr = 1.0; // can be unstable 
//
//    DecimalFormat f7 = new DecimalFormat("  0.0000");
//    DecimalFormat f8 = new DecimalFormat("  0.00000");
//
//    System.out.println("equation_nl.java running ");
//    System.out.println("solve   x1 + 2 x2^2 + 3/x3 = 10 ");
//    System.out.println("      2 x1 +   x2^2 + 1/x3 = 6.333 ");
//    System.out.println("      3 x1 +   x2^2 + 4/x3 = 8.333 ");
//    System.out.println(" | 1  2  3 |   |  x1  | = | 10.000 | ");
//    System.out.println(" | 2  1  1 | * | x2^2 | = |  6.333 | ");
//    System.out.println(" | 3  1  4 |   | 1/x3 | = |  8.333 | ");
//    System.out.println("      A      *    X     =     Y      ");
//    System.out.println("guess initial x1, x2, x3 ");
//    System.out.println("compute Xt = | x1  x2^2  1/x3 | ");
//    System.out.println("compute derivative D = | 1  2*x2 -1/x3^2 | ");
//    System.out.println("compute the Jacobian Ja = A * D and invert ");
//    System.out.println("iterate x_next = x - fctr*(A*Xt-Y)*Ja^-1 ");
//    System.out.println("no guarantee of solution or unique solution ");
//    System.out.println("sum absolute value A*Xt-Y should go to zero ");
//
//    Y[0] = f1(1.0, 2.0, 3.0); // desired solution 1, 2, 3 
//    Y[1] = f2(1.0, 2.0, 3.0); // compute Y accurately 
//    Y[2] = f3(1.0, 2.0, 3.0);
//    System.out.println("| "+f7.format(A[0][0])+" "+f7.format(A[0][1])+" "+f7.format(A[0][2])+" |   |  x1  |   | "+f7.format(Y[0])+" | "); 
//    System.out.println("| "+f7.format(A[1][0])+" "+f7.format(A[1][1])+" "+f7.format(A[1][2])+" |   |x2*x2 |   | "+f7.format(Y[1])+" | "); 
//    System.out.println("| "+f7.format(A[2][0])+" "+f7.format(A[2][1])+" "+f7.format(A[2][2])+" |   | 1/x3 |   | "+f7.format(Y[2])+" | "); 
//    System.out.println(" ");
//    x1 = 1.0; // variable initial guess 
//    x2 = 1.0;
//    x3 = 1.0;
//    for(int itr=0; itr<nitr; itr++)
//    {
//      System.out.println("x1="+f8.format(x1)+", x2="+f8.format(x2)+", x3="+f8.format(x3));
//      Xt[0] = x1; // terms based on this iteration 
//      Xt[1] = x2*x2;
//      Xt[2] = 1.0/x3;
//      System.out.println("Xt[0]="+f8.format(Xt[0])+", Xt[1]="+f8.format(Xt[1])+", Xt[2]="+f8.format(Xt[2]));
//      D[0] = 1.0; // derivatives based on this iteration 
//      D[1] = 2.0*x2;
//      D[2] = -1.0/(x3*x3);
//      System.out.println("D[0]="+f8.format(D[0])+", D[1]="+f8.format(D[1])+", D[2]="+f8.format(D[2]));
//      for(int i=0; i<3; i++)
//      { 
//        F[i] = 0.0;
//        for(int j=0; j<3; j++)
//        {
//          F[i] += A[i][j]*Xt[j];
//          Ja[i][j] = A[i][j]*D[j];
//        }
//        F[i] -= Y[i]; // residual  A*X-Y for row i 
//      }    
//      System.out.println("F[0]="+f8.format(F[0])+", F[1]="+f8.format(F[1])+", F[2]="+f8.format(F[2]));
//      System.out.println("iteration "+itr+", total error="+(Math.abs(F[0])+Math.abs(F[1])+Math.abs(F[2]))+"\n");
//      for(int i=0; i<3; i++)
//      System.out.println("Ja["+i+"][0]="+f8.format(Ja[i][0])+", Ja["+i+"][1]="+f8.format(Ja[i][1])+", Ja["+i+"][2]="+f8.format(Ja[i][2]));
//  // Invert, using LU decomposition
//RealMatrix m = MatrixUtils.createRealMatrix(Ja);
//              
//JI = new LUDecomposition(m).getSolver().getInverse().getData();
//   //   new inverse(Ja, JI);
//      for(int i=0; i<3; i++)
//        System.out.println("JI["+i+"][0]="+f8.format(JI[i][0])+", JI["+i+"][1]="+f8.format(JI[i][1])+", JI["+i+"][2]="+f8.format(JI[i][2]));
//      for(int i=0; i<3; i++)
//      {
//        x1 -= fctr*F[i]*JI[0][i]; // transpose  
//        x2 -= fctr*F[i]*JI[1][i]; // transpose  
//        x3 -= fctr*F[i]*JI[2][i]; // transpose  
//      }
//    }
//
//    System.out.println(" ");
//    System.out.println("final x1="+f8.format(x1)+", x2="+f8.format(x2)+", x3="+f8.format(x3));
//    Xt[0] = x1; // terms based on current guess 
//    Xt[1] = x2*x2;
//    Xt[2] = 1.0/x3;
//    System.out.println("terms Xt[0]="+f8.format(Xt[0])+", Xt[1]="+f8.format(Xt[1])+", Xt[2]="+f8.format(Xt[2]));
//    for(int i=0; i<3; i++)
//    { 
//      F[i] = 0.0;
//      for(int j=0; j<3; j++)
//      {
//        F[i] += A[i][j]*Xt[j];
//      }
//      F[i] -= Y[i]; // A*Xt-Y for row i 
//    }    
//    System.out.println("final total error="+(Math.abs(F[0])+Math.abs(F[1])+Math.abs(F[2])));
//    System.out.println("equation_nl.java finished ");
//}  
//       // three functions representing Y 
//    public double f1(double x1, double x2, double x3) {
//       return x1 + 2.0*x2*x2 + 3.0/x3; //  = 10.0 
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
//    }
//
//    public double f2(double x1, double x2, double x3) {
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//       return 2.0*x1 + x2*x2 + 1.0/x3; // = 6.333 
//    }
//
//    public double f3(double x1, double x2, double x3) {
//      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//       return 3.0*x1 + x2*x2 + 4.0/x3; // = 8.333 
//    }
  
    public int NumberOfsegments(Forma forma) {
        int numberofsegments = 0;
        if (forma.getInternalDiamCasing1() != 0.0) { numberofsegments = 1; }
        if (forma.getInternalDiamCasing2() != 0.0) { numberofsegments = 2; }
        if (forma.getInternalDiamCasing3() != 0.0) { numberofsegments = 3; }
        if (forma.getInternalDiamCasing4() != 0.0) { numberofsegments = 4; }
        if (forma.getInternalDiamCasing5() != 0.0) { numberofsegments = 5; }
        return numberofsegments;
    }
    
    public RealVector solvingLinearSystems() {
        RealMatrix coefficients = new Array2DRowRealMatrix(new double[][]{{2, 3, -2}, {-1, 7, 6}, {4, -3, -5}}, false);
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
// Next create a RealVector array to represent the constant vector B and use solve(RealVector) to solve the system
        RealVector constants = new ArrayRealVector(new double[]{1, -2, 1}, false);
        RealVector solution = solver.solve(constants);
        return solution;
    }

    @Override
    public void solver_for_avarageDiams(Forma forma) throws Exception {
        /*experimnets with Jython*/
        System.out.println("ssssssssssss");
        BuildingFactory factory = new BuildingFactory();
        
        factory.create("BUILDING-A", "100 WEST MAIN", "1");
//        factory.create("BUILDING-B", "110 WEST MAIN", "2");
//        factory.create("BUILDING-C", "120 WEST MAIN", "3");
         System.out.println("Building Info: ");
        System.out.println("Building Info: " +
                building.getBuildingId() + " " +
                building.getBuildingName() + " " +
                building.getBuildingAddress());
//        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        private void print(BuildingType building) {
        System.out.println("Building Info: " +
                building.getBuildingId() + " " +
                building.getBuildingName() + " " +
                building.getBuildingAddress());
    }
    
}
