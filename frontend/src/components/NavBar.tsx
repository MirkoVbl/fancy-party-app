import { Link } from 'react-router-dom';
import "./NavBar.css"

export default function NavBar(){

    return(
        <>
            <Link to={"/"}></Link>
            <Link to={"/spielerliste"}></Link>
            <Link to={"/game"}></Link>
            <Link to={"/result"}></Link>
        </>
    )
}