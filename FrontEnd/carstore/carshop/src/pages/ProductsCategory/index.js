/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable no-unused-vars */
/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useState } from "react";
import ProductItem from "../../component/ProductItem";
import api from "../../services/api";
import { useParams } from 'react-router-dom';
import './styles.css';


export default function ProductsCategory() {

  // Captura do id de categoria parâmetro passado para a página
  const categoryId = useParams("id");
  const [product, setProduct] = useState([]);
  useEffect(() => {
    callApiProductsCategory();
  }, []);

  async function callApiProductsCategory() {

    try {
      const URL = "categories"
      // const URL = "/productsCategory/" + categoryId
      const response = await api.get(URL);
      setProduct(response.data);
    }
    catch (error) {
    }
  }
  return (
    <>
      <body className="ProCategory-body" >
      <h1 className="ProCategory-h1">Produtos da categoria</h1>
      <ul className="ProCategory-ul">
        <li className="ProCategory-li">
        {product.map((item) => (
          <ProductItem key={item.id} prmProduct={item} />
        ))}
          </li>
        </ul>
        </body>
    </>
  );
}
