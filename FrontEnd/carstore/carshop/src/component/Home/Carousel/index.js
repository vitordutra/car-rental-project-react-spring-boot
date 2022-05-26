import api from '../../../services/api';
import CategoryItem from './CategoryItem';
import {Carousel, Row, Col} from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { useEffect, useState } from "react";

import './styles.css';

const Carrousel = () => {
  var maxItemsPage = 3;
  var maxItems = 10;

const [categories, setCategories] = useState([]);
useEffect(() => {
callApi();
}, []);

async function callApi() {
  try {
    const response = await api.get("/categories");
    console.log('response', response);

    var dataBatchs = [];
    const data = response.data;

    console.log(data);


    for (let i = 0; i < maxItems; i++) {
    if (i % maxItemsPage === 0) {
    dataBatchs.push([]);
    }

    dataBatchs[Math.floor(i / maxItemsPage)].push({
    id: data[i]['id'],
    qualificacao: data[i]['qualificacao'],
    descricao: data[i]['descricao'],
    url_imagem: data[i]['url_imagem']
    }); 
  }

    setCategories(dataBatchs);
  }
  catch (error) { 

  }
}

  const navigate = useNavigate();

  return (


      <section id="carrossel">
      <h2>Categorias populares</h2>

      <Carousel variant="dark" id= "destaques">
      {categories.map((dataBatch, index) => {
        return (
          <Carousel.Item>
            <Row>
            {dataBatch.map((item, index) => {
              return(
                <Col key={item.id} md={4} sm={6} className={`mx-auto ${index===1?'d-none d-sm-block' : index===2? 'd-none d-md-block' : ''}`}>
                  <CategoryItem key={item.id} prmCategory={item}/>
                </Col>
              )
            })}
            </Row>
          </Carousel.Item>
        )
    })}
  </Carousel> 
</section>





);
}
  
  export default Carrousel; 