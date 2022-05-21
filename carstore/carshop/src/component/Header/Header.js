import React from 'react';
import './Header.css'



const Header = () => {


  return (
  
    
      
    <div className='header'>
           <img src='' alt='Logo, lá do figma' />
    <div className="header-right">
            <a href='/'>Home</a>
            <a href='/eletricos'>Elétricos</a>
            <a href='/economicos'>Econômicos</a>
            <a href='/suvs'>Suvs</a>
            <a href='/esportivos'>Esportivos</a>
            <button className='btn-login' >login</button>
    </div>
  </div>
    
    
  
  );
}

export default Header;