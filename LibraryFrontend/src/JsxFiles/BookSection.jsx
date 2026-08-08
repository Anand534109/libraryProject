import BookCard from "./BookCard";

import {useState , useEffect} from  "react"


export default function BookSection({text,data}){
    
    return(
        <div style={{padding:"0px 160px"}}>
            <div>
                <h1>{text}</h1>
            </div>
        <div style={{display:"flex",justifyContent:"space-around"}}>
                {data?.items.map((item)=>(
    
                    <BookCard key={item.id} covepage={item?.volumeInfo.imageLinks?.thumbnail} id={item.id}></BookCard>
                ))}
            </div>
       
        </div>
    
    )
}