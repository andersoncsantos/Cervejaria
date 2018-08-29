package com.anderson.brewer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anderson.brewer.controller.page.PageWrapper;
import com.anderson.brewer.model.Cerveja;
import com.anderson.brewer.model.Origem;
import com.anderson.brewer.model.Sabor;
import com.anderson.brewer.repository.Cervejas;
import com.anderson.brewer.repository.Estilos;
import com.anderson.brewer.repository.filter.CervejaFilter;
import com.anderson.brewer.service.CadastroCervejaService;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {
	
	@Autowired
	private Estilos estilos;
	
	@Autowired
	private CadastroCervejaService cadastroCervejaService;
	
	@Autowired
	private Cervejas cervejas;
	
	@RequestMapping("/novo") /*URL que aparecerá no browser*/
	public ModelAndView novo(Cerveja cerveja){
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		
		return mv ;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes){
		if (result.hasErrors()){
//			throw new RuntimeException();
			return novo(cerveja);
		}
		
		cadastroCervejaService.salvar(cerveja);
	    attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!"); /*Cria uma sessão temporária - mantém mesmo após o redirect*/
		/*System.out.println(">>>>>> SKU: " + cerveja.getSku());
		System.out.println(">>>>>> Sabor: " + cerveja.getSabor());
		System.out.println(">>>>>> Origem: " + cerveja.getOrigem());
		System.out.println(">>>>>> Estilo: " + cerveja.getEstilo());*/
		return new ModelAndView("redirect:/cervejas/novo");
		
	}
	
	@GetMapping
	public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult result, @PageableDefault(size=2) Pageable pageable, 
			HttpServletRequest httpServletRequest){
		ModelAndView mv = new ModelAndView("cerveja/PesquisaCervejas");
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("sabores", Sabor.values());
		mv.addObject("origens", Origem.values());
		
		PageWrapper<Cerveja> paginaWrapper = new PageWrapper<>(cervejas.filtrar(cervejaFilter, pageable), httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
	return mv;
	}
}




