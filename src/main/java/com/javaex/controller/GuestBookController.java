package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	@Autowired
	private GuestBookDao dao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String addList(Model model) {
		List<GuestBookVo> list =  dao.getList();
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/addList.jsp";
	}
	
	@RequestMapping(value = "/deleteform", method = RequestMethod.GET)
	public String deleteForm(@RequestParam("no") int no) {
		
		return "/WEB-INF/views/deleteForm.jsp?no=" + no;
	}
	
	@RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
	public String deleteGuest(@PathVariable("no") int no, 
							  @RequestParam("password") String password) {
		dao.delete(new GuestBookVo(no, password));
		
		return "redirect:/";
	}
	/*
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@RequestParam("name") String name,
						 @RequestParam("password") String password,
						 @RequestParam("content") String content) {
		dao.insert(new GuestBookVo(name, password, content));
		return "redirect:/";
	}
	*/
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute GuestBookVo vo) {
		dao.insert(vo);
		return "redirect:/";
	}
	
}
