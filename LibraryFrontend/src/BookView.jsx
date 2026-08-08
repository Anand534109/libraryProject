import { motion, AnimatePresence } from "framer-motion";
import {Document,Page,pdfjs} from "react-pdf";
import "react-pdf/dist/Page/TextLayer.css";
import "react-pdf/dist/Page/AnnotationLayer.css";
import { useState } from "react";

pdfjs.GlobalWorkerOptions.workerSrc = new URL("pdfjs-dist/build/pdf.worker.min.mjs",import.meta.url).toString();

export default function BookView() {
  const [pageNumber,setPageNumber] = useState(1);
  const[numberOfPages,setNumberOfPages] = useState(null);

  const nextPage = () => {
    setPageNumber(pre => pre+1)
  };

  const prevPage = () => {
    setPageNumber(pre =>pre-1)
  };

  return (
    <div>

                <div style={{ textAlign: "center" }}>
        <Document file="http://localhost:8080/Library/books/Suno_Khani.pdf" onLoadSuccess={(numberOfPages)=>setNumberOfPages(numberOfPages)}>
                <div
                    style={{
                    width: 405,
                    height: 609,
                    margin: "auto",
                    perspective: 1000,
                    border: "1px solid #0b0a0a"
                    }}
                >
                    <AnimatePresence mode="wait">
                        <motion.div
                            key={pageNumber}
                            initial={{ rotateY: 90, }}
                            animate={{ rotateY: 0,  }}
                            exit={{ rotateY: -90, }}
                            transition={{ duration: 0.5 }}
                            style={{
                            width: "100%",
                            height: "100%",
                            background: "#000000",
                            display: "flex",    
                            alignItems: "center",
                            justifyContent: "center",
                            // fontSize: 24,
                            backfaceVisibility: "hidden"
                            }}
                        >
                            <Page pageNumber={pageNumber} width={400}/>
                        </motion.div>
                    </AnimatePresence>
                </div>

                
        </Document>
                <button onClick={prevPage}>Prev</button>
                <span>{pageNumber}</span>
                <button onClick={nextPage}>Next</button>
                </div>
    </div>
    );
    }


