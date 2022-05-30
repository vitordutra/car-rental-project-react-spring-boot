/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useState } from "react";
import api from "../../services/api";
import ProductItem from "../../component/ProductItem";
import './styles.css';
export default function Products() {

  const [products, setProducts] = useState([]);
  useEffect(() => {
    callApi();
  }, []);

  async function callApi() {
    try {
      const response = await api.get("/products");
      setProducts(response.data);
    }
    catch (error) { 

    }
  } 

  return (
    <>
      <body className="item-list-products-body" >
        <h1 className="item-list-products-h1" >As melhores condições para você reservar e aproveitar</h1>
          <ul className="item-list-products-ul" >
            <li className="item-list-products-li" >
            {products.map((item) => (
            <ProductItem key={item.id} prmProduct={item}/>
            ))}
          </li>
          
        </ul>
        
      </body>  
    </>
  );

};