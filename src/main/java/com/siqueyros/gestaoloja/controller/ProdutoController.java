package com.siqueyros.gestaoloja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siqueyros.gestaoloja.model.Produto;
import com.siqueyros.gestaoloja.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    /**
    * MÉTODO QUE RETORNA UMA LISTA DE PRODUTOS
    * @return uma lista de produtos
     */
    @GetMapping
    public List <Produto> obteTodos (){
        return produtoService.obteTodos();
    }


     /**
 * MÉTODO QUE RETORNA UM PRODUTO POR ID
 * @param id do produto que será localizado
 * @return um produto caso tenha enotrado por ID
 */
    @GetMapping ("/{id}")
    public Optional <Produto> obterPorId (@PathVariable Integer id){
    return produtoService.obterPorId(id);
    }   

    /**
 * MÉTODO PARA ADICONAR PRODUTO NA LISTA
 * @param produto que será adicionado na lista
 * @return o produto que foi adicionado na lista
 */
    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto){
        return produtoService.adicionaProduto(produto);
    }

    /**
     * MÉTODO QUE VAI DELETAR O PRODUTO POR ID
     * @param id que será deletado.
    */
    @DeleteMapping ("/{id}")
    public String deletarProduto (@PathVariable Integer id){
    produtoService.deletarProduto(id);
    return "Produto como o id" +id + " foi apagado com sucesso";    
}
    /**
 * MÉTODO PARA ADICONAR PRODUTO NA LISTA
 * @param produto que será adicionado na lista
 * @param id produto que será atualizado
 * @return o produto que foi adicionado na lista
 */
    @PutMapping ("/{id}")
    public Produto atualizarProduto(@RequestBody Produto produto, @PathVariable Integer id){
        return produtoService.atualizarProduto(id, produto);
    }

}
