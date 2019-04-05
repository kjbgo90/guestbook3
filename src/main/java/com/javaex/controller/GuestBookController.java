package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String addList(Model model) {
		List<GuestBookVo> list =  GuestBookDao.getInstance().getList();
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
		GuestBookDao.getInstance().delete(new GuestBookVo(no, password));
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@RequestParam("name") String name,
						 @RequestParam("password") String password,
						 @RequestParam("content") String content) {
		GuestBookDao.getInstance().insert(new GuestBookVo(name, password, content));
		return "redirect:/";
	}
	
}
