/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.region.forms.osvoenie.service;

import org.region.forms.osvoenie.form.data.CalculationsData;
import org.region.forms.osvoenie.form.data.Forma;

/**
 *
 * @author alex
 */
public interface FormOsvoenieSomeService {
       public void doSmthing (Forma forma, CalculationsData calculationsData) throws Exception;
       public void CasingAvarageDiamCalculations(Forma forma) throws Exception;
       public void solver_for_avarageDiams (Forma forma) throws Exception; 
}
