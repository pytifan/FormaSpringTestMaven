package calculations;

// equation_nl.java  handle reciprocal terms       
//  f1(x1, x2, x3) = x1 + 2 x2^2 + 3/x3 = 10    
//  f1'(x1) = 1                                 
//  f1'(x2) = 4 x2                              
//  f1'(x3) = -3/x3^2                           
//                                              
//  f2(x1, x2, x3) = 2 x1 + x2^2 + 1/x3 = 6.333 
//  f2'(x1) = 2                                 
//  f2'(x2) = 2 x2                              
//  f2'(x3) = -3/x3^2                           
//                                              
//  f3(x1, x2, x3) = 3 x1 + x2^2 + 4/x3 = 8.333 
//  f3'(x1) = 3                                 
//  f3'(x2) = 2 x2                              
//  f3'(x3) = -4/x3^2                          
//                                              
// in matrix form, the equations are: A * X = Y 
// | 1  2  3 |   |  x1  | = | 10.000 |          
// | 2  1  1 | * | x2^2 | = |  6.333 |          
// | 3  1  4 |   | 1/x3 | = |  8.333 |          
//      A      *    Xt    =     Y               
//                                              
// in matrix form, the Jacobian is:             
//     |   1    |   | 1   4*x2  -3/x3^2 |       
// A * | 2*x2   | = | 2   2*x2  -1/x3^2 | = Ja   
//     |-1/x3^2 |   | 3   2*x2  -4/x3^2 |       
// A *     D      =        Ja                    
//     deriv of X                               
//     wrt x1,x2,x3                             
//                                              
// Newton iteration:                            
// x_next = x-fctr*(A*Xt-Y)/Ja,  /Ja is times transpose inverse of Ja 
// Ja is, in general, dependent on all variables 

import java.text.*;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
// needs inverse.java

