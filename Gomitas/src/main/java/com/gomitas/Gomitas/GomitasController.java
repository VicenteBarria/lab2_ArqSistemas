package com.gomitas.Gomitas;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
//import java.util.stream.Collectors;

//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GomitasController {
	
	private final GomitasRepository repository;
	
	public GomitasController(GomitasRepository repository) {
		this.repository = repository;
	}
	
	/*@GetMapping("/gomitas")
	public Resources<Resource<Gomitas>> allGomitas() {		//Lee todas las gomitas
		List<Resource<Gomitas>> gomitas = repository.findAll().stream()
				.map(gomita -> new Resource<>(gomita,
						linkTo(methodOn(GomitasController.class).oneGomita(gomita.getId())).withSelfRel(),
						linkTo(methodOn(GomitasController.class).allGomitas()).withRel("gomitas")))
				.collect(Collectors.toList());
		return new Resources<>(gomitas, linkTo(methodOn(GomitasController.class).allGomitas()).withSelfRel());
	}*/
	
	@GetMapping("/gomitas")
	public List<Gomitas> allGomitas() {
		return repository.findAll();
	}
	
	@PostMapping("/gomitas")
	public Gomitas newGomita(@RequestBody Gomitas newGomita) {		//Guarda nueva gomita
		return repository.save(newGomita);
	}
	
	/*@GetMapping("/gomitas/{id}")
	public Resource<Gomitas> oneGomita(@PathVariable Long id) {		//Lee una gomita
		Gomitas gomita = repository.findById(id).orElseThrow(() -> new GomitasNotFoundException(id));
		return new Resource<>(gomita,
				linkTo(methodOn(GomitasController.class).oneGomita(id)).withSelfRel(),
				linkTo(methodOn(GomitasController.class).allGomitas()).withRel("gomitas"));
	}*/
	
	@GetMapping("/gomitas/{id}")
	public Gomitas oneGomita(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new GomitasNotFoundException(id));
	}

	@PutMapping("/employees/{id}")
	public Gomitas replaceGomita(@RequestBody Gomitas newGomita, @PathVariable Long id) {		//Reemplaza una gomita
		return repository.findById(id)
			.map(gomita -> {
				gomita.setNombre(newGomita.getNombre());
				gomita.setMarca(newGomita.getMarca());
				gomita.setPrecio(newGomita.getPrecio());
				return repository.save(gomita);
			})
			.orElseGet(() -> {
				newGomita.setId(id);
				return repository.save(newGomita);
			});
	}
	
	@DeleteMapping("/gomitas/{id}")
	public void deleteGomita(@PathVariable Long id) {		//Borrar una gomita
		repository.deleteById(id);
	}
}
