package org.region.forms.osvoenie.spring.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.region.forms.osvoenie.service.FormOsvoenieSomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

/**
 * A Spring MVC form controller for the Letter example.
 */
@Controller
//@SessionAttributes(types = Recipient.class)
@RequestMapping(value = "Forma-OsvoenieX.htm")
public class LetterFormController {

    private Map<Long, Forma> forms = new ConcurrentHashMap<Long, Forma>();
    private Validator validator;
    
    private final FormOsvoenieSomeService formOsvoenieSomeService;
    // private final AvarageDiametersCalculator avarageDiametersCalculator;

    @Autowired
    public LetterFormController(FormOsvoenieSomeService formOsvoenieSomeService) {
        this.formOsvoenieSomeService = formOsvoenieSomeService;
        //    this.avarageDiametersCalculator = avarageDiametersCalculator;
    }

    public LetterFormController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param model
     * @param request
     * @param response
     * @param command
     * @return
     * @throws Exception
     */
//  @Override
//   protected ModelAndView onSubmit (Object command) throws Exception {
//    Recipient recipient = (Recipient) command;
//    return new ModelAndView("RecipientSuccess", "recipient", recipient).addObject("date", new Date());
//  }
//  private Map<Long, Recipient> recipients = new ConcurrentHashMap<Long, Recipient>();    
    @RequestMapping(method = RequestMethod.GET)
    public String CreateForm(Model model) {
        Forma forma = new Forma();
        model.addAttribute(forma);
        model.addAttribute(new Date());
        return "Forma-OsvoenieX";
    }

    @RequestMapping(params = "Calculate", method = RequestMethod.POST)
    public String create(Forma forma, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            System.out.println("Calculate error");
            return "Forma-OsvoenieX";
        } else {
            try {
                this.formOsvoenieSomeService.doSmthing(forma);
                //  this.formOsvoenieSomeService.CasingAvarageDiamCalculations(forma);
                this.formOsvoenieSomeService.solver_for_avarageDiams(forma);
                } catch (Exception ex) {
                    //   Logger.getLogger(LetterFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            status.setComplete();
            return "RecipientSuccess";
        }
    }
    
    @RequestMapping(params = "Save Json", method = RequestMethod.POST)
    public @ResponseBody Map<String, ? extends Object> createForm(@RequestBody Forma forma, BindingResult result, HttpServletResponse response) {
        Set<ConstraintViolation<Forma>> failures = validator.validate(forma);
        if (!failures.isEmpty()) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        System.out.println("JSON error");
        return validationMessages(failures);       
        } else {
        forms.put(forma.assignId(), forma);
        return Collections.singletonMap("id", forma.getId());
        }
    }
    	// internal helpers
	private Map<String, String> validationMessages(Set<ConstraintViolation<Forma>> failures) {
		Map<String, String> failureMessages = new HashMap<String, String>();
		for (ConstraintViolation<Forma> failure : failures) {
			failureMessages.put(failure.getPropertyPath().toString(), failure.getMessage());
		}
		return failureMessages;
	}
}
