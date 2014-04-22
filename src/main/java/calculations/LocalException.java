/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculations;

import org.apache.commons.math3.analysis.UnivariateFunction;

/**
 *
 * @author alex
 */
class LocalException extends RuntimeException {

   // the x value that caused the problem
   private final double x;

   public LocalException(double x) {
     this.x = x;
   }

   public double getX() {
     return x;
   }
 }
