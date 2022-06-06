import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { AuthContext } from "../../context/auth";

import logo from "../../assets/logo.png";

import './Header.css';

const Header = () => {

  const {user} = useContext(AuthContext);
  
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
        
          <Link to='/'>
            <img src={logo} alt='' width={100} />
          </Link>
    </div>
      
      
      <div className="header-right"> 
        <Link to="/Produtos"><span>Conheça nossa Frota</span></Link>  
        <Link to="/Registro"><span>Criar conta</span></Link> 
            
         
       
        {user == null ?<a href='/login'>Login</a> : <>Bem vindo, {estaLogado()} !</>  }
    
      </div>
       
  </div>

    
  
  );
}

export default Header;