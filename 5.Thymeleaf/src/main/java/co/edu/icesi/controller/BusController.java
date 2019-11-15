package co.edu.icesi.controller;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.exceptions.BusNullException;
import co.edu.icesi.exceptions.BusTipoException;
import co.edu.icesi.exceptions.CapacidadNullException;
import co.edu.icesi.exceptions.GuardarBusException;
import co.edu.icesi.exceptions.TipoNullException;
import co.edu.icesi.model.Tmio1Bus;
import co.edu.icesi.model.Tmio1Conductore;
import co.edu.icesi.services.BusService;
import co.edu.icesi.services.UserServiceInt;
import co.edu.icesi.validation.Step1;

@Controller
public class BusController {

	private BusService service;

	@Autowired
	public BusController(BusService service) {
		this.service = service;
	}

	@RequestMapping(value = "/buses", method = RequestMethod.GET)
	public String buses(Model model) {
		model.addAttribute("buses", service.findAll());
		return "buses/index";
	}

	@GetMapping("/buses/add-bus")
	public String busesAdd(Model model) {
		model.addAttribute("tmio1Bus", new Tmio1Bus());
		model.addAttribute("types", service.getTypes());
		return "buses/add-bus";
	}

	@PostMapping("/buses/add-bus")
	public String saveApps(@RequestParam(value = "action", required = true) String action, @Validated Tmio1Bus tmio1Bus,
			BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("types", service.getTypes());
				return "buses/add-bus";
			} else {
				try {
					service.save(tmio1Bus);
				} catch (GuardarBusException | BusNullException | BusTipoException | TipoNullException
						| CapacidadNullException e) {

					
					return "redirect:/error";
				}
			}
			model.addAttribute("types", service.getTypes());
		}
		return "redirect:/buses";
	}

	@GetMapping("/buses/consult-bus")
	public String consultForm(Model model) {
		model.addAttribute("tmio1Bus", new Tmio1Bus());
		return "buses/consult-bus";
	}

	@PostMapping("/buses/consult-bus")
	public String showConsultForm2(@ModelAttribute Tmio1Bus tmio1Bus, Model model) {

		Optional<Tmio1Bus> b = service.findById(tmio1Bus.getId());
		if (b.get() == null) {

		}
		model.addAttribute("tmio1Bus", b.get());
		return "buses/edit-bus";
	}
}
