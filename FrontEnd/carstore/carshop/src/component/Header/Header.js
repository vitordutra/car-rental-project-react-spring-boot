import React, {useContext } from "react";

import logo from "../../assets/logo.png";

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
        <div className='logo'>
          <a href='/'>
            <img src={logo} alt='' width={100} />
          </a>
    </div>
      
      
      <div className="header-right">  
        <a href='/Produtos'>Conheça nossa Frota</a>    
        <a href='/Registro'>Criar conta</a> 
       
        {!(estaLogado() === false) ? <>Bem vindo, {estaLogado()} !</> : <a href='/login'>Login</a>}
    
      </div>
   

    
  </div>

    
  
  );
}

export default Header;