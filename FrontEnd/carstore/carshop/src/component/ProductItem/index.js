/* eslint-disable jsx-a11y/alt-text */
import React, { useState, useContext } from "react";
import { Link } from "react-router-dom";
import './styles.css'
    
export default function ProductItem({ prmProduct }) {
 
    return (

        <ul>
            <li className="ProductItemLi" >
                <Link className="LinkProductItem"   to={`/detalhes/${prmProduct.id}`}>
                    <img className="ImgProductItem"  src={prmProduct.url_imagem} />
                    <h3 className="H3ProductItem">{prmProduct.title}</h3>
                    <p className="ParagProductItem"> {prmProduct.localizacao}</p>
                    <p className="ParagProductItem">{prmProduct.categories}</p>
                    <p className="ParagProductItem">{prmProduct.descricao}</p>
                   
                </Link>
                <button className="ButtonProductItem">
                    Reserve Agora
                </button>
            </li>
        </ul>

    );
}