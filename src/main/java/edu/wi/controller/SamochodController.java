package edu.wi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.wi.entity.Samochod;
import edu.wi.dao.SamochodDAO;

@Controller
@RequestMapping("/samochod")
public class SamochodController {

	@Autowired
	private SamochodDAO samochodDAO;
	
	@RequestMapping("/dodaj")
	@ResponseBody
	public String addSamochod(@RequestBody Samochod samochod)//, UriComponentsBuilder ucBuilder)
	{
		samochodDAO.insert(samochod);
		
		return "New data inserted";
	    
	}
	
	@RequestMapping("/wyswietl")
	@ResponseBody
	public List<Samochod> getSamochod()
	{
		List<Samochod> result = samochodDAO.findByModel();
		
		return result;
	}
}
