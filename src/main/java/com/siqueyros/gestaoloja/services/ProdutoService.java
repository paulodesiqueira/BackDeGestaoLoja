package com.siqueyros.gestaoloja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siqueyros.gestaoloja.model.Produto;
import com.siqueyros.gestaoloja.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    /**
    * MÉTODO QUE RETORNA UMA LISTA DE PRODUTOS
    * @return uma lista de produtos
     */
    public List <Produto> obteTodos (){
        return produtoRepository.obterTodos();
    }

    /**
 * MÉTODO QUE RETORNA UM PRODUTO POR ID
 * @param id do produto que será localizado
 * @return um produto caso tenha enotrado por ID
 */
public Optional <Produto> obterPorId (Integer id){
 return produtoRepository.obterPorId(id);
}

/**
 * MÉTODO PARA ADICONAR PRODUTO NA LISTA
 * @param produto que será adicionado na lista
 * @return o produto que foi adicionado na lista
 */
public Produto adicionaProduto (Produto produto){
   return produtoRepository.adicionaProduto(produto);
 
    }

    /**
     * MÉTODO QUE VAI DELETAR O PRODUTO POR ID
     * @param id que será deletado.
     */
public void deletarProduto (Integer id){
produtoRepository.deletarProduto(id);

}

/**
 * MÉTODO PARA ATUALIZAR UM PRODUTO NA LISTA
 * @param produto que será atualizado
 * @param id do produto que será atualizado
 * @return o produto após atualizar
  */
public Produto atualizarProduto (Integer id,Produto produto){

    produto.setId(id);
    return produtoRepository.atualizarProduto(produto);


    
}
}
