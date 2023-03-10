package com.my.hr.web;

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

@RestController("com.my.hr.laborerController")
@RequestMapping("com/my/hr/laborer")
public class LaborerController {
	@Autowired private LaborerService laborerService;
	
	@GetMapping
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("com/my/hr/main");
		return mv;
	}
	
	@GetMapping("list")
	public List<Laborer> getlaborer(){
		return laborerService.getLaborers();
	}
	
	@PostMapping("add")
	public void addlaborer(@RequestBody Laborer laborer) {
		laborerService.addLaborer(laborer);
	}
	
	@PutMapping("fix")
	public void fixlaborer(@RequestBody Laborer laborer) {
		laborerService.fixLaborer(laborer);
	}
	
	@DeleteMapping("del/{laborerId}")
	public void dellaborer(@PathVariable int laborerId) {
		laborerService.delLaborer(laborerId);
	}
}
