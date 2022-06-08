/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useState } from "react";
import api from "../../services/api";
import './styles.css';


export default function Products({handleFilter}) {

  const [categoria, setCategoria] = useState([]);

  const [cidade, setCidade] = useState([]);
 
 


  
  
  useEffect(() => {
    callCategoriesApi();
    callCidadesApi(); 
    callApiProductsCategory();
  }, []);

  
  async function callProductsApi() {
    try {
      const response = await api.get("/products");
      handleFilter(response.data);
    }
    catch (error) { 

    }
  } 

  async function callCategoriesApi() {
    try {
      const response = await api.get("/categories");
      setCategoria(response.data);
    }
    catch (error) { 

    }
  } 

  async function callCidadesApi() {
    try {
      const response = await api.get("/cities");
      setCidade(response.data);
    }
    catch (error) { 

    }
  }

  
 async function callProductByCity(id) {
  try {
    const response = await api.get(`products?cityId=${id}`);
    handleFilter(response.data);
  }
  catch (error) { 

  }
}

  async function callApiProductsCategory(id) {

    try {
      //const URL = "categories"
      const URL = `products?categoryId=${id}`
      const response = await api.get(URL);
      handleFilter(response.data);
    }
    catch (error) {
    }
  }


  return (
    <>
      <body className="item-list-products-body" >     
        <div> 
        <h1 className="formFiltersH1">Grupos de carros</h1>
          <form className="formFilters">
            <label className="label">Categoria:  </label>
            <select className="select" name="categoria"  onChange={item => callApiProductsCategory(item.target.value)} >
              <option value="">Selecione</option>
              {categoria.map((item) => (
                <option value={item.id}>{item.qualificacao}</option>
                
              ))}
            </select> &nbsp;
           
            <label className="label">Cidade:</label>
            <select className="select" name="cidade"  onChange={item => callProductByCity(item.target.value)}>
              <option value="">Selecione</option>
              {cidade.map((item) => (
              <option value={item.id}>{item.nome}</option>
              ))}
            </select>
         
          </form>
        </div>
          {/* <ul className="item-list-products-ul" >
            <li className="item-list-products-li" >
            {products.map((item) => (
              
              <><ProdCategory key={item.id} prmProduct={item} /></>
            ))}          
          </li>        
        </ul>       */}
      </body>  
    </>
  );

};