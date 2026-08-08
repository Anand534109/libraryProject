import fav from "../cssFiles/favourite.module.css"
import { useState,useEffect } from "react";

function FavrateList(){

    const [data,setData] = useState();
    useEffect(()=>{
        fetch("http://localhost:8081/Borrow/borrow/fav",{
            method:"GET",
            credentials:"include"
        }).then(response=>response.json())
        .then(data=>setData(data))
    },[])
    function gotoPreview(path){
        window.open(path)
    }

    
console.log(data);
    return (
        <div style={{padding:"0px 160px"}}>
            {
                data?.map((item,index)=>(
                <div className={fav.container} key={index}>
                    <div>
                        <img src={item?.volumeInfo?.imageLinks?.thumbnail} style={{width:"12rem",height:"16rem",borderRadius:"5px 0px 0px 5px"}} />
                    </div>
                    <div className={fav.detail}>
                        <h4>{item?.volumeInfo?.title}</h4>
                        <h4>{item?.volumeInfo?.authors}</h4>
                        <p>{item?.volumeInfo?.publishedDate}</p>
                        <button className="btn btn-primary" onClick={()=>gotoPreview(item?.volumeInfo?.previewLink)}>Start Reading</button>
                    </div>
                </div>
                ))
            }
        </div>
    )
}
export default FavrateList;