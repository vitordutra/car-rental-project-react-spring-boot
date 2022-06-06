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
                    <h3 className="H3ProdCategory">{prmProduct.title}</h3>
                    <h3 className="H3ProdQualification">{prmProduct.qualificacao }</h3>
                    <img className="ImgProdCategory" src={prmProduct.url_imagem} />
                    <p className="ParagProdCategory">{prmProduct.descricao}</p>                  
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