import { Link } from 'react-router-dom';
import "./NavBar.css"

export default function NavBar(){

    return(
        <>
            <Link to={"/"}></Link>
            <Link to={"/spielerliste"}><button>Spielerliste</button></Link>
        </>
    )
}