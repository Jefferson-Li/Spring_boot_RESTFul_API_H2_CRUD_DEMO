package com.jefferson.restful.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jefferson.restful.h2.dto.RestH2Request;
import com.jefferson.restful.h2.dto.RestH2Response;
import com.jefferson.restful.h2.service.RestH2Service;

@RestController
@RequestMapping("/RestH2")
public class RestH2Controller {

	@Autowired
	RestH2Service restH2Service;

	@PostMapping("/create")
	public RestH2Response create(@RequestBody RestH2Request request) {
		RestH2Response restH2Response = new RestH2Response();

		restH2Response = restH2Service.create(request);

		return restH2Response;
	}

	@GetMapping("/queryById")
	public RestH2Response queryById(@RequestParam(value = "shopId", required = false) Long shopId) {
		RestH2Response restH2Response = new RestH2Response();

		restH2Response = restH2Service.queryById(shopId);

		return restH2Response;
	}

	@GetMapping("/queryAll")
	public RestH2Response query() throws Exception {
		RestH2Response restH2Response = new RestH2Response();

		restH2Response = restH2Service.queryAll();

		return restH2Response;
	}

	@PutMapping("/update")
	public RestH2Response update(@RequestBody RestH2Request request) throws Exception {
		RestH2Response restH2Response = new RestH2Response();

		restH2Response = restH2Service.update(request);

		return restH2Response;
	}

	@DeleteMapping("/delete")
	public RestH2Response delete(@RequestParam(value = "shopId", required = false) Long shopId) throws Exception {
		RestH2Response restH2Response = new RestH2Response();

		restH2Response = restH2Service.delete(shopId);

		return restH2Response;
	}

}
