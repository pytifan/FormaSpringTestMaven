/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculations;

import org.apache.commons.math3.analysis.MultivariateMatrixFunction;

/**
 *
 * @author alex
 */
 public class MyFunction implements MultivariateMatrixFunction {
     
//     public double value(double x) {
//     double y = Math.pow(x, 3) + x + 2;
//     if (y<0) {
//       throw new LocalException(x);
//     }
//     return y;
//   }

    @Override
    public double[][] value(double[] point) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