public class equation_nl
{
  equation_nl()
  {
    int nitr = 7;
    double A[][] = {{1.0, 2.0, 3.0}, {2.0, 1.0, 1.0}, {3.0, 1.0, 4.0}};
    double Xt[] = new double[3]; // X terms, A * Xt = Y 
                                 // with X being nonlinear terms 
    double Y[] = new double[3]; // RHS of equations 
    double D[] = new double[3]; // derivative of X terms 
    double Ja[][] = new double[3][3]; // Jacobian to be inverted 
    double JI[][] = new double[3][3]; // Jacobian  inverted 
    double F[] = new double[3];  // A*X-Y error to be multiplied by J inverse 
    double x1, x2, x3; // initial guess and solution 
    double fctr = 1.0; // can be unstable 

    DecimalFormat f7 = new DecimalFormat("  0.0000");
    DecimalFormat f8 = new DecimalFormat("  0.00000");

    System.out.println("equation_nl.java running ");
    System.out.println("solve   x1 + 2 x2^2 + 3/x3 = 10 ");
    System.out.println("      2 x1 +   x2^2 + 1/x3 = 6.333 ");
    System.out.println("      3 x1 +   x2^2 + 4/x3 = 8.333 ");
    System.out.println(" | 1  2  3 |   |  x1  | = | 10.000 | ");
    System.out.println(" | 2  1  1 | * | x2^2 | = |  6.333 | ");
    System.out.println(" | 3  1  4 |   | 1/x3 | = |  8.333 | ");
    System.out.println("      A      *    X     =     Y      ");
    System.out.println("guess initial x1, x2, x3 ");
    System.out.println("compute Xt = | x1  x2^2  1/x3 | ");
    System.out.println("compute derivative D = | 1  2*x2 -1/x3^2 | ");
    System.out.println("compute the Jacobian Ja = A * D and invert ");
    System.out.println("iterate x_next = x - fctr*(A*Xt-Y)*Ja^-1 ");
    System.out.println("no guarantee of solution or unique solution ");
    System.out.println("sum absolute value A*Xt-Y should go to zero ");

    Y[0] = f1(1.0, 2.0, 3.0); // desired solution 1, 2, 3 
    Y[1] = f2(1.0, 2.0, 3.0); // compute Y accurately 
    Y[2] = f3(1.0, 2.0, 3.0);
    System.out.println("| "+f7.format(A[0][0])+" "+f7.format(A[0][1])+" "+
		       f7.format(A[0][2])+" |   |  x1  |   | "+
                       f7.format(Y[0])+" | "); 
    System.out.println("| "+f7.format(A[1][0])+" "+f7.format(A[1][1])+" "+
		       f7.format(A[1][2])+" |   |x2*x2 |   | "+
                       f7.format(Y[1])+" | "); 
    System.out.println("| "+f7.format(A[2][0])+" "+f7.format(A[2][1])+" "+
		       f7.format(A[2][2])+" |   | 1/x3 |   | "+
                       f7.format(Y[2])+" | "); 
    System.out.println(" ");
    x1 = 1.0; // variable initial guess 
    x2 = 1.0;
    x3 = 1.0;
    for(int itr=0; itr<nitr; itr++)
    {
      System.out.println("x1="+f8.format(x1)+", x2="+f8.format(x2)+
      		         ", x3="+f8.format(x3));
      Xt[0] = x1; // terms based on this iteration 
      Xt[1] = x2*x2;
      Xt[2] = 1.0/x3;
      System.out.println("Xt[0]="+f8.format(Xt[0])+", Xt[1]="+f8.format(Xt[1])+
      		         ", Xt[2]="+f8.format(Xt[2]));
      D[0] = 1.0; // derivatives based on this iteration 
      D[1] = 2.0*x2;
      D[2] = -1.0/(x3*x3);
      System.out.println("D[0]="+f8.format(D[0])+", D[1]="+f8.format(D[1])+
      		         ", D[2]="+f8.format(D[2]));
      for(int i=0; i<3; i++)
      { 
        F[i] = 0.0;
        for(int j=0; j<3; j++)
        {
          F[i] += A[i][j]*Xt[j];
          Ja[i][j] = A[i][j]*D[j];
        }
        F[i] -= Y[i]; // residual  A*X-Y for row i 
      }    
      System.out.println("F[0]="+f8.format(F[0])+", F[1]="+f8.format(F[1])+
      		         ", F[2]="+f8.format(F[2]));
      System.out.println("iteration "+itr+", total error="+
                         (Math.abs(F[0])+Math.abs(F[1])+Math.abs(F[2]))+"\n");
      for(int i=0; i<3; i++)
        System.out.println("Ja["+i+"][0]="+f8.format(Ja[i][0])+
                           ", Ja["+i+"][1]="+f8.format(Ja[i][1])+
      		           ", Ja["+i+"][2]="+f8.format(Ja[i][2]));
  // Invert, using LU decomposition
RealMatrix m = MatrixUtils.createRealMatrix(Ja);
              
JI = new LUDecomposition(m).getSolver().getInverse().getData();
   //   new inverse(Ja, JI);
      for(int i=0; i<3; i++)
        System.out.println("JI["+i+"][0]="+f8.format(JI[i][0])+
                           ", JI["+i+"][1]="+f8.format(JI[i][1])+
      		           ", JI["+i+"][2]="+f8.format(JI[i][2]));
      for(int i=0; i<3; i++)
      {
        x1 -= fctr*F[i]*JI[0][i]; // transpose  
        x2 -= fctr*F[i]*JI[1][i]; // transpose  
        x3 -= fctr*F[i]*JI[2][i]; // transpose  
      }
    }

    System.out.println(" ");
    System.out.println("final x1="+f8.format(x1)+", x2="+f8.format(x2)+
      		         ", x3="+f8.format(x3));
    Xt[0] = x1; // terms based on current guess 
    Xt[1] = x2*x2;
    Xt[2] = 1.0/x3;
    System.out.println("terms Xt[0]="+f8.format(Xt[0])+
                       ", Xt[1]="+f8.format(Xt[1])+
      		       ", Xt[2]="+f8.format(Xt[2]));
    for(int i=0; i<3; i++)
    { 
      F[i] = 0.0;
      for(int j=0; j<3; j++)
      {
        F[i] += A[i][j]*Xt[j];
      }
      F[i] -= Y[i]; // A*Xt-Y for row i 
    }    
    System.out.println("final total error="+
    		     (Math.abs(F[0])+Math.abs(F[1])+Math.abs(F[2])));

    System.out.println("equation_nl.java finished ");
  }

  // three functions representing Y 
  double f1(double x1, double x2, double x3)
  {
    return x1 + 2.0*x2*x2 + 3.0/x3; //  = 10.0 
  }
  double f2(double x1, double x2, double x3)
  {
    return 2.0*x1 + x2*x2 + 1.0/x3; // = 6.333 
  }
  double f3(double x1, double x2, double x3)
  {
    return 3.0*x1 + x2*x2 + 4.0/x3; // = 8.333 
  }

  public static void run ()
  {
    new equation_nl();
  } // end main  

} // end class equation_nl 






