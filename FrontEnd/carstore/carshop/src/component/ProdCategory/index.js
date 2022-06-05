/* eslint-disable jsx-a11y/alt-text */
import React, {useState} from "react";
import Modal from "../Modal";
import './styles.css'
    
export default function ProdCategory({ prmProduct }) {
    const [isModalVisible, setIsModalVisible] = useState(false);
    return (

        <ul className="ProdCategoryLu">
            <li className="ProdCategoryLi" >
                <div className="LinkProdCategory">
                    <img className="ImgProdCategory"  src={prmProduct.url_imagem} />
                    <h3 className="H3ProdCategory">{prmProduct.title}</h3>
                    
                </div>
                
                <button className="ButtonProductItem" onClick={()=> setIsModalVisible(true)}>
                   Mais Detalhes
                </button>
                {isModalVisible ? (
                    <Modal onClose={() => setIsModalVisible(false)}>
                        
                        <img className="ImgModal" src={prmProduct.url_img} />
                        <button className="ButtonModal" >
                            Reserve Agora
                        </button>
                    </Modal >
                ) : null}
            </li>
        </ul>

    );
}