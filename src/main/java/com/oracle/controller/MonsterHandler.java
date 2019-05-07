package com.oracle.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.bean.Monster;
import com.oracle.bean.School;
import com.oracle.bean.SubMonster;
import com.oracle.service.MonsterService;
import com.oracle.service.SchoolService;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
@Scope(value="prototype")
public class MonsterHandler{
	
	@Autowired
	private MonsterService monsterService;
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping(value="/allMonster",method=RequestMethod.GET)
	public String allMonster(HttpServletRequest request){
		
		List<SubMonster> list=monsterService.list();
		
		request.setAttribute("mList", list);
		
		return "showAll";
		
		
	}
	
	
	
	@RequestMapping(value="/addUI",method=RequestMethod.GET)
	public String addUI(HttpServletRequest request){
		
		List<School> list = schoolService.list();
		
		request.setAttribute("sList", list);
		
		return "addMonster";
		
	}
	
	
	
	@RequestMapping(value="/addMonster",method=RequestMethod.POST)
	
	public String addMonster(SubMonster monster){
		
		int i=monsterService.addMonster(monster);
		
		if(i>0){
			
			return "redirect:/allMonster";
		}else{
			
			return "addMonster";
		}
		
		
		
	}
	
	
	@RequestMapping(value="/deleteMonster/{monsterId}",method=RequestMethod.DELETE)
	public String deleteMonster(@PathVariable("monsterId") Integer monsterId){
		
		monsterService.deleteMonster(monsterId);
		
		return "redirect:/allMonster";
		
	}
	
	
	@RequestMapping(value="/updateUI/{monsterId}",method=RequestMethod.GET)
	public String updateUI(@PathVariable("monsterId") Integer monsterId,HttpSession session){
		
		SubMonster monster=monsterService.QueryOneMonster(monsterId);
		
		//System.out.println(monster.getMonstername()+" "+monster.getEmail()+" "+monster.getBrithday()+" "+monster.getEntryday());
		
		session.setAttribute("m", monster);
		
		List<School> list = schoolService.list();
		
	    session.setAttribute("sList", list);
		
	    return "redirect:/updateMonster.jsp";
	}
	
	
	@RequestMapping(value="/updateMonster",method=RequestMethod.PUT)
	public String updateMonster(SubMonster monster){
		
		monsterService.updateMonster(monster);
		
		return "redirect:/allMonster";
		
	}
	
}
