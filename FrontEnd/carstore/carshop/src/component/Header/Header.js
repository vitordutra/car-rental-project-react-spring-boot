import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { AuthContext } from "../../context/auth";

import logo from "../../assets/logo.png";
import login from "../../assets/login.png";

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
          <Link to='/'><img src={logo} alt='' width={100} /></Link>
      </div>      
      <div className="header-right"> 
        <Link  to="/Produtos"><span className="header-rightLink">Conheça nossa Frota</span></Link>  
        <Link to="/Registro"><span className="header-rightLink">Criar conta</span></Link> 
        {user == null ?
          <a href='/login'>Login</a> :
          <>
            <img className='logInImg' src={login} alt=''/>
            <div className='logIn'>
            Bem vindo, {estaLogado()} !
          </div>
          </>
        }    
      </div>
       
  </div>

    
  
  );
}

export default Header;