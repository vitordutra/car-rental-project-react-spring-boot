import React from "react";
import './styles.css';



const BlocoPesquisa = () =>{

    return(

        <>
        <div className="pesquisa-container">
            <div className="pesquisa-titulo">
               <h1 className="pesquisa-titulo-texto"> Alugue seu carro aqui</h1>
            </div>
            <div className="pesquisa-primeira-fileira">
            
                <div className="pesquisa-itens-duplos">
                    <h4>Local de Retirada</h4>
                    <input placeholder="Onde quer retirar?" type="text" id="pesquisa-retirar-local" name="pesquisa-retirar-local" className="pesquisa-inputs"/>
                    <input type="checkbox" id="pesquisa-devolucao-checkbox" name="pesquisa-devolucao-checkbox" />
                <label htmlFor="pesquisa-devolucao-checkbox">Quer devolver em outra unidade?</label>
                    <h4>Local de Devolução</h4>
                    <input placeholder="Onde quer devolver?" type="text" id="pesquisa-devolucao-local" name="pesquisa-devolucao-local" className="pesquisa-inputs"/>
                </div>

                

                    
                <div className="pesquisa-itens-duplos">
                    <h4>Data de Retirada</h4>
                    <input type="date" id="pesquisa-retirar-data" name="pesquisa-retirar-data" className="pesquisa-inputs" />    
                </div>
                
                <div className="pesquisa-itens-duplos">
                    <h4>Data de Devolução</h4>
                    <input type="date" id="pesquisa-devolucao-data" name="pesquisa-devolucao-data" className="pesquisa-inputs"/>
                </div>

                <div className="pesquisa-itens-duplos">
                    
                    <input type="button" id="pesquisa-botao-buscar" name="pesquisa-botao-buscar"   value= "Buscar"/> 
                </div>
                
            </div>
            
            
        </div>
        </>

    )




}

export default BlocoPesquisa;