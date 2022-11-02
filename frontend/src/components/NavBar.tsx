import { Link } from 'react-router-dom';
import "./NavBar.css"

export default function NavBar(){

    return(
        <>
            <Link to={"/"}></Link>
            <Link to={"/addplayer"}></Link>
            <Link to={"/editplayer"}></Link>
            <Link to={"/spielerliste"}></Link>
            <Link to={"/game"}></Link>
        </>
    )
}