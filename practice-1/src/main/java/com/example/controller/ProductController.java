package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.ProductService;

@Controller
@RestController
public class ProductController {

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "productService")
	ProductService ProductService = new ProductService();

	/*
	 * 메인페이지 제품페이지랑 연결됨
	 */
	@RequestMapping(value = { "/", "/index.do" }, method = RequestMethod.GET)
	public ModelAndView home(@RequestParam Map<String, Object> map) {
		log.debug("Request Parameter : " + map);

		ModelAndView mv = new ModelAndView("/main");

		List<Map<String, Object>> list = ProductService.getList(null);
		mv.addObject("list", list);
		mv.addObject("map", map);

		System.out.println("list출력" + list);
		System.out.println("map출력" + map);

		return mv;
	}
}
