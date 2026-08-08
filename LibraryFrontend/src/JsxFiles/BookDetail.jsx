import { useState,useEffect } from "react"
import { useNavigate,useParams } from "react-router-dom";
import detail from "../cssFiles/bookdetail.module.css";
import image from '../CoverPage/MathCover.jpg'

export default function BookDetail(){
    const {id} = useParams();
    const navigate=useNavigate();
    // function gotoView(id){
    //     if(data?.path.includes(".epub")){
    //         window.open(data.path,"_blank");
    //     }else{
    //         navigate(`/home/bookdetail/${id}/view`);
    //     }
    // }
    const[data,setData] =useState({})
    
     const AddFav = ()=>{
        const book={
            book_id:id
        }
        console.log(book);
        try{
            const response = fetch("http://localhost:8081/Borrow/demo/add",{
                method:"POST",
                credentials:"include",
                headers:{
                    "Content-Type":"application/json"
                },
                body:JSON.stringify(book)
            });
            response.then(res=>console.log(res));
        }catch(error){
            console.log("Add Favarite error =>",error)
        };
    }

    // function AddFav(){
    //     fetch("http://localhost:8081/Borrow/test",{
    //         method:"POST"
    //     })
    // }

    useEffect(()=>{
        fetch(`http://localhost:8083/Book/googlebooks/findone/${id}`)
        .then(result=>result.json())
        .then(data=>setData(data));
    },[])
    console.log("boo details =",data);
     function gotoPreview(){
        window.open(data?.volumeInfo?.previewLink)
    }

    
    return(
        <div className={detail.container}>
            <div >
                <img src={data?.volumeInfo?.imageLinks?.thumbnail} style={{width:"300px"}} />
            </div>
            <div className={detail.bookdetail}>
                <h1>book title</h1>
                <table className="table">
                    <tbody>
                        <tr>
                            <th>Author</th>
                            <th>{data?.volumeInfo?.authors}</th>
                        </tr>
                        <tr>
                            <th>Languate</th>
                            <th>{data?.volumeInfo?.language}</th>
                        </tr>
                        <tr>
                            <th>Total Number Of Pages</th>
                            <th>{data?.volumeInfo?.pageCount}</th>
                        </tr>
                    </tbody>
                </table>
                <div style={{display:"flex",justifyContent:"space-between"}}>
                    <button className="btn btn-primary" onClick={()=>AddFav()} >Add Fav</button>
                    <button className="btn btn-primary" onClick={()=>gotoPreview()}>Start Reading</button>
                </div>
            </div>
        </div>
    )
}