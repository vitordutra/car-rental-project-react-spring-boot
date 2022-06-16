import aplicativo from "../../../assets/aplicativo.jpg";
import './styles.css';

const SectionApp = () => {
    return(
        <>
            <div className="sectionApp-body">
                <div className="sectionApp-body-img">
                    <img src={aplicativo} alt='' />
                </div>
                <h2>Baixe o aplicativo do Ctd Cars</h2>
                <p> Drive Happy com o novo aplicativo do Ctd Cars.
                    Faça sua reserva rapidamente, visualize ou modifique facilmente suas próximas
                    reservas e obtenha instruções para chegar à sua agência mais proxima. Mantenha-se
                    conectado à conta Ctd Cars para facilitar o acesso a suas reservas
                    e economize 5% nas nossas tarifas.
                    <br/>
                    é rapido e facil

                </p>
                
                
                    
            </div>          
        </>

    )




}

export default SectionApp;