package it.ludo.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.ludo.pizzeria.model.PizzaMod;
import it.ludo.pizzeria.repository.PizzaRepo;
import jakarta.validation.Valid;

@Controller
@RequestMapping("pizzeria")
public class PizzaController {

    @Autowired
    private PizzaRepo pizzaRepo;

    @GetMapping("/menu")
    public String pizze(Model model) {
        model.addAttribute("pizze", pizzaRepo.findAll());
        return "pizzeria/index";
    }

    @GetMapping("/dettaglio/{id}")
    public String dettaglioPizze(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("dettaglio", pizzaRepo.getReferenceById(id));
        return "pizzeria/dettaglio";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new PizzaMod());

        return "/pizzeria/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizza") PizzaMod pizza, BindingResult bindingResult, Model model) {

        if (pizza.getPrice() <= 0) {
            bindingResult.addError(new ObjectError("Errore di prezzo", "Inserisci il prezzo della pizza"));
        }
        if (bindingResult.hasErrors()) {
            return "/pizzeria/create";
        }

        pizzaRepo.save(pizza);

        return "redirect:/pizzeria/menu";
    }

    @GetMapping("edit/{id}")
    public String editPizza(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("edit", pizzaRepo.getReferenceById(id));
        if (pizzaRepo == null) {
            return "/redirect:/pizzeria/menu";
        }

        return "/pizzeria/edit";
    }

    @PostMapping("/edit")
    public String editPizza(@Valid @ModelAttribute("pizza") PizzaMod pizza, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        pizzaRepo.save(pizza);
        return "redirect:/pizzeria/menu";
    }

    @GetMapping("/delete/{id}")
    public String deletePizza(@PathVariable("id") Integer id) {
        pizzaRepo.deleteById(id);
        return "redirect:/pizzeria/menu";
    }
}
