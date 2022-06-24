import './styles.css';
import { Link } from 'react-router-dom';


export default function ReservaSucedida() {

    return(
<div className="container-reserva-sucedida">
<h2>Reserva bem sucedida!</h2>
<img src="https://w7.pngwing.com/pngs/944/793/png-transparent-computer-icons-check-mark-presentation-symbol-check-list-miscellaneous-angle-text.png" alt="Reserva bem sucedida"  />
<Link to='/'> <p> voltar para home</p></Link>








</div>
)
}