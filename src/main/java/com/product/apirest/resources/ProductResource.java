package com.product.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.apirest.models.Product;
import com.product.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produto")
@CrossOrigin(origins="*")
//@CrossOrigin(origins="/http:dominio") restringe
public class ProductResource {

	@Autowired
	ProductRepository produtoRepository;
	
	@GetMapping("/product")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Product> listaProdutos(){
		return produtoRepository.findAll();
		
	}

	@GetMapping("/product/{id}")
	@ApiOperation(value="Retorna um unico produto")
	public Product listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
		
	}
	
	@PostMapping("/product")
	@ApiOperation(value="Salva um produto")
	public Product salvaProduto(@RequestBody Product produto){
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/product")
	@ApiOperation(value="Deleta um produto")
	public void deletaProduto(@RequestBody Product produto){
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/product")
	@ApiOperation(value="Atualiza um produto")
	public Product atualizaProduto(@RequestBody Product produto){
		return produtoRepository.save(produto);
	}
	
	
}
