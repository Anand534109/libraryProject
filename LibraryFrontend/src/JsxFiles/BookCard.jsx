import { useEffect ,useState} from "react";
import Book from "../cssFiles/Bookcard.module.css";
import { useNavigate } from "react-router-dom";

export default function BookCard({id,covepage}){
    const navigate=useNavigate();
    function gotoBookDetail(id){
        navigate(`/home/bookdetail/${id}`);
    }
   
    return(
        // <div>
            <div className={`card ${Book.bookcard}`} onClick={()=>gotoBookDetail(id)} >
                 <img src={`${covepage}`} className={`card-img-top ${Book.image}`} />
                <div className={`card-img-overlay`}>
                    <h3>{name}</h3>
                </div>
            </div>
        // </div>
    )
}