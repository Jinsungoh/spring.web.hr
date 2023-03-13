package com.my.hr.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.hr.domain.Laborer;
import com.my.hr.service.LaborerService;



@RestController
@RequestMapping("laborer")
public class LaborerController {
	@Autowired private LaborerService laborerService;
	
	@GetMapping
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("laborer/laborerMain");
		return mv;
	}
	
	@GetMapping("list")
	public List<Laborer> getLaborer(){
		return laborerService.getLaborers();
	}
	
	@PostMapping("add/{laborerName}/{hireDate}")
	public void addLaborer(@PathVariable("laborerName") String laborerName,
							@PathVariable("hireDate") LocalDate hireDate) {
		laborerService.addLaborer(laborerName,hireDate);
	}
	
	@PutMapping("fix")
	public void fixLaborer(@RequestBody Laborer laborer) {
		laborerService.fixLaborer(laborer);
	}
	
	@DeleteMapping("del/{laborerId}")
	public void delLaborer(@PathVariable int laborerId) {
		laborerService.delLaborer(laborerId);
	}
}
