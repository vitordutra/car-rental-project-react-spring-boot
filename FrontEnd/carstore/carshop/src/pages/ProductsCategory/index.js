/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable no-unused-vars */
/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useState } from "react";
import ProdCategory from "../../component/ProdCategory";
import Products from "../Products";
import api from "../../services/api";
import { useParams } from 'react-router-dom';
import './styles.css';


export default function ProductsCategory() {
  const [products, setProducts] = useState([]);

  // Captura do id de categoria parâmetro passado para a página
  const {id} = useParams("id");

  useEffect(() => {
    console.log(id)
    if (id === undefined) {
      callApiProducts();
    } else {
      callApiProductsCategory();
    
    
    }
    
  }, []);

  async function callApiProductsCategory() {

    try {
      //const URL = "categories"
    
      const URL = `products?categoryId=${id}`
      const response = await api.get(URL);
      setProducts(response.data);
    }
    catch (error) {
    }
  }

  async function callApiProducts() {

    try {
      //const URL = "categories"
    
      const URL = `products`
      const response = await api.get(URL);
      setProducts(response.data);
    }
    catch (error) {
    }
  }

 

  
  return (
    <>
      <body className="ProCategory-body" >
        <Products handleFilter={setProducts}/>
      <h1 className="ProCategory-h1">Categorias</h1>
      <ul className="ProCategory-ul">
        <li className="ProCategory-li">
        {products.map((item) => (
          < ProdCategory prmProduct={item }/>
        ))}
          </li>
        </ul>
        </body>
    </>
  );
}
