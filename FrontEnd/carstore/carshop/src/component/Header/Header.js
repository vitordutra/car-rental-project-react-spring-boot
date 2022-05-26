
import React, { useContext } from "react";

import { AuthContext } from "../../context/auth";
import logo from "../../assets/logo.png"
import './Header.css';

const Header = () => {
  
  
  function estaLogado() {
    try {
      let user = JSON.parse(localStorage.getItem("user"));
      return user["name"]

    } catch (error) {
      
      return false
    }
  }
  
  
  return (
  
    
      
    <div className='header'>
      <img src={logo} alt='' width={100} />
      
    <div className="header-right">   
    <a href='/Registro'>Criar conta</a> 
     {!(estaLogado() === false) ? <>Bem vindo, {estaLogado()} !</> : <a href='/login'>Login</a>}
        
      </div>
      
  </div>

    
  
  );
}

export default Header;