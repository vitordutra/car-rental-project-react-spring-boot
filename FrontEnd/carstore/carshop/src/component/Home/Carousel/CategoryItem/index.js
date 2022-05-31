import React from "react";
import './styles.css';
import { Link } from "react-router-dom";




export default function CategoryItem({ prmCategory }) {


    return (
    <ul style={{alignItems:"center" }}>
            <li style={{listStyle: "none", border: "1px #666",borderRadius:"10px", margin:"20px",width: 400, height:400,alignItems: "center",background: "#f5d6a7",boxShadow: "5px 5px 5px #D3D3D3" }}>
                <Link to={`/categorias/${prmCategory.id}`}style={{textDecoration:"none"}}>
                    <img  style={{ width: 200, height:150,margin: "50px 100px"}} src={prmCategory.url_imagem} />
                    <h3 style={{color: "black", margin: "10px",textAlign: "center"}}>{prmCategory.qualificacao}</h3>
                    <p style={{color: "black", margin: "10px ",textAlign: "center"}}>{prmCategory.descricao}</p>
                    

                </Link>
            </li>
        </ul>
    );
  }
  
   