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

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value = "/phone")
public class PhoneController {

	// 필드
	@Autowired
	private PhoneDao pDao;

	// 생성자

	// 메소드(get/set)

	// 일반 메소드
	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("list");

		// dao.getList();
		List<PersonVo> pList = pDao.dbList();

		System.out.println(pList.toString());

		// modle → data 전송
		model.addAttribute("PersonList", pList);

		return "/list";
	}

	// 등록 폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("writeForm");

		return "/writeForm";
	}

	// http://localhost:8088/phonebook3/phone/write?name=[]&hp=[]&company=[]
	// 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@RequestParam("name") String name, @RequestParam("hp") String hp,
			@RequestParam("company") String company) {
		System.out.println("write");

		PersonVo pVo = new PersonVo(name, hp, company);
		System.out.println(pVo);

		pDao.dbIsrt(pVo);

		System.out.println(pVo.toString());

		return "redirect:/phone/list";
	}

	// 수정 폼
	@RequestMapping(value = "/uForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String uForm(Model model, @RequestParam("id") int person_id) {
		System.out.println("uForm");

		PersonVo pVo = pDao.getPerson(person_id);

		System.out.println(pVo.toString());

		model.addAttribute("PersonVo", pVo);

		return "/updateForm";
	}

	// http://localhost:8088/phonebook3/phone/update?id=[]
	// 수정 @RequestParam
	/*
	 * @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	 * public String update(@RequestParam("id") int person_id, @RequestParam("name") String name, @RequestParam("hp") String hp, @RequestParam("company") String company) {
	 * 		System.out.println("update");
	 * 
	 * 		PersonVo pVo = new PersonVo(person_id, name, hp, company);
	 * 		PhoneDao pDao = new PhoneDao(); pDao.dbUpd(pVo);
	 * 
	 * 		System.out.println(pVo.toString());
	 * 
	 * 		return "redirect:/phone/list";
	 * }
	 */

	// http://localhost:8088/phonebook3/phone/update?id=[]
	// 수정 @ModelAttribute → default 생성자 필요
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo pVo) {
		System.out.println("update");

		pDao.dbUpd(pVo);

		System.out.println(pVo.toString());

		return "redirect:/phone/list";
	}

	// http://localhost:8088/phonebook3/phone/delete?id=[]
	// 삭제
	/*
	 * @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })// @RequestMapping("/delete")
	 * public String delete(@RequestParam("id") int person_id) {
	 * 		System.out.println("delete");
	 * 
	 * 		PhoneDao pDao = new PhoneDao();
	 * 		pDao.dbDle(person_id);
	 * 
	 * 		System.out.println(person_id);
	 * 
	 * 		return "redirect:/phone/list";
	 * }
	 */

	// http://localhost:8088/phonebook3/phone/delete?id=[]
	// 삭제
	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST }) // @RequestMapping("/delete")
	public String delete(@PathVariable("id") int person_id) {
		System.out.println("delete");

		pDao.dbDle(person_id);

		System.out.println(person_id);

		return "redirect:/phone/list";
	}

}
