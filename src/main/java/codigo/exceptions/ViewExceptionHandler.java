//package codigo.exceptions;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class ViewExceptionHandler {
//
//    @ExceptionHandler(EmpresaNotFoundException.class)
//    public String handleEmpresaNotFoundException(EmpresaNotFoundException ex, Model model) {
//        model.addAttribute("pageTitle", "Product Not Found");
//        model.addAttribute("errorTitle", "Product Not Found");
//        model.addAttribute("errorMessage", ex.getMessage());
//
//        return "Empresa/dashboard";
//    }
//
//    @ExceptionHandler(Exception.class)
//    public String handleGenericException(Exception ex, Model model) {
//        model.addAttribute("pageTitle", "Error");
//        model.addAttribute("errorTitle", "An Error Occurred");
//        model.addAttribute("errorMessage", "An unexpected error occurred. Please try again later.");
//
//        return "Publico/Dashboard";
//    }
//
//}
