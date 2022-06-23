import './styles.css';

const BlocoPesquisa = () => {
    return(
        <>
            <div className="pesquisa-primeira-fileira">                  
                    <div className="pesquisa-itens-duplos">
                        <input
                            placeholder="Digite o local de retirada"
                            type="text"
                            id="pesquisa-retirar-local"
                            name="pesquisa-retirar-local"
                            className="pesquisa-inputs"
                        ></input>                        
                        </div>
                        <div className="pesquisa-itens-duplos">                        
                        <input  type="date" id="pesquisa-retirar-data" name="pesquisa-retirar-data" className="pesquisa-inputs"></input>    
                        </div>
                        <div className="pesquisa-itens-duplos">                        
                        <input type="date" id="pesquisa-devolucao-data" name="pesquisa-devolucao-data" className="pesquisa-inputs"/>
                        </div>                        
                        <input type="button" id="pesquisa-botao-buscar" name="pesquisa-botao-buscar" value="Buscar" /> 
                        <div className="pesquisa-devolcao-unidade">
                        <input type="checkbox" id="pesquisa-devolucao-checkbox" name="pesquisa-devolucao-checkbox" />                        
                        <label className="pesquisa-devolucao-checkbox">Quer devolver em outra unidade?</label>
                    </div>
                </div>          
        </>

    )




}

export default BlocoPesquisa;