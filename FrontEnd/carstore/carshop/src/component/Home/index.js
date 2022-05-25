import React from "react";
import './styles.css';
import Carrousel from "./Carousel";
import BannerHome from "./BannerHome";


const home = (props) => {
    return (
     <>
      
     <div id='home'>
  
          <div id="HomeBase">
            <p>
              
              <BannerHome />
              <Carrousel />
            </p>
          </div>
        </div>
     
     </>
    );
  }
  
  export default home; 