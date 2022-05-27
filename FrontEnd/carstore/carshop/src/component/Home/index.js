import React from "react";
import './styles.css';
import Carrousel from "./Carousel";
import BannerHome from "./BannerHome";
import BlocoPesquisa from "./BlocoPesquisa";

const home = (props) => {
    return (
     <>
      
     <div id='home'>
  
          <div id="HomeBase">
            <p>
              <BlocoPesquisa />
              <BannerHome />
              <Carrousel />
            </p>
          </div>
        </div>
     
     </>
    );
  }
  
  export default home; 
