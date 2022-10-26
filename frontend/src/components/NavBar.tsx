import { Link } from 'react-router-dom';

export default function NavBar(){

    return(
        <>
            <Link to={"/"}> Spielerliste </Link>
            <Link to={"/mainpage"}> Fancy Party App</Link>
        </>
    )
}