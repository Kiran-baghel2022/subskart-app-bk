package com.subskart.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subskart.entity.Category;
import com.subskart.entity.Item;
import com.subskart.entity.Vender;
import com.subskart.model.JwtRequest;
import com.subskart.model.Login;
import com.subskart.repository.LoginRepository;
import com.subskart.service.CategoryService;
import com.subskart.service.ItemService;
import com.subskart.service.PlanService;
import com.subskart.service.VenderService;

@CrossOrigin
@RestController
public class SubskartController {

	@Autowired
	private VenderService venderService;

	@Autowired
	private ItemService itemService;

	@Autowired
	public PlanService planService;

	@Autowired
	public CategoryService categoryService;

	@Autowired
	public LoginRepository loginRepository;

	@PostMapping("/login")
	public ResponseEntity<Login> login(@RequestBody JwtRequest request) {
		Login login =new Login();
		login= loginRepository.findByUsernameAndPassword(request.getUsernameOrEmail(), request.getPassword());
		return new ResponseEntity<>(login, HttpStatus.OK);
	}

	// save/update category
	@PostMapping("/savecategory")
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		category = categoryService.saveCategory(category);
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}

	// Get Items
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> categories() {
		List<Category> categoryList = categoryService.categories();
		return new ResponseEntity<>(categoryList, HttpStatus.OK);
	}

	// Save/Update item
	@PostMapping("/saveitem")
	public ResponseEntity<Item> saveItem(@RequestBody Item item) {
		item = itemService.saveItem(item);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}

	// Get Items
	@GetMapping("/items")
	public ResponseEntity<List<Item>> items() {
		List<Item> itemList = itemService.items();
		return new ResponseEntity<>(itemList, HttpStatus.OK);
	}

	// Save item
	@PutMapping("/updateitem")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) {
		item = itemService.saveItem(item);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}

	// Get Items

	@GetMapping("/itemselection")
	public ResponseEntity<List<Item>> itemSelection() {
		List<Item> itemSelectionList = new ArrayList<Item>();
		itemSelectionList = itemService.itemSelections();
		return new ResponseEntity<>(itemSelectionList, HttpStatus.OK);
	}

	@PostMapping("/savevender")
	public ResponseEntity<Vender> saveVender(@RequestBody Vender vender) {
		vender.setCreatedAt(new Date());
		venderService.saveVender(vender);
		return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
	}

	@GetMapping("/test")
	public String tes() {
		return "hello";
	}

	@GetMapping("/venders")
	public ResponseEntity<List<Vender>> venders() {
		List<Vender> venderList = venderService.venders();
		return new ResponseEntity<>(venderList, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/itemsdetails") public ResponseEntity<ItemPlanVenderForm>
	 * itemsDetails() { List<Item> itemList = itemService.items(); List<Plan>
	 * planList = planService.plans(); ItemPlanVenderForm itemPlanVenderForm = new
	 * ItemPlanVenderForm(); itemPlanVenderForm.setItems(itemList);
	 * itemPlanVenderForm.setPlans(planList); return new
	 * ResponseEntity<>(itemPlanVenderForm, HttpStatus.OK); }
	 */
}
