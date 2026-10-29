
package com.example.demo.OSSTController;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.Inquiry;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.InquiryService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    private final InquiryService inquiryService;
    private final ProductService productService;

    // Constructor injection
    public HomeController(
            InquiryService inquiryService,
            ProductService productService) {

        this.inquiryService = inquiryService;
        this.productService = productService;
    }

    // Home page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Products page - load products from MySQL
    @GetMapping("/products")
    public String products(Model model) {

        List<Product> products =
                productService.getActiveProducts();

        model.addAttribute("products", products);

        return "products";
    }

    // About page
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    // Contact page
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    // Save customer inquiry
    @PostMapping("/contact")
    public String submitInquiry(
            @ModelAttribute Inquiry inquiry,
            RedirectAttributes redirectAttributes) {

        inquiryService.saveInquiry(inquiry);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Your inquiry has been submitted successfully!"
        );

        return "redirect:/contact";
    }
}
