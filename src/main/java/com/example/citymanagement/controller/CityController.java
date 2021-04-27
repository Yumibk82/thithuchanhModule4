package com.example.citymanagement.controller;

import com.example.citymanagement.model.City;
import com.example.citymanagement.model.Nation;
import com.example.citymanagement.service.CityService;
import com.example.citymanagement.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;
    @ModelAttribute("nations")
    public List<Nation> getNation(){
        List<Nation> abc = (List<Nation>) nationService.findAll();
        return abc;
    }
    @GetMapping("/list")
    public ModelAndView showCityList(Pageable pageable){
        Page<City> cities=cityService.findAll(pageable);
        ModelAndView modelAndView=new ModelAndView("/list");
        modelAndView.addObject("list",cities);
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView showDetailInfo(@PathVariable Long id){
        Optional<City> cityOptional=cityService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/view");
        modelAndView.addObject("view",cityOptional.get());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/createCity");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createNewCity(@Valid @ModelAttribute City city, BindingResult bindingResult){
//        City newCity=new City();
//        newCity.setCityName(city.getCityName());
//        newCity.setNational(city.getNational());
//        newCity.setArea(city.getArea());
//        newCity.setPopulation(city.getPopulation());
//        newCity.setGdp(city.getGdp());
//        newCity.setDescription(city.getDescription());
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/createCity");
        }
        cityService.save(city);
        ModelAndView modelAndView=new ModelAndView("/createCity");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<City> cityOptional=cityService.findById(id);
        if(cityOptional !=null){
            ModelAndView modelAndView=new ModelAndView("/edit");
            modelAndView.addObject("city",cityOptional);
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("/error-404");
            return modelAndView;
        }
    }
    @PostMapping("/edit")
    public ModelAndView updateCity(@Valid @ModelAttribute("city") City city){
        cityService.save(city);
        Optional<City> cityOptional=cityService.findById(city.getCityId());
        if(!cityOptional.isPresent()){
            return new ModelAndView("/error-404");
        }else{
            ModelAndView modelAndView=new ModelAndView("edit");
            modelAndView.addObject("city",city);
            return modelAndView;
        }
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCity(@PathVariable Long id){
        Optional<City> cityOptional=cityService.findById(id);
        ModelAndView modelAndView;
        if(cityOptional.isPresent()){
            modelAndView=new ModelAndView("/delete");
            modelAndView.addObject("city",cityOptional.get());
        }else {
            modelAndView=new ModelAndView("/error-404");
        }
        return modelAndView;
    }
    @PostMapping("delete")
    private String deleteCity(@ModelAttribute City city){
        cityService.remove(city.getCityId());
        return "redirect:/city/list";
    }
}
