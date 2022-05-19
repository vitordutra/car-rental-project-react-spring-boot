import React from 'react';
/* import {Nav, Navbar, Link, Container} from 'react-bootstrap' */
import './Header.css'

const Header = () => {


  return (
  
    
      
    <div className='header'>
           <img src='' alt='Logo, lá do figma' />
    <div className="header-right">
            <a className="active" href="#home">Home</a>
            <a href='/eletricos'>Elétricos</a>
            <a href='/economicos'>Econômicos</a>
            <a href='/suvs'>Suvs</a>
            <a href='/esportivos'>Esportivos</a>

          <button className='btn-login'>login</button>
    </div>
  </div>
    
    
  
  );
}

export default Header;