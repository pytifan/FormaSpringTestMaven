package org.region.forms.osvoenie.spring.controller;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.region.forms.osvoenie.form.data.Forma;
import org.region.forms.osvoenie.service.FormOsvoenieSomeService;
import org.region.forms.osvoenie.service.FormaServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

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
//  private Map<Long, Recipient> recipients = new ConcurrentHashMap<Long, Recipient>();    
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView CreateForm(Model model) {
//        Forma forma = new Forma();
//        model.addAttribute("forma", forma);
//       // model.addAttribute(forma);
//       // model.addAttribute(new Date());
//       // return "Forma-OsvoenieX";
//        return new ModelAndView ("Forma-OsvoenieX", "forma", forma).addObject("date", new Date());
//    }
    @RequestMapping(value = "Forma-OsvoenieX.htm", method = RequestMethod.GET)
    public String CreateForm(Model model) {
//    public String CreateForm(Map<String, Object> map) {
//     map.put("forma", new Forma());
        model.addAttribute("forma", new Forma());
        System.out.println("model: " + model);
        // model.addAttribute(new Date());
        return "Forma-OsvoenieX";
    }

    @RequestMapping(value = "Forma-OsvoenieX.htm", params = "Calculate", method = RequestMethod.POST)
    public String create(Forma forma, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            System.out.println("Calculate error");
            return "Forma-OsvoenieX";
        } else {
            try {
                this.formOsvoenieSomeService.doSmthing(forma);
                // this.formOsvoenieSomeService.CasingAvarageDiamCalculations(forma);
                this.formOsvoenieSomeService.solver_for_avarageDiams(forma);
            } catch (Exception ex) {
                Logger.getLogger(FormController.class.getName()).log(null, Priority.ERROR, result, ex);
            }
            status.setComplete();
            return "RecipientSuccess";
        }
    }

    @RequestMapping(value = "/Forma-OsvoenieX.htm/add", params = "add", method = RequestMethod.POST)
    //public String add(@ModelAttribute("forma") Forma forma, BindingResult result, SessionStatus sessionStatus) {
    public String add(Forma forma, BindingResult result, SessionStatus sessionStatus) {
        logger.debug("Received request to add new forma");
        // The "formaAttribute" model has been passed to the controller from the JSP
        // We use the name "formaAttribute" because the JSP uses that name
        if (result.hasErrors()) {
            System.out.println("Save in bd error");
            return "Forma-OsvoenieX";
        } else {
            try {
                formaServiceDAO.create(forma);
            } catch (Exception ex) {
                Logger.getLogger(FormController.class.getName()).log(null, Priority.ERROR, result, ex);
            }
        // This will resolve to /WEB-INF/jsp/addedpage.jsp return "addedpage";
            sessionStatus.setComplete();
            return "RecipientSuccess";
        }
    }

    @RequestMapping(params = "forms", method = RequestMethod.GET)
    public String getPersons(Model model) {
        logger.debug("Received request to show all forms");
        // Retrieve all persons by delegating the call to PersonService
        List<Forma> forms = formaServiceDAO.getAll();
        // Attach persons to the Model
        model.addAttribute("forms", forms);
        // This will resolve to /WEB-INF/jsp/personspage.jsp
        return "formpage"; //????????????????????????????????????
    }
//
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
//
//        // Create new Form and add to model
//        // This is the formBackingOBject
//        model.addAttribute("formaAttribute", new Forma());
//
//        // This will resolve to /WEB-INF/jsp/addpage.jsp
//        return "addpage";//????????????????????????????????????
//    }
//
//    /**
//     * Adds a new form by delegating the processing to FormService. Displays a
//     * confirmation JSP page
//     * @param forma
//     * @return the name of the JSP page
//     */
//    //@RequestMapping(value = "/forms/add", method = RequestMethod.POST)
//
//    /**
//     * Deletes an existing forma by delegating the processing to FormService.
//     * Displays a confirmation JSP page
//     *
//     * @param id
//     * @param model
//     * @return the name of the JSP page
//     */
//    //@RequestMapping(value = "/forms/delete", method = RequestMethod.GET)
//    @RequestMapping(params = "delete", method = RequestMethod.GET)
//    public String delete(@RequestParam(value = "id", required = true) Integer id,
//            Model model) {
//
//        logger.debug("Received request to delete existing forma");
//
//        // Call PersonService to do the actual deleting
//        formService.delete(id);
//
//        // Add id reference to Model
//        model.addAttribute("id", id);
//
//        // This will resolve to /WEB-INF/jsp/deletedpage.jsp
//        return "deletedpage";
//    }
//
//    /**
//     * Retrieves the edit page
//     *
//     * @param id
//     * @param model
//     * @return the name of the JSP page
//     */
//    //@RequestMapping(value = "/forms/edit", method = RequestMethod.GET)
//    @RequestMapping(params = "edit", method = RequestMethod.GET)
//    public String getEdit(@RequestParam(value = "id", required = true) Integer id,
//            Model model) {
//        logger.debug("Received request to show edit page");
//
//        // Retrieve existing Forma and add to model
//        // This is the formBackingOBject
//        model.addAttribute("formaAttribute", formService.get(id));
//
//        // This will resolve to /WEB-INF/jsp/editpage.jsp
//        return "editpage";
//    }
//
//    /**
//     * Edits an existing person by delegating the processing to PersonService.
//     * Displays a confirmation JSP page
//     *
//     * @param forma
//     * @param id
//     * @param model
//     * @return the name of the JSP page
//     */
//    //@RequestMapping(value = "/forms/edit", method = RequestMethod.POST)
//    @RequestMapping(params = "edit", method = RequestMethod.POST)
//    public String saveEdit(@ModelAttribute("formaAttribute") Forma forma,
//            @RequestParam(value = "id", required = true) Long id,
//            Model model) {
//        logger.debug("Received request to update person");
//
//     // The "formaAttribute" model has been passed to the controller from the JSP
//        // We use the name "formaAttribute" because the JSP uses that name
//        // We manually assign the id because we disabled it in the JSP page
//        // When a field is disabled it will not be included in the ModelAttribute
//        forma.setId(id);
//
//        // Delegate to FormaService for editing
//        formService.edit(forma);
//
//        // Add id reference to Model
//        model.addAttribute("id", id);
//
//        // This will resolve to /WEB-INF/jsp/editedpage.jsp
//        return "editedpage";
//    }
}
