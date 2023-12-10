package com.siqueyros.gestaoloja.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.siqueyros.gestaoloja.model.Produto;
import com.siqueyros.gestaoloja.model.Exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository {

    //Lista que simula o Banco de Dados
private List<Produto> produtos = new ArrayList <Produto>();
private Integer ultimoId = 0;


/**
 * MÉTODO QUE RETORNA UMA LISTA DE PRODUTOS
 * @return uma lista de produtos
 */
public List<Produto>obterTodos(){
return produtos;
}

/**
 * MÉTODO QUE RETORNA UM PRODUTO POR ID
 * @param id do produto que será localizado
 * @return um produto caso tenha enotrado por ID
 */
public Optional <Produto> obterPorId (Integer id){
 return produtos
    .stream()
    .filter(produto -> produto.getId() == id)
    .findFirst();
}


/**
 * MÉTODO PARA ADICONAR PRODUTO NA LISTA
 * @param produto que será adicionado na lista
 * @return o produto que foi adicionado na lista
 */
public Produto adicionaProduto (Produto produto){
   
    ultimoId++;
    produto.setId(ultimoId);
    produtos.add(produto);
    return produto;
    }



    /**
     * MÉTODO QUE VAI DELETAR O PRODUTO POR ID
     * @param id que será deletado.
     */
public void deletarProduto (Integer id){

    produtos.removeIf(produto -> produto.getId() == id);

}


/**
 * MÉTODO PARA ATUALIZAR UM PRODUTO NA LISTA
 * @param produto que será atualizado
 * @return o produto após atualizar
 */

public Produto atualizarProduto (Produto produto){

    // Encontra pr0duto na lista
    Optional<Produto>produtoEncontrado = obterPorId (produto.getId());
    
    if(produtoEncontrado.isEmpty()) {
     throw new ResourceNotFoundException("Não foi encontrado um produto com esse id" );
    }
 
    //Deleta produto do id encontrado
    deletarProduto(produto.getId());

    // Adiona o novo produto no mesmo id

    produtos.add(produto);

    return produto;


    

}

}
