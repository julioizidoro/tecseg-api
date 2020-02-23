package br.com.tecsegapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.tecsegapi.model.Clinicapagtoexame;
import br.com.tecsegapi.repository.ClinicaPagtoExameReoisitory;

public class ClinicaPagtoExameController {
	
	@Autowired
	private ClinicaPagtoExameReoisitory clinicaPagtoExameReoisitory;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Clinicapagtoexame salvar(@Valid @RequestBody Clinicapagtoexame clinicaPagtoExame) {
		return clinicaPagtoExameReoisitory.save(clinicaPagtoExame);
	}

}
