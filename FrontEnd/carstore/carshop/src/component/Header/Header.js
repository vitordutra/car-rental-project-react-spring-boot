
import React, { useContext } from "react";
import './Header.css'
import { AuthContext } from "../../context/auth";


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
           <img src='' alt='Logo, lá do figma' />
    <div className="header-right">   
    
     {!(estaLogado() === false) ? <>Bem vindo, {estaLogado()} !</> : <a href='/login'>Login</a>}
            
    </div>
  </div>

    
  
  );
}

export default Header;