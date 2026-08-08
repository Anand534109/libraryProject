import { useEffect, useState ,useRef } from "react";
import {Document,Page,pdfjs} from "react-pdf";
import HTMLFlipBook from "react-pageflip"

import "react-pdf/dist/Page/TextLayer.css";
import "react-pdf/dist/Page/AnnotationLayer.css";

pdfjs.GlobalWorkerOptions.workerSrc = new URL("pdfjs-dist/build/pdf.worker.min.mjs",import.meta.url).toString();

function App(){
  const [data , setData] = useState({});
  const[numPages ,setNumPages] = useState(null);
  const [pageNumber ,setPageNumber] =useState(1);
  const bookRef = useRef();


  useEffect(()=>{
    fetch("http://localhost:8080/Library/book")
    .then((result)=>result.json())
    .then(data=>setData(data));
  },[])

  const fileName = data.path?.split("/").pop();
  const fileUrl  = `http://localhost:8080/Library/books/${fileName}`
  console.log("demo => ",fileName)

  return (
    <div>
      <Document file={fileUrl} onLoadSuccess={({numPages})=>setNumPages(numPages)}>
        {/* <HTMLFlipBook width={450} height={700} ref={bookRef}> */}
          {
            Array.from([pageNumber,pageNumber+1],(_,index)=>(
              <div key={index}>
                <Page pageNumber={index+1} width={450} renderAnnotationLayer={false} renderTextLayer={false}  />
              </div>
            ))
          }
        {/* </HTMLFlipBook> */}
      </Document>
<br />

      <button onClick={()=>setPageNumber(pre=>pre-1)}>prev</button>
      <span>{pageNumber}/ {numPages}</span>
      <button onClick={()=>setPageNumber(pre=>pre+1)}>next</button>
    </div>
  )
}
export default App;