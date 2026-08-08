import { useEffect, useState ,useRef } from "react";
import {Document,Page,pdfjs} from "react-pdf";
import HTMLFlipBook from "react-pageflip"
import { useParams ,useNavigate , useLocation} from "react-router-dom";

import bookView from "../cssFiles/Bookcard.module.css";


import "react-pdf/dist/Page/TextLayer.css";
import "react-pdf/dist/Page/AnnotationLayer.css";

pdfjs.GlobalWorkerOptions.workerSrc = new URL("pdfjs-dist/build/pdf.worker.min.mjs",import.meta.url).toString();

function BookView1({BookName}){
  const [numPages ,setNumPages] = useState(null);
  const [pageNumber ,setPageNumber] =useState(1);
  const bookRef = useRef();
  const [url,setUrl]=useState("");
  const navigate = useNavigate();
  const location = useLocation();
  const {id} = useParams();
  const bookview= {
    display:"felx",
    // flexDirection:"column",
    alignItems:"center",
    justifyContent:"center"
  }

  useEffect(()=>{
    let re = fetch(`http://localhost:8080/Library/book/${id}/filepath`,{
      credentials:"include"
    })
    re.then(async (res)=>{
      if(res.status === 401 || res.status === 403){
        navigate("/login",{
          replace:true
        });
        return;
      }
      const blob = await res.blob();
      const pdfurl = URL.createObjectURL(blob);
      setUrl(pdfurl);
    }).catch(error=>console.log("error -> ",error));
    
  },[])
  
  return (
    <div className={bookView.view}> 
        <div style={{width:"1100px"}}> 
          <Document 
          file={url} 
          onLoadSuccess={({numPages})=>setNumPages(numPages)}
          onLoadError={(error)=>console.log("pdf load error: ",error)}
          loading={<p>Book loading....</p>}
          
          >
            <HTMLFlipBook 
            width={530} 
            height={700} 
            ref={bookRef} 
            useMouseEvents={false} 
            swipeDistance={0}
            onFlip={(e)=>setPageNumber(e.data+1)}
            size="fixed"
            >
              {
                Array.from({length:numPages},(_,index)=>(
                  <div key={index}>
                    <Page pageNumber={index+1} width={530} renderAnnotationLayer={false} renderTextLayer={false}  />
                  </div>
                ))
              }
            </HTMLFlipBook>
          </Document>
        </div>
      <div>
        <button className="btn" onClick={()=>bookRef.current.pageFlip().flipPrev()}>Prev Page</button>
        <span>{pageNumber} / {numPages}</span>
        <button className="btn" onClick={()=>bookRef.current.pageFlip().flipNext()}>Next Page</button>
      </div>
    </div>

    
    
  )
}
export default BookView1;