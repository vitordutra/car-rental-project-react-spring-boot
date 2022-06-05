/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useState } from "react";
import api from "../../services/api";
import ProdCategory from "../../component/ProdCategory";
import './styles.css';


export default function Products() {

  const [categoria, setCategoria] = useState([]);

  const [cidade, setCidade] = useState([]);

  const filtrarProdutos = e => {
    e.preventDefault();
    if ((categoria != null) || (cidade != null)) {
      callFilteredProductsApi(categoria, cidade);
    }
    else {
      callProductsApi();
    }
  }

  const [products, setProducts] = useState([]);
  
  useEffect(() => {
    callCategoriesApi();
    callCidadesApi();
    callProductsApi();
  }, []);


  async function callProductsApi() {
    try {
      const response = await api.get("/products");
      setProducts(response.data);
    }
    catch (error) { 

    }
  } 

  async function callFilteredProductsApi(prmCategoria, prmCidade) {
    try {
      const response = await api.get("/products?categoryId=" + prmCategoria + "&cityId=" + prmCidade);
      setProducts(response.data);
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
      const response = await api.get("/citys");
      setCidade(response.data);
    }
    catch (error) { 

    }
  }

  return (
    <>
      <body className="item-list-products-body" >
        <h1 className="item-list-products-h1" >Esta é nossa frota</h1>
        <div>
          <h1>Filtro:</h1>
          <form onSubmit={filtrarProdutos}>
            <label>Categoria</label>
            <select name="categoria" value={categoria} onChange={item => setCategoria(item.target.value)} >
              <option value="">Selecione</option>
              {categoria.map((item) => (
              <option value={item.id}>{item.qualificacao}</option>
              ))}
            </select>
            <label>Cidade</label>
            <select name="cidade" value={cidade} onChange={item => setCidade(item.target.value)}>
              <option value="">Selecione</option>
              {cidade.map((item) => (
              <option value={item.id}>{item.nome}</option>
              ))}
            </select>
            <button type="submit">filtrar</button>
          </form>
        </div>
          <ul className="item-list-products-ul" >
            <li className="item-list-products-li" >
            {products.map((item) => (
              
              <><ProdCategory key={item.id} prmProduct={item} /></>
            ))}

         
             
          </li>
        
          
        </ul>
        
      </body>  
    </>
  );

};