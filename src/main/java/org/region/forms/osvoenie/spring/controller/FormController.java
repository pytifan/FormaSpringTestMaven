package org.region.forms.osvoenie.spring.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.region.forms.osvoenie.form.data.Forma;
import org.region.forms.osvoenie.service.FormOsvoenieSomeService;
import org.region.forms.osvoenie.service.FormaServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * A Spring MVC form controller for the Letter example.
 */
@Controller
//@SessionAttributes(types = Recipient.class)
//@RequestMapping(value = "Forma-OsvoenieX.htm")
public class FormController {

    protected static Logger logger = Logger.getLogger("controller");

    private final FormOsvoenieSomeService formOsvoenieSomeService;
    // private final AvarageDiametersCalculator avarageDiametersCalculator;

//    @Resource(name = "FormService")
//    private FormService formService;
    @Autowired
    private FormaServiceDAO formaServiceDAO;

    @Autowired
    public FormController(FormOsvoenieSomeService formOsvoenieSomeService) {
        this.formOsvoenieSomeService = formOsvoenieSomeService;
        //    this.avarageDiametersCalculator = avarageDiametersCalculator;
    }

    public FormController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//  @Override
//   protected ModelAndView onSubmit (Object command) throws Exception {
//    Recipient recipient = (Recipient) command;
//    return new ModelAndView("RecipientSuccess", "recipient", recipient).addObject("date", new Date());
//  }
 
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView CreateForm(Model model) {
//        Forma forma = new Forma();
//        model.addAttribute("forma", forma);
//       // model.addAttribute(new Date());
//       // return "Forma-OsvoenieX";
//        return new ModelAndView ("Forma-OsvoenieX", "forma", forma).addObject("date", new Date());
//    }
    
    @RequestMapping(value="/add")
    public ModelAndView addTeamPage() {
        ModelAndView modelAndView = new ModelAndView("Forma-OsvoenieX");
        modelAndView.addObject("forma", new Forma());
        return modelAndView;
    }
    
    @RequestMapping(value = "/add/process", params = "add", method = RequestMethod.POST)
    //public String add(@ModelAttribute("forma") Forma forma, BindingResult result, SessionStatus sessionStatus) {
    public String addForm(Forma forma, BindingResult result, SessionStatus sessionStatus) {
        logger.debug("Received request to add new forma");
        if (result.hasErrors()) {
            System.out.println("Save in bd error");
            return "Forma-OsvoenieX";
        } else {
            try {
                formaServiceDAO.create(forma);
            } catch (Exception ex) {
                Logger.getLogger(FormController.class.getName()).log(null, Priority.ERROR, result, ex);
            }
            sessionStatus.setComplete();
            return "home";
        }
    }
//    @RequestMapping(value = "Forma-OsvoenieX.htm", method = RequestMethod.GET)
//    public String CreateForm(Model model) {
////    public String CreateForm(Map<String, Object> map) {
////     map.put("forma", new Forma());
//        model.addAttribute("forma", new Forma());
//        System.out.println("model: " + model);
//        model.addAttribute(new Date());
//        return "Forma-OsvoenieX";
//    }

    @RequestMapping(value = "/Calculate", params = "Calculate", method = RequestMethod.POST)
    public String calculate(Forma forma, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            System.out.println("Calculate error");
            return "Forma-OsvoenieX";
        } else {
            try {
                this.formOsvoenieSomeService.doSmthing(forma);
                this.formOsvoenieSomeService.solver_for_avarageDiams(forma);
            } catch (Exception ex) {
                Logger.getLogger(FormController.class.getName()).log(null, Priority.ERROR, result, ex);
            }
            status.setComplete();
            return "RecipientSuccess";
        }
    }

    @RequestMapping(value = "/listforms", method = RequestMethod.GET)
    public String getAllforms(Map<String, Object> map) {
        logger.debug("Received request to show all forms");
        // Retrieve all forms by delegating the call to formService
        List<Forma> forms = formaServiceDAO.getAllforms();
        // Attach forms to the Model
        map.put("forms", forms);
        return "listforms";
    }
    
    /**
     * Retrieves the edit page
     * @param id
     * @param model
     * @return the name of the JSP page
     */
    //@RequestMapping(value = "/forms/edit", method = RequestMethod.GET)
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable long id, Model model) {
        logger.debug("Received request to show edit page");
        // Retrieve existing Forma and add to model
        // This is the formBackingOBject
        // model.addAttribute("formaAttribute", formaServiceDAO.getForm(id));
        // This will resolve to /WEB-INF/jsp/editpage.jsp
        ModelAndView modelAndView = new ModelAndView("Forma-OsvoenieX");
        Forma forma = formaServiceDAO.getForm(id);
        //System.out.println("form.getId(): " + forma.getId()+ " " + id);
        modelAndView.addObject("forma",forma);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView saveEditForm(@PathVariable long id, Forma forma) {
        ModelAndView modelAndView = new ModelAndView("home");
        try {
            formaServiceDAO.update(forma);
            String message = "FORm was successfully edited.";
         //   modelAndView.addObject("message", message);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelAndView;
    }
    
    /**
     * Deletes an existing forma by delegating the processing to FormService.
     * Displays a confirmation JSP page
     *
     * @param id
     * @param model
     * @param forma
     * @return the name of the JSP page
     */
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("listforms");
        formaServiceDAO.remove(id);
        String message = "Team was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }
    
    /**
     * @param forma
     * @param id
     * @param model
     * @return the name of the JSP page
     */
    //@RequestMapping(value = "/forms/edit", method = RequestMethod.POST)
//    @RequestMapping(value = "Forma-OsvoenieX.htm", params = "edit", method = RequestMethod.POST)
//    public String saveEdit(@ModelAttribute("formaAttribute") Forma forma,
//            @RequestParam(value = "id", required = true) Long id, Model model) {
//        logger.debug("Received request to update person");
//     // The "formaAttribute" model has been passed to the controller from the JSP
//        // We use the name "formaAttribute" because the JSP uses that name
//        // We manually assign the id because we disabled it in the JSP page
//        // When a field is disabled it will not be included in the ModelAttribute
//        forma.setId(id);
//        try {
//            // Delegate to FormaServiceDAO for editing
//            formaServiceDAO.update(forma);
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // Add id reference to Model
//        model.addAttribute("id", id);
//        return "editedpage";
//    }
//    /**
//     * Retrieves the add page
//     *
//     * @param model
//     * @return the name of the JSP page
//     */
//    //@RequestMapping(value = "/forms/add", method = RequestMethod.GET)
//    @RequestMapping(params = "add", method = RequestMethod.GET)
//    public String getAdd(Model model) {
//        logger.debug("Received request to show add page");
//        // Create new Form and add to model
//        // This is the formBackingOBject
//        model.addAttribute("formaAttribute", new Forma());
//        // This will resolve to /WEB-INF/jsp/addpage.jsp
//        return "addpage";//????????????????????????????????????
//    }
}
