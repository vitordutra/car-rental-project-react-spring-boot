/* eslint-disable jsx-a11y/alt-text */
import React, {useState} from "react";
import { Link } from "react-router-dom";
import Modal from "../Modal";
import './styles.css'
    
export default function ProdCategory({ prmProduct }) {
    const [isModalVisible, setIsModalVisible] = useState(false);
    return (

        <ul className="ProdCategoryLu">
            <li className="ProdCategoryLi" >
                <Link className="LinkProdCategory"   to={`/detalhes/${prmProduct.id}`}>
                    <img className="ImgProdCategory"  src={prmProduct.url_imagem} />
                    <h3 className="H3ProdCategory">{prmProduct.title}</h3>               
                </Link>
                
                <button className="ButtonProductItem" onClick={()=> setIsModalVisible(true)}>
                   Mais Detalhes
                </button>
                {isModalVisible ? (
                    <Modal onClose={() => setIsModalVisible(false)}>
                        <h2>Modal dos produtos</h2>
                        <p>detalhes dos produtos neste modal!!!!!!!!!!!!!!!!!!</p>
                    </Modal >
                ) : null}
            </li>
        </ul>

    );
}