package com.netcracker.rootCounter.controller;

import com.netcracker.rootCounter.message.Response;
import com.netcracker.rootCounter.model.Polynomial;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/controller/rest")
public class RestWebController {

	ArrayList<Polynomial> polynomialHistory = new ArrayList<>();

	@GetMapping(value = "/get")
	public Response getCoefficients() {
		Response response = new Response("Done", polynomialHistory);
		return response;
	}

	@PostMapping(value ="/post")
	public Response postCoefficients(@RequestBody Polynomial polynomial) {
	    polynomial.setCountOfRoots(polynomial.countRoots());
		polynomialHistory.add(polynomial);
        //System.out.println(Arrays.toString(polynomial.getCoefficients()));

		// Create Response Object
		Response response = new Response("Done", polynomial);
		return response;
	}

	@GetMapping(value = "/clear")
    public Response clearPolynomialHistory() {
	    polynomialHistory = new ArrayList<>();
	    Response response = new Response("Done", polynomialHistory);
	    return response;
    }
}