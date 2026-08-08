import { useParams } from "react-router-dom";
import BookCard from "./BookCard";
import { useState ,useEffect} from "react";

import show from "../cssFiles/Showbook.module.css";


function ShowBooks(){
    const {name} = useParams();
    const [data,SetData]= useState();
    useEffect(()=>{
        fetch(`http://localhost:8083/Book/googlebooks?q=subject:${name}&max=10&index=0`)
        .then(res=>res.json())
        .then(d =>SetData(d))
    },[])
    console.log(data);
    return (
        <div style={{padding:"0px 160px"}}>
            <div >
                <h1>catagory - {name}</h1>
            </div>
            <div className={show.bookcontainer}>
                <div className={show.allbooks}>
                    {data?.items.map((item)=>(    
                        <BookCard key={item.id} covepage={item?.volumeInfo.imageLinks?.thumbnail} id={item.id}></BookCard>
                    ))
                    }
                </div>
            </div>
        </div>
    )
}

export default   ShowBooks;